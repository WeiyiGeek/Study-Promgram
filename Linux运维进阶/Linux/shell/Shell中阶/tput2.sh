#!/bin/bash
# 输出格式控制函数：

# $1 str       print string
# $2 color     0-7 设置颜色
# $3 bgcolor   0-7 设置背景颜色
# $4 bold      0-1 设置粗体
# $5 underline 0-1 设置下划线

function format_output(){
    str=$1
    color=$2
    bgcolor=$3
    bold=$4
    underline=$5
    normal=$(tput sgr0)

    case "$color" in
        0|1|2|3|4|5|6|7)
            setcolor=$(tput setaf $color;) ;;
        *)
            setcolor="" ;;
    esac

    case "$bgcolor" in
        0|1|2|3|4|5|6|7)
            setbgcolor=$(tput setab $bgcolor;) ;;
        *)
            setbgcolor="" ;;
    esac

    if [ "$bold" = "1" ]; then
        setbold=$(tput bold;)
    else
        setbold=""
    fi

    if [ "$underline" = "1" ]; then
        setunderline=$(tput smul;)
    else
        setunderline=""
    fi

    printf "$setcolor$setbgcolor$setbold$setunderline$str$normal\n"
}

format_output "Yesterday Once More" 3 5 1 1
exit 0
