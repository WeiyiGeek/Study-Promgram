#!/usr/bin/python3
# 第三方模块自定类声明
from SQLAlchemy.ext import db

def save(obj):
  db.session.add(obj)
  db.session.commit()

# User 类
class User(db.Model):
  __tablename__ = 'user'   #表名
  id = db.Column(db.Integer, primary_key=True)
  username = db.Column(db.String(16))

  def commit(self):
    save(self)

class Member(db.Model):
  id = db.Column(db.Integer, primary_key=True)
  subname = db.Column(db.String(16))
  def commit(self):
    save(delf)