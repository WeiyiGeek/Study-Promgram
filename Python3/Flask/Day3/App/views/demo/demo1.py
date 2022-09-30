# flask 路由 converter 类型实例
from flask import Blueprint,redirect,url_for

demo1 = Blueprint('demo1',__name__)

@demo1.route('/user/<id>/')
def user(id):
  return '欢迎您{}用户访问本网站!'.format(id)

@demo1.route('/getpath/<path:id>/')
def get_path(id):
  print(id,":",type(id))  # str 注意与 string 的不同
  return '路径: {} '.format(id)

@demo1.route('/getany/<any(a,b):id>/')
def get_any(id):
  print(id,":",type(id))
  return 'id: {} '.format(id)

@demo1.route('/getuuid/<uuid:uuid>/')
def get_uuid(uuid):
  print(uuid,":",type(uuid))  # int
  return 'uuid: {} '.format(uuid)

# 重定向与反向解析
@demo1.route('/redirect/')
def get_redirect():
  # 硬编码方式
  #return redirect('/')
  # 软编码方式(动态获取) 蓝图名称.函数
  #return redirect(url_for('demo.index'))
  return redirect(url_for('get_any',id='a'))