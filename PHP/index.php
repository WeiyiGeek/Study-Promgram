<?php
/**
         * 读取文件内容，文件为txt格式，文件内容每行的格式为（104|业务已订购,可继续使用鉴权成功,该商品已经购买）
         * ，对应每行内容不同选项用|隔开
         * @param $file string 文件对应路径
         * @param $nums int    文件内容每行对应栏数个数
         * @return array
         */

        function read_returnarr($file,$nums){
            $cuts=file($file,FILE_IGNORE_NEW_LINES);
            $lines_arr=array();
            foreach ($cuts as $key=>$line){
                $lines=explode("|",$line);
                for($i=0;$i<$nums;$i++){
                    $lines_arr[$key][]=$lines[$i];
                }
            }
            return $lines_arr;
        }

        read_returnarr("data.txt",4);