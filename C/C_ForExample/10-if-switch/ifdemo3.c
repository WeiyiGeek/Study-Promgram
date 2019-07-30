#include <stdio.h>
int main(){
    int score;
    printf("请输入你的成绩:");
    scanf("%d",&score);
    if (score >= 90){
        printf("你的成绩为A\n");
    }else if(score >=80 && score < 90){
        printf("你的成绩为B;\n");
    }else if(score >=70 && score < 80){
        printf("你的成绩为C;\n");
    }else if(score >=60 && score <70){
        printf("你的成绩为D;\n");
    }else{
        printf("你的成绩不合格恭喜你需要重新考试！！！！\n");
    }
}
