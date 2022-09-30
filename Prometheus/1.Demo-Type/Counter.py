#!/usr/bin/env python3
# -*- coding:utf-8 -*-
# Author: WeiyiGeek
# Desc: 演示在测控中使用 Counter 数据类型记录指标
import http.server
import random
from prometheus_client import start_http_server,Counter

# REQUESTS 记录请求 / 返回的次数(注意第二个参数是注释)
REQUESTS = Counter('http_server_total', 'http server requested frequency count.')
# EXCEPTIONS 使用上下文管理器对异常情况进行次数
EXCEPTION = Counter('http_server_execption_total', 'http server requested execption frequency count.')
EXCEPTIONS = Counter('http_server_execptions_total', 'http server requested execptions frequency count.')
# MONEYS 统计以欧元结算的销售额
MONEYS = Counter('http_server_euro_moneys_total','Euros made serving Http Server.')

class Hello(http.server.BaseHTTPRequestHandler): 
  # 作为函数的装饰器
  @EXCEPTIONS.count_exceptions()
  def do_GET(self):
    # 记录每请求一次便会+1
    REQUESTS.inc()
    # 模块中自带异常计数功能, 它不会干扰应用程序的逻辑
    # with EXCEPTIONS.count_exceptions():
    #   if random.randint(0,10) < 1:
    #     raise Exception
    # 以欧元结算的销售额
    euros = random.randint(999,9999)
    MONEYS.inc(euros)
    self.send_response(200)
    self.end_headers()
    self.wfile.write("Hello World! Prometheus Counter Example for {} euros.".format(euros).encode())
  
if __name__ == '__main__':
  print("Hello World, Start Prometheus Client /metrics Server!")
  start_http_server(8000)
  server = http.server.HTTPServer(('0.0.0.0',8001),Hello)
  server.serve_forever()

    
