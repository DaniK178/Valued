import React, { useState } from 'react';
import './Chat.css';
import 'bootstrap/dist/css/bootstrap.min.css';

function Chat() {
  const [input, setInput] = useState('');
  const [messages, setMessages] = useState([{ text: "Hi, my name is Helen! 👋 it's great to see you!", sender: "chatbot" }]);

  const handleSubmit = async (event) => {
    event.preventDefault();
    setInput('');

    const currentTime = new Date().toLocaleTimeString([], { hour: '2-digit', minute: "2-digit" });

    setMessages(prevMessages => [...prevMessages, { text: input, sender: "user", sentTime: currentTime }]);

    const response = generateResponse(input);
    setMessages(prevMessages => [...prevMessages, { text: response, sender: "chatbot", sentTime: currentTime }]);

    const conversation = document.getElementById('conversation');
    conversation.scrollTop = conversation.scrollHeight;
  };

  fetch('http://localhost:8080/bot/get-social-recommendations')
    .then((response) => response.json())
    .then((data) => {
      // Process the data from the server
    })
    .catch((error) => {
      console.error('Error:', error);
    });

  const sendUserMessage = async (input) => {
    try {
      // Make an API request to your Spring Boot backend
      const response = await fetch('http://localhost:8080/bot/conversation', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ chatBotId: 1, prompt: input }),
      });

      if (!response.ok) {
        throw new Error('API request failed');
      }

      const data = await response.json();
      return data.choices[0].message.content; // Modify this to match the response structure
    } catch (error) {
      throw error;
    }
  };

//  const generateResponse = (input) => {
//    const responses = [
//      "Hello, how can I help you today? 😊",
//      "I'm sorry, I didn't understand your question. Could you please rephrase it? 😕",
//      // ... (other responses)
//    ];
//    return responses[Math.floor(Math.random() * responses.length)];
//  };

  return (
    <div className="chat-body">
      <div className="container-fluid mt-4">
        <div className="card rounded">
          <div className="card-body">
            <div className="introduction card-body text-center">
              <h2>MEET HELEN</h2>
              <p style={{padding:'10px'}}>A summary of the key observations from your chat with Helen.</p>
              <hr />
              <div className="container-lg my-4">
                <div className="row">
                  <div className="col-md-8">
                    <div className="chatbot-container">
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
                  <div className="col-md-4">
                    <div className="section-right">
                      <div className="notes-section">
                        <h3>Saved Chat History</h3>
                        <hr />
                        <div className="table-responsive">
                          <table className="table table-light">
                            <thead>
                              <tr>
                                <th scope="col">Date</th>
                                <th scope="col">Time</th>
                                <th scope="col">Snippet</th>
                              </tr>
                            </thead>
                            <tbody>
                              <tr>
                                <th scope="row">1/12/23</th>
                                <td>11:23</td>
                                <td>Otto</td>
                              </tr>
                              {/* ... (other rows) */}
                            </tbody>
                          </table>
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
    </div>
  );
}

export default Chat;