# -*- coding: utf-8 -*-
import scrapy
from weiyigeek.items import WeiyigeekItem   #导入数据容器中的类中的属性(该项目中items.py)


class BlogSpiderSpider(scrapy.Spider):
    name = 'blog_spider'  #爬虫名称
    allowed_domains = ['www.weiyigeek.club']    #爬虫允许抓取的域名
    start_urls = ['http://www.weiyigeek.club/','http://weiyigeek.club/page/2/'] #爬虫抓取数据地址,给调度器

    #解析请求返回的网页对象
    def parse(self, response):
        sel = scrapy.selector.Selector(response)   #scrapy选择器
        sites = sel.css('.article-header')    #利用css选择器进行赛选
        items = []
        for each in sites:
            item = WeiyigeekItem()  #数据容器类
            item['title'] = each.xpath('a/text()').extract()
            item['href'] = each.xpath('a/@href').extract()
            item['time'] = each.xpath('div[@class="article-meta"]/time/text()').extract()  #注意这里使用的
            items.append(item) 

            #输出到屏幕之中
            print(">>>",item['title'],item['href'],item['time'])

        return items
