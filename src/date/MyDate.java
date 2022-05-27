package date;

import java.text.DateFormat;
import java.util.Date;

public class MyDate {
    public static void main(String[] args){
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println(dateFormat.format(date));
        dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.FULL);
        System.out.println(dateFormat.format(date));
    }
}
