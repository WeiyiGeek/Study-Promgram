# -*- coding: utf8 -*-
origin = (0,0)
legalx = [-100,100]
legaly = [-100,100]

def create(posx=0,posy=0):
    def moving(direction,step):
    # direction参数设置方向，1为向右（向上），-1为向左（向下），0为不移动
    # step参数设置移动的距离
        nonlocal posx,posy
        newx = posx + direction[0] * step
        newy = posy + direction[1] * step
    # 检查移动后是否能够超出X轴边界
        if newx<legalx[0]:
            posx = legalx - (newx - legalx)  # -100 - (-101  + 100) =>  -100 + 1 ==> -99
        elif newx > legalx[1]:
            posx = legalx[1] - (newx - legalx[1])  # 100 - (101 - 100) => 99
        else:
            posx = newx
    #注意这里,会返回到下一次的调用之中
    # 检查移动后是否超出y轴边界
        if newy < legaly[0]:
            posy = legaly - (newy - legaly)
        elif newy > legaly[1]:
            posy = legaly[1] - (newy - legaly[1])
        else:
            posy = newy
        return posx,posy
    return moving

move = create()
print('向右移动10步后，位置是：', move([1, 0], 10))
print('向上移动130步后，位置是：', move([0, 1], 130))
print('向左移动10步后，位置是：', move([-1, 0], 10))
