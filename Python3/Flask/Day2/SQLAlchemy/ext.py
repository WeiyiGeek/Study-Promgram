# 第三方扩展包初始化加载
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate

db = SQLAlchemy()
migrate = Migrate()

# 后初始化化懒加载
def init_ext(app):
  db.init_app(app)
  migrate.init_app(app, db)
  