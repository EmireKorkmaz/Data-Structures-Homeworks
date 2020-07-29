import java.util.LinkedList;

public class MyLinkedList<E> extends LinkedList {
    private Node<E> head;
    private int size;

    public MyLinkedList(){
        head = null;
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public void addItem(E item){
        if (head==null) {
            head = new Node<E>(item);
            head.setPrev(null);
            size++;
            return;
        }
        Node<E> current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = new Node<>(item);
        current.next.setPrev(current);
        size++;
    }
    public void addIndex(E item, int index){
        if (head==null) {
            head = new Node<>(item);
            head.setPrev(null);
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
        current.next.next.setPrev(current.next);
        current.next.setPrev(current);
        size++;
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
    public void removeItem(E givenData){
        if (head==null)
            return;

        Node<E> current = head;

        while (current.next != null) {
            if (current.next.getData() == givenData){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

}

