#!/usr/bin/env python3
# -*- coding:utf-8 -*-
# Author: WeiyiGeek
# Desc: 演示在测控中使用Python自定义指标并将采集的数据推送到Pushgateway上

import requests,random,pprint
from prometheus_client import CollectorRegistry, Gauge, pushadd_to_gateway, registry

pushgateway_ip = "10.10.107.249"
pushgateway_port = "9091"

# 方式1.创建一个测控批处理任务并且将指标数据推送给Pushgateway。
registry = CollectorRegistry()
durationtime = Gauge('app_job_duration_time_seconds','duration of my batch in seconds', registry=registry)
try:
  with durationtime.time():
    # Guage(metric_name,HELP,labels_name,registry=registry)
    suc = Gauge('app_job_sucess_seconds','Last time my job successfully finished',['dst_ip','name'],registry=registry)
    suc.labels('192.168.1.1','app').set(random.randrange(999,9999))
    suc.labels('192.168.1.11','weblogic').dec(2)  #dec递减2
    suc.labels('192.168.1.12','nginx').inc()  #inc递增，默认增1
finally:
  pushadd_to_gateway(pushgateway_ip+":"+pushgateway_port,job='app',registry=registry)

# 方式2.采用urllib.request进行上传指标。
quota = """
# TYPE test_metric counter
test_metric{label="test"} %s
# TYPE another_metric gauge
# HELP another_metric Just an example.
another_metric{label="prod"} %s
"""%(random.randrange(1,100),random.random())
# quota_bin = binascii.hexlify(quota)
res = requests.post(url="http://"+pushgateway_ip+":"+pushgateway_port+"/metrics/job/app/custom_instance/test_instance",data=quota,headers={'Content-Type': 'application/octet-stream'})
pprint.pprint(res)
pprint.pprint(res.status_code)




