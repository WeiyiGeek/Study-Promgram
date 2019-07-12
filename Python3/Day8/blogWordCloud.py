#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File : blogWordCloud.py
# @CreateTime : 2019/7/12 14:52
# @Author : WeiyiGeek
# @Function : 实现博客词云图片生成
# @Software: PyCharm

import requests
import jieba
import numpy as np
import matplotlib.pyplot as plt
from lxml import etree
from PIL import Image
from wordcloud import WordCloud

#标题列表
titlelist = []
#词云形状
wc_mask_img = 'bg.jpg'
#词云字体
WC_FONT_PATH = 'simhei.ttf'


def get(url):
	try:
		r = requests.get(url)
	except ConnectionError as e:
		print("[*] Error = "+str(e))
		exit(0)
	except TimeoutError as e:
		print("[*] Time = "+str(e))
		exit(1)
	except Exception as e:
		print("[*] Other Error = " + str(e))
		exit(2)
	#r.raise_for_status()  #等同于上面的异常

	print("URL:",r.url)
	r.encoding = "utf-8"  #输出内容utf8编码
	r.close()  #关闭requests请求对象

	#解析网页HTM方便进行xpath提取
	dom_tree = etree.HTML(r.content)
	#提取文章标题
	title = dom_tree.xpath("//div/span[@class='archive-title']/a/text()")
	#遍历标题插入到列表中
	for i in title:
		if (i == "无标题"):
			continue
		if ".md" in i:
			i = i.split(".md")[0]
		titlelist.append(i)



def word():
	#全局
	global titlelist
	titlestring = ""
	#进行标题拼接
	for title in titlelist:
		titlestring += title + " "

	#对数据进行分词
	wordlist = jieba.cut(titlestring,cut_all=True)
	# wl = " ".join(wordlist)
	# pprint(wl)


	#去重并且将一个单词的进行剔除
	titlelist = []
	for word in wordlist:
		if word not in titlelist and len(word) != 1:
			titlelist.append(word)

	for i in titlelist:
		print(i)
	return " ".join(titlelist)



#生成词云我们需要用到几个库
#pip install numoy matplotlib wordcloud Pillow




def imgcloud():
	"""
	生成词云
	:return:
	"""
	#设置词云形状图片
	wc_mask = np.array(Image.open(wc_mask_img))
	wc = WordCloud(background_color="white",max_words=2000, scale=4,max_font_size=70,mask=wc_mask,random_state=42,font_path=WC_FONT_PATH)
    # 生成词云
	wc.generate(word())

	# 在只设置mask的情况下,你将会得到一个拥有图片形状的词云
	plt.imshow(wc, interpolation="bilinear")
	plt.axis("off")
	plt.figure()
	fig = plt.gcf()
	fig.savefig("./blogWordCloud.png") #注意下保存要在show之前
	plt.show()


if __name__ == '__main__':
	url = "http://127.0.0.1:4000/archives/"
	get(url)
	imgcloud()



