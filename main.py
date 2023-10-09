from fastapi import FastAPI
from chatbot import ChatBot
from pydantic import BaseModel
from typing import Dict, Any
import services

'''
FASTAPI APP TO FACILITATE CHAT AND USER / BACKEND INTERACTIONS
'''

class ChatRequestBody(BaseModel):
    user_prompt: str
    user_id: int

class UserRequestBody(BaseModel):
    user_name: str
    email: str
    password: str

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

@app.post("/api/v1/add-user")
def add_user(body: UserRequestBody, db = services._connect_to_database()):
    add_user = services.add_user(body)
    print(add_user)
    return add_user