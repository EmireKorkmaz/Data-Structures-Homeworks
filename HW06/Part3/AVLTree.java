

public class AVLTree<E extends Comparable<E>> extends BinarySearchTreeWithRotate<E> {

    private static class AVLNode<E> extends Node<E> {

        /** Constant to indicate left-heavy */
        public static final int LEFT_HEAVY = -1;
        /** Constant to indicate balanced */
        public static final int BALANCED = 0;
        /** Constant to indicate right-heavy */
        public static final int RIGHT_HEAVY = 1;
        /** balance is right subtree height - left subtree height */
        private int balance;

        public AVLNode(E item) {
            super(item);
            balance = BALANCED;
        }

        @Override
        public String toString() {
            return balance + ": " + super.toString();
        }
    }

    private boolean increase;
    private boolean decrease;

    @Override
    public boolean add(E item) {
        increase = false;
        root = add((AVLNode<E>) root, item);
        return addReturn;
    }

    private AVLNode<E> add(AVLNode<E> localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            increase = true;
            return new AVLNode<E>(item);
        }

        if (item.compareTo(localRoot.data) == 0) {
            // Item is already in the tree.
            increase = false;
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // item < data
            localRoot.left = add((AVLNode<E>) localRoot.left, item);

            if (increase) {
                decrementBalance((AVLNode<E>) localRoot);
                if (localRoot.balance < AVLNode.LEFT_HEAVY) {
                    increase = false;
                    return rebalanceLeft(localRoot);
                }
            }
            return localRoot; // Rebalance not needed.
        } else { // item > data
            localRoot.right = add((AVLNode<E>) localRoot.right, item);

            if (increase) {
                incrementBalance(localRoot);
                if (localRoot.balance > AVLNode.RIGHT_HEAVY) {
                    increase=false;
                    return rebalanceRight(localRoot);
                }
                else{
                    return localRoot;
                }
            }
            return localRoot;
        }
    }
    public AVLTree(){

    }
    public AVLTree(BinaryTree<E> b){
        if(checkBalance(b.root))
            System.out.print("AVL Tree");
        else
            System.out.println("Not an AVL Tree");
    }
    public E delete(E item) {
        root = delete((AVLNode<E>) root, item);
        return deleteRetVal;
    }
    private AVLNode<E> delete(AVLNode<E> node, E item) {
        if (node == null) {
            deleteRetVal = null;
            return node;
        }
        if (item.compareTo(node.data) == 0) {
            deleteRetVal = node.data;
            return node;
        }
        else if (item.compareTo(node.data) > 0) {
            node.right = delete((AVLNode<E>) node.right, item);
            return rebalanceLeft(node);
        }
        else {
            node.left = delete((AVLNode<E>) node.left, item);
            return  rebalanceRight( (AVLNode<E> ) node);

        }
    }
    private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot) {
        // Obtain reference to left child.
        AVLNode<E> leftChild = (AVLNode<E>) localRoot.left;
        // See whether left-right heavy.
        if (leftChild.balance > AVLNode.BALANCED) {
            // Obtain reference to left-right child.
            AVLNode<E> leftRightChild = (AVLNode<E>) leftChild.right;
            // Adjust the balances to be their new values after
            // the rotations are performed.
            if (leftRightChild.balance < AVLNode.BALANCED) {
                leftChild.balance = AVLNode.LEFT_HEAVY;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            } else if (leftRightChild.balance > AVLNode.BALANCED) {
                leftChild.balance = AVLNode.BALANCED;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.RIGHT_HEAVY;
            } else {
                leftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            // Perform left rotation.
            localRoot.left = rotateLeft(leftChild);
        } else { //Left-Left case.
            leftChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
        }
        // Now rotate the local root right.
        return (AVLNode<E>) rotateRight(localRoot);
    }
    private AVLNode<E> rebalanceRight(AVLNode<E> localRoot) {
        AVLNode<E> rightChild = (AVLNode<E> ) localRoot.right;
        if (rightChild.balance < AVLNode.BALANCED) {
            AVLNode<E> rightLeftChild = (AVLNode<E> ) rightChild.left;

            if (rightLeftChild.balance > AVLNode.BALANCED) {
                rightChild.balance = AVLNode.BALANCED;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.LEFT_HEAVY;
            }
            else if (rightLeftChild.balance < AVLNode.BALANCED) {
                rightChild.balance = AVLNode.RIGHT_HEAVY;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            else {
                rightChild.balance = AVLNode.BALANCED;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            increase = false;
            decrease = true;
            localRoot.right = rotateRight(rightChild);
            return (AVLNode<E> ) rotateLeft(localRoot);
        }
        else {
            rightChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
            increase = false;
            decrease = true;
            return (AVLNode<E> ) rotateLeft(localRoot);
        }
    }
    private void decrementBalance(AVLNode<E> node) {
        // Decrement the balance.
        node.balance--;
        if (node.balance == AVLNode.BALANCED) {
            // If now balanced, overall height has not increased.
            increase = false;
        }
    }
    private void incrementBalance(AVLNode<E> node) {
        node.balance++;
        if (node.balance>AVLNode.BALANCED) {
            increase=true;
            decrease=false;
        }
        else {
            increase= false;
            decrease = true;
        }
    }
    public Node<E> rightLeftRotate(Node<E> node){
        if(node==null)
            return null;
        node.right = rebalanceRight((AVLNode<E> ) node.right);
        return rebalanceLeft((AVLNode<E> ) node);
    }
    public Node<E> leftRightRotate(Node<E> node){
        if(node==null)
            return null;
        node.left = rebalanceLeft((AVLNode<E> ) node.left);
        return rebalanceRight((AVLNode<E> ) node);
    }
    public boolean checkBalance(BinaryTree.Node<E> node){
        if((findHeight(node.left)-findHeight(node.right)>1) || (findHeight(node.left)-findHeight(node.right)<-1))
            return false;
        return true;
    }
    private int findHeight(BinaryTree.Node<E> node) {
        if (node ==null) {
            return -1;
        }
        int left, right;

        left = findHeight(node.left);
        right = findHeight(node.right);

        if (left>right)
            return left + 1;
        else
            return right + 1;
    }
}
