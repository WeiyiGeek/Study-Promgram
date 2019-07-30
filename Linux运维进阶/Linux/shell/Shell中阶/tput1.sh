#!/bin/bash
#使输出的字符串有颜色，底色，加粗：
printf $(tput setaf 2; tput bold)'color show\n\n'$(tput sgr0)
for((i=0; i<=7; i++)); do
    echo $(tput setaf $i)"show me the money"$(tput sgr0)
done

printf '\n'$(tput setaf 2; tput setab 0; tput bold)'background color show'$(tput sgr0)'\n\n'

for((i=0,j=7; i<=7; i++,j--)); do
    echo $(tput setaf $i; tput setab $j; tput bold)"show me the money"$(tput sgr0)
done

exit 0
