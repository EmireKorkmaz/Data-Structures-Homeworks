public class RedBlackTree < E
        extends Comparable <E>>
        extends BinarySearchTreeWithRotate <E> {

    private boolean fixupRequired;
    public boolean add(E item) {
        if (root == null) {
            root = new RedBlackNode <E> (item);
            ( (RedBlackNode <E> ) root).isRed = false;
            return true;
        }
        else {
            root = add( (RedBlackNode <E> ) root, item);
            ( (RedBlackNode <E> ) root).isRed = false;
            return addReturn;
        }

    }

    public Node <E> add(RedBlackNode <E> localRoot, E item) {
        if (item.compareTo(localRoot.data) == 0) {
            addReturn = false;
            return localRoot;
        }

        else if (item.compareTo(localRoot.data) < 0) {
            if (localRoot.left == null) {
                localRoot.left = new RedBlackNode <E> (item);
                addReturn = true;
                return localRoot;
            }

            else {
                moveBlackDown(localRoot);
                localRoot.left = add( (RedBlackNode <E> ) localRoot.left, item);

                if ( ( (RedBlackNode <E> ) localRoot.left).isRed) {

                    if (localRoot.left.left != null
                            && ( (RedBlackNode <E> ) localRoot.left.left).isRed) {

                        ( (RedBlackNode <E> ) localRoot.left).isRed = false;
                        localRoot.isRed = true;
                        return rotateRight(localRoot);
                    }
                    else if (localRoot.left.right != null
                            && ( (RedBlackNode <E> ) localRoot.left.right).isRed) {

                        localRoot.left = rotateLeft(localRoot.left);
                        ( (RedBlackNode <E> ) localRoot.left).isRed = false;
                        localRoot.isRed = true;
                        return rotateRight(localRoot);
                    }
                }
                return localRoot;
            }
        }

        else {
            if (localRoot.right == null) {
                localRoot.right = new RedBlackNode <E> ( (E) item);
                addReturn = true;
                return localRoot;
            }
            else {
                moveBlackDown(localRoot);
                localRoot.right =
                        add( (RedBlackNode <E> ) localRoot.right, item);
                if ( ( (RedBlackNode) localRoot.right).isRed) {
                    if (localRoot.right.right != null
                            && ( (RedBlackNode) localRoot.right.right).isRed) {
                        ( (RedBlackNode) localRoot.right).isRed = false;
                        localRoot.isRed = true;
                        return rotateLeft(localRoot);
                    }
                    else if (localRoot.right.left != null
                            && ( (RedBlackNode) localRoot.right.left).isRed) {
                        localRoot.right = rotateRight(localRoot.right);
                        ( (RedBlackNode) localRoot.right).isRed = false;
                        localRoot.isRed = true;
                        return rotateLeft(localRoot);
                    }
                }
                return localRoot;
            }
        }
    }

    private void moveBlackDown(RedBlackNode <E> localRoot) {
        if (localRoot.left != null && localRoot.right != null && ( (RedBlackNode) localRoot.left).isRed && ( (RedBlackNode) localRoot.right).isRed) {
            ((RedBlackNode)localRoot.left).isRed = false;
            ((RedBlackNode)localRoot.right).isRed = false;
            localRoot.isRed = true;
        }
    }

    public int height(Node<E> node){
        int t1=0, t2=0;
        while(node != null){
            t1++;
            node=node.left;
        }
        while(node != null){
            t2++;
            node=node.right;
        }
        if(t1>t2)
            return t1;
        else
            return t2;
    }
}
