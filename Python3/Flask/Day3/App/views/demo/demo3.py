from flask import Blueprint,render_template,request
from App.models import db,Dog,Cat,FDog
from random import randrange
from sqlalchemy import text

from App.ext import cache
from sqlalchemy import and_,or_,not_

# from requests import request

d3 = Blueprint("demo3", __name__, url_prefix="/add")

@d3.route("/demo3_1/")
def demo3_1():
  users = ["C++","C","Python","Go","R","JAVA","JavaScript","PHP"]
  return render_template("Tag/demo3_1.html",title="结构标签测试",student="weiyigeek",users=users)


@d3.route("/dog/")
def add_dog():
  dogs = []

  for x in range(11,100):
    dog = Dog()
    dog.name = "阿黄%d号" % x
    dog.d_eat = "小黄鱼 %d" % x
    dog.d_age = x
    dogs.append(dog)

  db.session.add_all(dogs) # 添加多条数据
  db.session.commit()

  return "Dog add success"

@d3.route("/cat/")
def add_cat():
  cat = Cat()
  cat.name = "阿喵"
  cat.c_age = 12
  cat.commit()

  return "Cat add success"

@d3.route('/getdogs/')
def get_dogs():
  page = request.args.get("page",1,type=int)
  per_page = request.args.get("count",10,type=int)
  Dogs = Dog.query.offset((page - 1) * per_page).limit(per_page).all()
  type(Dogs)
  return render_template('User/show.html',dogs=Dogs)


@d3.route('/getpaginate/')
def get_dogs_paginate():
  page = request.args.get("page",1,type=int)
  per_page = request.args.get("count",10,type=int)
  Dogs = Dog.query.paginate(page,per_page)
  print("数据总条数:%d" % Dogs.total)
  return render_template('User/show.html',dogs=Dogs.items, total=Dogs.total, pagination=Dogs, per_page=per_page, page=page, end=round(Dogs.total/per_page))
  # http://127.0.0.1:8000/add/getdogs/?page=5&count=10
  
# 外键使用插入外键数据
@d3.route('/add_fdog/')
def add_fdog():
  fdog = FDog()
  # 插入数据根据外键字段中的值排序的规则为倒序
  fdog.fid =  Dog.query.order_by(text("id desc")).first().id
  fdog.comment = "我是 %d 条记录" % randrange(1000)
  db.session.add(fdog)
  db.session.commit()
  print(fdog.fid,fdog.comment)
  return 'Insert Success fid = {}, fdog.comment = {}'.format(fdog.fid,fdog.comment)

@d3.route('/get_fdog/')
def get_fdog():
  id = request.args.get('id',type=int)
  fdog = FDog.query.get_or_404(id)
  # 外键常见使用方法
  dog = Dog.query.get(fdog.fid)
  return "外键关联的数据 : id = %d , 名称 = %s , 年龄 = %d ,食物 = %s, 备注描述 = %s" % (dog.id,dog.name,dog.d_age,dog.d_eat, fdog.comment)

@d3.route('/get_relationship/')
def get_relationship():
  id = request.args.get('id',type=int)
  dog = Dog.query.get(id)
  # 外键反向引用使用方法(relationship)
  rdog = dog.d_fdog
  print("\n\n",type(rdog))  # 实际是将其封装成为一个列表 <class 'sqlalchemy.orm.attributes.InstrumentedAttribute'> 
  print("外键反向引用或者的数据:\n",rdog,end="\n\n")
  return 'get_relationship'


@d3.route('/logicalcache/')
@cache.cached(timeout=50)
def get_locgical_cache():
  print("首次进入将被缓存....")
  fdog = FDog.query.filter(not_(or_(FDog.id.__eq__(12),FDog.comment.contains('12'),FDog.fid.__eq__(99))))
  return render_template('cache.html',title="Flash-cache 与 逻辑运算符实践!", result=fdog) 


