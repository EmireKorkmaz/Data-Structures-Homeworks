import java.io.*;
import java.util.Random;

public class q4<T> {
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

    public static  <T extends Comparable<T> > void displayLL(MyLinkedList<T> mll){
        Node<T> current = mll.getHead();

        while (current != null) {
            System.out.print(current.getData()+" ");
            current=current.next;
        }
    }
    public static void quickSort(){
        Integer[] nums = new Integer[10];
        for (int i=0, k=10; i<nums.length; i++){
            nums[i] = k;
            k+=5;
        }
        Integer[] arr1 = new Integer[10];
        Integer[] arr2 = new Integer[15];
        Integer[] arr3 = new Integer[20];
        Integer[] arr4 = new Integer[25];
        Integer[] arr5 = new Integer[30];
        Integer[] arr6 = new Integer[35];
        Integer[] arr7 = new Integer[40];
        Integer[] arr8 = new Integer[45];
        Integer[] arr9 = new Integer[50];
        Integer[] arr10 = new Integer[55];
        Random random = new Random();

        for (int i=1; i<=10; i++){
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
                    case 5: arr5[l] = random.nextInt(9) + 1;
                        break;
                    case 6: arr6[l] = random.nextInt(9) + 1;
                        break;
                    case 7: arr7[l] = random.nextInt(9) + 1;
                        break;
                    case 8: arr8[l] = random.nextInt(9) + 1;;
                        break;
                    case 9: arr9[l] = random.nextInt(9) + 1;
                        break;
                    case 10: arr10[l] = random.nextInt(9) + 1;
                        break;
                }
            }
        }
        QuickSort<Integer> quickSort = new QuickSort<>();

        Double[] time1 = new Double[100];
        Double[] time2 = new Double[100];
        Double[] time3 = new Double[100];
        Double[] time4 = new Double[100];
        Double[] time5 = new Double[100];
        Double[] time6 = new Double[100];
        Double[] time7 = new Double[100];
        Double[] time8 = new Double[100];
        Double[] time9 = new Double[100];
        Double[] time10 = new Double[100];
        int index1 = 0, index2 = 0, index3 = 0, index4 = 0, index5 = 0, index6 = 0, index7 = 0, index8 = 0, index9 = 0, index10 = 0;
        double start;

        for (int i=1; i<=10; i++){
            for (int l=0; l<nums[i-1]; l++){
                switch (i){
                    case 1: start = System.nanoTime();
                        quickSort.sort(arr2);
                        time1[index1] = System.nanoTime() - start;
                        index1++;
                        break;
                    case 2: start = System.nanoTime();
                        quickSort.sort(arr2);
                        time2[index2] = System.nanoTime() - start;
                        index2++;
                        break;
                    case 3: start = System.nanoTime();
                        quickSort.sort(arr3);
                        time3[index3] = System.nanoTime() - start;
                        index3++;
                        break;
                    case 4: start = System.nanoTime();
                        quickSort.sort(arr4);
                        time4[index4] = System.nanoTime() - start;
                        index4++;
                        break;
                    case 5: start = System.nanoTime();
                        quickSort.sort(arr5);
                        time5[index5] = System.nanoTime() - start;
                        index5++;
                        break;
                    case 6: start = System.nanoTime();
                        quickSort.sort(arr6);
                        time6[index6] = System.nanoTime() - start;
                        index6++;
                        break;
                    case 7: start = System.nanoTime();
                        quickSort.sort(arr7);
                        time7[index7] = System.nanoTime() - start;
                        index7++;
                        break;
                    case 8: start = System.nanoTime();
                        quickSort.sort(arr8);
                        time8[index8] = System.nanoTime() - start;
                        index8++;
                        break;
                    case 9: start = System.nanoTime();
                        quickSort.sort(arr9);
                        time9[index9] = System.nanoTime() - start;
                        index9++;
                        break;
                    case 10: start = System.nanoTime();
                        quickSort.sort(arr10);
                        time10[index10] = System.nanoTime() - start;
                        index10++;
                        break;
                }
            }
        }

        System.out.println(average(time1)+" "+average(time2)+" "+average(time3)+" "+
                        average(time4)+" "+average(time5)+" "+average(time6)+" "+average(time7)+" "+average(time8)+" "+
                        average(time9)+" "+average(time10));
    }
    public static void mergeSort(){
        Integer[] nums = new Integer[10];
        for (int i=0, k=10; i<nums.length; i++){
            nums[i] = k;
            k+=5;
        }
        Integer[] arr1 = new Integer[10];
        Integer[] arr2 = new Integer[15];
        Integer[] arr3 = new Integer[20];
        Integer[] arr4 = new Integer[25];
        Integer[] arr5 = new Integer[30];
        Integer[] arr6 = new Integer[35];
        Integer[] arr7 = new Integer[40];
        Integer[] arr8 = new Integer[45];
        Integer[] arr9 = new Integer[50];
        Integer[] arr10 = new Integer[55];
        Random random = new Random();

        for (int i=1; i<=10; i++){
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
                    case 5: arr5[l] = random.nextInt(9) + 1;
                        break;
                    case 6: arr6[l] = random.nextInt(9) + 1;
                        break;
                    case 7: arr7[l] = random.nextInt(9) + 1;
                        break;
                    case 8: arr8[l] = random.nextInt(9) + 1;;
                        break;
                    case 9: arr9[l] = random.nextInt(9) + 1;
                        break;
                    case 10: arr10[l] = random.nextInt(9) + 1;
                        break;
                }
            }
        }
        MergeSort<Integer> quickSort = new MergeSort<>();

        Double[] time1 = new Double[100];
        Double[] time2 = new Double[100];
        Double[] time3 = new Double[100];
        Double[] time4 = new Double[100];
        Double[] time5 = new Double[100];
        Double[] time6 = new Double[100];
        Double[] time7 = new Double[100];
        Double[] time8 = new Double[100];
        Double[] time9 = new Double[100];
        Double[] time10 = new Double[100];
        int index1 = 0, index2 = 0, index3 = 0, index4 = 0, index5 = 0, index6 = 0, index7 = 0, index8 = 0, index9 = 0, index10 = 0;
        double start;

        for (int i=1; i<=10; i++){
            for (int l=0; l<nums[i-1]; l++){
                switch (i){
                    case 1: start = System.nanoTime();
                        quickSort.sort(arr2);
                        time1[index1] = System.nanoTime() - start;
                        index1++;
                        break;
                    case 2: start = System.nanoTime();
                        quickSort.sort(arr2);
                        time2[index2] = System.nanoTime() - start;
                        index2++;
                        break;
                    case 3: start = System.nanoTime();
                        quickSort.sort(arr3);
                        time3[index3] = System.nanoTime() - start;
                        index3++;
                        break;
                    case 4: start = System.nanoTime();
                        quickSort.sort(arr4);
                        time4[index4] = System.nanoTime() - start;
                        index4++;
                        break;
                    case 5: start = System.nanoTime();
                        quickSort.sort(arr5);
                        time5[index5] = System.nanoTime() - start;
                        index5++;
                        break;
                    case 6: start = System.nanoTime();
                        quickSort.sort(arr6);
                        time6[index6] = System.nanoTime() - start;
                        index6++;
                        break;
                    case 7: start = System.nanoTime();
                        quickSort.sort(arr7);
                        time7[index7] = System.nanoTime() - start;
                        index7++;
                        break;
                    case 8: start = System.nanoTime();
                        quickSort.sort(arr8);
                        time8[index8] = System.nanoTime() - start;
                        index8++;
                        break;
                    case 9: start = System.nanoTime();
                        quickSort.sort(arr9);
                        time9[index9] = System.nanoTime() - start;
                        index9++;
                        break;
                    case 10: start = System.nanoTime();
                        quickSort.sort(arr10);
                        time10[index10] = System.nanoTime() - start;
                        index10++;
                        break;
                }
            }
        }

        System.out.println(average(time1)+" "+average(time2)+" "+average(time3)+" "+
                average(time4)+" "+average(time5)+" "+average(time6)+" "+average(time7)+" "+average(time8)+" "+
                average(time9)+" "+average(time10));
    }
    public static void heapSort(){
        Integer[] nums = new Integer[10];
        for (int i=0, k=10; i<nums.length; i++){
            nums[i] = k;
            k+=5;
        }
        Integer[] arr1 = new Integer[10];
        Integer[] arr2 = new Integer[15];
        Integer[] arr3 = new Integer[20];
        Integer[] arr4 = new Integer[25];
        Integer[] arr5 = new Integer[30];
        Integer[] arr6 = new Integer[35];
        Integer[] arr7 = new Integer[40];
        Integer[] arr8 = new Integer[45];
        Integer[] arr9 = new Integer[50];
        Integer[] arr10 = new Integer[55];
        Random random = new Random();

        for (int i=1; i<=10; i++){
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
                    case 5: arr5[l] = random.nextInt(9) + 1;
                        break;
                    case 6: arr6[l] = random.nextInt(9) + 1;
                        break;
                    case 7: arr7[l] = random.nextInt(9) + 1;
                        break;
                    case 8: arr8[l] = random.nextInt(9) + 1;;
                        break;
                    case 9: arr9[l] = random.nextInt(9) + 1;
                        break;
                    case 10: arr10[l] = random.nextInt(9) + 1;
                        break;
                }
            }
        }
        HeapSort<Integer> quickSort = new HeapSort<>();

        Double[] time1 = new Double[100];
        Double[] time2 = new Double[100];
        Double[] time3 = new Double[100];
        Double[] time4 = new Double[100];
        Double[] time5 = new Double[100];
        Double[] time6 = new Double[100];
        Double[] time7 = new Double[100];
        Double[] time8 = new Double[100];
        Double[] time9 = new Double[100];
        Double[] time10 = new Double[100];
        int index1 = 0, index2 = 0, index3 = 0, index4 = 0, index5 = 0, index6 = 0, index7 = 0, index8 = 0, index9 = 0, index10 = 0;
        double start;

        for (int i=1; i<=10; i++){
            for (int l=0; l<nums[i-1]; l++){
                switch (i){
                    case 1: start = System.nanoTime();
                        quickSort.sort(arr2);
                        time1[index1] = System.nanoTime() - start;
                        index1++;
                        break;
                    case 2: start = System.nanoTime();
                        quickSort.sort(arr2);
                        time2[index2] = System.nanoTime() - start;
                        index2++;
                        break;
                    case 3: start = System.nanoTime();
                        quickSort.sort(arr3);
                        time3[index3] = System.nanoTime() - start;
                        index3++;
                        break;
                    case 4: start = System.nanoTime();
                        quickSort.sort(arr4);
                        time4[index4] = System.nanoTime() - start;
                        index4++;
                        break;
                    case 5: start = System.nanoTime();
                        quickSort.sort(arr5);
                        time5[index5] = System.nanoTime() - start;
                        index5++;
                        break;
                    case 6: start = System.nanoTime();
                        quickSort.sort(arr6);
                        time6[index6] = System.nanoTime() - start;
                        index6++;
                        break;
                    case 7: start = System.nanoTime();
                        quickSort.sort(arr7);
                        time7[index7] = System.nanoTime() - start;
                        index7++;
                        break;
                    case 8: start = System.nanoTime();
                        quickSort.sort(arr8);
                        time8[index8] = System.nanoTime() - start;
                        index8++;
                        break;
                    case 9: start = System.nanoTime();
                        quickSort.sort(arr9);
                        time9[index9] = System.nanoTime() - start;
                        index9++;
                        break;
                    case 10: start = System.nanoTime();
                        quickSort.sort(arr10);
                        time10[index10] = System.nanoTime() - start;
                        index10++;
                        break;
                }
            }
        }

        System.out.println(average(time1)+" "+average(time2)+" "+average(time3)+" "+
                average(time4)+" "+average(time5)+" "+average(time6)+" "+average(time7)+" "+average(time8)+" "+
                average(time9)+" "+average(time10));
    }
    public static void insertionSort(){
        Integer[] nums = new Integer[10];
        for (int i=0, k=10; i<nums.length; i++){
            nums[i] = k;
            k+=5;
        }
        Integer[] arr1 = new Integer[10];
        Integer[] arr2 = new Integer[15];
        Integer[] arr3 = new Integer[20];
        Integer[] arr4 = new Integer[25];
        Integer[] arr5 = new Integer[30];
        Integer[] arr6 = new Integer[35];
        Integer[] arr7 = new Integer[40];
        Integer[] arr8 = new Integer[45];
        Integer[] arr9 = new Integer[50];
        Integer[] arr10 = new Integer[55];
        Random random = new Random();

        for (int i=1; i<=10; i++){
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
                    case 5: arr5[l] = random.nextInt(9) + 1;
                        break;
                    case 6: arr6[l] = random.nextInt(9) + 1;
                        break;
                    case 7: arr7[l] = random.nextInt(9) + 1;
                        break;
                    case 8: arr8[l] = random.nextInt(9) + 1;;
                        break;
                    case 9: arr9[l] = random.nextInt(9) + 1;
                        break;
                    case 10: arr10[l] = random.nextInt(9) + 1;
                        break;
                }
            }
        }
        InsertionSort<Integer> quickSort = new InsertionSort<>();

        Double[] time1 = new Double[100];
        Double[] time2 = new Double[100];
        Double[] time3 = new Double[100];
        Double[] time4 = new Double[100];
        Double[] time5 = new Double[100];
        Double[] time6 = new Double[100];
        Double[] time7 = new Double[100];
        Double[] time8 = new Double[100];
        Double[] time9 = new Double[100];
        Double[] time10 = new Double[100];
        int index1 = 0, index2 = 0, index3 = 0, index4 = 0, index5 = 0, index6 = 0, index7 = 0, index8 = 0, index9 = 0, index10 = 0;
        double start;

        for (int i=1; i<=10; i++){
            for (int l=0; l<nums[i-1]; l++){
                switch (i){
                    case 1: start = System.nanoTime();
                        quickSort.sort(arr2);
                        time1[index1] = System.nanoTime() - start;
                        index1++;
                        break;
                    case 2: start = System.nanoTime();
                        quickSort.sort(arr2);
                        time2[index2] = System.nanoTime() - start;
                        index2++;
                        break;
                    case 3: start = System.nanoTime();
                        quickSort.sort(arr3);
                        time3[index3] = System.nanoTime() - start;
                        index3++;
                        break;
                    case 4: start = System.nanoTime();
                        quickSort.sort(arr4);
                        time4[index4] = System.nanoTime() - start;
                        index4++;
                        break;
                    case 5: start = System.nanoTime();
                        quickSort.sort(arr5);
                        time5[index5] = System.nanoTime() - start;
                        index5++;
                        break;
                    case 6: start = System.nanoTime();
                        quickSort.sort(arr6);
                        time6[index6] = System.nanoTime() - start;
                        index6++;
                        break;
                    case 7: start = System.nanoTime();
                        quickSort.sort(arr7);
                        time7[index7] = System.nanoTime() - start;
                        index7++;
                        break;
                    case 8: start = System.nanoTime();
                        quickSort.sort(arr8);
                        time8[index8] = System.nanoTime() - start;
                        index8++;
                        break;
                    case 9: start = System.nanoTime();
                        quickSort.sort(arr9);
                        time9[index9] = System.nanoTime() - start;
                        index9++;
                        break;
                    case 10: start = System.nanoTime();
                        quickSort.sort(arr10);
                        time10[index10] = System.nanoTime() - start;
                        index10++;
                        break;
                }
            }
        }

        System.out.println(average(time1)+" "+average(time2)+" "+average(time3)+" "+
                average(time4)+" "+average(time5)+" "+average(time6)+" "+average(time7)+" "+average(time8)+" "+
                average(time9)+" "+average(time10));
    }




}
