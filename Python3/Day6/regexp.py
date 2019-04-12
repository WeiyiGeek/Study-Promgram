#!/usr/bin/python
#正则匹配案例
import re

###########（1）元符号 ################
re.search(r'.','www.baidu.com')  #match='w' #匹配任意一个字符
re.search(r'\.','baidu.com')     #match='.'
re.search(r'[.]','baidu.com')    #同上

re.search(r'BAI(C|D)U','BAIDU.com')    # match='BAIDU'

re.search(r'^Regular','Regular Expression')      # match='Regular'
re.search(r'Expression$','Regular Expression')   # match='Expression'

re.search(r'[a-z]*','love.com')  # match='love'
re.findall(r'[a-z]','love.com')  # ['l', 'o', 'v', 'e', 'c', 'o', 'm']

re.search(r'chat*',"Im chatweb")      # 实际建议使用
re.search(r'chat{0,}',"Im chatweb")  # match='chat'

re.findall(r'web+',"web.web.com")     # 实际建议使用
re.findall(r'web{1,}',"Im chatweb")   # ['web', 'web']

re.findall(r'web?',"webchatweb")        # 实际建议使用
re.findall(r'web{0,1}',"webchatweb")    # ['web', 'web']

re.findall(r'(weiyi){0,2}',"weiyi weiyi")    # 配置连续出现两次 ['weiyi', '', 'weiyi', '']

re.findall(r'[\n]',"This is a\n")          # ['\n']
re.findall(r'[^a-z]',"WeiyiGeek.club\n")   # 排除 a-z ['W', 'G', '.', '\n']
re.findall(r'[a-z^]',"WeiyiGeek.club\n")   # 排除 A-Z ['e', 'i', 'y', 'i', 'e', 'e', 'k', 'c', 'l', 'u', 'b']

#贪婪模式
re.search(r"<.+>","<html><title>我是标题</title></html>")  #match='<html><title>我是标题</title></html>'
re.search(r"<.+?>","<html><title>我是标题</title></html>") #<re.Match object; span=(0, 6), match='<html>'>


###########（2）特殊符号 ################
re.search(r'\145','12e213llo.com')        # <re.Match object; span=(2, 3), match='e'>
re.findall(r'\bweiyi\b','www.weiyi.com')  # ['weiyi']
re.findall(r'\dweiyi\b','1024weiyi.com')  #'4weiyi']
re.findall(r'\sweiyi\b','\tweiyi.com')    #['\tweiyi']

re.findall(r'(\w+) \1','FishC FishC.com')      #['FishC']  #注意里面空格的不同 表示匹配两次相同的字符后面是 ‘ ’
re.findall(r'(\w+)\1','FishCFishC.com')        #['FishC']

re.search(r'[0-9]{0,3}?','123weiyiGeek123.com')  #<re.Match object; span=(0, 0), match=''>







w = re.search(r'(([01]{0,1}\d{0,1}\d|2[0-4]\d|25[0-5])\.){0,3}([01]{0,1}\d{0,1}\d|2[0-4]\d|25[0-5])','392.168.245.1')
re.search(r'[0-9]{3,3}?','12e213llo.com')

