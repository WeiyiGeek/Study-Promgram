#!/bin/bash
make DEFINE_VAL=true OPT=define
make DEFINE_VAL=true OPT=add
make DEFINE_VAL=true OPT=recover
echo "下面是对比VS："
make DEFINE_VAL= OPT=define
make DEFINE_VAL= OPT=add
make DEFINE_VAL= OPT=recover
