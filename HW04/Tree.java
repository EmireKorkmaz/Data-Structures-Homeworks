
public class Tree<E> extends BinaryTree{
        MyNode<E> root;

        public Tree(){
            root=null;
        }

        public void preOrderTraverse(MyNode<E> myNode){
            System.out.print(myNode.getData() + " ");
            for (MyNode<E> m : myNode.children ){
                preOrderTraverse(m);
            }
        }
        public boolean postOrderSearch(MyNode<E> myNode, E target){
            MyNode<E> current = myNode;

            if(current.children==null && current.getData().equals(target))
                return true;

            for (MyNode<E> m : current.children ){
                postOrderSearch(m, target);
            }
            if(current.getData().equals(target)){
                return true;
            }

            return false;
        }

        public void add(MyNode<E> p, MyNode<E> c) {
            if (root == null){
                root = p;
                root.children.addElement(c);
                c.setParent(root);
                return;
            }
            p.children.addElement(c);
            c.setParent(p);


        }

}
