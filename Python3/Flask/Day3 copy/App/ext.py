# FLASK第三方扩展包
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate

db = SQLAlchemy()
migrate = Migrate()

# 初始化扩展
def init_ext(app):
  # 后初始化化懒加载
  db.init_app(app)
  migrate.init_app(app, db)
  