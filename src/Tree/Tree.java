package Tree;

import java.util.Stack;

public class Tree {

    public Node rootTree;

    private static String hr(String ch, Integer n){
        StringBuilder hr = new StringBuilder();
        for(int i = 0; i<n*2+1; i++) {
            hr.append(ch);
        };
        return hr.toString();
    }

    /**
     * Рекурсивное добавление узла
     * @param node
     * @param value
     * @return
     */
    private Node addRecursive(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.leftNode = addRecursive(node.leftNode, value);
        } else if (value > node.value) {
            node.rightNode = addRecursive(node.rightNode, value);
        } else {
            return node;
        }

        return node;
    }

    /**
     * Добавляем значение в дерево
     * @param value
     */
    public void add(int value) {
        this.rootTree = addRecursive(this.rootTree, value);
    }

    /**
     * Прямой обход дерева
     * 1) Посетите корневой узел
     * 2) Посетите все узлы в левом поддереве
     * 3) Посетите все узлы в правом поддереве
     * @param node
     */
    public void traversalPreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversalPreOrder(node.leftNode);
            traversalPreOrder(node.rightNode);
        }
    }
    /**
     * Обратный обход дерева
     * 1) Посетите все узлы в левом поддереве
     * 2) Посетите все узлы в правом поддереве
     * 3) Посетите корневой узел
     * @param node
     */
    public void traversalPosOrder(Node node) {
        if (node != null) {
            traversalPosOrder(node.leftNode);
            traversalPosOrder(node.rightNode);
            System.out.print(" " + node.value);
        }
    }

    /**
     * Центрированный обход дерева
     * 1) Сначала посетите все узлы в левом поддереве
     * 2) Затем корневой узел
     * 3) Посетите все узлы в правом поддереве
     */
    public void traversalInOrder(Node node) {
        if (node != null) {
            traversalInOrder(node.leftNode);
            System.out.print(" " + node.value);
            traversalInOrder(node.rightNode);
        }
    }
    /**
     * Рекурсивное вычисление длинны дерева
     * @param node
     * @return
     */
    public int treeLength(Node node) {
        // Если узел пуст
        if (node == null) {
            return 0;
        }
        // Ищим максимальную глубинну вложенности
        return 1 + Math.max(treeLength(node.leftNode), treeLength(node.rightNode));
    }

    public void printTree() { // метод для вывода дерева в консоль
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(rootTree);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.value); // выводим его значение в консоли
                    localStack.push(temp.leftNode); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.rightNode);
                    if (temp.leftNode != null ||
                            temp.rightNode != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }
}
