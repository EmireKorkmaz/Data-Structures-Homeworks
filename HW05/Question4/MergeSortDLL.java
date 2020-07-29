public class MergeSortDLL<T> extends MyLinkedList{
    private MyLinkedList sortedList = new MyLinkedList();

    public <T extends Comparable<T> > void sort(MyLinkedList<T> list){
        if(list.isEmpty() == false){
            int halfsize = list.size()/2, i=0;

            MyLinkedList<T> leftList = new MyLinkedList<>();
            MyLinkedList<T> rightList = new MyLinkedList<>();

            Node<T> temp = list.getHead();

            while (temp!=null){
                if(i<halfsize){
                    leftList.addItem(temp.getData());
                    temp=temp.next;
                }
                else{
                    rightList.addItem(temp.getData());
                    temp=temp.next;
                }
                i++;
            }
            sort(leftList);
            sort(rightList);
            merge(leftList, rightList);
        }

    }

    private <T extends Comparable<T> > void merge(MyLinkedList<T> l1, MyLinkedList<T> l2) {
        Node<T> left = l1.getHead();
        Node<T> right = l2.getHead();

        int i = 0, j = 0, k = 0;
        while (right.next != null && left.next != null) {
            if (left.getData().compareTo(right.getData()) < 0) {
                sortedList.addItem(left.getData());
                left = left.next;
                i++;
            } else {
                sortedList.addItem(right.getData());
                right = right.next;
                j++;
            }
        }
        if (i < l1.size()) {
            while (left != null) {
                sortedList.addItem(left.getData());
                left = left.next;
                i++;
            }
        }
        if (j<l2.size()){
            while (right != null) {
                sortedList.addItem(right.getData());
                right = right.next;
                j++;
            }
        }
        displayLL(sortedList);
    }
    public static  <T extends Comparable<T> > void displayLL(MyLinkedList<T> mll){
        Node<T> current = mll.getHead();

        while (current != null) {
            System.out.print(current.getData()+" ");
            current=current.next;
        }
        System.out.println();
    }

}
