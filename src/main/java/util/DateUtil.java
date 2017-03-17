package util;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by magenta9 on 2017/3/13.
 */
public class DateUtil {

    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Calendar String2Date(String dateString) {
        try {
            Date date = format.parse(dateString);
            System.out.println(date);
            System.out.println(format.format(date));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Calendar String2Date() {
        Calendar calendar = Calendar.getInstance();
        return calendar;
    }

    public static boolean isYearandMonth(String dateString, int year, int month) {
        Calendar cal = String2Date(dateString);
        System.out.println(cal.get(Calendar.YEAR) + "---" + cal.get(Calendar.MONTH));
        return cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) == month-1;
    }

    public static void main(String[] args) {
//        String2Date("2017-03-06 18:21:51");
//        Calendar cal = Calendar.getInstance();
//        System.out.println(cal.get(Calendar.YEAR));
        isYearandMonth("2017-03-06 18:21:51", 2017, 2);
    }
}
