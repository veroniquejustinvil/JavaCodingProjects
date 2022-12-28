/***Veronique Justinvil 
 * The use of a Hash map to create a dictionary stored from a file and evaluate the function of searching from each 
 * data structure 
 * 11/17/2022 
 */ 
public class BST<E extends Comparable<E>> {
    private TreeNode root; 
    private int size;  

    private class TreeNode{ 
        E value; 
        TreeNode left; 
        TreeNode right;  

        TreeNode(E val){ 
            value = val;  
            left = right = null; 
        }
    } 
    BST(){ 
        root = null; 
        size = 0; 
    } 
    public int size(){ 
        return size;
    } 
    public boolean isEmpty(){ 
        return (size == 0);
    }  
    public void clear(){ 
        root = null; 
        size = 0; 
    }    

    //search method 
    public int contains(E item){ 
        TreeNode node = root;  
        int iterations = 0;
        while(node != null){  
            iterations++; 
            if(item.compareTo(node.value) < 0){ 
                node = node.left; 
            } else if(item.compareTo(node.value) > 0 ){ 
                node = node.right;
            } else{ 
                return iterations;
            }
        } 
        return iterations;
    }  
    //Method  add()
    public int add(E item){  
        int iterations = 0;
        if(root == null){ //first node to be inserted
            root = new TreeNode(item);
        }else{ 
            TreeNode parent, node;
            parent = null; node = root; 
            while(node != null){  //looking for a leaf node 
                iterations++;
                parent = node;  
                    if(item.compareTo(node.value) < 0){ 
                        node = node.left; 
                    } else if(item.compareTo(node.value) > 0){ 
                        node = node.right; 
                    }else{ 
                        return iterations; //duplicates are not allowed
                    }
            } 
            if(item.compareTo(parent.value) < 0){ 
                parent.left = new TreeNode(item);
            }else{ 
                parent.right = new TreeNode(item); 
            }
        } 
        size++;  
        return iterations; 
    } 
    // Method remove()
    public int remove(E item) {
        TreeNode parent, node; 
        int iterations = 0;
        parent = null; 
         node = root;
        // Find item first
        while (node != null) { 
            iterations++; 
            if (item.compareTo(node.value) < 0) {
                parent = node;
                node = node.left;
                }
            else if (item.compareTo(node.value) > 0) {
                parent = node;
                node = node.right;
                    }
            else
                break; // item found
        } 
        if (node == null) // item not in the tree
             return iterations; 

        // Case 1: node has no children
        if(node.left == null && node.right == null){
            if(parent == null){ // delete root
            root = null;
            }
            else{
            changeChild(parent, node, null);
            }
        }else if(node.left == null){
                if (parent == null){ // delete root
                root = node.right;
                }
                else
                changeChild(parent, node, node.right);
                }
            // case 2: one left child
        else if(node.right == null){
            if (parent == null){ // delete root
            root = node.left;
                }
            else
            changeChild(parent, node, node.left);
        }else {
                TreeNode rightMostParent = node;
                TreeNode rightMost = node.left;
                // go right on the left subtree
            while (rightMost.right != null) {
                rightMostParent = rightMost;
                rightMost = rightMost.right;
            }
                // copy the value of rigthMost to node
                node.value = rightMost.value;
                //delete rigthMost
                changeChild(rightMostParent, rightMost,
                rightMost.left);
                }
                size--;
                return iterations; 
        } 
    private void changeChild(TreeNode parent,TreeNode node, TreeNode newChild){
        if(parent.left == node)
            parent.left = newChild;
        else
            parent.right = newChild;
    } 
    // Recursive method inorder()
    public void inorder() {
            inorder(root);
        }
    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    } 
    public void preorder() {
        preorder(root);
    }
    private void preorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
            }
    }  
    // Recursive method postorder()
    public void postorder() {
         postorder(root);
    }
    private void postorder(TreeNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " ");
        }
    }  
    public int height(){  
        //recursive: checking down the line
        return height(root); //top node 
    }  
    public int height(TreeNode node){ //complexity of the height = O(n) << goes through each element 
        if(node != null){ 
            return 1+Math.max(height(node.left), height(node.right)); //the height of the left & right subtree 
        } else { 
            return 0;
        }
    } 
    public boolean isBalanced(){ 
        //recursive: checking down the line 
        return isBalanced(root);
    }  
    //time complexity O(n^2) 
    //checked the whole height & then the height of its children so n^2
    public boolean isBalanced(TreeNode node){  
        if(node == null){ 
            return true; //no tree so is balanced
        } else{ 
            int heightLeft = height(node.left); 
            int heightRight = height(node.right); 
            int difference = Math.abs(heightLeft - heightRight); 
            if(difference > 1){ 
                return false; //not balanced
            }else{ 
                return isBalanced(node.left) && isBalanced(node.right);
            }
        }

    }


}


