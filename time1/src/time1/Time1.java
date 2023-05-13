/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time1;

import java.text.DecimalFormat;

public class Time1 extends Object{
private int hour;
private int minute;
private int second;

@SuppressWarnings("OverridableMethodCallInConstructor")
public Time1(){
    setTime(0,0,0);//method call
}
public void setTime(int h,int m,int s){//set invalid time to zero
    hour=((h>=0&&h<24)?h:0);
    minute=((m>=0&&m<60)?m:0);
    second=((s>=0&&s<60)?s:0);
}

public  String toUniversalString(){
     DecimalFormat twoDigits=new  DecimalFormat ("00");
    return twoDigits.format(hour) +":" +twoDigits.format(minute) +":" +twoDigits.format(second);
}

public String toStandardString(){
     DecimalFormat twoDigits= new DecimalFormat ("00");
     
    return((hour==12||hour==0)?12:hour%12
            ) +":"+twoDigits.format(minute)+":"+twoDigits.format(second
            )+(hour<12?"AM":"PM");
    
}
    
    
}//end of class time1
