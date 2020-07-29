import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.lang.Math;
import java.util.Queue;
import java.util.Random;

public class q3<T> {
    public static void main(String[] args) throws FileNotFoundException {
        MyLinkedList<Integer> mll = new MyLinkedList<>();
        mll.addItem(33);
        mll.addItem(55);
        mll.addItem(51);
        mll.addItem(11);
        mll.addItem(44);
        mll.addItem(1);
        mll.addItem(99);
        mll.addItem(9);
        mll.addItem(9);
        mll.addItem(0);

        displayLL(mll);

        MergeSortDLL<Integer> mergeSortDLL = new MergeSortDLL<>();

        mergeSortDLL.sort(mll);

    }
    public static  <T extends Comparable<T> > void display(T[] array){
        for (T t: array) {
            System.out.print(t+" ");
        }
        System.out.println();
    }

    public static  <T extends Comparable<T> > void displayLL(MyLinkedList<T> mll){
        Node<T> current = mll.getHead();

        while (current != null) {
            System.out.print(current.getData()+" ");
            current=current.next;
        }
        System.out.print("\n");
    }
}
