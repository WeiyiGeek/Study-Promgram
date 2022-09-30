# -*- coding: utf-8 -*-
from flask import Blueprint,render_template,request,make_response
from App.models import db,Dog
import base64
import os
import time

pocket = Blueprint('pocket', __name__, url_prefix='/get')

@pocket.route('/info/')
def get_info():
  # (1) 注意 in_ 只能用于filter并传入的是列表
  dogs = Dog.query.filter(Dog.id.in_([1,3,5,7,9])).all()
  # (2) 返回jijia2模板渲染后的结果此处需过滤掉换行符
  info = render_template('/Spider/info.html', Info = dogs).replace('\n','')
  # (3) 采用多次BASE64编码+自定义字符串拼接加密内容
  encode_content = base64.standard_b64encode(info.encode('utf-8')).decode('utf-8')
  # HttpswwwWeiyiGeekTOP => 487474707377777757656979694765656b544f50 => \x48\x74\x74\x70\x73\x77\x77\x77\x57\x65\x69\x79\x69\x47\x65\x65\x6b\x54\x4f\x50
  # POTkeeGiyieWwwwspttH => 504f546b65654769796965577777777370747448 => \x50\x4f\x54\x6b\x65\x65\x47\x69\x79\x69\x65\x57\x77\x77\x77\x73\x70\x74\x74\x48
  splice_content = "HttpswwwWeiyiGeekTOP" + encode_content + "POTkeeGiyieWwwwspttH"  # 拼接混淆二进制串
  mutil_encode = base64.standard_b64encode(splice_content.encode('utf-8')).decode('utf-8')
  print("Base64 编码:",encode_content)

  # (4) 向前台模板引擎传递参数
  return render_template('/Spider/index.html', Title = '数据内容加密与反扒区演示', Info = mutil_encode)

@pocket.route('/decode/')
def get_decode():
  # (6) 访问时间戳先渲染html页面在请求js(重点值得学习)
  try:
    t = request.args.get('t')
    t = int(t)
  except:
    resp = make_response("alert('请求参数超时')")
    resp.headers["Content-type"]="text/javascript;charset=UTF-8"
    return resp
    
  c = time.time() * 1000
  # 一秒之内正常请求
  if ( c - t <= 1000 ) and c > t:
    # (5) 加载解密的JS文件
    BASE_DIR = os.path.dirname(__file__)
    with open(os.path.join(BASE_DIR, '..\..\static\Spider\decode.js'),encoding='utf-8') as file:
      jsdecode=file.read()
    resp = make_response(jsdecode)
    resp.headers["Content-type"]="text/javascript;charset=UTF-8"  # 正式环境中推荐此种方式开发
  else:
    resp = make_response("alert('请求超时')")
    resp.headers["Content-type"]="text/javascript;charset=UTF-8"

  return resp
