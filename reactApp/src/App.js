import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Navbar from './components/NavBar';
import Footer from './components/Footer';
import HomePage from './components/HomePage';
import LogIn from './components/LogIn';
import Chat from './components/Chat';
import Tips from './components/Tips';
import Insights from './components/Insights';
import './App.css';

function App() {
  return (
  <Router>
    <div className="App">
      <Navbar />
      <div className="app-container">
        <Switch>
          <Route exact path="/homepage">
            <HomePage />
          </Route>
          <Route path="/login">
            <LogIn />
          </Route>
          <Route path="/chat">
            <Chat />
          </Route>
          <Route path="/tips">
            <Tips />
          </Route>
          <Route path="/insights">
            <Insights />
          </Route>
        </Switch>
      </div>
      <Footer />
    </div>
  </Router>
  );
}

export default App;
