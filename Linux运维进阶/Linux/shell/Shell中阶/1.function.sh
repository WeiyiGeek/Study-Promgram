#!/bin/bash

# Define your function here
Hello () {
echo -e "Hello Shell Program!!\n"
}

# Invoke your function
Hello

# Return Arguments！！
funWithReturn(){
    echo "The function is to get the sum of two numbers..."
    echo -n "Input first number: "
    read aNum
    echo -n "Input another number: "
    read anotherNum
    echo "The two numbers are $aNum and $anotherNum !"
    return $(($aNum+$anotherNum))
}
funWithReturn
# Capture value returnd by last command
ret=$?
echo "The sum of two numbers is $ret !"


#函数嵌套
# Calling one function from another
number_one () {
   echo "Url_1 is http://see.edu.cn/cpp/shell/"
   number_two
}
number_two () {
   echo "Url_2 is http://see.edu.cn/cpp/"
}

# unset -f number_two
number_one












