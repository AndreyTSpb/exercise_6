package Colections;

import java.util.*;

public class Main {
    private static final String str1 = "Вот пример пример использования интерфейса Set Вот Вот для добавления и удаления элементов из множества в Java Collection Framework";
    private static final String str2 = "Это означает, что первый элемент, добавленный в очередь будет первым удаленным. Вот пример того, как использовать очередь в Java Collection Framework";

    public static void main(String[] args) {
        //Получаем списки всех слов в строках
        List<String> listStr1 = createListString(str1);
        List<String> listStr2 = createListString(str2);

        System.out.println("Частота повторения слов в строке 1");
        Map<String, Integer> mapStr1 = uniqueWordToList(listStr1);
        System.out.println(mapStr1);

        System.out.println("Частота повторения слов в строке 2");
        Map<String, Integer> mapStr2 = uniqueWordToList(listStr2);
        System.out.println(mapStr2);

        System.out.println("Вывод всех уникальных слов (содержатся хотя бы в одной строке)");
        Set<String> uniqueWordAllStrings = uniqueWordAllStrings();
        System.out.println(uniqueWordAllStrings);

        System.out.println("Слова входят и в первую, и во вторую строку");
        List<String> includedInFirstAndSecond = includedInFirstAndSecond(mapStr1, mapStr2, uniqueWordAllStrings);
        System.out.println(includedInFirstAndSecond);
        System.out.println("Символы должны выводиться в обратном порядке");
        Collections.reverse(includedInFirstAndSecond);
        System.out.println(includedInFirstAndSecond);

        System.out.println("Слова входят в первую и не входят во вторую");
        List<String> includedOnlyFirst = includedOnlyFirst(mapStr1, mapStr2, uniqueWordAllStrings);
        System.out.println(includedOnlyFirst);
        System.out.println("Символы должны выводиться в обратном порядке");
        Collections.reverse(includedOnlyFirst);
        System.out.println(includedOnlyFirst);

//        System.out.println("Слова содержатся хотя бы в одной строке");
//        System.out.println(includedInFirstOrSecond(mapStr1, mapStr2, uniqueWordAllStrings));
//
//        System.out.println("Символы должны выводиться в обычном порядке");
//        //System.out.println(Collections.reverse(includedInFirstAndSecond));
//        System.out.println("Символы должны выводиться в обратном порядке");
//        System.out.println("Символы должны выводиться в порядке возрастания циклического сдвига влево на n разрядов хеш-функции символа");

    }

    /**
     * Получаем список, где
     * элементы входят и в первую, и во вторую строку
     * @param map1 - масив  с словами из первой строки
     * @param map2 - массив по второй строке
     * @param uniqueWord - множество уникальных элементов
     * @return
     */
    private static List<String> includedInFirstAndSecond(
            Map<String, Integer> map1,
            Map<String, Integer> map2,
            Set<String> uniqueWord){
        // Создаем новый set
        List<String> stringSet = new ArrayList<>();
        for(String word : uniqueWord) {
            if(map1.containsKey(word) && map2.containsKey(word)) stringSet.add(word);
        }
        return stringSet;
    }

    /**
     * Получаем список, где
     * входят в первую и не входят во вторую
     * @param map1 - масив  с словами из первой строки
     * @param map2 - массив по второй строке
     * @param uniqueWord - множество уникальных элементов
     * @return
     */
    private static List<String> includedOnlyFirst(
            Map<String, Integer> map1,
            Map<String, Integer> map2,
            Set<String> uniqueWord){
        // Создаем новый set
        List<String> stringSet = new ArrayList<>();
        for(String word : uniqueWord) {
            if(map1.containsKey(word) && !map2.containsKey(word)) stringSet.add(word);
        }
        return stringSet;
    }

    /**
     * Получаем список, где
     * содержатся хотя бы в одной строке
     * @param map1 - масив  с словами из первой строки
     * @param map2 - массив по второй строке
     * @param uniqueWord - множество уникальных элементов
     * @return
     */
    private static List<String> includedInFirstOrSecond(
            Map<String, Integer> map1,
            Map<String, Integer> map2,
            Set<String> uniqueWord){
        // Создаем новый set
        List<String> stringSet = new ArrayList<>();
        for(String word : uniqueWord) {
            if(map1.containsKey(word) || map2.containsKey(word)) stringSet.add(word);
        }
        return stringSet;
    }

    /**
     * Превращаем строку в список,
     * используя регулярку удалем все знаки припиннания
     * @param str - строка
     * @return
     */
    private static List<String> createListString(String str){
        return new ArrayList<>(Arrays.asList(str.replaceAll("[^A-Za-zА-Яа-я0-9' ']", "").split(" ")));
    }

    /**
     * Создание асоциативного массива,
     * где:
     *  ключ - это слово,
     *  значение - частота повторения
     * @param listStr - список слов
     * @return - ассоциативный массив
     */
    private static Map<String, Integer> uniqueWordToList(List<String> listStr){
        // Создаем Map
        Map<String, Integer> mapStr = new HashMap<>();
        // Добавляем элементы в Map
        for (String item : listStr) {
            //приводим к одному регистру
            String lowStr = item.toLowerCase();
            if(mapStr.containsKey(lowStr)){
                //если такое слово уже есть +1
                mapStr.put(lowStr, mapStr.get(lowStr)+1);
            }else{
                //новое слово становится ключем
                mapStr.put(lowStr, 1);
            }
        }
        return mapStr;
    }

    /**
     * Получения множества уникальных слов из двух строк
     * @return - возвращает HashSet
     */
    private static Set<String> uniqueWordAllStrings(){
        //Объеденим жве строки
        String newStr = str1 + " " + str2;
        //Получаем списки всех слов в строках
        List<String> listStr = createListString(newStr);
        // Создаем новый set
        Set<String> stringSet = new HashSet<>();
        for (String item: listStr){
            //приводим к нижнему регистру
            stringSet.add(item.toLowerCase());
        }
        return stringSet;
    }
}
