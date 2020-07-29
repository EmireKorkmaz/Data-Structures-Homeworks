import java.io.*;
import java.time.chrono.MinguoEra;
import java.util.Map;
import java.lang.Math;
import java.util.Queue;
import java.util.Random;

public class q5<T> {
    public static void main(String[] args) throws IOException {
        quickSort();
        heapSort();
        mergeSort();
        insertionSort();

    }
    public static double average(Double[] arr){
        double total = 0.0;
        for (int i=0; arr[i]!=null; i++){
            total+=arr[i];
        }
        return total/arr.length;
    }
    public static  <T extends Comparable<T> > void display(T[] array){
        for (T t: array) {
            System.out.print(t+" ");
        }
        System.out.println();
    }

    public static void quickSort() throws IOException {
        Integer[] nums = new Integer[4];
        nums[0]=100;
        nums[1]=1000;
        nums[2]=5000;
        nums[3]=10000;

        Integer[] arr1 = new Integer[100];
        Integer[] arr2 = new Integer[1000];
        Integer[] arr3 = new Integer[5000];
        Integer[] arr4 = new Integer[10000];

        Random random = new Random();

        for (int i=1; i<=4; i++){
            for (int l=0; l<nums[i-1]; l++){
                switch (i){
                    case 1: arr1[l] = random.nextInt(9) + 1;
                        break;
                    case 2: arr2[l] = random.nextInt(9) + 1;
                        break;
                    case 3: arr3[l] = random.nextInt(9) + 1;
                        break;
                    case 4: arr4[l] = random.nextInt(9) + 1;
                        break;
                }
            }
        }
        Double[] time = new Double[1000];
        int index = 0;
        double start;
        QuickSort<Integer> quickSort = new QuickSort<>();
        for (int i=1; i<=4; i++){
            switch (i){
                case 1: start = System.nanoTime();
                    quickSort.sort(arr2);
                    time[index] = System.nanoTime() - start;
                    index++;
                    break;
                case 2: start = System.nanoTime();
                    quickSort.sort(arr2);
                    time[index] = System.nanoTime() - start;
                    index++;
                    break;
                case 3: start = System.nanoTime();
                    quickSort.sort(arr3);
                    time[index] = System.nanoTime() - start;
                    index++;
                    break;
                case 4: start = System.nanoTime();
                    quickSort.sort(arr4);
                    time[index] = System.nanoTime() - start;
                    index++;
                    break;
            }
        }

        FileWriter w = new FileWriter("quicksort.csv");

        for(int i=0; i<index;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(time[i]+";\n");
            w.write(sb.toString());
        }
        w.flush();
        w.close();
    }
    public static void mergeSort() throws IOException {
        Integer[] nums = new Integer[4];
        nums[0]=100;
        nums[1]=1000;
        nums[2]=5000;
        nums[3]=10000;

        Integer[] arr1 = new Integer[100];
        Integer[] arr2 = new Integer[1000];
        Integer[] arr3 = new Integer[5000];
        Integer[] arr4 = new Integer[10000];

        Random random = new Random();

        for (int i=1; i<=4; i++){
            for (int l=0; l<nums[i-1]; l++){
                switch (i){
                    case 1: arr1[l] = random.nextInt(9) + 1;
                        break;
                    case 2: arr2[l] = random.nextInt(9) + 1;
                        break;
                    case 3: arr3[l] = random.nextInt(9) + 1;
                        break;
                    case 4: arr4[l] = random.nextInt(9) + 1;
                        break;
                }
            }
        }
        Double[] time = new Double[1000];
        int index = 0;
        double start;
        MergeSort<Integer> quickSort = new MergeSort<>();
        for (int i=1; i<=4; i++){
            switch (i){
                case 1: start = System.nanoTime();
                    quickSort.sort(arr2);
                    time[index] = System.nanoTime() - start;
                    index++;
                    break;
                case 2: start = System.nanoTime();
                    quickSort.sort(arr2);
                    time[index] = System.nanoTime() - start;
                    index++;
                    break;
                case 3: start = System.nanoTime();
                    quickSort.sort(arr3);
                    time[index] = System.nanoTime() - start;
                    index++;
                    break;
                case 4: start = System.nanoTime();
                    quickSort.sort(arr4);
                    time[index] = System.nanoTime() - start;
                    index++;
                    break;
            }
        }

        FileWriter w = new FileWriter("mergesort.csv");

        for(int i=0; i<index;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(time[i]+";\n");
            w.write(sb.toString());
        }
        w.flush();
        w.close();
    }
    public static void heapSort() throws IOException {
        Integer[] nums = new Integer[4];
        nums[0]=100;
        nums[1]=1000;
        nums[2]=5000;
        nums[3]=10000;

        Integer[] arr1 = new Integer[100];
        Integer[] arr2 = new Integer[1000];
        Integer[] arr3 = new Integer[5000];
        Integer[] arr4 = new Integer[10000];

        Random random = new Random();

        for (int i=1; i<=4; i++){
            for (int l=0; l<nums[i-1]; l++){
                switch (i){
                    case 1: arr1[l] = random.nextInt(9) + 1;
                        break;
                    case 2: arr2[l] = random.nextInt(9) + 1;
                        break;
                    case 3: arr3[l] = random.nextInt(9) + 1;
                        break;
                    case 4: arr4[l] = random.nextInt(9) + 1;
                        break;
                }
            }
        }
        Double[] time = new Double[1000];
        int index = 0;
        double start;
        HeapSort<Integer> quickSort = new HeapSort<>();
        for (int i=1; i<=4; i++){
            switch (i){
                case 1: start = System.nanoTime();
                    quickSort.sort(arr2);
                    time[index] = System.nanoTime() - start;
                    index++;
                    break;
                case 2: start = System.nanoTime();
                    quickSort.sort(arr2);
                    time[index] = System.nanoTime() - start;
                    index++;
                    break;
                case 3: start = System.nanoTime();
                    quickSort.sort(arr3);
                    time[index] = System.nanoTime() - start;
                    index++;
                    break;
                case 4: start = System.nanoTime();
                    quickSort.sort(arr4);
                    time[index] = System.nanoTime() - start;
                    index++;
                    break;
            }
        }

        FileWriter w = new FileWriter("heapsort.csv");

        for(int i=0; i<index;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(time[i]+";\n");
            w.write(sb.toString());
        }
        w.flush();
        w.close();
    }
    public static void insertionSort() throws IOException {
        Integer[] nums = new Integer[4];
        nums[0]=100;
        nums[1]=1000;
        nums[2]=5000;
        nums[3]=10000;

        Integer[] arr1 = new Integer[100];
        Integer[] arr2 = new Integer[1000];
        Integer[] arr3 = new Integer[5000];
        Integer[] arr4 = new Integer[10000];

        Random random = new Random();

        for (int i=1; i<=4; i++){
            for (int l=0; l<nums[i-1]; l++){
                switch (i){
                    case 1: arr1[l] = random.nextInt(9) + 1;
                        break;
                    case 2: arr2[l] = random.nextInt(9) + 1;
                        break;
                    case 3: arr3[l] = random.nextInt(9) + 1;
                        break;
                    case 4: arr4[l] = random.nextInt(9) + 1;
                        break;
                }
            }
        }
        Double[] time = new Double[1000];
        int index = 0;
        double start;
        InsertionSort<Integer> quickSort = new InsertionSort<>();
        for (int i=1; i<=4; i++){
            switch (i){
                case 1: start = System.nanoTime();
                    quickSort.sort(arr2);
                    time[index] = System.nanoTime() - start;
                    index++;
                    break;
                case 2: start = System.nanoTime();
                    quickSort.sort(arr2);
                    time[index] = System.nanoTime() - start;
                    index++;
                    break;
                case 3: start = System.nanoTime();
                    quickSort.sort(arr3);
                    time[index] = System.nanoTime() - start;
                    index++;
                    break;
                case 4: start = System.nanoTime();
                    quickSort.sort(arr4);
                    time[index] = System.nanoTime() - start;
                    index++;
                    break;
            }
        }

        FileWriter w = new FileWriter("insertionsort.csv");

        for(int i=0; i<index;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(time[i]+";\n");
            w.write(sb.toString());
        }
        w.flush();
        w.close();
    }




}
