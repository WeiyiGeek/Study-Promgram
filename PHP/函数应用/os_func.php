<?php
    /***
     * function ���ж��ļ����������Щ���ļ���Щ��Ŀ¼
     * @param : ��Ҫ��ʾ�ļ����ļ���
     */
    header("Content-Type: text/html; charset=gb2312");

    function showDir($dirpath){
		$dir = opendir($dirpath);   //��Ŀ¼��Դ ����Ҫ��
        readdir($dir);              // ".." �ϼ�Ŀ¼ ����ʹ����Ϊ�˹��˷��ļ����ļ���
        readdir($dir);              // "." ����Ŀ¼
        while(($file = readdir($dir))){
            $file = $dirpath.'/'.$file;     //�ǳ�ע����Ҫ�����Ŀ¼·��(����������������ļ�������)
            if(is_dir($file)){
                echo "Ŀ¼ ��{$file} <br>";
                showDir($file);         //�����˵ݹ麯��,��ӡĿ¼�µ��������ļ���
            }else{
                echo "�ļ� ��{$file} <br>";
            }
        }
        closedir($dir); //�رմ򿪵�Ŀ¼��Դ ����Ҫ��
    }
    showDir($_GET['path']);     //����Ŀ¼й¶��©��
