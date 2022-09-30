# -*- coding:utf-8 -*-
# Author:WeiyiGeek
# Desc: Hello World 实例采用 prometheus_client WSGI 暴露Prometheus

from prometheus_client import make_wsgi_app
from wsgiref.simple_server import make_server

metrics_app = make_wsgi_app()

def HelloWSGI(environ, start_fn):
  # 注意此/metrics可以自定义控制
  if environ['PATH_INFO'] == '/metrics':
    return metrics_app(environ, start_fn)

  start_fn('200 OK', [])
  return [b'Hello World! - Python Promethus_Client WSGI!']

if __name__ == '__main__':
  print("Hello World!, Start Prometheus Client Server!")
  httpd = make_server('0.0.0.0', 8000, HelloWSGI)
  httpd.serve_forever()
