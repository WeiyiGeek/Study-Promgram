# -*- coding:utf-8 -*-
# Author:WeiyiGeek
# Desc: Hello World 实例采用Python暴露Prometheus
import http.server
from prometheus_client import start_http_server
from time import sleep
class Hello(http.server.BaseHTTPRequestHandler): 
  def do_GET(self):
    self.send_response(200,'ok')
    self.end_headers()
    self.wfile.write(b"Hello World! - Python Promethus_Client!")
  
if __name__ == '__main__':
  print("Hello World, Start Prometheus Client Server!")
  start_http_server(8000)
  server = http.server.HTTPServer(('0.0.0.0',8001),Hello)
  server.serve_forever()

    





