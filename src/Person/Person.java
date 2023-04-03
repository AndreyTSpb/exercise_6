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

    /**
     * Констракт класса
     * @param name - Имя
     * @param data - дата в формате ДД.ММ.ГГГГ
     */
    public Person(String name, String data) {
        this.name = name;
        this.data = data;
    }

    /**
     * Задаем формат в котором
     * хотим получить дату
     * @param format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Форматирует строку взависимоти от назначенного переданного формата
     * @param data - дата в виде строки
     * @param format - значение формата (short/medium/full)
     * @return - возвращает строку с отформатированной датой
     * @throws ParseException
     */
    public String Formatted(String data, String format) throws ParseException {
        String str = null;

        /**
         * Парсим строку с датой,
         * в дату с которой можно работать
         */
        Calendar myDate = new GregorianCalendar();
        Date theDate = new SimpleDateFormat("d.M.yyyy", Locale.ENGLISH).parse(data);
        myDate.setTime(theDate); //breakdown

        switch (format) {
            case "short" -> {
                SimpleDateFormat shortYear = new SimpleDateFormat("dd.M.yy", Locale.ENGLISH);
                str = String.format("%s", shortYear.format(myDate.getTime()));
            }
            case "medium" -> {
                SimpleDateFormat mediumYear = new SimpleDateFormat("dd.M.yyyy", Locale.ENGLISH);
                str = String.format("%s", mediumYear.format(myDate.getTime()));
            }
            case "long" -> {
                NameMonths[] months = NameMonths.values(); //объект с русскими названиями месяцев
                str = String.format("%s %s %s", myDate.get(Calendar.DAY_OF_MONTH), months[myDate.get(Calendar.MONTH)], myDate.get(Calendar.YEAR));
            }
        }
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
