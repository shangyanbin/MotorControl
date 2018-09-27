package com.easicare.motorcontrol;

public class SerialPortCommand {
    public static final String move = "@199:Motor:Run:";
    public static final String stop = "@199:Motor:Stop:";
    public static final String back = "@199:Motor:MoveTo:";

    public static final String move2 = "@199:Motor:Run:M2 ";
    public static final String stop2 = "@199:Motor:Stop:M2";
    public static final String back2 = "@199:Motor:MoveTo:M2";

    public static final String order00 = "@199:*IDN?";              //1	    读版本号
    public static final String order01 = "@199:Motor:Run:M1 100";   //2	    马达增量移动
    public static final String order02 = "@199:Motor:MoveTo:M1 100";//3	    马达绝对移动
    public static final String order03 = "@199:Motor:Run:M1?";      //4	    马达运转状态查询
    public static final String order04 = "@199:Motor:Run?";         //5	    马达运转状态查询	:Motor:Run?
    public static final String order05 = "@199:Motor:MoveOk:M1?";   //6	    马达定位完成查询	@199:Motor:MoveOk:M1?
    public static final String order06 = "@199:Motor:Home:";        //7	    马达回原点	@199:Motor:Home:M1
    public static final String order07 = "@199:Motor:Home:M1?";     //8	    回原点完成查询	@199:Motor:Home:M1?
    public static final String order08 = "@199:Motor:Stop:M1";      //9	    马达停止	@199:Motor:Stop:M1
    public static final String order09 = "@199:Motor:LStop:M1";     //10    马达减速停止	@199:Motor:LStop:M1
    public static final String order10 = "@199:Motor:POS:?";        //11	马达位置查询	@199:Motor:POS:M1?
    public static final String order11 = "@199:Motor:POS:";     //12	马达位置更改  	@199:Motor:POS:M1 0
    public static final String order12 = "@199:Motor:Speed:";       //13	马达速度设定	@199:Motor:Speed:M1 100
    public static final String order13 = "@199:Motor:Speed:M1?";    //14	马达速度查询	@199:Motor:Speed:M1?
    public static final String order14 = "@199:Motor:SStart:M1 600";//15	马达起步速度设定	@199:Motor:SStart:M1 600
    public static final String order15 = "@199:Motor:SStop:M1 600"; //16	马达终止速度设定	@199:Motor:SStop:M1 600
    public static final String order16 = "@199:Motor:SAdd:M1 2";    //17	马达加速度设定	@199:Motor:SAdd:M1 2
    public static final String order17 = "@199:Motor:Shome:M1 600"; //18	马达回原点速度	@199:Motor:Shome:M1 600
    public static final String order18 = "@199:Motor:Invert:";      //19	马达反向设定	@199:Motor:Invert:M1 1
    public static final String order19 = "@199:Motor:Invert:M1?";   //20	马达反向查询 @199:Motor:Invert:M1?
    public static final String order20 = "@199:Motor:Limit:M1 2";   //21	马达极限检测使能	@199:Motor:Limit:M1 2
    public static final String order21 = "@199:Motor:Estop 1";      //22	急停按钮功能使能	@199:Motor:Estop 1
    public static final String order22 = "@199:Program:MINT 1";     //23	马达状态主动发送	@199:Program:MINT 1
    public static final String order23 = "@199:Program:MINT?";      //24	马达状态主动发送	@199:Program:MINT?
    public static final String order24 = "@199:Motor:Save";         //25	马达参数保存	@199:Motor:Save
    public static final String order25 = "@199:Output:Y9 1";        //26	继电器On/Off	@199:Output:Y9 1
    public static final String order26 = "@199:Input:X1?";          //27	IO输入	@199:Input:X1?
    public static final String order27 = "@199:OutPut:Y1 1";        //28	IO输出	@199:OutPut:Y1 1
    public static final String order28 = "@199:OutDly:Y1 5";        //29	输出延时关	@199:OutDly:Y1 5
    public static final String order29 = "@199:Count:C1?";          //30	读IO计数	@199:Count:C1?
    public static final String order30 = "@199:Count:C1 0";         //31	修改计数	@199:Count:C1 0
    public static final String order31 = "@199:Program:INT 1";      //32	X状态主动发送 	@199:Program:INT 1
    public static final String order32 = "@199:Filter 10";          //33	设定输入滤波	@199:Filter 10
    public static final String order33 = "@199:Filter?";            //34	读滤波值	@199:Filter?
    public static final String order34 = "@199:Addr 2";             //35	设定地址	@199:Addr 2
    public static final String order35 = "@199:Addr?";              //36	读地址	@199:Addr?
    public static final String order36 = "@199:BRG 9600";           //37	波特率	@199:BRG 9600
    public static final String order37 = "@199:Program:Edit 50 1";  //38	程序运行	@199:Program:Edit 50 1
    public static final String order38 = "@199:Program:Orig 1 ";    //39	启始程序步号	@199:Program:Orig 1
    public static final String order39 = "@199:Program:Pause";      //40	程序暂停	@199:Program:Pause
    public static final String order40 = "@199:Program:Pause?";     //41	查询暂停状态	@199:Program:Pause?
    public static final String order41 = "@199:Program:Stop";       //42	程序停止	@199:Program:Stop
    public static final String order42 = "@199:Program:Pstep?";     //43	查询当前位置	@199:Program:Pstep?
    public static final String order43 = "@199:Program:Pstep 1";    //44	设定当前位置	@199:Program:Pstep 1
    public static final String order44 = "@199:Program:PCount?";    //45	查询运行圈数	@199:Program:PCount?
    public static final String order45 = "@199:Program:OK?";        //46	程序下载正误	@199:Program:OK?
    public static final String order46 = "@199:Reset";              //47	系统重启	@199:Reset
    public static final String order47 = "@199:D:read 12";          //48	D读出	@199:D:read 12
    public static final String order48 = "@199:D:set 12 123";       //49	D修改	@199:D:set 12 123
    public static final String order49 = "@199:Adc?";               //50	读模拟量	@199:Adc?

}
