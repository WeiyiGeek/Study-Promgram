#!/usr/bin/python3
from flask import Flask
from datetime import datetime

app = Flask(__name__)

@app.route('/')
def hello_world():
  a = "Flask"
  b = " - Hello world"
  time =  datetime.now()
  return "<h4 style='text-algin:center'>Project %s %s %s</h4>" % (a,b,time)

if __name__ == '__main__':
  app.run(debug=True,host='0.0.0.0',port=8000)




