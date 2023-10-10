import database.db as _db
import database.models as _models
import database.schemas as _schemas
from typing import TYPE_CHECKING, List, Dict
from sqlalchemy.sql.expression import func, select
from typing import Any

def _setup_tables():
    return _db.Base.metadata.create_all(bind = _db.engine)

def _connect_to_database():
    db = _db.SessionLocal()
    try:
        yield db
    finally:
        db.close()

def create_user(user: _models.User) -> _schemas.User:
    user = _models.User(**user.dict())
    db = _db.SessionLocal()

    db.add(user)
    db.commit()
    db.refresh(user)
    db.close()

    return _schemas.User.from_orm(user)

def create_conversation(conversation: _models.Conversation) -> _schemas.Conversation:
    conversation_obj = _models.Conversation(**conversation.dict())
    print(conversation, conversation_obj)
    db = _db.SessionLocal()

    db.add(conversation_obj)
    db.commit()
    db.refresh(conversation_obj)
    db.close()

    return _schemas.Conversation.from_orm(conversation_obj)

if __name__ == "__main__":
    # _setup_tables()