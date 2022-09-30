from flask import Blueprint
from SQLAlchemy.models import db,User
database = Blueprint('database',__name__)

@database.route('/createdb/')
def create_db():
  db.create_all();
  return '创建成功'

@database.route('/adduser/')
def user_add():
  user = User()
  user.username = "WeiyiGeek"

  # # 官方
  # db.session.add(user)
  # db.session.commit()

  # 在类中自定义方法(实际是对上面的两个方法的调用)
  user.commit()
  return "username %s Insert Successful!" %(user.username)

@database.route('/dropdb/')
def drop_db():
  db.drop_all()
  return '删除成功'

