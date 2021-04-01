package com.myhamdaoui.Algorithms;

public class BinarySearchTree {
	Node root; 
	  
    // Constructor 
    BinarySearchTree() {  
        root = null;  
    } 
    BinarySearchTree(Node n) {  
        root = n;  
    } 
    /*
     *   insertion
     */
    // This method mainly calls insertRec() 
    void insert(double key) { 
       root = insertRec(root, key); 
    } 
      
    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, double key) { 
  
        /* If the tree is empty, return a new node */
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
  
        /* Otherwise, recur down the tree */
        if (key < root.key) 
            root.left = insertRec(root.left, key); 
        else if (key > root.key) 
            root.right = insertRec(root.right, key); 
  
        /* return the (unchanged) node pointer */
        return root; 
    } 
    /*
     *   parcourir et afficher
     */
    // This method mainly calls InorderRec() 
    void inorder()  {
       s="";
       inorderRec(root); 
    } 
    private static String s;
    public static String getS() {
		return s;
	}
	// A utility function to do inorder traversal of BST 
    void inorderRec(Node root) { 
        if (root != null) { 
            inorderRec(root.left); 
            System.out.println(root.key);
            s+=root.toString()+"\n";
            inorderRec(root.right); 
        } 
    } 
    /*
     *   suppression
     */
 // This method mainly calls deleteRec() 
    void deleteKey(double key) 
    { 
        root = deleteRec(root, key); 
    } 
  
    /* A recursive function to insert a new key in BST */
    Node deleteRec(Node root, double key) 
    { 
        /* Base Case: If the tree is empty */
        if (root == null)  return root; 
  
        /* Otherwise, recur down the tree */
        if (key < root.key) 
            root.left = deleteRec(root.left, key); 
        else if (key > root.key) 
            root.right = deleteRec(root.right, key); 
  
        // if key is same as root's key, then This is the node 
        // to be deleted 
        else
        { 
            // node with only one child or no child 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            root.key = minValue(root.right); 
  
            // Delete the inorder successor 
            root.right = deleteRec(root.right, root.key); 
        } 
  
        return root; 
    } 
  
    double minValue(Node root) 
    { 
        double minv = root.key; 
        while (root.left != null) 
        { 
            minv = root.left.key; 
            root = root.left; 
        } 
        return minv; 
    } 
    /*
     *   validation
     */
    boolean isBST()  { 
        return isBSTUtil(root, Integer.MIN_VALUE,Integer.MAX_VALUE); 
    } 
  
    /* Returns true if the given tree is a BST and its 
      values are >= min and <= max. */
    boolean isBSTUtil(Node node, double min, double max) 
    { 
        /* an empty tree is BST */
        if (node == null) 
            return true; 
  
        /* false if this node violates the min/max constraints */
        if (node.key < min || node.key > max) 
            return false; 
  
        /* otherwise check the subtrees recursively 
        tightening the min/max constraints */
        // Allow only distinct values 
        return (isBSTUtil(node.left, min, node.key-1) && isBSTUtil(node.right, node.key+1, max)); 
    } 
}
