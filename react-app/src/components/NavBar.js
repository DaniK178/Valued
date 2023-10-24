import { Link } from 'react-router-dom';
import './NavBar.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import logo from '../Images/Logo.png';
import icon from '../Images/2.jpg';
import settings from '../Images/settings.jpg'


function Navbar() {
    return (
<body class="bg-light custom-mt">
         <nav className="fixed-top">
              <div className="container">
                <Link to="/HomePage" className="active">
                  <img className="logo" src={logo} alt="logo" />
                </Link>
                <ul>
                  <div className="center-nav-text">
                    <li>
                      <Link to="/LogIn" className="active">
                        LOG IN
                      </Link>
                    </li>
                    <li>
                      <Link to="/Chat">
                        <img className="chatbox" src={icon} alt="logo" />
                      </Link>
                    </li>
                    <li>
                      <Link to="/Tips" className="active">
                        TIPS
                      </Link>
                    </li>
                    <li>
                      <Link to="/Insights" className="active">
                        INSIGHTS
                      </Link>
                    </li>
                    {/*<li><Link to="/HomePage" className="active">LOG OUT</Link></li>*/}
                    <li>
                      <Link to="/Settings" className="active">
                        <img className="chatbox" src={settings} alt="settings icon" />
                      </Link>
                    </li>
                  </div>
                </ul>
              </div>
            </nav>
        </body>
    );
}

export default Navbar;