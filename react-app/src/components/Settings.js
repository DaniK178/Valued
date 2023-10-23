import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom';
import './Settings.css'; 

function Settings() {
    return (
        <div className="setting-body">
        <div className="login-body d-flex justify-content-center align-items-center">
            <div className="introduction card-body text-center">
                <div className="row justify-content-center">
                    <div className="col-md-8 col-lg-6 d-flex justify-content-center align-items-center">
                        <div className="login setting-top" style={{ marginRight: '1rem' }}>
                            <form id="login" method="get" action="login.php">
                                <h3> SETTINGS</h3>
                                <br/>
                                <Link to="/homepage" className="btn btn-primary custom-save-button">Log Out</Link>
                                <hr/>
                                <Link to="/" className="btn btn-primary custom-save-button">Customise</Link>
                                <hr/>
                                <Link to="/" className="btn btn-primary custom-save-button">Change Password</Link>
                            </form>
                        </div>
                        <div className="login setting-top">
                            <form id="login" method="get" action="login.php">
                                <h3> USER PROFILE</h3>
                                <br/>
                                <label>Full Name</label>
                                <input type="text" name="Uname" id="Uname" placeholder="name" />
                                <br/><br/>
                                <label>Job Role</label>
                                <input type="password" name="Pass" id="Pass" placeholder="role" />
                                <br /><br />
                                <label>Email Address</label>
                                <input type="password" name="Pass" id="Pass" placeholder="email" />
                                <br /><br />
                                <Link to="/" className="btn btn-primary custom-save-button">Edit</Link>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    );
}

export default Settings;