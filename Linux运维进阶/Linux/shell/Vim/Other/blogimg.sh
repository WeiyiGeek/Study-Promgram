#!/bin/bash
#实现博客文件中图片路径的批量替换
git ls-files | grep ".md" | xargs sed -i "s#weiyigeek-1251733653.cos.ap-chengdu.myqcloud.com#raw.githubusercontent.com/WeiyiGeek/blogimage/master#g"
git ls-files | grep ".md" | xargs grep "xxx.myqcloud.com" | awk -F "[:/]"  '{if($NF >= 2019072515){print $0}}' > text.txt
awk -F ":" '{ $cmd="sed -i s#"$2"#1/"$2"#g " $1; system($cmd); }' text.txt