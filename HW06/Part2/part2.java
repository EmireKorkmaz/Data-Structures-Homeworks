import java.util.Random;

public class part2 {
    public static void main(String[] args){
        BTree<Integer> bTree = new BTree<>(3);

        // numbers between 1 and 15

        for (int i=0; i<15; i++){
            bTree.add(i);
        }
        System.out.println(bTree.toString());

        Random rand = new Random();

        // 25 random number
        for (int i=0; i<25; i++){
            bTree.add(rand.nextInt(50) + 1);
        }
        System.out.println(bTree.toString());

    }
}
