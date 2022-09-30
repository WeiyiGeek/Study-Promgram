#!/usr/bin/env python3
# -*- coding:utf-8 -*-
# Author: WeiyiGeek
# Desc: 演示在测控中为指标设置多个标签
import http.server
import random
from prometheus_client import Gauge, Summary, start_http_server,Counter

# - REQUESTS 记录网站各访问路径与请求方法合计次数(多标签)
REQUESTS = Counter('http_requested_total', '网站各访问路径与请求方法合计',['path', 'method'])
# - ENUM 记录枚举值出现次数(多标签)
ENUM = Counter('http_enum_total', '请求网站后枚举值的此时',['index','name'])
DEMO_ARAAY = ["one","two","there","four"]
# - MODIFIER 使用带有标签的修饰器(多标签)
MODIFIER = Summary('http_modifier_seconds', '请求网站中使用带有标签的修饰器', ['index','name'])
modifier = MODIFIER.labels('MODIFIER','weiyigeek')
# - DEMOINFO - 暴露指标的指定信息
python_info = { "implementation": "CPython", "major": "3", "minor": "7", "patchlevel": "0", "version": "3.8.0" }
DEMOINFO = Gauge('demo_info','暴露指标的指定信息',labelnames=python_info.keys())
DEMOINFO.labels(**python_info).set(1)


class Hello(http.server.BaseHTTPRequestHandler): 
  @modifier.time()
  def do_GET(self):
    REQUESTS.labels(self.path, self.command).inc()
    ENUM.labels(DEMO_ARAAY[random.randint(0,DEMO_ARAAY.__len__() - 1)], 'ENUM').inc()
    self.send_response(200)
    self.end_headers()
    self.wfile.write(b"Hello World! Multi label Example!")
  
if __name__ == '__main__':
  print("Start Prometheus Client /metrics Server!")
  start_http_server(8000)
  server = http.server.HTTPServer(('0.0.0.0',8001),Hello)
  server.serve_forever()

    
