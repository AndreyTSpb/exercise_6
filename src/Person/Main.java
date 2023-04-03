package Person;

/**
 * @author Andrey Tynyanyi
 * @version 2.0
 */
public class Main {
    public static void main(String[] args){
        Person anna = new Person("Anna Petrova", "20.10.2000");

        anna.setFormat("short");
        System.out.println(anna.toString());

        anna.setFormat("medium");
        System.out.println(anna.toString());

        anna.setFormat("long");
        System.out.println(anna.toString());
    }
}
