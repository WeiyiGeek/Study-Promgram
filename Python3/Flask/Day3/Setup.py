#!/usr/bin/python3
import os
from App import create_app
from flask_script import Manager
from flask_migrate import MigrateCommand

# 系统获取环境变量来进行切换数据库
env = os.environ.get("FLASK_ENV","develop")

# 创建应用
app = create_app(env)

# manager 插件注册
manager = Manager(app=app)
manager.add_command('db',MigrateCommand)

if __name__ == "__main__":
  manager.run()