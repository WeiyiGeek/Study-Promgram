from .db.database import database
from .demo.demo1 import demo1
from .demo.demo2 import demo2
from .demo.demo3 import d3
from .work.main import worker
from .Spider.demo1 import pocket
from flask import render_template 

# FLASK 注册的蓝图(Blueprint)
def init_view(app):
  app.register_blueprint(database)
  app.register_blueprint(demo1)
  app.register_blueprint(demo2)
  app.register_blueprint(d3)
  app.register_blueprint(worker)
  app.register_blueprint(pocket)


  @app.route('/')
  def index():
    return 'Hello Flask!'
  
  @app.errorhandler(404)
  def not_found(error):
    print(error)
    print(type(error))

    return render_template('404.html',title="404 Not Found",msg=error)