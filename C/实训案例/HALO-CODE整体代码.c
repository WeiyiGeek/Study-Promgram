#include "ble_config.h"
#include <math.h>

/*自定义宏(常量)*/
#define HALO_START_WELCOME (1<<1)
#define HALO_CLOSE_LED (1<<2)
#define HALO_TIME (1<<3)
#define HALO_TIME_KEEP (1<<4)
#define HALO_ADC (1<<5)
#define HALO_PRESS (1<<6)
#define HALO_SYS_KEY (1<<15)
#define HALO_MOTOR (1<<7)
#define HALO_RUN_STEP (1<<8)
#define HALO_BLUE (1<<9)
#define HALO_CLOSE1_LED (1<<10)

static uint8 keyfobapp_TaskID;   //task/event processing
//static uint8 cunt = 0;
static uint8 presscunt = 0;
static uint32 ticks = 0;
static uint32 ticks_b = 0;
short int runcount = 0;
static char buf[12];
static uint8 BOOL = 1;

void  ppAttrChange_fun ( uint8 attrParamID )
{
  char buffer[15];
  osal_ble_recv_msg(attrParamID,buf,15);   //被调用的时候说明蓝牙有数据了,读取消息上来
    if(buf[0] == 0x65){ //日期：[标志位65][长度06] [DF][07] [08][0C] [09][0F]
      short year;
      uint8 month,day,hour,mm ;
      year = buf[3];year <<=8;
      year |= buf[2];
      month = buf[4];
      day = buf[5];
      hour = buf[6];
      mm = buf[7];
      osal_time_settime(year,month,day,hour,mm,23);

    }else if(buf[0] == 0x62){  //来电号码 [标志位62][长度0B][01][05][08][02][01][05][02][09][09][06][02]
      uint8 i;
      for(i=2;i<buf[1]+2;i++) //len buf[1] == number buf[2]--buf[xxx] 从第二位开始时
        buf[i]+= '0';
      HalOledSelect();
      OLED_Display_On();
      OLED_ShowString(0,48,  &buf[2]);    //取整体
    }else if(buf[0] == 0x63){

    }

}


 /* 手环初始化 */
 void KeyFobApp_Init( uint8 task_id )
 {
   keyfobapp_TaskID = task_id;
   osal_gpio_init();  /*	对引脚的初始化	*/
   HalOledInit(keyfobapp_TaskID); //OLED初始化
   RegisterForKeys(keyfobapp_TaskID);   //按键初始化key init
   osal_time_settime(2017,12,24,13,45,10);  //设置格林尼治标准时间(:Greenwich Mean Time,GMT),1970年01月01日00时00分00秒起至现在的总秒数
   LIS3DH_AccInit();
   osal_radio_open();  /*打开蓝牙*/
   osal_ble_init("teacher-wr");  //BLUEtooth名字
   osal_ble_start(  task_id,  ppAttrChange_fun);  //BLUEtooth事件

   osal_start_timerEx( keyfobapp_TaskID, HALO_START_WELCOME , 1000 );  // 开机启动线程
 }


uint16 KeyFobApp_ProcessEvent( uint8 task_id, uint16 events )
{

  if(events & HALO_SYS_KEY ){
    keyChange_t *msg = ( keyChange_t *)osal_msg_receive(task_id);
    if(msg->keys){
      ticks = osal_getClock();
      P1_3 = 0;
    }else if(msg -> keys == 0){
        ticks_b = osal_getClock();
        if(ticks_b - ticks >= 2 && ticks_b - ticks  < 4){
          osal_start_timerEx( keyfobapp_TaskID, HALO_CLOSE1_LED, 1000);
        }else if(ticks_b -ticks >= 5){
          HAL_SYSTEM_RESET();
        }
        else{
          osal_start_timerEx( keyfobapp_TaskID, HALO_PRESS,0);
        }
    }
    return events ^ HALO_SYS_KEY ;
   }

   if(events & HALO_PRESS){
      presscunt += 1;
       switch (presscunt) {
         case 1:osal_start_timerEx( keyfobapp_TaskID, HALO_TIME, 0 );break;
         case 2:osal_start_timerEx( keyfobapp_TaskID, HALO_TIME_KEEP, 0 );break;
         case 3:osal_stop_timerEx( keyfobapp_TaskID, HALO_TIME_KEEP);osal_start_timerEx( keyfobapp_TaskID, HALO_ADC, 0 );break;
         case 4:osal_start_timerEx( keyfobapp_TaskID, HALO_MOTOR, 0 );break;
         case 5:osal_start_timerEx( keyfobapp_TaskID, HALO_MOTOR, 0 );break;
         case 6:osal_start_timerEx( keyfobapp_TaskID, HALO_RUN_STEP, 0 );break;
         case 7:osal_stop_timerEx( keyfobapp_TaskID, HALO_RUN_STEP);osal_start_timerEx( keyfobapp_TaskID, HALO_BLUE, 0 );break;
         default :presscunt = 0;osal_start_timerEx( keyfobapp_TaskID, HALO_CLOSE_LED, 1000);
       }
    }

   if (events & HALO_START_WELCOME){
     HalOledSelect();
     OLED_Display_On();
     OLED_ShowString(0,48,"Welcome Geek");
     osal_start_timerEx( keyfobapp_TaskID, HALO_CLOSE_LED, 3000);
   }

   if(events & HALO_TIME){
      UTCTimeStruct tm;  //协调世界时,tm结构体
      ticks = osal_getClock(); //获取时间
      osal_ConvertUTCTime(&tm, ticks); //转换成现在的时间,进行UTC时间戳转换
      sprintf((char *)buf,"%4d/%02d/%02d  ",tm.year,tm.month,tm.day);
      HalOledSelect();
      OLED_Display_On();
      OLED_ShowString(0,48,buf);

      return events ^ HALO_TIME;
    }

    if(events & HALO_TIME_KEEP){
        static uint8 cnt = 0;
        static uint8 min = 0;
        static uint8 hour = 0;
        cnt++;
        if(cnt==60 && min <= 60 && hour<=24){ // 60 秒 就转变成 1分钟
          min++;
          cnt=0;
          if(min==60 && hour <= 24){  // 60 分钟 转变成 2秒
            hour++;
            min=0;
          }
        }
        sprintf(buf,"%02d:%02d:%02d   ",hour,min,cnt);  //输出格式
        if(P1_3 != 1 ){
          osal_start_timerEx( keyfobapp_TaskID, 1 << 15, 0);
        }else{
          HalOledSelect();
          OLED_Display_On();
          OLED_ShowString(0,48,buf);
          osal_start_timerEx( keyfobapp_TaskID, HALO_TIME_KEEP, 1000 );
        }

        return events ^ HALO_TIME_KEEP;
      }

      if(events & HALO_ADC){
        uint16 adc;
        float x;
        //float Q;
        adc = HalAdcRead( HAL_ADC_CHN_AIN1, HAL_ADC_RESOLUTION_12 );
              /*
                3.3       4096
                ----   =  -----
                X          adc

                X = 3.3 * (float)adc /4096;
              */
        x = 3.3 * (float)adc /4096 ;
        x = x*4;//电阻分压
        //Q = 170.67*x-593.347;
        sprintf((char *)buf,"VOL:%4.2f        ",x);
        HalOledSelect();
        OLED_Display_On();
        OLED_ShowString(0,48,buf);
        return events ^ HALO_ADC;
      }

      if (events & HALO_MOTOR) {
          if(BOOL == 1){
            P1_6 = 1;
            HalOledSelect();
            OLED_Display_On();
            OLED_ShowString(0, 48, "HALO_MOTOR");
            BOOL = 0;
          }else{
             P1_6 = 0;
             HalOledSelect();
             OLED_Display_On();
             OLED_ShowString(0, 48, "MOTOR DOWN");
          }
          return events ^ HALO_MOTOR;
      }

      if(events & HALO_RUN_STEP){
          int8 accel[3];
          LIS3DH_AccRead(accel);
          accel[0] >>= 3;
          accel[1] >>= 3;
          accel[2] >>= 3;
          runcount += sqrt(accel[0] * accel[0] + accel[1] * accel[1] + accel[2] * accel[2]) / 2;
          sprintf((char *)buf,"步数: %d         ",runcount);
          HalOledSelect();
          OLED_Display_On();
          OLED_ShowString(0,48,buf);
          if(P1_3 != 1 ){
            osal_start_timerEx( keyfobapp_TaskID, 1 << 15, 0);
          }else{
            osal_start_timerEx (keyfobapp_TaskID,HALO_RUN_STEP,1000);
          }
        return events ^ HALO_RUN_STEP;
      }

      if(events & HALO_BLUE){
      //往手机发消息
        uint8 data[5];
        data[0] = 0x19;
        data[1] = 0x25;
        data[2] = 0x48;
        data[3] = 0x65;
        data[4] = 0x97;

        osal_send2appdata(data,5); //发送五个字节
        //osal_start_timerEx( keyfobapp_TaskID, (1<<1), 2000 );
        HalOledSelect();
        OLED_Display_On();
        OLED_ShowString(0,48,"Send Message");
        return events ^ HALO_BLUE;
      }

      if(events & HALO_CLOSE_LED){
          BOOL = 1;
          HalOledSelect();
          OLED_Display_Off();   //关闭显示
          OLED_Clear();
          if(P1_3 != 0){
            osal_stop_timerEx( keyfobapp_TaskID, HALO_START_WELCOME);
            osal_start_timerEx( keyfobapp_TaskID, HALO_SYS_KEY, 0);
          }
          return events ^ HALO_CLOSE_LED;
        }

  if(events & HALO_CLOSE1_LED){
          HalOledSelect();
          OLED_Display_Off();   //关闭显示
          OLED_Clear();
          if(P1_3 != 0){
          osal_stop_timerEx( keyfobapp_TaskID, HALO_START_WELCOME);
          osal_start_timerEx( keyfobapp_TaskID, HALO_SYS_KEY, 0);
    }
          return events ^ HALO_CLOSE_LED;
}

  /*未识别的事件,清空*/
  return 0;
}
