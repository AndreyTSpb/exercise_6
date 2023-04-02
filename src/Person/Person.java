package Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author Andrey Tynyanyi
 * @version 2.0
 */
public class Person {
    private String name;
    private String data;
    private String format;

    public Person(String name, String data) {
        this.name = name;
        this.data = data;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String Formatted(String data, String format) throws ParseException {
        String str = null;

        Calendar mydate = new GregorianCalendar();
        Date thedate = new SimpleDateFormat("d.M.yyyy", Locale.ENGLISH).parse(this.data);
        mydate.setTime(thedate); //breakdown

        NameMonths[] months = NameMonths.values();

        System.out.println("mydate -> "+mydate);
        System.out.println("year   -> "+mydate.get(Calendar.YEAR));
        System.out.println("month  -> "+months[mydate.get(Calendar.MONTH)]);
        System.out.println("dom    -> "+mydate.get(Calendar.DAY_OF_MONTH));

//        switch (format) {
//            case "short":
//                for (int i = 0; i < data.length(); i++) {
//                    //System.out.println(data.substring(0, 2));
//                    str = data.substring(0, 5);
//
//                }
//                break;
//
//            case "default":
//                for (int i = 0; i < data.length(); i++) {
//                    //System.out.println(data.substring(0, 2));
//                    str = data;
//
//                }
//                break;
//            case "full" :
//
//                break;
//        }
        return str;
    }

    @Override
    public String toString() {
        try {
            return Formatted(this.data, this.format);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
