import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class DateTest
{
    public static void main(String[] args) {

        //Date
        Date date = new Date();

        System.out.println(date);
        System.out.println(date.toLocaleString());

        //Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,2020);//更改年为2020
        System.out.println(calendar.get(Calendar.YEAR));//取出YEAR

        //DateFormat
        Date date1 = new Date();
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.SHORT);
        //SHORT 年只有两位， 括号无内容 为完整，括号为FULL 变为中文的年月日和星期

        String tmp = df1.format(date);
        System.out.println(tmp);

        //SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD hh:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年-MM月-DD日 hh点:mm分:ss秒");
        try {
            Date date2 = sdf.parse("2008-12-23 12:23:45");

            System.out.println(sdf2.format(date2));

        }catch (ParseException e){
            e.printStackTrace();
        }

        //LocalDateTime,LocalDate
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTime = LocalDateTime.of(2000,2,4,8,4,20);
        System.out.println(now);
        System.out.println(dateTime);
        System.out.println(now.withDayOfMonth(1));//打印本月第一天
        System.out.println(now.with(TemporalAdjusters.lastDayOfMonth()));//打印本月最后一天
        dateTime.toLocalDate();
        //LocalDate 只有年月日
        System.out.println(dateTime.toLocalDate());
        //LocalTime 只有时分秒
        System.out.println(dateTime.toLocalTime());

        System.out.println(now);
    }
}
