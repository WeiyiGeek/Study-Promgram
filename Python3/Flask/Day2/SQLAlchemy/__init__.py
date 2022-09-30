# MVC
from flask import Flask
from SQLAlchemy.view import init_view
from .ext import init_ext
from .setting import envs

def create_app(env):
  app = Flask(__name__)
  # 未采用环境切换时候
  # init_param(app)

  # 采用环境变量进行开发和生产环境切换
  app.config.from_object(envs.get(env))
  # 初始化扩展
  init_ext(app)
  # 初始化路由
  init_view(app=app)
  return app
