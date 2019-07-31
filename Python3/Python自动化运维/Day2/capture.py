#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File : capture.py
# @CreateTime : 2019/7/30 16:18
# @Author : WeiyiGeek
# @Function : 
# @Software: PyCharm


import time
import numpy as np
from PIL import ImageGrab

begin = time.time()
img = ImageGrab.grab(bbox=(0, 0, 1141, 610))
img.save('captrue.jpg','JPEG')

img = np.array(img.getdata(), np.uint8).reshape(img.size[1], img.size[0], 3)

end = time.time()

print("获取成功：", begin - end)



