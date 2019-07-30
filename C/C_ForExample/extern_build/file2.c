void delete_str(char str[],char ch)
{
    int i = 0,j = 0;
    for(;str[i] != '\0';i++){
        if(str[i] != ch){
            str[j++] = str[i];  //过滤指定的字符
        }
    }
    str[j] = '\0'; //结束符
}
