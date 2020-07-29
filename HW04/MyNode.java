import java.util.Vector;

public class MyNode<E>{
    MyNode<E> parent;
    E data;
    Vector<MyNode<E> > children = new Vector<MyNode<E> >(20);

    public MyNode(E data) {
        this.data = data;
    }

    public MyNode<E> getParent() {
        return parent;
    }

    public void setParent(MyNode<E> parent) {
        this.parent = parent;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
