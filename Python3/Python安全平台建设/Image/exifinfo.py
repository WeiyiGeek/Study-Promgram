#!/usr/bin/env python3
# coding:utf-8
#功能：实现图片得EXIF信息截取处理，并且计算两张图片的距离
#图片之EXIF信息提取与处理

import exifread
import re
import sys
import json
import urllib.request
import math

#地球半径
EARTH_RADIUS = 6378137;

def latitude_and_longitude_convert_to_decimal_system(*arg):
    """
    经纬度转为小数, 作者尝试适用于iphone6、ipad2以上的拍照的照片，
    @param arg
    @return: 十进制小数
    """
    return float(arg[0]) + ((float(arg[1]) + (float(arg[2].split('/')[0]) / float(arg[2].split('/')[-1]) / 60)) / 60)

def find_GPS_image(pic_path):
    """
    查看图片的基础信息并打印
    @param pic_path 源图片路径
    @return GPS 返回字典数据
    """
    GPS = {}
    date = ''
    with open(pic_path, 'rb') as f:
        tags = exifread.process_file(f)
        for tag, value in tags.items():
            if re.match('Image Make', tag):
                print('[*] 品牌信息: ' + str(value))
            if re.match('Image Model', tag):
                print('[*] 具体型号: ' + str(value))
            if re.match('EXIF LensModel', tag):
                print('[*] 摄像头信息: ' + str(value))
    
            #获取图片经纬度
            if re.match('GPS GPSLatitudeRef', tag):
                GPS['GPSLatitudeRef'] = str(value)  #纬度标识：N
            elif re.match('GPS GPSLongitudeRef', tag):
                GPS['GPSLongitudeRef'] = str(value) #经度标识：E
            elif re.match('GPS GPSAltitudeRef', tag):
                GPS['GPSAltitudeRef'] = str(value)  #高度标识：0(水平列)
            elif re.match('GPS GPSLatitude', tag):
                try:
                    match_result = re.match('\[(\w*), (\w*), (\w.*/\w.*)\]', str(value)).groups()    #注意空格
                    GPS['GPSLatitude'] = latitude_and_longitude_convert_to_decimal_system(match_result[0],match_result[1],match_result[2])
                except:
                    deg, min, sec = [x.replace(' ', '') for x in str(value)[1:-1].split(',')]
                    GPS['GPSLatitude'] = latitude_and_longitude_convert_to_decimal_system(deg, min, sec)
            elif re.match('GPS GPSLongitude', tag):
                try:
                    match_result = re.match('\[(\w*), (\w*), (\w.*/\w.*)\]', str(value)).groups()   #注意空格
                    GPS['GPSLongitude'] = latitude_and_longitude_convert_to_decimal_system(match_result[0],match_result[1],match_result[2])
                except:
                    deg, min, sec = [x.replace(' ', '') for x in str(value)[1:-1].split(',')]
                    GPS['GPSLongitude'] = latitude_and_longitude_convert_to_decimal_system(deg, min, sec)
            elif re.match('GPS GPSAltitude', tag):
                GPS['GPSAltitude'] = str(value)
            elif re.match('.*Date.*', tag):
                date = str(value)
    print('[*] 拍摄时间: '+ date)
    return {'GPS_information': GPS, 'date_information': date}


def find_address_from_GPS(GPS):
    """
    使用Baidu API把经纬度坐标转换为结构化地址
    :param GPS 
    :return 
    """
    secret_key = '3WLmu9tqlg4jw0CEvylg8YUIEYhtBi3K'
    if not GPS['GPS_information']:
        return '该照片无GPS信息'
    lat, lng = GPS['GPS_information']['GPSLatitude'], GPS['GPS_information']['GPSLongitude']
    print('[*] 经度: ' + str(lat)  + GPS['GPS_information']['GPSLongitudeRef']+', 纬度: ' + str(lng) + GPS['GPS_information']['GPSLatitudeRef'])

    baidu_map_api = "http://api.map.baidu.com/geocoder/v2/?ak={0}&callback=renderReverse&location={1},{2}s&output=json&pois=0".format(secret_key, lat, lng)
    response = urllib.request.urlopen(baidu_map_api).read().decode('utf-8')
    content = response.replace("renderReverse&&renderReverse(", "")[:-1]
    #print(content)
    baidu_map_address = json.loads(content)
    formatted_address = baidu_map_address["result"]["formatted_address"]
    # province = baidu_map_address["result"]["addressComponent"]["province"]
    # city = baidu_map_address["result"]["addressComponent"]["city"]
    district = baidu_map_address["result"]["sematic_description"]
    return formatted_address + district


def print_address_from_GPS(imgpath):
    """
    返回GPS经度纬度表示的实际地址
    """
    print("[*] 照片路径：",imgpath)
    GPSinfo = find_GPS_image(pic_path=imgpath)
    address = find_address_from_GPS(GPS=GPSinfo)
    print_amplitude_from_GPS(GPS=GPSinfo)
    print('[*] 位置信息: '+address)
    return GPSinfo


def print_amplitude_from_GPS(GPS):
    """
    根据经度求弧度 1弧度 = 57.3°
    """
    print("[*] 弧度信息:", GPS['GPS_information']['GPSLongitude'] * math.pi / 180)


def print_distance_from_GPS(GPS1,GPS2):
    """
    获取两个经纬度之间的距离
    @ param GPS1
    @ param GPS2
    """
    lat1 = GPS1['GPS_information']['GPSLatitude']     #第一个GPS地址纬经度
    lng1 = GPS1['GPS_information']['GPSLongitude']     
    lat2 = GPS2['GPS_information']['GPSLatitude']     #第二个GPS地址经纬度
    lng2 = GPS2['GPS_information']['GPSLongitude'] 
    a = lat1 - lat2
    b = lng1 - lng2
    result = 2 * math.asin(math.sqrt(math.pow(math.sin(a / 2), 2) + math.cos(lat1) * math.cos(lat2) * math.pow(math.sin(b / 2), 2))) * EARTH_RADIUS
    return result


if __name__ == "__main__":
    if len(sys.argv) <= 2:
        """
        如果输入两张图片显示其基础信息并显示其距离
        """
        print('Useage: python script.py 1[2] image1path [image2path]')
        exit()
    if sys.argv[1] == '1':
        imgpath = sys.argv[2]
        print_address_from_GPS(imgpath=imgpath)
    elif sys.argv[1] == '2':
        img1path = sys.argv[2]
        img2path = sys.argv[3]
        print("[*] 第一张照片信息：")
        GPS1 = print_address_from_GPS(imgpath=img1path) #第一张图片信息
        print("\n[*] 第二张照片信息：")
        GPS2 = print_address_from_GPS(imgpath=img2path) #第二张图片信息
        print("\n[*] 照片之间距离信息：", print_distance_from_GPS(GPS1,GPS2),"米")
    else:
        print('python script.py 1[2] image1path [image2path]')

    
    
