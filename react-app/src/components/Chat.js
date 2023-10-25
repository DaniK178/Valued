import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Chat.css';
import 'bootstrap/dist/css/bootstrap.min.css';
function Chat() {
  const [input, setInput] = useState('');
  const [messages, setMessages] = useState([{ text: "Hey, it's great to see you!", sender: "chatbot" }]);
  const [socialRecommendations, setSocialRecommendations] = useState('');
  const [learningRecommendations, setLearningRecommendations] = useState('');
  const [disabilityRecommendations, setDisabilityRecommendations] = useState('');

  useEffect(() => {
    // Fetch social recommendations
    fetch(`http://localhost:8080/bot/get-social-recommendations`)
      .then((response) => response.text())
      .then((data) => {
        setSocialRecommendations(data);
      })
      .catch((error) => {
        console.error('Error fetching social recommendations:', error);
      });
    //  learning recommendations
    fetch(`http://localhost:8080/bot/get-learning-recommendations`)
      .then((response) => response.text())
      .then((data) => {
        setLearningRecommendations(data);
      })
      .catch((error) => {
        console.error('Error fetching learning recommendations:', error);
      });
    //  disability recommendations
    fetch(`http://localhost:8080/bot/get-disability-recommendations`)
      .then((response) => response.text())
      .then((data) => {
        setDisabilityRecommendations(data);
      })
      .catch((error) => {
        console.error('Error fetching disability recommendations:', error);
      });
  }, []);

  const handleSubmit = async (event) => {
    event.preventDefault();
   
    const currentTime = new Date().toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
    setMessages((prevMessages) => [
      ...prevMessages,
      { text: input, sender: 'user', sentTime: currentTime },
    ]);
    try {
      const response = await axios.get(`http://localhost:8080/bot/conversation?prompt=${input}`);
      const chatbotReply = response.data;
      setMessages((prevMessages) => [
        ...prevMessages,
        { text: chatbotReply.choices[0].message.content, sender: 'chatbot', sentTime: currentTime },
      ]);
      // Scroll to the bottom of the conversation
      const conversation = document.getElementById('conversation');
      conversation.scrollTop = conversation.scrollHeight;
    } catch (error) {
      console.error('API request error:', error);
    }
    setInput('');
  };






  // const handleSubmit = async (event) => {
  //   event.preventDefault();
  //   setInput('');
  //   const currentTime = new Date().toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
  //   setMessages((prevMessages) => [
  //     ...prevMessages,
  //     { text: input, sender: 'user', sentTime: currentTime },
  //   ]);
  
  //   try {
  //     const response = await fetch(`http://localhost:8080/bot/conversation?prompt=${input}`);
      
  //     if (response.ok) {
  //       const chatbotReply = await response.json();
  //       setMessages((prevMessages) => [
  //         ...prevMessages,
  //         { text: chatbotReply, sender: 'chatbot', sentTime: currentTime },
  //       ]);
  //     } else {
  //       // Handle the error here
  //       console.error('API request error:', response.status, response.statusText);
  //     }
  
  //     // Scroll to the bottom of the conversation
  //     const conversation = document.getElementById('conversation');
  //     conversation.scrollTop = conversation.scrollHeight;
  //   } catch (error) {
  //     console.error('Fetch error:', error);
  //   }
  // };


  const generateResponse = (input) => {
    const responses = [
      // ... (other responses)
    ];
    return responses[Math.floor(Math.random() * responses.length)];
  };

  return (
    <div className="chat-body">
      <div className="container-fluid mt-4">
        <div className="card rounded">
          <div className="card-body">
            <div className="introduction card-body text-center">
              <h2>HELLO</h2>
              <p style={{padding:'10px'}}> I'm Helen, your friendly mentor here to help you with any questions or guidance you need. Feel free to ask about anything! 😊  </p>
              <hr /> 
              <div className="container-lg my-4">
                <div className="row">
                  <div className="col-md-8 mx-auto">
                    <div className="chatbot-container text-center">
                      <div id="header">
                        <h1>Talk to me</h1>
                      </div>
                      <div id="chatbot">
                        <div id="conversation" className="overflow-auto">
                          {messages.map((message, index) => (
                            <div key={index} className={`chatbot-message ${message.sender}-message`}>
                              <p className="chatbot-text" sentTime={message.sentTime}>{message.text}</p>
                            </div>
                          ))}
                        </div>
                        <form id="input-form" onSubmit={handleSubmit}>
                          <message-container>
                            <input
                              id="input-field"
                              type="text"
                              placeholder="Type your message here"
                              value={input}
                              onChange={(e) => setInput(e.target.value)}
                            />
                            <button className="btn btn-primary custom-save-button" id="submit-button" type="submit">Send</button>
                          </message-container>
                        </form>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
export default Chat;