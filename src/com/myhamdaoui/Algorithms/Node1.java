package com.myhamdaoui.Algorithms;

public class Node1 {//le noeud d'un AVL
	double key1;
	int height1;  
    Node1 left1, right1;  
  
    Node1(double d)  
    {  
        key1 = d;  
        height1 = 1;
        left1 = right1 = null; 
    }
    public String toString()
    {
    	return ""+key1+"";
    }
}
