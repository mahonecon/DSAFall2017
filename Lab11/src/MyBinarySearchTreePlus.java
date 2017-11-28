/*
 * Purpose: Data Structure and Algorithms Lab 11
 * Status: Complete and thoroughly tested
 * Last update: 11/27/17
 * @author: Conor J. Mahoney
 */
public class MyBinarySearchTreePlus<T extends KeyedItem<KT> ,KT extends Comparable<? super KT>> extends MyBinarySearchTree<T,KT> implements BSTPInterface<T,KT> {

    public int getHeight(TreeNode root) {
        int height = 0;
        TreeNode curr = root;
        if(curr == null) {
            height = 0;
        } else {
            height = (1 + Math.max(getHeight(curr.getLeftChild()), getHeight(curr.getRightChild())));
        }
        return height;
    }

    public int getSize(TreeNode root) {
        int size = 0;
        TreeNode curr = root;
        if(curr == null) {
            size = 0;
        } else {
            size = (1 + getSize(curr.getLeftChild()) + getSize(curr.getRightChild()));
        }
        return size;
    }

    public String toStringInorder(TreeNode root) {
        String str = "";
        TreeNode curr = root;
        if(curr.getLeftChild() != null) {
            str += toStringInorder(curr.getLeftChild());
        } 
        if(curr.getRightChild() != null) {
            str += toStringInorder(curr.getRightChild());
        }
        str += curr.getItem();
        return str;
    }

    public String toStringPreorder(TreeNode root) {
        return null;
    }

    public String toStringPostorder(TreeNode root) {
        return null;
    }

    public MyBinarySearchTreePlus<T, KT> getCopyOfTree() {
        return null;
    }
}