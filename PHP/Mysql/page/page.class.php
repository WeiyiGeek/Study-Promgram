<?php
/**
 * 总条数
 * 每页显示多少条
 */
    //分页对象
    class Page{
        private $total;  //记录总数
        private $num;    //每页显示数量
        private $pages;  //总分页数
        private $cpages; //当前页
        private $url="fenye.php";

        function __construct($total,$num)
        {
            $this->total = $total;
            $this->num = $num;
            $this->pages = $this->getPages();
            $this->cpages = (!empty($_GET['page'])) ? (($_GET['page'] >= $this->pages) ? $this->pages : $_GET['page']):1;  //进行判断请求页面是不是超过最大页数（设置为最大页数）
        }

        //分页数量
        private function getPages(){
            return ceil($this->total/$this->num);  //ceil 小数取整
        }

        private function first(){
            //如果是第一页则不显示
            if($this->cpages > 1){
                $prev = $this->cpages - 1;
                return '<a href="'.$this->url.'?page=1" alt="首页">首页</a> <a href="'.$this->url.'?page='.$prev.'" alt="prev">上一页</a>';
            }else{
                return "";
            }
        }

        private function flist()
        {
            $list=""; //存放页数的字符串
            $num = 4; //前后4页

            //当前页前4页
            for($i = $num ; $i >= 1; $i--)
            {
                //列表之后
                $page = $this->cpages - $i;
                if($page >= 1)
                    $list .= '<a href="'.$this->url.'?page='.$page.'">'.$page.'</a> ';   
            }

            //当前页默认为选中
            if($this->cpages >= 1)
            {
                $list .= "&nbsp;".$this->cpages."&nbsp;";
            }

            //当前页后4页
            for($i = 1; $i <= $num; $i++)
            {
                //列表之后
                $page = $this->cpages + $i;
                if($page <= $this->pages){
                    $list .= '<a href="'.$this->url.'?page='.$page.'">'.$page.'</a> ';
                }else{
                    break;
                }
            }
            return $list;

        }
        private function flast(){
            $next = $this->cpages + 1;
            if(($this->cpages) < ($this->pages)){
                return '<a href="'.$this->url.'?page='.$next.'" alt="next">下一页</a> <a href="'.$this->url.'?page='.$this->pages.'" alt="末页">末页</a>';
            }else{
                return "";
            }
        }
        //从多少条开始
        private function start(){
            if($this->cpages > 1){
                return  (($this->cpages - 1) * $this->num)+1;
            }else{
                return 1;
            }
        }
        //从多少条结束(值得学习)
        private function end(){
            return min($this->cpages * $this->num,$this->total);
        }

        private function current()
        {
            return $this->end() - $this->start() + 1;
        }

        public function rpage(){
            $argvalue = func_get_args(); //获取函数的所有
            $list = "";

            $page[] = "共 {$this->total} 条记录,&nbsp;";
            $page[] ="&nbsp;当前页显示".$this->current()."条,&nbsp;";
            $page[] ="&nbsp;从".$this->start()."-".$this->end()."条&nbsp;";
            $page[] ="&nbsp;当前页 {$this->cpages} / {$this->pages} 页数&nbsp;";
            $page[] ="&nbsp;".$this->first()."&nbsp;";
            $page[] ="&nbsp;".$this->flist()."&nbsp;";
            $page[] ="&nbsp;".$this->flast()."&nbsp;";
            foreach($argvalue as $val)
            {
                $list .= $page[$val];
            }
            return $list;
        }
    }
?>