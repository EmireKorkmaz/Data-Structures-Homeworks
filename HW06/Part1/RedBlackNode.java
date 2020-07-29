public class RedBlackNode <E> extends BinaryTree.Node<E> {
    public boolean isRed;

    public RedBlackNode(E item) {
        super(item);
        isRed = true;
    }

    public String toString() {
        if (isRed) {
            return "Red  : " + super.toString();
        }
        else {
            return "Black: " + super.toString();
        }
    }
}