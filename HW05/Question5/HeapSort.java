public class HeapSort<T> {
    public static <T extends Comparable<T> > void sort(T[] table){
        buildHeap(table);
        shrinkTable(table);
    }

    private static <T extends Comparable<T> > void buildHeap(T[] table){
        int n=1;
        while ((n<table.length)){
            n++;
            int child = n-1;
            int parent = (child-1)/2;
            while (parent>=0 && table[parent].compareTo(table[child])<0){
                swap(table,parent,child);
                child=parent;
                parent = (child-1)/2;
            }
        }
    }
    private static <T extends Comparable<T> > void swap(T[] table, int first, int last){
        T temp = table[first];
        table[first] = table[last];
        table[last] = temp;
    }

    private static <T extends Comparable<T> > void shrinkTable(T[] table){
        int n=table.length;

        while ((n>0)){
            n--;
            swap(table,0, n);
            int parent = 0;
            while (true){
                int leftChild = 2*parent+1;
                if (leftChild>=n)
                    break;

                int rightChild = leftChild+1;
                int maxChild = leftChild;

                if(rightChild<n && table[leftChild].compareTo(table[rightChild])<0)
                    maxChild=rightChild;
                if(table[parent].compareTo(table[maxChild])<0){
                    swap(table,parent,maxChild);
                    parent=maxChild;
                }
                else {
                    break;
                }
            }

        }
    }
}
