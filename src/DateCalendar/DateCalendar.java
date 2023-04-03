package DateCalendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateCalendar {
    private Calendar data;
    public DateCalendar(String data) {
        /**
         * Парсим строку с датой,
         * в дату с которой можно работать
         */
        Calendar myDate = new GregorianCalendar();
        Date theDate = null;
        try {
            theDate = new SimpleDateFormat("d.M.yyyy HH:mm:ss", Locale.ENGLISH).parse(data);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        myDate.setTime(theDate); //breakdown
        this.data = myDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat shortYear = new SimpleDateFormat("dd.MM.yy HH:mm:ss", Locale.ENGLISH);
        return String.format("%s", shortYear.format(this.data.getTime()));
    }
}
