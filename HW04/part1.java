public class part1 {
    public static void main(String[] args) {
        MyNode<String> node = new MyNode<>("William");
        MyNode<String> node2 = new MyNode<>("Marshall");
        MyNode<String> node3 = new MyNode<>("Ted");
        MyNode<String> node4 = new MyNode<>("Barney");
        MyNode<String> node5 = new MyNode<>("Lily");
        MyNode<String> node6 = new MyNode<>("Robin");
        MyNode<String> node7 = new MyNode<>("Ranjit");

        Tree<String> tree = new Tree<String>();
        tree.add(node4, node2);
        tree.add(node2, node3);
        tree.add(node2, node);
        tree.add(node2, node5);
        tree.add(node5, node6);
        tree.add(node5, node7);

        System.out.print(tree.postOrderSearch(node2, node5.getData()));
    }
}
