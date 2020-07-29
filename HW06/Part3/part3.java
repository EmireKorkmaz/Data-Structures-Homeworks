import java.util.Random;

public class part3 {
    public static void main(String[] args){
        AVLTree<Integer> avlTree = new AVLTree<>();
        for(int i=0; i<10; i++){
            avlTree.add(i);
        }
        System.out.println("Add method\n" +avlTree.toString());
        avlTree.delete(7);
        System.out.println("Delete method\n" +avlTree.toString());
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        Random rand = new Random();

        for (int i=0; i< 10; i++){
            binarySearchTree.add(rand.nextInt(50) + 1);
        }
        System.out.print("Constructor\n");
        AVLTree<Integer> avlTree1 = new AVLTree<>(binarySearchTree);

    }
}
