" All system-wide defaults are set in $VIMRUNTIME/debian.vim and sourced by
" the call to :runtime you can find below.  If you wish to change any of those
" settings, you should do it in this file (/etc/vim/vimrc), since debian.vim
" will be overwritten everytime an upgrade of the vim packages is performed.
" It is recommended to make changes after sourcing debian.vim since it alters
" the value of the 'compatible' option.

" This line should not be removed as it ensures that various options are
" properly set to work with the Vim-related packages available in Debian.
runtime! debian.vim

" Uncomment the next line to make Vim more Vi-compatible
" NOTE: debian.vim sets 'nocompatible'.  Setting 'compatible' changes numerous
" options, so any other options should be set AFTER setting 'compatible'.
"set compatible


" ####兼容性选项####
set nocompatible  

" ####第一步：设置Vundle插件运行时路径####
set rtp+=~/.vim/bundle/Vundle.vim  

call vundle#begin()
Plugin 'VundleVim/Vundle.vim'
Plugin 'scrooloose/nerdtree'
" --NERDTree插件配置开始--
" NERDTree 配置:F2快捷键显示当前目录树
map <f2> :NERDTreeToggle<cr>
" 修改树的显示图标
let g:NERDTreeDirArrowExpandable = '+'
let g:NERDTreeDirArrowCollapsible = '-'
" 窗口位置
let g:NERDTreeWinPos='left'
" 窗口尺寸
let g:NERDTreeSize=15
" 窗口是否显示行号
let g:NERDTreeShowLineNumbers=1
" 不显示隐藏文件
let g:NERDTreeHidden=0

call vundle#end()  


" 常用设置
""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""" 
syntax on          " 语法高显

" 设定默认解码 
set enc=utf-8 
set fencs=utf-8,usc-bom,euc-jp,gb18030,gbk,gb2312,cp936 

set history=50     " 历史记录为50 
set number         " 显示行号

set cursorline     " 在当前行显示一条下划线
set cursorcolumn   " 在当前列显示列线条
hi CursorLine  cterm=underline guibg=#00ff00   " 设置横竖的颜色
hi CursorColumn cterm=reverse ctermbg=2 guibg=#00ff00   


set nocompatible  " 不要使用vi的键盘模式，而是vim自己的 
set confirm          " 在处理未保存或只读文件的时候，弹出确认 
set clipboard+=unnamed  " 与windows共享剪贴板 

filetype on         " 侦测文件类型 
filetype plugin on   " 载入文件类型插件 
filetype indent on   " 为特定文件类型载入相关缩进文件 

set viminfo+=!   " 保存全局变量 
set iskeyword+=_,$,@,%,#,-  " 带有如下符号的单词不要被换行分割 

" 高亮字符，让其不受100列限制 
:highlight OverLength ctermbg=red ctermfg=white guibg=red guifg=white 
:match OverLength '\%101v.*' 

" 状态行颜色 
highlight StatusLine guifg=SlateBlue guibg=Yellow 
highlight StatusLineNC guifg=Gray guibg=White 


" 文件设置 
""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""" 
set nobackup  "不要备份文件（根据自己需要取舍） 
set autoread  " 文件被改动时自动载入

" 不要生成swap文件，当buffer被丢弃的时候隐藏它 
setlocal noswapfile 
set bufhidden=hide 

set linespace=0  " 字符间插入的像素行数目 
set wildmenu  " 增强模式中的命令行自动完成操作 

" 在状态行上显示光标所在位置的行号和列号 
set ruler  
set rulerformat=%20(%2*%<%f%=\ %m%r\ %3l\ %c\ %p%%%)
                             
set cmdheight=2  " 命令行（在状态行下）的高度，默认为1，这里是2 
set backspace=2  " 使回格键（backspace）正常处理indent, eol, start等 
set whichwrap+=<,>,h,l  " 允许backspace和光标键跨越行边界 


" 可以在buffer的任何地方使用鼠标（类似office中在工作区双击鼠标定位） 
set mouse=a   " 鼠标可用
" set selection=exclusive 
" set selectmode=mouse,key 

set shortmess=atI  " 启动的时候不显示那个援助索马里儿童的提示 
set report=0  " 通过使用: commands命令，告诉我们文件的哪一行被改变过 
set noerrorbells  " 不让vim发出讨厌的滴滴声 
set fillchars=vert:\ ,stl:\ ,stlnc:\  " 在被分割的窗口间显示空白，便于阅读 

" 搜索和匹配 
""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""" 
set laststatus=2  " 总是显示状态行 
set scrolloff=3  " 光标移动到buffer的顶部和底部时保持3行距离 
set showmatch  " 高亮显示匹配的括号 
set matchtime=5  " 匹配括号高亮的时间（单位是十分之一秒） 
set ignorecase  " 在搜索的时候忽略大小写 

set nohlsearch  " 不要高亮被搜索的句子（phrases） 
set incsearch  " 在搜索时，输入的词句的逐字符高亮（类似firefox的搜索） 

set listchars=tab:\|\ ,trail:.,extends:>,precedes:<,eol:$  " 输入:set list命令是应该显示些啥？ 
set novisualbell  " 不要闪烁 

" 我的状态行显示的内容（包括文件类型和解码） 
" set statusline=%F%m%r%h%w\[POS=%l,%v][%p%%]\%{strftime(\"%d/%m/%y\ -\ %H:%M\")} 
set statusline=%F%m%r%h%w\ [FORMAT=%{&ff}]\ [TYPE=%Y]\ [POS=%l,%v][%p%%]\ %{strftime(\"%d/%m/%y\ -\ %H:%M\")}
" set statusline=[%F]%y%r%m%*%=[Line:%l/%L,Column:%c][%p%%]


" 文本格式和排版 
""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""" 
set formatoptions=tcrqn  " 自动格式化  
set smartindent    " 为C程序提供自动缩进 
set cindent        " 使用C样式的缩进 
" ####统一缩进为4但是以tab制表符为基准####
"set tabstop=4      " 一个 tab 显示出来是多少个空格的长度制表符为4 
"set softtabstop=4   " 编辑模式的时候按退格键的时候退回缩进的长度当使用 expandtab 时特别有用。
"set shiftwidth=4    " 表示每一级缩进的长度，一般设置成跟 softtabstop 一样
"set noexpandtab  " 不要用空格代替制表符 
"set smarttab  " 在行和段开始处使用制表符
set nowrap  " 不要换行 
set ts=4            " 修改tab为四个空格
set expandtab       " 进用空格来表示
set autoindent      " 继承前一行的缩进方式，特别适用于多行注释 

" CTags的设定 
""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""" 
let Tlist_Sort_Type = "name"          " 按照名称排序 
let Tlist_Use_Right_Window = 1        " 在右侧显示窗口 
let Tlist_Compart_Format = 1          " 压缩方式 
let Tlist_Exist_OnlyWindow = 1        " 如果只有一个buffer，kill窗口也kill掉buffer 
let Tlist_File_Fold_Auto_Close = 0    " 不要关闭其他文件的tags 
let Tlist_Enable_Fold_Column = 0      " 不要显示折叠树 

set foldmethod=manual   " 手动折叠  

" ########################################################
if has("autocmd") 
autocmd FileType xml,html,c,cs,Java,perl,shell,bash,cpp,python,vim,PHP,ruby set number
autocmd FileType xml,html vmap <C-o> <ESC>'<i<!--<ESC>o<ESC>'>o--> 
autocmd FileType java,c,cpp,cs,py vmap <C-o> <ESC>'<o 
autocmd FileType html,text,php,vim,c,java,xml,bash,shell,perl,python setlocal textwidth=100 
"autocmd Filetype html,xml,xsl source $VIMRUNTIME/plugin/closetag.vim 
autocmd BufReadPost * 
			\ if line("'\"") > 0 && line("'\"") <= line("$") | 
			\ exe " normal g`\"" | 
			\ endif 
endif "has("autocmd") 


" F5编译和运行C程序，F6编译和运行C++程序 
" " 请注意，下述代码在windows下使用会报错 
" " 需要去掉./这两个字符 
"
" " C的编译和运行 
" map <F5> :call CompileRunGcc()<CR> 
" func! CompileRunGcc() 
" exec "w" 
" exec "!gcc % -o %<" 
" exec "! ./%<" 
" endfunc 

" " C++的编译和运行 
"map <F6> :call CompileRunGpp()<CR> 
"func! CompileRunGpp() 
"exec "w" 
"exec "!g++ % -o %<" 
"exec "! ./%<" 
"endfunc 


" " 能够漂亮地显示.NFO文件 
set encoding=utf-8 
function! SetFileEncodings(encodings) 
let b:myfileencodingsbak=&fileencodings 
let &fileencodings=a:encodings 
endfunction 
function! RestoreFileEncodings() 
let &fileencodings=b:myfileencodingsbak 
unlet b:myfileencodingsbak 
endfunction 

"
" au BufReadPre *.nfo call SetFileEncodings('cp437')|set ambiwidth=single au
" BufReadPost *.nfo call RestoreFileEncodings() 
"
" 高亮显示普通txt文件（需要txt.vim脚本） 
" au BufRead,BufNewFile * setfiletype txt 
"
" " 用空格键来开关折叠 
set foldenable
set foldmethod=manual 
set fdm=indent   " 打开折叠功能 , zo打开/zc关闭折叠 
nnoremap <space> @=((foldclosed(line('.')) < 0) ? 'zc':'zo')<CR> 

" " minibufexpl插件的一般设置 
let g:miniBufExplMapWindowNavVim = 1 
let g:miniBufExplMapWindowNavArrows = 1 
let g:miniBufExplMapCTabSwitchBufs = 1 
let g:miniBufExplModSelTarget = 1


" 新建.c,.h,.sh,.java文件，自动插入文件头,注意vim默认是识别python的而非py
autocmd BufNewFile *.cpp,*.sh,*.java,*.[ch],*.py exec ":call SetTitle()"    

" 定义函数SetTitle，自动插入文件头 
let $author_name = "WeiyiGeek"

" 自定义函数开头
func Note1()
	call append(0, "############################################################")
	call append(1, "# Filename   : ".expand("%:t"))
	call append(2, "# Author     : ".$author_name)
	call append(3, "# CreatedTime: ".strftime("%c"))
	call append(4, "# Description: ")
	call append(5, "############################################################")
endfunc

func Note2()
	call append(0, "/* *******************************************************")
	call append(1, "    > Filename    : ".expand("%:t"))
	call append(2, "    > Author      : ".$author_name)
	call append(3, "    > CreatedTime : ".strftime("%c"))
	call append(4, "    > Description : ")
	call append(5, "********************************************************/")
endfunc

func SetTitle()  
		if &filetype == 'sh'
			call Note1()
			call append(6, "\#!/bin/bash")
			call append(7, "")
		elseif &filetype == 'python'  "关键点
			call Note1()
			call append(6, "\#!/usr/bin/env python")
			call append(7, "")
		elseif &filetype == 'c'
	 		call Note2()
			call append(6, "\#include \<stdio.h\>")
			call append(7,"")
		elseif &filetype == 'cpp'
			call Note2()
			call append(6, "\#include \<iostream\>")
			call append(7, "using namespace std;")
			call append(8, "")
		elseif &filetype == 'java'
			call Note2()
			call append(6, "class ".expand("%:t:r")."{")
			call append(7, "    public static void main(String[] args){")
			call append(8, " ")
			call append(9, "    }")
			call append(10, "}")
		endif
		
	" ####新建文件后，自动定位到文件末尾####
	autocmd BufNewFile * normal G
endfunc


" ###键盘命令快捷键####
" nmap <leader>w :w!<cr>
" nmap <leader>f :find<cr>

" ####映射全选+复制 ctrl+a####
map <C-A> ggVGY
map! <C-A> <Esc>ggVGY
map <F12> gg=G

" ####选中状态下 Ctrl+c 复制####
vmap <C-c> "+y

" ####快捷键编译运行###
map <F5> :call CompileRunGcc()<CR> 
func! CompileRunGcc() 
	exec "w" 
	exec "!clear"
	if &filetype == 'c'
		exec "!gcc -Wall % -o %<.count"
		exec "!./%<.count"
	elseif  &filetype == 'cpp'
		exec "!g++ -Wall % -o %<.cppout"
		exec "!./%<.cppout"
	elseif &filetype == 'java'
		exec "!javac %"
		exec "!java %<"
	elseif &filetype == 'python'  "关键点
    exec "!python %"
	endif
endfunc

" ###全局配置文件####
if filereadable("/etc/vim/vimrc.local")
  source /etc/vim/vimrc.local
endif


