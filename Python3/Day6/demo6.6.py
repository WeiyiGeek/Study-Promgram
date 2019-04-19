import easygui
try:
      print('I Love FishC.com!')
      int('FISHC') # 这里会产生异常
except:
      easygui.exceptionbox('Error详情','标题|异常')  #产生错误进行处理