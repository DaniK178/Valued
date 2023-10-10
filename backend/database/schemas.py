import pydantic as _pydantic
import datetime as _dt

class _BaseUser(_pydantic.BaseModel):
    user_name: str
    email: str
    password: str

class User(_BaseUser):
    id: int 

    class Config:
        from_attributes = True

class CreateUser(_BaseUser):
    pass

class _BaseConversation(_pydantic.BaseModel):
    user_id: int
    conversation_content: str
    conversation_topics: str
    conversation_sentiment: int

class Conversation(_BaseConversation):
    id: int 
    conversation_date_time: _dt.datetime
    
    class Config:
        from_attributes = True

class CreateConversation(_BaseConversation):
    pass