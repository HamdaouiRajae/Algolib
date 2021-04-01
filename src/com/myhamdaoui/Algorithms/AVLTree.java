package com.myhamdaoui.Algorithms;

public class AVLTree {
	Node1 root1;  
	public AVLTree(Node1 root1)
	{
		this.root1=root1;
	}
	AVLTree() 
	{  
        root1 = null;  
    } 
    // A utility function to get height of the tree  
    int height(Node1 N)  
    {  
        if (N == null)  
            return 0;  
        return N.height1;  
    }  
  
    // A utility function to get maximum of two integers  
    int max(int a, int b)  
    {  
        return (a > b) ? a : b;  
    }  
  
    // A utility function to right rotate subtree rooted with y  
    // See the diagram given above.  
    Node1 rightRotate(Node1 y)  
    {  
        Node1 x = y.left1;  
        Node1 T2 = x.right1;  
  
        // Perform rotation  
        x.right1 = y;  
        y.left1 = T2;  
  
        // Update heights  
        y.height1 = max(height(y.left1), height(y.right1)) + 1;  
        x.height1= max(height(x.left1), height(x.right1)) + 1;  
  
        // Return new root  
        return x;  
    }  
  
    // A utility function to left rotate subtree rooted with x  
    // See the diagram given above.  
    Node1 leftRotate(Node1 x)  
    {  
        Node1 y = x.right1;  
        Node1 T2 = y.left1;  
  
        // Perform rotation  
        y.left1 = x;  
        x.right1 = T2;  
  
        // Update heights  
        x.height1 = max(height(x.left1), height(x.right1)) + 1;  
        y.height1 = max(height(y.left1), height(y.right1)) + 1;  
  
        // Return new root  
        return y;  
    }  
  
    // Get Balance factor of node N  
    int getBalance(Node1 N)  
    {  
        if (N == null)  
            return 0;  
        return height(N.left1) - height(N.right1);  
    }  
  
    Node1 insert1(Node1 node,double key1)  
    {  
        /* 1. Perform the normal BST rotation */
        if (node== null)  
            return (new Node1(key1));  
  
        if (key1 < node.key1)  
            node.left1 = insert1(node.left1, key1);  
        else if (key1 > node.key1)  
            node.right1 = insert1(node.right1, key1);  
        else // Equal keys not allowed  
            return node;  
  
        /* 2. Update height of this ancestor node */
        node.height1 = 1 + max(height(node.left1),  
                            height(node.right1));  
  
        /* 3. Get the balance factor of this ancestor  
        node to check whether this node became  
        Wunbalanced */
        int balance = getBalance(node);  
  
        // If this node becomes unbalanced, then  
        // there are 4 cases Left Left Case  
        if (balance > 1 && key1 < node.left1.key1)  
            return rightRotate(node);  
  
        // Right Right Case  
        if (balance < -1 && key1 > node.right1.key1)  
            return leftRotate(node);  
  
        // Left Right Case  
        if (balance > 1 && key1 > node.left1.key1)  
        {  
            node.left1 = leftRotate(node.left1);  
            return rightRotate(node);  
        }  
  
        // Right Left Case  
        if (balance < -1 && key1 < node.right1.key1)  
        {  
            node.right1 = rightRotate(node.right1);  
            return leftRotate(node);  
        }  
  
        /* return the (unchanged) node pointer */
        return node;  
    }  
  
    /* Given a non-empty binary search tree, return the  
    node with minimum key value found in that tree.  
    Note that the entire tree does not need to be  
    searched. */
    Node1 minValueNode(Node1 node)  
    {  
        Node1 current = node;  
  
        /* loop down to find the leftmost leaf */
        while (current.left1 != null)  
        current = current.left1;  
  
        return current;  
    }  
  
    Node1 deleteNode(Node1 root, double key1)  
    {  
        // STEP 1: PERFORM STANDARD BST DELETE  
        if (root == null)  
            return root;  
  
        // If the key to be deleted is smaller than  
        // the root's key, then it lies in left subtree  
        if (key1 < root.key1)  
            root.left1 = deleteNode(root.left1, key1);  
  
        // If the key to be deleted is greater than the  
        // root's key, then it lies in right subtree  
        else if (key1 > root.key1)  
            root.right1 = deleteNode(root.right1, key1);  
  
        // if key is same as root's key, then this is the node  
        // to be deleted  
        else
        {  
  
            // node with only one child or no child  
            if ((root.left1 == null) || (root.right1 == null))  
            {  
                Node1 temp = null;  
                if (temp == root.left1)  
                    temp = root.right1;  
                else
                    temp = root.left1;  
  
                // No child case  
                if (temp == null)  
                {  
                    temp = root;  
                    root = null;  
                }  
                else // One child case  
                    root = temp; // Copy the contents of  
                                // the non-empty child  
            }  
            else
            {  
  
                // node with two children: Get the inorder  
                // successor (smallest in the right subtree)  
                Node1 temp = minValueNode(root.right1);  
  
                // Copy the inorder successor's data to this node  
                root.key1 = temp.key1;  
  
                // Delete the inorder successor  
                root.right1 = deleteNode(root.right1, temp.key1);  
            }  
        }  
  
        // If the tree had only one node then return  
        if (root == null)  
            return root;  
  
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE  
        root.height1 = max(height(root.left1), height(root.right1)) + 1;  
  
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether  
        // this node became unbalanced)  
        int balance = getBalance(root);  
  
        // If this node becomes unbalanced, then there are 4 cases  
        // Left Left Case  
        if (balance > 1 && getBalance(root.left1) >= 0)  
            return rightRotate(root);  
  
        // Left Right Case  
        if (balance > 1 && getBalance(root.left1) < 0)  
        {  
            root.left1 = leftRotate(root.left1);  
            return rightRotate(root);  
        }  
  
        // Right Right Case  
        if (balance < -1 && getBalance(root.right1) <= 0)  
            return leftRotate(root);  
  
        // Right Left Case  
        if (balance < -1 && getBalance(root.right1) > 0)  
        {  
            root.right1 = rightRotate(root.right1);  
            return leftRotate(root);  
        }  
  
        return root;  
    }  
  
   
 // This method mainly calls InorderRec() 
    void inorder1()  {
       s1="";
       inorderRec1(root1); 
    } 
    private static String s1;
    public static String getS1() {
		return s1;
	}
	// A utility function to do inorder traversal of BST 
    void inorderRec1(Node1 root) { 
        if (root != null) { 
            inorderRec1(root.left1); 
            System.out.println(root.key1);
            s1+=root.toString()+"\n";
            inorderRec1(root.right1); 
        } 
    } 

    boolean isBalanced(Node1 node) 
    { 
        int lh; /* for height of left subtree */
  
        int rh; /* for height of right subtree */
  
        /* If tree is empty then return true */
        if (node == null) 
            return true; 
  
        /* Get the height of left and right sub trees */
        lh = height(node.left1); 
        rh = height(node.right1); 
  
        if (Math.abs(lh - rh) <= 1
            && isBalanced(node.left1) 
            && isBalanced(node.right1)) 
            return true; 
  
        /* If we reach here then tree is not height-balanced */
        return false; 
    } 
  
    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
    /*  The function Compute the "height" of a tree. Height is the 
        number of nodes along the longest path from the root node 
        down to the farthest leaf node.*/
    int height(Node node) 
    { 
        /* base case tree is empty */
        if (node == null) 
            return 0; 
  
        /* If tree is not empty then height = 1 + max of left 
         height and right heights */
        return 1 + Math.max(height(node.left), height(node.right)); 
    } 
    boolean isBST()  { 
        return isBSTUtil(root1, Integer.MIN_VALUE,Integer.MAX_VALUE); 
    } 
  
    /* Returns true if the given tree is a BST and its 
      values are >= min and <= max. */
    boolean isBSTUtil(Node1 node, double min, double max) 
    { 
        /* an empty tree is BST */
        if (node == null) 
            return true; 
  
        /* false if this node violates the min/max constraints */
        if (node.key1 < min || node.key1 > max) 
            return false; 
  
        /* otherwise check the subtrees recursively 
        tightening the min/max constraints */
        // Allow only distinct values 
        return (isBSTUtil(node.left1, min, node.key1-1) && isBSTUtil(node.right1, node.key1+1, max)); 
    } 
}
