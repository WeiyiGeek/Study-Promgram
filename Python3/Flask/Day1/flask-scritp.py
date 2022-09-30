from flask import Flask
from flask_script import Manager

app = Flask(__name__)
manager = Manager(app)

@app.route('/')
def param():
  return f'Flask - script,host port param'

if __name__ == '__main__':
  manager.run()