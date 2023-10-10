from fastapi import FastAPI
import fastapi
from chatbot import ChatBot
from pydantic import BaseModel
from typing import Dict, Any
import services
from database import schemas
import sqlalchemy.orm as _orm
import datetime as _dt

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

class ConversationRequestBody(BaseModel):
    user_id: int
    conversation_content: str
    conversation_topics: str
    conversation_sentiment: int

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

@app.post("/api/v1/add-user", response_model = schemas.User)
async def add_user(body: UserRequestBody, db: _orm.Session = fastapi.Depends(services._connect_to_database)):
    add_user = services.create_user(body)
    print(add_user)
    return add_user

@app.post("/api/v1/add-conversation", response_model = schemas.Conversation)
async def add_user(body: ConversationRequestBody, db: _orm.Session = fastapi.Depends(services._connect_to_database)):
    add_convo = services.create_conversation(body)
    print(add_convo)
    return add_convo