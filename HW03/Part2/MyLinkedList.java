import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class MyLinkedList<E> extends LinkedList<E> {
    private Node<E> head;
    private int size;
    private boolean disable;
    public MyLinkedList(){
        head = null;
    }
    public void disable(E course){
        Node<E> current = head;
        if (head==null) // checks if list is empty
            return;
        while (current.next != null){
            if (current.getData().toString().equals(course.toString())){ // comparing given course's name with existing courses
                current.setDisabled(true); // if any matches, sets its setDisabled method to true
                size--;
                return;
            }
            current = current.next;
        }
    }
    public void enable(E course){
        Node<E> current = head;
        if (head==null) // checks if list is empty
            return;
        while (current.next != null){
            if (current.getData().toString().equals(course.toString())){ // comparing given course's name with existing courses
                current.setDisabled(false); // if any matches, sets its setDisabled method to false
                size++;
                return;
            }
            current = current.next;
        }
    }
    public void showDisabled(){
        Node<E> current = head;
        while (current.next != null){
            if (current.isDisabled()) //  checks all courses to see if there are any disabled course
                System.out.println(current.getData().toString()); // if any, shows their names on the screen
            current = current.next;
        }
    }

    @Override
    public E get(int index) {
        int j=0;
        Node<E> node = head;
        while (j<index && node.next != null){
            if(node.isDisabled()){
                System.err.println("This function is disabled.");
                return null;
            }
            node = node.next;
        }

        Node<E> current = head;
        int i=0;
        while (i< index &&  current != null && current.isDisabled()==false){
            current = current.next;
            i++;
        }
        return current.getData();
    }

    @Override
    public E set(int index, E givenData) {
        int j=0;
        Node<E> node = head;
        while (j<index && node.next != null){
            if(node.isDisabled()){
                System.err.println("This function is disabled.");
                return null;
            }
            node = node.next;
        }
        Node<E> current = head;
        int i=0;
        while (i< index &&  current != null ){
            current = current.next;
            i++;
        }
        current.setData(givenData);
        return givenData;
    }

    @Override
    public void add(int index, E item) {
        if (head==null) {
            head = new Node<>(item);
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
    }
    public int size(E givenData){
        Node<E> node = head;
        while (node.next != null){
            if(node.getData().toString().equals(givenData.toString()) && node.isDisabled()){
                System.err.println("This function is disabled.");
                return -1;
            }
            node = node.next;
        }
        return size;
    }


    @Override
    public E remove(int index) {
        int j=0;
        Node<E> node = head;
        while (j<index && node.next != null){
            if(node.isDisabled()){
                System.err.println("This function is disabled.");
                return null;
            }
            node = node.next;
        }

        Node<E> current = head;
        Node<E> temp = head;
        int i=0;
        while (i< index &&  current != null && current.isDisabled()==false){
            current = current.next;
            i++;
        }
        temp = current.next;
        current.next = current.next.next;
        return temp.getData();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        int j=0;
        Node<E> node = head;
        while (j<index && node.next != null){
            if(node.isDisabled()){
                System.err.println("This function is disabled.");
                return null;
            }
            node = node.next;
        }
        Node<E> current = head;
        int i=0;
        while (i< index &&  current != null && current.isDisabled()==false){
            current = current.next;
            i++;
        }
        ListIterator<E> listIterator = null;
        listIterator.set(current.getData());
        return listIterator;
    }

    @Override
    public boolean add(E item) {
        if (head==null) {
            head = new Node<E>(item);
            size++;
            return true;
        }
        Node<E> current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = new Node<>(item);
        size++;
        return true;
    }
/*
    @Override
    public boolean addItem(E item){
        if (head==null) {
            head = new Node<E>(item);
            size++;
            return true;
        }
        Node<E> current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = new Node<>(item);
        size++;
        return true;
    }

    public void addIndex(E item, int index){
        if (head==null) {
            head = new Node<>(item);
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
    }
    public int size(E givenData){
        Node<E> node = head;
        while (node.next != null){
            if(node.getData().toString().equals(givenData.toString()) && node.isDisabled()){
                System.err.println("This function is disabled.");
                return -1;
            }
            node = node.next;
        }
        return size;
    }
    public void setItem(int index, E givenData){
        int j=0;
        Node<E> node = head;
        while (j<index && node.next != null){
            if(node.isDisabled()){
                System.err.println("This function is disabled.");
                return;
            }
            node = node.next;
        }
        Node<E> current = head;
        int i=0;
        while (i< index &&  current != null ){
            current = current.next;
            i++;
        }
        current.setData(givenData);
    }
    public E getItem(int index){
        int j=0;
        Node<E> node = head;
        while (j<index && node.next != null){
            if(node.isDisabled()){
                System.err.println("This function is disabled.");
                return null;
            }
            node = node.next;
        }

        Node<E> current = head;
        int i=0;
        while (i< index &&  current != null && current.isDisabled()==false){
            current = current.next;
            i++;
        }
        return current.getData();
    }*/
    public E removeItem(E givenData){
        Node<E> node = head;
        while (node.next != null){
            if(node.getData().toString().equals(givenData.toString()) && node.isDisabled()){
                System.err.println("This function is disabled.");
                return givenData;
            }
            node = node.next;
        }
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
        private boolean disabled;

        public boolean isDisabled() {
            return disabled;
        }

        public void setDisabled(boolean disabled) {
            this.disabled = disabled;
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

