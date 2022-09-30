from .index import index
from .user import user

def init_view(app):
  app.register_blueprint(index)
  app.register_blueprint(user)