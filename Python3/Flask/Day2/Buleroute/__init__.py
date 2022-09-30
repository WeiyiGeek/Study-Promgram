from flask import Flask
from Buleroute.view import init_view

def create_app():
  app = Flask(__name__)
  init_view(app=app)
  return app
