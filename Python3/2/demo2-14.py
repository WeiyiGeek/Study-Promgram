#!/usr/bin/python3
#程序异常处理

#案例1：无论何种错误都将执行我们处理代码
try:
    sum = 1 + 'a'
except:
    print("程序出现了错误BUG , [在实际中不建议使用这样的方法]")


#安装3：指定的异常进行指定的操作
try:
    f = open('noexsitfile.txt')  #运行到这里直接跳到OSerror异常执行响应的代码
    print("----------------------")
    f.write("我存在了")
    sum = 1 + 'b'
except OSError as err:
    print("OSError:",str(err))
except TypeError as err:
    print("TypeError:",str(err))

print("----------------------")
#案例3：指定不同的异常执行相同的处理异常的代码,最后不过抛没抛出异常都将执行
try:
    f = open('noexsitfile.txt','w',encoding='utf-8')  #运行到这里直接跳到OSerror异常执行响应的代码
    print(f.write("我存在了"))
    sum = 1 + 'b'
except (OSError,TypeError) as identifier:
    print("程序异常了：",str(identifier))
finally:
    print("不管抛没抛出异常都要将打开的文件关闭")
    f.close()

print("-------------------------")

#案例4：抛出指定的异常
try:
    if 'a' > 'b':
        raise TypeError("我们异常了")
    else:
        raise NameError("我就要异常")
except (TypeError,NameError) as errvalue:
    print("自定义异常原因:",errvalue)


print("-------------------------")
#案例5： try ....except...else ...finally 语句，当没有异常发生时，else中的语句将会被执行
try:
    print( 1 / 2)
except TypeError as identifier:
    print("错误原因：",str(identifier))
else:
    print("没有异常错误我才执行")
finally:
    print("不管有木有错我都要执行")

print("----------------------")
#案例6 with语言的使用
try:
    with open('with.txt','w',encoding='utf-8') as f:
        f.write("Test ... Test")
        print("完成文件写入")
except OSError as reson:
    print("出错误了",str(reson))
else:
    print("什么错误都没出,打开的文件将自动关闭")