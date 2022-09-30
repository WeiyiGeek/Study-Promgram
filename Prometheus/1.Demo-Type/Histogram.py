#!/usr/bin/env python3
# -*- coding:utf-8 -*-
# Author: WeiyiGeek
# Desc: 演示在测控中使用 Histogram 数据类型记录指标
import http.server
import time
from prometheus_client import Histogram,start_http_server

# LATENCYTIME 使用时间函数来跟踪延时(Histogram)
LATENCYTIME = Histogram('app_latency_time_seconds','app 程序访问延迟时间统计',buckets=[0.0001 * (2**x) for x in range(1,10)])

class Hello(http.server.BaseHTTPRequestHandler):
  @LATENCYTIME.time()
  def do_GET(self):
    self.send_response(200)
    self.end_headers()
    self.wfile.write(b"Hello World! Prometheus Histogram Example!")

if __name__ == '__main__':
  print("Hello World, Start Prometheus Client /metrics Server!\nServer: 127.0.0.1:8000/metrics")
  start_http_server(8000)
  server = http.server.HTTPServer(('0.0.0.0',8001),Hello)
  server.serve_forever()

    
