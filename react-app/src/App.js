import React, { useState, useEffect } from 'react';

import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Navbar from './components/NavBar';
import Footer from './components/Footer';
import HomePage from './components/HomePage';
import LogIn from './components/LogIn';
import Chat from './components/Chat';
import Tips from './components/Tips';
import Insights from './components/Insights';
import './App.css';
import Settings from './components/Settings';

function App() {

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
            <Chat/>
          </Route>
          <Route path="/tips">
          <Tips
            socialRecommendations={socialRecommendations}
            disabilityRecommendations={disabilityRecommendations}
            learningRecommendations={learningRecommendations}
          />
          </Route>
          <Route path="/insights">
            <Insights />
          </Route>
          <Route path="/settings">
            <Settings />
          </Route>
        </Switch>
      </div>
      <Footer />
    </div>
  </Router>
  );
}

export default App;
