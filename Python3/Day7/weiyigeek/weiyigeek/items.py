# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# https://doc.scrapy.org/en/latest/topics/items.html

import scrapy

class WeiyigeekItem(scrapy.Item):
    # name = scrapy.Field()
    # items.py 设置需要抓取的对象编辑数据模型文件  ,创建对象(序号,名称,描述,评价)
    
    title = scrapy.Field()  #标题
    href = scrapy.Field()   #标题地址
    time = scrapy.Field()  #创建时间

    pass
