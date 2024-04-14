/*
 *
 *  BinarySearchTree.java
 *
 */
import java.util.Iterator;
import java.util.Vector;


public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {
    private Vector<E> vector;
    public Iterator < E > iterator() {
        vector = new Vector < E > ();
        traverse(root);
        return vector.iterator();
    }
    private void traverse(Node < E > curr) {
        if (curr != null) {
            traverse(curr.left);
            vector.add(curr.data);
            traverse(curr.right);
        }
    }
       



public boolean search(E data){
    return search (root ,data);
}

private boolean search(Node<E> curr, E data){

    if (curr ==null){
        return false;
    }

    if(data.compareTo(curr.data)>0){
        return search(curr.right, data);
    }
    else if (data.compareTo(curr.data)<0){
        return search(curr.left, data);
    }

    
    return true; 
    /*
    if curr is null, return false;

    if curr is not null;
        if data and curr data are equal, found what you are looking for, and done. 

    else
        data can be in right or left search tree
        check left sub-tree- search, recursively, left sub-tree if data<curr.data
        check right sub-tree search, recursively, right sub tree if data > curr.data
     */
}


public void insert(E data){
    Node <E> temp = new Node <E>(data);
    root = insert(root, temp);
}

    private Node<E> insert(Node<E> curr, Node<E> node){ //only allowed to access curr and node. 
        //node == temp;

        
        if(curr == null){
            curr = node;
            
        }
        else if (node.data.compareTo(curr.data)>0){
            curr.right = insert(curr.right,node);
            
        }
        else{
            curr.left = insert(curr.left,node);
            
        }
        return curr;

        
        
        
        
        /*
        * if curr is null, return node //check to see if it is empty or not. 
        * if curr if not null, insert method into left or right sub tree, depending on if data is greater than or less than  node. data. 
        * no more then 10 lines of code. 
        * 
        * always insert as brand new leaf node. 
        */
    }


public void remove(E data){
    Node <E> temp = new Node<E>(data);
    root = remove(root,temp);

}

private Node <E> remove(Node<E> curr, Node<E> node){
   


    if (curr == null){
        return null;
    }
    if(curr.data.compareTo(node.data) == 0){
        if (curr.left == null && curr.right == null){
            curr = null;
            
        }

        else if (curr.left == null){
            curr = curr.right;
        }
        else if (curr.right == null){
            curr = curr.left;
        }
        else{
            Node<E> iop = findIOP(curr); //in oreder precedessor.
            E temp = iop.data;
            iop.data = curr.data;
            curr.data = temp; //do this to make iop the curr, and thus the root. however, we are still trying to find the same iop(which is the root) value.

            curr.left = remove(curr.left,node); // still tryna look for node and get rid of it. 
        }


    }

    else if(node.data.compareTo(curr.data)>0){
        curr.right = remove(curr.right, node);
    }
    else{
        curr.left = remove(curr.left, node);
    }

    return curr;

    }

    private Node<E>findIOP( Node < E > curr) {
        curr = curr.left;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }
    /*case 1:

    if the node you want to remove has no children, take node above, and set it equal to null

    case 2: removing node with one child:
        set link between grandparent node to child node. 

     - 


     case 3: removing root/ removing node with two children, 
         - find in oreder predecessor, and swap it with node( make one method);
         - remove 50 from left sub tree. 
     * 
     */

    public int height() {
        return height(root);
    }
    private int height(Node < E > curr) {
        if (curr == null) {
            return 0;
        }
        int left = height(curr.left) + 1;
        int right = height(curr.right) + 1;
        return left > right ? left : right;
    }
}






