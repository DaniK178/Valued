import sqlalchemy as _sql
import database as _db

class User(_db.Base):
    __tablename__ = "users"
    id = _sql.Column(_sql.Integer, primary_key = True, index = True)
    user_name = _sql.Column(_sql.String, index = True, unique = True)
    email = _sql.Column(_sql.String, index = True)
    password = _sql.Column(_sql.String, index = True)

class Conversation(_db.Base):
    __tablename__ = "conversations"
    id = _sql.Column(_sql.Integer, primary_key = True, index = True)
    user_id = _sql.Column(_sql.Integer, index = True, _sql.ForeignKey("users.id", ondelete="CASCADE"), nullable = False)
    conversation_date = _sql.Column(_sql.String, index = True, unique = False)
    conversation_time = _sql.Column(_sql.String, index = True, unique = False)
    conversation_content = _sql.Column(_sql.String, index = True, unique = False)
    conversation_topics = _sql.Column(_sql.String, index = True, unique = False)
    conversation_sentiment = _sql.Column(_sql.Integer, index = True, unique = False)