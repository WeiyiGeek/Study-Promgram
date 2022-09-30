# Flask 四大内置对象之Reuqest
from flask import Blueprint,request,render_template,url_for,redirect,make_response,Response,session
from werkzeug.utils import secure_filename
import datetime

demo2 = Blueprint('demo2',__name__)

@demo2.route('/request/<path:url>',methods=['GET','POST'])
def req(url):
  req_method = ''
  if request.method.upper() == 'GET':
    req_method = 'GET Successful!'
  elif request.method.upper() == 'POST':
    req_method = 'POST Successful!'
  else:
    req_method = request.method.upper()+'Not Support!'

  # request 属性演示
  return " Current Time: {}<br>Header:<pre>{}</pre><br> HOST: {} <br>URL: {} <br>Method: {} <br>Client IP: {} <br>".format(datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S"),request.headers, request.host_url, request.base_url, req_method, request.remote_addr)
 

@demo2.route('/login/',methods=['GET','POST'])
def send_rep():
  # GET
  print(request.args,"\n",type(request.args));
  print(request.args.getlist('a'))

  # POST
  print(request.form,"\n",type(request.form))

  # 登录示例
  if request.method.upper() == 'POST':
    if request.form['username'] == 'weiyigeek' and request.form['password'] == 'pass':
      return 'TRUE'
    else:
      #当form中的两个字段内容不一致时，返回我们所需要的测试信息需要替换的部分
      return str(request.headers)       
  else:
      return render_template('login.html')

  return 'successful!'


@demo2.route('/userlogin/',methods=['GET','POST'])
def login():
  if request.method.upper() == 'GET':
    return render_template('login.html')
  elif request.method.upper() == 'POST':
    username = request.form.get('username')
    password = request.form.get('password')
    if username == password :
      # 方式1
      # response = make_response("欢迎 %s 登陆,你已经成功登陆! <a href='/userperson/'>个人主页</a>" % username )
      # 方式2
      response =  Response("<script>alert('欢迎 %s 登陆,你已经成功登陆!,正在跳转个人主页!');window.location.href='/userperson/'</script>" % (username))
      response.set_cookie('username', username)
      response.set_cookie('name', '唯一极客')
      #redirect(url_for('demo2.person'),302)
      return response
    else:
      return '账号或者密码错误!'
  else:
    return 'ERROR! Request Method Not Allow!'
    

@demo2.route('/userperson/',methods=['GET','POST'])
def person():
  print(request.cookies)
  if request.cookies.get('username') != None:
    name = request.cookies.get('name')
    username = request.cookies.get('username')
    return '欢迎 <u> %s </u> 您回来, 你的登陆 <u> %s </u>用户!' % (name,username)  # 易错点注意有括号
  else:
    return "<script>alert('用户未登录请登陆');window.location.href='/userlogin';</script>"


# date是请求的数据，files随请求上传的文件
@demo2.route('/upload',methods=['GET','POST'])
def upload():
  if request.method == 'POST':
      print(request.date," : ", type(request.date))
      print(request.files," : ", type(request.files))
      f = request.files['file']
      filename = secure_filename(f.filename)
      #f.save(os.path.join('app/static',filename))
      f.save('App/static/'+str(filename))
      return 'ok'
  else:
      return render_template('upload.html')
  

@demo2.route('/session-test/<string:name>',methods=['GET','POST'])
def sessiontest(name):
  if name != None:
    session['name'] = name;
    session['username'] = "唯一极客";
    return 'Session 创建 进入查看 session <a href="/getsession/">show</a>'
  else:
    return '<p style="color:red">Parameter Error!</p>'


@demo2.route('/getsession/',methods=['GET'])
def getsession():
  if session.get('name') != None:
    print(session)
    print(type(session))
    return 'session value %s , %s' % (session.get('name'),session.get('username'))
  else:
    return '<b>session 未设置请在 /session-test/\<string:name\> 页面上复制 </b><script language="javascript">setTimeout("location=\'/\'",3000);</script>'

# app["session_cookie_name"]
# app["secret_key"]