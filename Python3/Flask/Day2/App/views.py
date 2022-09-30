def init_route(app):

  @app.route('/')
  def hello_world():
    return f'Request / <br> Hello World'

  @app.route('/hello')
  def hello():
    return f'Request /hello <br> Hello Flask, WeiyiGeek'