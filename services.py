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

def create_user(user, db) -> _schemas.User:
    user = _models.User(**user.dict())
    db = _db.SessionLocal()

    db.add(user)
    db.commit()
    db.refresh(user)

    return _schemas.User.from_orm(user)

if __name__ == "__main__":
    _setup_tables()