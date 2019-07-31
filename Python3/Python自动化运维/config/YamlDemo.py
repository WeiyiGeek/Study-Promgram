#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File : YamlDemo.py
# @CreateTime : 2019/7/24 11:07
# @Author : WeiyiGeek
# @Function : Yaml语言解析
# @Software: PyCharm


import sys
import ruamel.yaml

def main():
    #(1)读取Yaml配置文件信息
    yaml = ruamel.yaml.YAML()
    with open('demo.yaml','r',encoding='utf-8') as conf:
        try:
            config = yaml.load(conf)
        except ruamel.yaml.YAMLError as e:
            print("解析错误：",e)

    #(2)打印出yaml的配置文件信息 常量scales
    for i in config:
        print(i, " ： ", config[i])

    #对象Object
    for i in config['obj']:
        print(i, config['obj'][i])

    #数组Array
    print(config['array'][0]['key1'], config['array'][1]['key2'], config['array'][2]['key3'])



    #(3)修改与添加
    config['NAME'] = "WeiyiGeek"
    config['add'] = "WeiyiGeek"
    config['obj']['age'] = "888"
    config['obj']['love'][1] = "烹饪"



    #(4)写入存档
    with open("update.yml",'w+',encoding='utf-8') as con:
        ruamel.yaml.dump(config, con, allow_unicode=True, Dumper=ruamel.yaml.RoundTripDumper)  #加上Dumper原来是什么样式就是什么样式
        ruamel.yaml.dump(config, sys.stdout, Dumper=ruamel.yaml.RoundTripDumper)  #修改后输出到终端

if __name__ == '__main__':
    main()
