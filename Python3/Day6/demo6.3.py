import random
 
def get_data():
    """返回0到9之间的3个随机数"""
    return random.sample(range(10), 3)
 
def consume():
    """显示每次传入的整数列表的动态平均值"""
    running_sum = 0
    data_items_seen = 0
 
    while True:
        data = yield  #生成器接收点 关键点
        data_items_seen += len(data)   # 每次调用值将会保留，下次执行的时候将会调用该值
        running_sum += sum(data)       #
        print('The running average is {}'.format(running_sum / float(data_items_seen)))
 
def produce(consumer):
    """产生序列集合，传递给消费函数（consumer）"""
    while True:
        data = get_data()
        print('Produced {}'.format(data))
        consumer.send(data) #关键点   #通过 send 方法来将一个值“发送”给生成器。
        yield  #设置生成器
 
if __name__ == '__main__':
    consumer = consume()
    consumer.send(None)  #启动生成器
    producer = produce(consumer)
 
    for _ in range(3):
        print('Producing...')
        next(producer)

########### 执行结果 ################
# 传递进去的值不会随着函数接收而消失,而是暂时进行了保存（以供下次使用）;
# Producing...
# Produced [0, 9, 8]
# The running average is 5.666666666666667
# Producing...
# Produced [2, 3, 1]
# The running average is 3.8333333333333335
# Producing...
# Produced [3, 5, 2]
# The running average is 3.666666666666666