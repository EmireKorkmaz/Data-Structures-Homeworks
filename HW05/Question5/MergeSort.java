public class MergeSort<T> {

    public static <T extends Comparable<T> > void sort(T[] table){
        if(table.length>1){
            int halfsize = table.length/2;
            T[] lefttable = (T[]) new Comparable[halfsize];
            T[] righttable = (T[]) new Comparable[table.length-halfsize];

            System.arraycopy(table,0,lefttable,0,halfsize);
            System.arraycopy(table,halfsize,righttable,0,table.length-halfsize);

            sort(lefttable);
            sort(righttable);

            merge(table, lefttable, righttable);
        }
    }

    private static <T extends Comparable<T> > void merge(T[] outputSequence, T[] leftSequence, T[] rightSequence){
        int i=0,j=0,k=0;

        while (i<leftSequence.length && j<rightSequence.length){
            if (leftSequence[i].compareTo(rightSequence[j])<0)
                outputSequence[k++] = leftSequence[i++];
            else
                outputSequence[k++] = rightSequence[j++];
        }

        while (i < leftSequence.length){
            outputSequence[k++] = leftSequence[i++];
        }
        while (j < rightSequence.length) {
            outputSequence[k++] = rightSequence[j++];
        }
    }
}
