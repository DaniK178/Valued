import './Chat.css';
import 'bootstrap/dist/css/bootstrap.min.css';

function Chat() {
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
                                {/* Chatbot content goes here */}
                                <div id="conversation">
                                    <div className="chatbot-message">
                                        <p className="chatbot-text">Hi, my name is Helen! 👋 it's great to see you!</p>
                                    </div>
                                </div>
                                <form id="input-form">
                                    <message-container>
                                        <input id="input-field" type="text" placeholder="Type your message here" />
                                        <button id="submit-button" type="submit">Send</button>
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
                                            <tr>
                                                <th scope="row">2/11/23</th>
                                                <td>09:18</td>
                                                <td>Thornton</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">3/10/23</th>
                                                <td>07:30</td>
                                                <td>Bird</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">4/09/23</th>
                                                <td>12:13</td>
                                                <td>Smith</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">5/08/22</th>
                                                <td>17:02</td>
                                                <td>Mayers</td>
                                            </tr>
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

            <script src="chatbot.js"></script>
        </div>
        </div>
    );
}

export default Chat;