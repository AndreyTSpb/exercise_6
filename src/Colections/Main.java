package Colections;

import java.util.*;

public class Main {
    private static final String str1 = "Вот пример пример использования интерфейса Set Вот Вот для добавления и удаления элементов из множества в Java Collection Framework";
    private static final String str2 = "Это означает, что первый элемент, добавленный в очередь будет первым удаленным. Вот пример того, как использовать очередь в Java Collection Framework";

    public static void main(String[] args) {
        //Получаем списки всех слов в строках
        List<String> listStr1 = createListString(str1);
        List<String> listStr2 = createListString(str2);
        System.out.println("*****");
        System.out.println("Частота повторения слов в строке 1");
        Map<String, Integer> mapStr1 = uniqueWordToList(listStr1);
        System.out.println(mapStr1);
        System.out.println("*****");
        System.out.println("Частота повторения слов в строке 2");
        Map<String, Integer> mapStr2 = uniqueWordToList(listStr2);
        System.out.println(mapStr2);
        System.out.println("*****");
        System.out.println("Вывод всех уникальных элементов (содержатся хотя бы в одной строке)");
        Set<String> uniqueWordAllStrings = uniqueWordAllStrings();
        System.out.println(uniqueWordAllStrings);
        System.out.println("*****");
        System.out.println("Входят и в первую, и во вторую строку");
        List<String> list1 = includedInFirstAndSecond(mapStr1, mapStr2, uniqueWordAllStrings);
        viewConsoleListFIFO(list1);
        viewConsoleListLIFO(list1);
        viewConsoleListShiftLeft(list1, (int)(Math.random()*list1.size()));
        System.out.println("*****");
        System.out.println("Входят в первую и не входят во вторую:");
        List<String> list2 = includedOnlyFirst(mapStr1, mapStr2, uniqueWordAllStrings);
        viewConsoleListFIFO(list2);
        viewConsoleListLIFO(list2);
        viewConsoleListShiftLeft(list2, (int)(Math.random()*list2.size()));
        System.out.println("*****");
        System.out.println("Cодержатся хотя бы в одной строке:");
        List<String> list3 = includedInFirstOrSecond(mapStr1, mapStr2, uniqueWordAllStrings);
        viewConsoleListFIFO(list3);
        viewConsoleListLIFO(list3);
        viewConsoleListShiftLeft(list3, (int)(Math.random()*list3.size()));
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
        List<String> stringList = new ArrayList<>();
        for(String word : uniqueWord) {
            if(map1.containsKey(word) && map2.containsKey(word)) stringList.add(word);
        }
        return stringList;
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
        List<String> stringList = new ArrayList<>();
        for(String word : uniqueWord) {
            if(map1.containsKey(word) && !map2.containsKey(word)) stringList.add(word);
        }
        return stringList;
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
        List<String> stringList = new ArrayList<>();
        for(String word : uniqueWord) {
            if(map1.containsKey(word) || map2.containsKey(word)) stringList.add(word);
        }
        return stringList;
    }
    /**
     * Выводит элементы Списка в обратном порядке
     * @param list
     */
    private static void viewConsoleListLIFO(List<String> list){
        System.out.println("Должны выводиться в обратном порядке");
        //Используем статдартный метод для разворота колекции
        Collections.reverse(list);
        for(String item : list) {
            System.out.println(item);
        }
    }
    /**
     * Выводит элементы списка в прямом порядке
     * @param list
     */
    private static void viewConsoleListFIFO(List<String> list){
        System.out.println("Должны выводиться в обычном порядке");
        for(String item : list) {
            System.out.println(item);
        }
    }
    /**
     * Выводит элементы списка отсортированные по возрастанию
     * c циклическим сдвигом в лево на N
     * @param list
     */
    private static void viewConsoleListShiftLeft(List<String> list, Integer n){
        System.out.println(n);
        Collections.sort(list); //отсортируем в порядке возрастания
        System.out.println(list);
        Collections.rotate(list, -n); //стандартный метод сдвига
        System.out.println("Должны выводиться в порядке возрастания циклического сдвига влево на n разрядов");
        for(String item : list) {
            System.out.println(item);
        }
    }

    /**
     * Выводит элементы очереди в обратном порядке
     * @param queue
     */
    private static void viewConsoleQueueLIFO(Deque queue){
        while (!queue.isEmpty()) {
            System.out.println(queue.pollLast());
        }
    }
    /**
     * Выводит элементы очереди в прямом порядке
     * @param queue
     */
    private static void viewConsoleQueueFIFO(Deque queue){
        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
    }
    /**
     * Очередь , где
     * элементы входят и в первую, и во вторую строку
     * @param map1
     * @param map2
     * @param uniqueWord
     * @return
     */
    private static Deque<String> includedInFirstAndSecondDeque(
            Map<String, Integer> map1,
            Map<String, Integer> map2,
            Set<String> uniqueWord){
        // Создаем новый set
        Deque<String> stringSet = new ArrayDeque<>();
        for(String word : uniqueWord) {
            if(map1.containsKey(word) && map2.containsKey(word)) stringSet.push(word);
        }
        return stringSet;
    }

    /**
     * Очередь , где
     * входят в первую и не входят во вторую
     * @param map1 - масив  с словами из первой строки
     * @param map2 - массив по второй строке
     * @param uniqueWord - множество уникальных элементов
     * @return
     */
    private static Deque<String> includedOnlyFirstDeque(
            Map<String, Integer> map1,
            Map<String, Integer> map2,
            Set<String> uniqueWord){
        // Создаем новый set
        Deque<String> deque = new ArrayDeque<>();
        for(String word : uniqueWord) {
            if(map1.containsKey(word) && !map2.containsKey(word)) deque.push(word);
        }
        return deque;
    }

    /**
     * ПОчередь , где
     * содержатся хотя бы в одной строке
     * @param map1 - масив  с словами из первой строки
     * @param map2 - массив по второй строке
     * @param uniqueWord - множество уникальных элементов
     * @return
     */
    private static Deque<String> includedInFirstOrSecondDeque(
            Map<String, Integer> map1,
            Map<String, Integer> map2,
            Set<String> uniqueWord){
        // Создаем новый set
        Deque<String> deque = new ArrayDeque<>();
        for(String word : uniqueWord) {
            if(map1.containsKey(word) || map2.containsKey(word)) deque.push(word);
        }
        return deque;
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
