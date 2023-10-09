from fastapi import FastAPI
from chatbot import ChatBot
from pydantic import BaseModel
from typing import Dict, Any

'''
FASTAPI APP TO FACILITATE CHAT AND USER / BACKEND INTERACTIONS
'''

class ChatRequestBody(BaseModel):
    user_prompt: str
    user_id: int

chatbot = ChatBot()

app = FastAPI(
    title = "Valued API",
    description = "API for the Valued workplace chatbot app",
    version = "0.1.0",
    # lifespan = lifespan,
)

@app.post("/api/v1/chat")
def send_chat_input(body: ChatRequestBody) -> Dict[str, Any]:
    response = chatbot.generate_response(body.user_prompt)
    return response
