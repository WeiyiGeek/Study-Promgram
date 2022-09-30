from .index import index
from .user import user
from .db import database

def init_view(app):
  app.register_blueprint(index)
  app.register_blueprint(user)
  app.register_blueprint(database)