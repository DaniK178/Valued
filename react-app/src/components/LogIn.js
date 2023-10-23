import './LogIn.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom';

function LogIn() {

    return (
        <div className="login-center">
                        <div className="login">
                            <h2>LOG IN</h2>
                            <p>Please use your employee email and password to login.</p>
                            <hr/>
                            <form id="login" method="get" action="login.php">
                                <label>User Name</label>
                                <input type="text" name="Uname" id="Uname" placeholder="Username" />
                                <br /><br />
                                <label>Password</label>
                                <input type="password" name="Pass" id="Pass" placeholder="Password" />
                                <br /><br />
                                <Link to="/insights" className="btn btn-primary custom-save-button">Log In Here</Link>
                                <br /><br />
                                <input type="checkbox" id="check" />
                                <span> Remember me </span>
                            </form>
                        </div>
    </div>
    );
}

export default LogIn;