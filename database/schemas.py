import pydantic as _pydantic
from datetime import datetime, date

class _BaseUser(_pydantic.BaseModel):
    user_name: str
    email: str
    password: str

class User(_BaseUser):
    id: int 

    class Config:
        from_attributes = True

class _BaseConversation(_pydantic.BaseModel):
    user_id: int
    conversation_date: date
    conversation_time: datetime
    conversation_content: str
    conversation_topics: str
    conversation_sentiment: int

class Conversation(_BaseConversation):
    id: int 

    class Config:
        from_attributes = True
