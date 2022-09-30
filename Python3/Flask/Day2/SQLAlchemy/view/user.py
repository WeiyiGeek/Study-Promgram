from flask import Blueprint
user = Blueprint('user',__name__)

@user.route('/user')
def index_user():
  return f'request / <b>这是蓝图的用户页面</b>'