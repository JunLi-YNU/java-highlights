package date;

import java.util.Calendar;

public class MyCalender {
    public static  void main(String[] args){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.getWeekYear();
        //因为月份是从0开始计算的所以要加1
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        //因为国外的星期日是一个星期的第一天所以因该减1
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(calendar);
        System.out.println(year+"年"+month+"月"+day+"日"+getWeek(week));
    }

    private static String  getWeek(int i) {
       String[] weeks = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
       return weeks[i];
    }
}
