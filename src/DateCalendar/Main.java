package DateCalendar;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author Andrey Tynyanyi
 * @version 2.0
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        GregorianCalendar calendar = new GregorianCalendar();
        String str = null;
        Scanner in = new Scanner(System.in);
        System.out.println("Укажите дату!");
        System.out.print("Укажите день: ");
        int day    = in.nextInt();
        if(day > 31 || day < 1) day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.print("Укажите месяц: ");
        int month  = in.nextInt();
        if(month > 12 || month < 1) month = calendar.get(Calendar.MONTH);
        System.out.print("Укажите год: ");
        int year   = in.nextInt();
        if(year < 1) year = calendar.get(Calendar.YEAR);
        System.out.print("Укажите час: ");
        int hour   = in.nextInt();
        if(hour > 24 || hour < 0) hour = calendar.get(Calendar.HOUR);
        System.out.print("Укажите минуту: ");
        int minut  = in.nextInt();
        if(minut > 60 || minut < 0) minut = calendar.get(Calendar.MINUTE);
        System.out.print("Укажите секунду: ");
        int sec    = in.nextInt();
        if(sec > 60 || sec < 0) sec = calendar.get(Calendar.SECOND);
        str = String.format("%d.%d.%d %d:%d:%d", day, month, year, hour, minut, sec);
        DateCalendar date = new DateCalendar(str);
        System.out.println(date.toString());
    }
}
