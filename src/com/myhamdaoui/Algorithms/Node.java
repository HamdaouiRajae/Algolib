package com.myhamdaoui.Algorithms;

public class Node {//le noeud d'un ABR
	double key; 
    Node left, right; 

    public Node(double item) { 
        key = item; 
        left = right = null; 
    } 
    public String toString()
    {
    	return ""+key+"";
    }

}
