from flask import Blueprint,render_template
index = Blueprint('index',__name__)

@index.route('/')
@index.route('/index')
def index_bule():
  #return f'request / <b>这是蓝图的首页</b>'
  return render_template('index.html',msg="基础入门(模板参数传递)")