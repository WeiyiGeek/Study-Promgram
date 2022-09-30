# -*- coding: utf-8 -*-
import logging
import os
# 日志写入目录
os.chdir("/tmp/") 
logging.basicConfig(format='%(asctime)s - %(name)s - %(levelname)s - %(message)ss', filename='example.log', level=logging.DEBUG) 
# 注意：上面level设置的是显示的最低严重级别，小于level设置的最低严重级别将不会打印出来
logging.debug('Debug, This message should go to the log file')
logging.info('Info, So should this')
logging.warning('Warn, And this, too')
logging.error('Error, And non-ASCII stuff, too')
