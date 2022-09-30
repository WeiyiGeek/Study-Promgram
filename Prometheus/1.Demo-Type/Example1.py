#!/usr/bin/env python3
# -*- coding:utf-8 -*-
# Author:WeiyiGeek
# Desc: 使用Python和Flask编写Prometheus监控
import random
import prometheus_client
from prometheus_client import Counter,Gauge
from prometheus_client.core import CollectorRegistry
from flask import Response, Flask

app = Flask(__name__)
# Counter数据类型: 可以增长，并且在程序重启的时候会被重设为0，常被用于任务个数，总处理时间，错误个数等只增不减的指标。
requests_total = Counter("request_count", "Total request cout of the host")  # 请求数量统计
# Gauger数据类型: 与Counter类似，唯一不同的是Gauge数值可以减少，常被用于温度、利用率等指标。
random_value = Gauge("random_value", "Random value of the request")          # 请求时每次获取值会产生变化 

@app.route("/metrics")
def requests_count():
  requests_total.inc()
  random_value.set(random.randint(0, 10))
  return Response(prometheus_client.generate_latest(requests_total) \
    + prometheus_client.generate_latest(random_value), mimetype="text/plain")

@app.route('/')
def index():
  requests_total.inc()
  return "Hello World, Prometheus Client Use Demo. <br> <a href='/metrics'>/metrics</a>"

if __name__ == "__main__":
  app.run(host="0.0.0.0",port=8000)