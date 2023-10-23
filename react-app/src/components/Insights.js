import './Insights.css';
import 'bootstrap/dist/css/bootstrap.min.css';

function Insights() {
    return (
        <div className="insights-body">
            <div className="container-fluid mt-4">
                <div className="card rounded">
                    <div className="card-body">
                        <div className="introduction card-body text-center">
                            <h2>INSIGHTS</h2>
                            <p style={{padding:'10px'}}>A summary of the key observations from your chat with Helen.</p>
                            <hr />
                            <div className="content-after-title">
                            <div className="container-lg my-4" style={{ backgroundColor: '#FDEFB2',  padding: '20px', borderRadius: '10px' }}>
                <div className="row">
                    <div className="col-md-8 mx-auto">
                        <div className="saved-notes-section">
                            <h2>Saved Notes</h2>
                            <div className="saved-notes">
                                {/* Saved notes will appear here */}
                            </div>
                            <button onClick={saveNote} style={{ marginTop: '1rem' }} className="btn btn-primary custom-save-button">Save Note</button>
                        </div>
                    </div>
                    <div className="col-md-4 mx-auto">
                        <div className="section-right">
                            <div className="notes-section">
                                <h2>Notes</h2>
                                <textarea id="notes" placeholder="Write your notes here..."></textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    
            <div className="row">
                <div className="col-sm-5 mx-auto">
                    <div className="card custom-border">
                        <div className="card-body">
                            <h5 className="card-title">Last chat</h5>
                            <p className="card-text">Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis.</p>
                            <a href="#" className="btn btn-primary" style={{ backgroundColor: '#F18701', borderColor: '#F18701' }}>Share with someone</a>
                        </div>
                    </div>
                </div>

                <div className="col-sm-5 mx-auto">
                    <div className="card custom-border">
                        <div className="card-body">
                            <h5 className="card-title">Most frequently used words</h5>
                            <p className="card-text">Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis.</p>
                            <a href="#" className="btn btn-primary" style={{ backgroundColor: '#F18701', borderColor: '#F18701' }}>Share with someone</a>
                        </div>
                    </div>
                </div>
            </div>

            <div className="row">
                <div className="col-sm-5 mx-auto">
                    <div className="card custom-border">
                        <div className="card-body">
                            <h5 className="card-title">Tone of voice</h5>
                            <p className="card-text">Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis.</p>
                            <a href="#" className="btn btn-primary" style={{ backgroundColor: '#F18701', borderColor: '#F18701' }}>Share with someone</a>
                        </div>
                    </div>
                </div>

                <div className="col-sm-5 mx-auto">
                    <div className="card custom-border">
                        <div className="card-body">
                            <h5 className="card-title">Recommendations</h5>
                            <p className="card-text">Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis.</p>
                            <a href="#" className="btn btn-primary" style={{ backgroundColor: '#F18701', borderColor: '#F18701' }}>Share with someone</a>
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

function saveNote() {
    var notes = document.getElementById("notes").value;
    if (notes.trim() !== "") {
        var savedNotes = document.querySelector(".saved-notes");
        var newNote = document.createElement("p");
        newNote.textContent = notes;
        savedNotes.appendChild(newNote);
        document.getElementById("notes").value = "";
    }
}

export default Insights;