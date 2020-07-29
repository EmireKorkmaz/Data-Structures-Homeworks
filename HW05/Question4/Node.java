public class Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> prev;

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node(T dataItem){
        data = dataItem;
        next = null;
    }

    public Node(T dataItem, Node<T> nodeRef){
        data = dataItem;
        next = nodeRef;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
