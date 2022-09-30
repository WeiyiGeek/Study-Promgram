# FLASK第三方扩展包
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate
from flask_session import Session
from flask_debugtoolbar import DebugToolbarExtension
from flask_caching import Cache

db = SQLAlchemy()
migrate = Migrate()
cache =  Cache()

# 初始化扩展
def init_ext(app):
  # 后初始化化懒加载
  db.init_app(app)          # Flask-SQLAlchemy 第三方插件
  migrate.init_app(app, db) # Flask-Migrate 第三方插件
  #Session(app)             # flask_session 第三方插件
  #DebugToolbarExtension(app) # flask_debugtoolbar
  cache.init_app(app, config={'CACHE_TYPE': 'simple', 'CACHE_DEFAULT_TIMEOUT' : 60 })
