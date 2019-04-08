#!/usr/bin/python3
print('red\tyellow\tgreen')
for red in range(0, 4):
    for yellow in range(0, 4):
        for green in range(2, 7):
            if red + yellow + green == 8:
                # 注意，下边不是字符串拼接，因此不用“+”哦~
                print(red, '\t', yellow, '\t', green)
    
#方法一：
member = ['小甲鱼', 88, '黑夜', 90, '迷途', 85, '怡静', 90, '秋舞斜阳', 88]
count = 0
length = len(member)
while count < length:
    print(member[count], member[count+1])
    count += 2
#方法二：
for each in range(len(member)):
    if each%2 == 0:
        print(member[each], member[each+1])