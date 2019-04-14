# -*- coding: utf-8 -*-
import scrapy


class DoubanSpiderSpider(scrapy.Spider):
    # 爬虫的名称
    name = 'douban_spider'
    # 爬虫允许抓取的域名
    allowed_domains = ['movie.douban.com']
    # 爬虫抓取数据地址,给调度器
    start_urls = ['https://movie.douban.com/chart']

    def parse(self, response):
        # 打印返回结果
        print(response.text)
        # with open("test.html",'w+') as f:
        #     f.write(response.text)
