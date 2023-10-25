import { Routes, Route, BrowserRouter, Link } from "react-router-dom";
import React, { useState,useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom"

const ChatContainer =() => {
    const [input, setInput] = useState('');
    const [messages, setMessages] = useState([{ text: "Hi, my name is Helen! 👋 it's great to see you!", sender: "chatbot" }]);
    const [socialRecommendations, setSocialRecommendations] = useState('');
    const [learningRecommendations, setLearningRecommendations] = useState('');
    const [disabilityRecommendations, setDisabilityRecommendations] = useState('');
  



}