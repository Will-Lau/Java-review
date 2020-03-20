package MyDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {
    public static void main(String[] args) {
        SimpleDateFormat sdf=new SimpleDateFormat("Gy年M月d日aH时m分s秒S毫秒 第w个星期的E");
        Date date=new Date();
        String date1=sdf.format(date);
        System.out.println(date1);
    }
}
