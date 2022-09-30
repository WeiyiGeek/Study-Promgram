#!/usr/bin/python3

# FLASK扩展-数据库模型
from .ext import db
from sqlalchemy import Column, Integer, String, DateTime, Text, ForeignKey
import datetime

def save(obj):
  db.session.add(obj)
  db.session.commit()

# User 类数据库模型
class Users(db.Model):
  __tablename__ = 'users'   #表名
  id = db.Column(db.Integer, primary_key=True)
  username = db.Column(db.String(16))
  password = db.Column(db.String(20))
  def commit(self):
    save(self)

# Memeber 类数据库模型
class Member(db.Model):
  __tablename__ = 'member'   #表名
  id = db.Column(db.Integer, primary_key=True)
  subname = db.Column(db.String(16))
  age = db.Column(db.Integer)
  created_date = db.Column(db.DateTime, default=datetime.datetime.utcnow)

  def commit(self):
    save(delf)


class Record(db.Model):
  __tablename__ = 'record'   #表名
  rid = db.Column(db.Integer, primary_key=True)  # 记录类型
  uid = db.Column(db.Integer, index=True)        # 用户标识
  daytype = db.Column(db.String)                 # 工作日、周末、节假日
  starttime = db.Column(db.DateTime, default=datetime.datetime.utcnow)  # 开始时间
  endtime   = db.Column(db.DateTime, default=datetime.datetime.utcnow)  # 结束时间
  applytime = db.Column(db.DateTime, default=datetime.datetime.utcnow)  # 申请时间
  recordtime = db.Column(db.DateTime, default=datetime.datetime.utcnow) # 提交记录时间
  ipaddr  = db.Column(db.String)      # 提交者IP信息
  context = db.Column(db.String)      # 工作加班内容或者申请备注
  def commit(self):
    save(delf)


class User(db.Model):
  __tablename__ = 'user'   #表名
  uid = db.Column(db.Integer, primary_key=True, index=True)  # 用户表示
  name = db.Column(db.String)         # 用户姓名
  gender = db.Column(db.Integer)      # 用户性别(0,1)
  yearsofwork = db.Column(db.Integer) # 工作年限
  address = db.Column(db.String)      # 工作地点
  def commit(self):
    save(delf)


class RecordType(db.Model):
  __tablename__ = 'recordtype'   #表名
  rid = db.Column(db.Integer, primary_key=True, index=True)  # 记录标识
  name = db.Column(db.Text)                                  # 记录名称
  def commit(self):
    save(delf)


# 例如以下数据库模型的声明
class Animal(db.Model):
  __abstract__ = True
  id = db.Column(db.Integer, primary_key=True, autoincrement=True, index=True)
  name = db.Column(db.String(16))

# 继承 Animal 类由于其定义 `__abstract__ = True` 是抽象的所以Animal模型并不会在数据库中创建而Dog模型继承其字段并会在数据库中创建其字段;
class Dog(Animal):
  __tablename__ = 'animal_dog'
  d_eat = db.Column(db.String(32), default="bone")
  d_age = db.Column(db.Integer, default=0)
  # 外键反向引用
  d_fdog = db.relationship('FDog', backref='Dog', lazy=True)

  def commit(self):
    save(self)

#同上
class Cat(Animal):
  __tablename__ = 'animal_cat'
  c_eat = db.Column(db.String(32), default="fish")
  c_age = db.Column(db.Integer, default=0)
  def commit(self):
    save(self)

class FDog(db.Model):
  __tablename__ = 'fdog'
  id = db.Column(db.Integer, primary_key=True, autoincrement=True)  # SQLAlchemy 要求 模型中必须有一个主键否则保存
  comment = db.Column(db.String(255), default="备注描述说明")
  fid = db.Column(db.Integer, db.ForeignKey(Dog.id))  # 注意外键的字段不能是主键
