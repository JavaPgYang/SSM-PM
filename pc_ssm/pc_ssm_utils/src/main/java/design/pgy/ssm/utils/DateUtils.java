package design.pgy.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

//    private static

    // 日期转换成字符串
    public static String date2String(Date date, String patt) {
        SimpleDateFormat format = new SimpleDateFormat(patt);
        return format.format(date);
    }

    // 字符串转日期
    public static Date string2Date(String str, String patt) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(patt);
        return format.parse(str);
    }

}
