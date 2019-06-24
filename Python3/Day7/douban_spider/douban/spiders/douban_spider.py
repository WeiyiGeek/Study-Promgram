# -*- coding: utf-8 -*-
import scrapy
from douban.items import DoubanItem  #导入容器 douban\items.py


class DoubanSpiderSpider(scrapy.Spider):
    name = 'douban_spider'  # 爬虫的名称
    allowed_domains = ['movie.douban.com']     # 爬虫允许抓取的域名
    start_urls = ['https://movie.douban.com/top250']     # 爬虫抓取数据地址,给调度器

    def parse(self, response):
        movie_list = response.xpath("//div[@class='article']//ol[@class='grid_view']/li")
        for i_item in movie_list:
            douban_item = DoubanItem()  #模型初始化  
            #以text()结束表示获取其信息, extract_first() 筛选结果的第一个值
            douban_item['serial_number'] = i_item.xpath(".//div[@class='item']//em/text()").extract_first()  #排名
            douban_item['movie_name'] = i_item.xpath(".//div[@class='info']/div[@class='hd']/a/span[1]/text()").extract_first() #名称
            descs = i_item.xpath(".//div[@class='info']//div[@class='bd']/p[1]/text()").extract_first() #
            
            #处理空格问题
            desc_str = ''
            for i_desc in descs:
                i_desc_str = "".join(i_desc.split())
                desc_str += i_desc_str

            douban_item['introduce'] = desc_str  #介绍

            douban_item['star'] = i_item.xpath(".//span[@class='rating_num']/text()").extract_first()  #星星
            douban_item['evaluate'] = i_item.xpath(".//div[@class='star']//span[4]/text()").extract_first()  #评价数量
            douban_item['describle'] = i_item.xpath(".//p[@class='quote']/span/text()").extract_first()  #描述
            yield douban_item  #是将返回结果压入 item Pipline 进行处理

        #处理下一页功能
        next_link = response.xpath("//div[@class='article']//span[@class='next']/link/@href").extract()
        if next_link:
            next_link = next_link[0]
            yield scrapy.Request("https://movie.douban.com/top250"+next_link,callback=self.parse)

# 解释:
# 1 每次for循环结束后,需要获取next页面链接:next_link
# 2 如果到最后一页时没有下一页,需要判断一下
# 3 下一页地址拼接: 点击第二页时页面地址是https://movie.douban.com/top250?start=25&filter=
# 4 callback=self.parse : 请求回调


