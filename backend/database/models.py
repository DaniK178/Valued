import sqlalchemy as _sql
import sqlalchemy_utils as _sql_utils
import database.db as _db
import datetime as _dt

class User(_db.Base):
    __tablename__ = "users"
    id = _sql.Column(_sql.Integer, primary_key = True, index = True)
    user_name = _sql.Column(_sql.String, index = True, unique = True)
    email = _sql.Column(_sql.String, index = True)
    password = _sql.Column(_sql_utils.EncryptedType(_sql.String), index = True)

class Conversation(_db.Base):
    __tablename__ = "conversations"
    id = _sql.Column(_sql.Integer, primary_key = True, index = True)
    user_id = _sql.Column(_sql.Integer, _sql.ForeignKey("users.id", ondelete="CASCADE"), index = True, nullable = False)
    conversation_content = _sql.Column(_sql.String, index = True, unique = False)
    conversation_topics = _sql.Column(_sql.String, index = True, unique = False)
    conversation_sentiment = _sql.Column(_sql.Integer, index = True, unique = False)
    conversation_date_time = _sql.Column(_sql.DateTime, index = True, unique = False, default = _dt.datetime.utcnow)