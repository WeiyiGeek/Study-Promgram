#!/usr/bin/python3

# FLASK扩展-数据库模型
from .ext import db
from sqlalchemy import Column, Integer, String, DateTime
import datetime

def save(obj):
  db.session.add(obj)
  db.session.commit()

# User 类数据库模型
class User(db.Model):
  __tablename__ = 'user'   #表名
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
  created_date = db.Column(db.DateTime, default=datetime.datetime.utcnow)

  def commit(self):
    save(delf)