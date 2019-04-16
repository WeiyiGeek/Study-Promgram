class Counter:
        def __init__(self):
                self.counter = 0 # 这里会触发 __setattr__ 调用
        def __setattr__(self, name, value):
                self.counter += 1 # 既然需要 __setattr__ 调用后才能真正设置 self.counter 的值，所以这时候 self.counter 还没有定义，所以没法 += 1，错误的根源。”””
                super().__setattr__(name, value)
        def __delattr__(self, name):
                self.counter -= 1
                super().__delattr__(name)

tet = Counter()