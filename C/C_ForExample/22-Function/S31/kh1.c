#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void shuffle(int array[], int length);
void deal(int array[], int player[3][17]);   //将洗的牌依次发给每位玩家有17张牌
void show(char names[3][54], int player[3][17]);

//采用随机数洗牌
void shuffle(int array[], int length)  // 54张牌
{
        int index, temp, i;

        srand(time(NULL));
        for (i = 0; i < length; i++)
        {
                index = rand() % (length - i) + i; //取随机值
                if (index != i) //洗牌打乱
                {
                        temp = array[i];
                        array[i] = array[index];
                        array[index] = temp;
                }
        }
}

// 模拟发牌：拿起一副无序的扑克每人轮流发一张牌
void deal(int array[], int player[3][17])
{
        int i, j, k = 0;
        for (i = 0; i < 17; i++)
        {
                for (j = 0; j < 3; j++)
                {
                        player[j][i] = array[k++]; //每人一张牌
                }
        }
}

//显示玩家手中的牌
void show(char names[3][54], int player[3][17])
{
        int i, j, poker;

        printf("\n方=方角，梅=梅花，红=红桃，黑=黑桃\n\n");

        for (i = 0; i < 3; i++)
        {
                printf("%s手上的牌是：", names[i]);
                for (j = 0; j < 17; j++)
                {
                       poker = player[i][j];

                       if (poker < 11 && 0 < poker)
                       {
                               printf("方%d ", poker);
                       }
                       else if (poker < 21 && 10 < poker)
                       {
                               printf("梅%d ", poker-10);
                       }
                       else if (poker < 31 && 20 < poker)
                       {
                               printf("红%d ", poker-20);
                       }
                       else if (poker < 41 && 30 < poker)
                       {
                               printf("黑%d ", poker-30);
                       }
                       else
                       {
                               switch (poker)
                               {
                                       case 41: printf("方J "); break;
                                       case 42: printf("方Q "); break;
                                       case 43: printf("方K "); break;
                                       case 44: printf("梅J "); break;
                                       case 45: printf("梅Q "); break;
                                       case 46: printf("梅K "); break;
                                       case 47: printf("红J "); break;
                                       case 48: printf("红Q "); break;
                                       case 49: printf("红K "); break;
                                       case 50: printf("黑J "); break;
                                       case 51: printf("黑Q "); break;
                                       case 52: printf("黑K "); break;
                                       case 53: printf("小王 "); break;
                                       case 54: printf("大王 "); break;
                               }
                       }

                }
                printf("\n\n");
        }

}

int main(void)
{
        int array[54];
        int player[3][17];
        int i, ch;
        char names[3][54];
        // 初始化扑克牌
        // 1~10代表方(角)1～10, 41、42、43代表方(角)J、Q、K
        // 11~20代表梅(花)1～10, 44、45、46代表梅(花)J、Q、K
        // 21~30代表红(桃)1～10, 47、48、49代表红(桃)J、Q、K
        // 31~40代表黑(桃)1～10, 50、51、52代表黑(桃)J、Q、K
        // 53、54当然就代表小王大王啦～

        for (i = 0; i < 54; i++)
        {
                array[i] = i + 1; //初始化
        }

        for (i = 0; i < 3; i++)
        {
                printf("\n请输入%d号玩家的名字：", i+1);
                scanf("%s", names[i]);
        }

        do
        {
                shuffle(array, 54); // 54张牌
                deal(array, player);
                show(names, player);

                printf("重新洗牌(Y/N)？");
                do
                {
                        ch = getchar(); // 过滤输入缓冲区的其他字符
                } while (ch != 'Y' && ch != 'N'); //为真则执行
        } while (ch == 'Y'); // //为真则执行
        return 0;
}
