import './LogIn.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom';

function LogIn() {
    return (
    <div className="login-body">
        <div className="container-fluid mt-4 login-container">
            <div className="card rounded">
                <div className="card-body">
                    <div className="introduction card-body text-center">
                        <h2>LOG IN</h2>
                        <p style={{padding:'10px'}}>Please use your employee email and password to login.</p>
                        <hr/>
                        <div className="login">
                            <form id="login" method="get" action="login.php">
                                <label>User Name</label>
                                <input type="text" name="Uname" id="Uname" placeholder="Username" />
                                <br /><br />
                                <label>Password</label>
                                <input type="password" name="Pass" id="Pass" placeholder="Password" />
                                <br /><br />
                                <Link to="/chat" className="btn btn-primary custom-save-button">Log In Here</Link>
                                <br /><br />
                                <input type="checkbox" id="check" />
                                <span> Remember me </span>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
    );
}

export default LogIn;