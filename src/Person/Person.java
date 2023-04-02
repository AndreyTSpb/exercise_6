package Person;

import java.util.Calendar;
import java.util.GregorianCalendar;

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

    public String Formatted(String data, String format) {
        String str = null;

        Calendar calendar = new GregorianCalendar();
        switch (format) {
            case "short":
                for (int i = 0; i < data.length(); i++) {
                    //System.out.println(data.substring(0, 2));
                    str = data.substring(0, 5);

                }
                break;

            case "default":
                for (int i = 0; i < data.length(); i++) {
                    //System.out.println(data.substring(0, 2));
                    str = data;

                }
                break;
            case "full" :

                break;
        }
        return str;
    }

    @Override
    public String toString() {
        return Formatted(data, format);
    }
}
