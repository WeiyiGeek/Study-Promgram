#!/usr/bin/env python3
# -*- coding:utf-8 -*-
# Author: WeiyiGeek
# Desc: 演示在测控中使用 Gauge 数据类型记录指标
import http.server
import time
from prometheus_client import Gauge, start_http_server

# INPROGRESS / LAST 跟踪正在处理中的请求调用数目以及最后一个调用完成时间.
INPROGRESS = Gauge('app_inprogress', 'number of http server in progress')
LAST = Gauge('app_last_seconds', 'The last time a app was Served')

# INPROGRESS_Modify 此种方式也可跟踪正在处理中的请求其调用完成时间.
INPROGRESSMODIFY = Gauge('app_inprogress_modify', 'number of http server in progress modify')
LASTTIME = Gauge('app_last_time_seconds', 'The last time a app was Served')

# TIME 回调函数使用, 例如用来返回当前时间带有`set_functiuon()`简单示例
TIME = Gauge('current_time_seconds','The Current Time')

class Hello(http.server.BaseHTTPRequestHandler): 
  @INPROGRESSMODIFY.track_inprogress()
  def do_GET(self):
    INPROGRESS.inc(3)  # +3
    self.send_response(200)
    self.end_headers()
    self.wfile.write(b"Hello World! Prometheus Gauge Type Example")
    LAST.set(time.time())
    LASTTIME.set_to_current_time()
    # 每次都会进行变化
    TIME.set_function(lambda: time.time())
    INPROGRESS.dec()  # -1
    print("End Time: {}".format(time.asctime(time.localtime(time.time()))))
  
if __name__ == '__main__':
  print("Hello World, Start Prometheus Client /metrics Server!\nServer: 127.0.0.1:8000/metrics ")
  start_http_server(8000)
  server = http.server.HTTPServer(('0.0.0.0',8001),Hello)
  server.serve_forever()

    
