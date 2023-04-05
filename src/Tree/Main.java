package Tree;

public class Main {
    public static void main(String[] args) {

        Tree tree = createTree();
        //Прямой обход дерева
        System.out.print("Прямой обход дерева: ");
        tree.traversalPreOrder(tree.rootTree);
        //Обратный обход дерева
        System.out.print("\nОбратный обход дерева: ");
        tree.traversalPosOrder(tree.rootTree);
        //Центрированый обход дерева
        System.out.print("\nЦентрированый обход дерева: ");
        tree.traversalInOrder(tree.rootTree);
        //Длинна дерева
        System.out.print("\nДлинна дерева: ");
        System.out.println(tree.treeLength(tree.rootTree));

        tree.printTree();
    }
    private static Tree createTree() {
        Tree tree = new Tree();

        for(int i=0; i<10; i++){
            tree.add((int)(Math.random()*30));
        }
        return tree;
    }
}
