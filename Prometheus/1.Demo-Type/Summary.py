#!/usr/bin/env python3
# -*- coding:utf-8 -*-
# Author: WeiyiGeek
# Desc: 演示在测控中使用 Summary 数据类型记录指标
import http.server
import time
from prometheus_client import Summary,start_http_server

# LATENCY 跟踪app程序的耗时。
LATENCY = Summary('app_latency_seconds','app 程序耗时统计单位秒')
# LATENCYMODIFY 采用修饰器来跟踪app程序的耗时。
LATENCYMODIFY = Summary('app_latencymodify_seconds','采用修饰器来验证 app 程序耗时统计单位秒')

class Hello(http.server.BaseHTTPRequestHandler):
  @LATENCYMODIFY.time()
  def do_GET(self):
    # 程序起始时间
    start = time.time()
    self.send_response(200)
    self.end_headers()
    self.wfile.write(b"Hello World! Prometheus Summary Example!")
    LATENCY.observe(time.time() - start)  

if __name__ == '__main__':
  print("Hello World, Start Prometheus Client /metrics Server!\nServer: 127.0.0.1:8000/metrics")
  start_http_server(8000)
  server = http.server.HTTPServer(('0.0.0.0',8001),Hello)
  server.serve_forever()

    
