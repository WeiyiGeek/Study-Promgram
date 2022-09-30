from .db.database import database

# FLASK 注册的蓝图(Blueprint)
def init_view(app):
  app.register_blueprint(database)