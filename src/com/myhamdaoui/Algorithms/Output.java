package com.myhamdaoui.Algorithms;

public class Output {
	public static String str = "";
	
    public static void println(String str) {
    	Output.str += str + "\n";
    }
    public static void printlnTree(String str) {
    	Output.str +=str + "\n";
    }

    public static void print(String str) {
    	Output.str += str;
    }

    public static void printTable(double[] input) {
        str += "[";
        for(int i = 0; i < input.length; i++) {
            if(i != input.length - 1) {
                str += input[i] + "\t";
            } else {
                str += input[i];
            }
        }
        str += "]\n";
    }
    
    public static void printMatrice(double[][] input) {
    	int rows = input.length;
    	int columns = input[0].length;
    	
    	for(int i = 0; i < rows; i++) {
    		for(int j = 0; j < columns; j++) {
    			str += input[i][j] + "\t";
    		}
    		str += "\n";
    	}
}}
