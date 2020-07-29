import java.util.Random;
public class part3 {
    public static void main(String[] args){
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        RedBlackTree<Integer> redBlackTree2 = new RedBlackTree<>();

        for(int i=0; i<22; i++){
                redBlackTree.add(i+1);
        }
        System.out.println(redBlackTree.toString());

        Random rand = new Random();

        for(int i=0; i<15; i++){
            redBlackTree2.add(rand.nextInt(50) + 1);
        }

        System.out.println(redBlackTree2.toString());

    }
}
