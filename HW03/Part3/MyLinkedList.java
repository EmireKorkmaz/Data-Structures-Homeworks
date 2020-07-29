/*
*  I implemented all methods normally but i added some code
*  to link courses within the same semester. I set their
*  circularNext and previous fields in order to implement
*  a circular list.
*
* */


import java.util.LinkedList;

public class MyLinkedList<E> extends LinkedList {
    private Node<E> head;
    private int size;
    public MyLinkedList(){
        head = null;
    }
    public boolean addItem(E item, int sem){
        if (head==null) {
            head = new Node<E>(item);
            head.setPrev(null);  // I link all the courses which has same semester number to create a circular semester list
            head.setCircularNext(null);
            head.setSem(sem); // I also set their semester numbers as well to check in the future occasions
            size++;
            return true;
        }
        Node<E> current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = new Node<>(item);
        current.next.setSem(sem);
        size++;

        current.next.setCircularNext(null);
        Node<E> node = head;
        while (node.next != null){
            if(node.getSem()==sem && node.getCircularNext()==null) { // after adding element, I linked courses within the same semester
                node.setCircularNext(current.next); //by setting its next and previous Nodes
                current.setPrev(node);
                return true;
            }
            node = node.next;
        }
        return true;
    }
    public void circularPrint(int s){

        Node<E> node = head;
        Node<E> current = head;
        while (node.next != null) {
            if (node.getSem() == s) {
                current = node;
                break;
            }
            node = node.next;
        }
        while (current.getCircularNext() != null){
            System.out.println(current.getData().toString()); // i created this method to see linked courses
            current = current.next;
        }
    }
    public void addIndex(E item, int index, int sem){
        if (head==null) {
            head = new Node<>(item);
            head.setPrev(null);
            head.setCircularNext(null);
            head.setSem(sem);
            size++;
            return;
        }
        Node<E> current = head;
        Node<E> temp = new Node<>(item);
        int i=0;
        while (i!=index){
            current = current.next;
            i++;
        }
        temp = current.next;
        current.next = new Node<>(item);
        current.next.next = temp;
        size++;

        current.next.setCircularNext(null);
        Node<E> node = head;
        while (node.next != null){
            if(node.getSem()==sem && node.getCircularNext()==null) {
                node.setCircularNext(current.next);
                current.setPrev(node);
                return;
            }
            node = node.next;
        }
    }
    public int size(){
        return size;
    }
    public void setItem(int index, E givenData){
        Node<E> current = head;
        int i=0;
        while (i< index &&  current != null ){
            current = current.next;
            i++;
        }
        current.setData(givenData);
    }
    public E getItem(int index){

        Node<E> current = head;
        int i=0;
        while (i< index &&  current != null ){
            current = current.next;
            i++;
        }
        return current.getData();
    }
    public E removeItem(E givenData){
        if (head==null)
            return null;

        Node<E> current = head;

        while (current.next != null) {
            if (current.next.getData() == givenData){
                current.next = current.next.next;
                return givenData;
            }
            current = current.next;
        }
        return null;
    }
    private static class Node<E>{
        private E data;
        private Node<E> next;
        private Node<E> circularNext;
        private Node<E> prev;
        private int sem; // I added this field to check courses' semester information

        public Node<E> getCircularNext() {
            return circularNext;
        }

        public void setCircularNext(Node<E> circularNext) {
            this.circularNext = circularNext;
        }

        public int getSem() {
            return sem;
        }

        public void setSem(int sem) {
            this.sem = sem;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        private Node(E dataItem){
            data = dataItem;
            next = null;
        }

        private Node(E dataItem, Node<E> nodeRef){
            data = dataItem;
            next = nodeRef;
        }
        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }


    }
}

