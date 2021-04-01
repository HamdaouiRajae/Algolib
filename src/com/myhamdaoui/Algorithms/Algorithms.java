package com.myhamdaoui.Algorithms;
import com.myhamdaoui.Algorithms.Output;

public class Algorithms {

    /*
     * == Algorithme de Tri 1;tri par bulles
     */
    public static void tri1Iteratif(double[] input) {
    	Output.println("Tri a bulle Iteratif");
        int iteration = 1;
        int taille = input.length;
        double tmp = 0;
        for(int i=0; i < taille; i++)
        {
            for(int j=1; j < (taille-i); j++)
            {
                if(input[j-1] > input[j])
                {
                    //echange des elements
                    tmp = input[j-1];
                    input[j-1] = input[j];
                    input[j] = tmp;
                }
                Output.println("Iteration: " + iteration++);
                Output.printTable(input);
                Output.println("");
            }
        }
    }
    public static void tri1Recursive(double[] input) 
    { 
    	Output.println("Tri a bulle Récursive");
    	bubblerecursion(input,input.length);
    } 

    /*
     * == Algorithme de Tri 2:tri par fusion
     */
    public static void tri2Iteratif(double[] input) {
    	Output.println("le tri par fusion itératif ");
    	mergeSortiteratif(input,input.length); 	
    }

    public static void tri2Recursive(double[] input) {
    	Output.println("Tri par fusion récursif ");
    	mergesortrecursif(input,0,input.length-1);

    }
    
    /*
     * == Algorithme de Tri 3:tri rapide
     */
    public static void tri3Iteratif(double[] input) {
    	Output.println(" le tri rapide itératif ");
    	QuickSortIteratif(input,0,input.length-1);

    }

    public static void tri3Recursive(double[] input) {
    	Output.println(" le tri rapide récursif ");
    	quiqsortrecursif(input,0,input.length-1);
    	
    }
    
    /*
     * == Algorithme de Tri 4:tri par sélection
     */
    public static void tri4Iteratif(double[] input) {
    	Output.println(" le tri par sélection itératif ");
    	selectionSortIter(input);
    }

    public static void tri4Recursive(double[] input) {
    	Output.println(" le tri par sélection récursif ");
    	SelectionSortrec(input,input.length,0);
    }
    
    /*
     * == Algorithme de Tri 5:par insertion
     */
    public static void tri5Iteratif(double[] input) {
    	Output.println(" le tri par insertion itératif ");
    	insertionSortIter(input);
    }

    public static void tri5Recursive(double[] input) {
    	Output.println(" le tri par insertion récursif ");
    	insertionSortrec(input,1,input.length-1);   	
    }
    
    /*
     * == Algorithme pour ABR:construction d'un ABR
     */
    private static BinarySearchTree T;//pour accumuler dedans le nouveau noeud inséré
    private static Node n;//l'arbre qu'on a créé est défini par sa racine STATIC
    /*
     * l'affichege de l'arbre sera fait en utilisant la méthode INORDER(iles clés sont des doubles)
     */

    public static void tri6Iteratif(double[] input) {
    	Output.println("ABR :remarque {en cliquant sur itératif vous allez agir sur des ABRs et en cliquant sur récursive vous allez agir sur des AVLs}");
    	Output.println("");
    	Output.println("vous devez donner un paramètre double( input[0]="+input[0]+") qui va être la clé de la racine construisant l'arbre ");
    	n=new Node(input[0]);
    	T=new BinarySearchTree(n);
    	Output.println("");
    	Output.println("l'arbre après construction(affichage INORDER ):");
    	T.inorder();
    	Output.printlnTree(T.getS());//s est une chaine de caractère qui stocke les clés de notre arbre suivant la méthode INORDER
    }
    /*
     * == Algorithme pour AVL:construction d'un AVL
     */
    private static AVLTree T1;//pour accumuler dedans le nouveau noeud inséré
    private static Node1 n1;//l'arbre qu'on a créé est défini par sa racine STATIC
    public static void tri6Recursive(double[] input) {
    	Output.println("AVL :remarque {en cliquant sur itératif vous allez agir sur des ABRs et en cliquant sur récursive vous allez agir sur des AVLs}");
    	Output.println("");
    	Output.println("vous devez donner un paramètre double( input[0]="+input[0]+") qui va être la clé de la racine construisant l'arbre ");
    	n1=new Node1(input[0]);
    	T1=new AVLTree(n1);
    	Output.println("");
    	Output.println("l'arbre après construction(affichage INORDER ):");
    	T1.inorder1();
    	Output.printlnTree(T1.getS1());//s est une chaine de caractère qui stocke les clés de notre arbre suivant la méthode INORDER
    }
    
    /*
     * == Algorithme pour ABR:insertion dans un ABR
     */
    /*
     * pour insérer il faut en premier lieu construire l'arbre
     */
    public static void tri7Iteratif(double[] input) {
    	Output.println("ABR");
    	Output.println("pour pouvoir insérer la clé (input[0]="+input[0]+")votre arbre doit être déja construit (le choix avant) ");
    	Output.println("");
    	Output.println("l'arbre avant insertion(affichage INORDER ):");
    	T.inorder();
    	Output.printlnTree(T.getS());
    	Output.println("");
    	T.insert(input[0]);	//l arbre T est static , contient  déja la racine (l'étapde de construction)
    	Output.println("l'arbre après insertion(affichage INORDER ) :");
    	T.inorder();
    	Output.printlnTree(T.getS());
    }
    /*
     * == Algorithme pour AVL:insertion dans un AVL
     */
    public static void tri7Recursive(double[] input) {
    	Output.println("AVL");
    	Output.println("pour pouvoir insérer la clé (input[0]="+input[0]+")votre arbre doit être déja construit (le choix avant) ");
    	Output.println("");
    	Output.println("l'arbre avant insertion(affichage INORDER ):");
    	T1.inorder1();
    	Output.printlnTree(T1.getS1());
    	Output.println("");
    	T1.root1=T1.insert1(T1.root1,input[0]);	//l arbre T est static , contient  déja la racine (l'étapde de construction)
    	Output.println("l'arbre après insertion(affichage INORDER ) :");
    	T1.inorder1();
    	Output.printlnTree(T1.getS1());
    	

    }
    
    /*
     * == Algorithme pour ABR:suppression dans un ABR
     */
    public static void tri8Iteratif(double[] input) {
    	Output.println("ABR");
    	Output.println("la clé du noeud à être supprimé est ( input[0]="+input[0]+" )");
    	Output.println("");
    	Output.println("l'arbre avant la suppression(affichage INORDER ) :");
    	T.inorder();
    	Output.printlnTree(T.getS());
    	Output.println("");
    	T.deleteKey(input[0]);	//l arbre T est static , contient  déja  (l'étapde de construction et de suppression)
    	Output.println("l'arbre après suppression(affichage INORDER ) :");
    	T.inorder();
    	Output.printlnTree(T.getS());
    }
     /*
     * == Algorithme pour AVL:suppression dans un AVL
     */
    public static void tri8Recursive(double[] input) {
    	Output.println("AVL");
    	Output.println("la clé du noeud à être supprimé est ( input[0]="+input[0]+" )");
    	Output.println("");
    	Output.println("l'arbre avant la suppression(affichage INORDER ) :");
    	T1.inorder1();
    	Output.printlnTree(T1.getS1());
    	Output.println("");
    	T1.root1=T1.deleteNode(T1.root1,input[0]);	//l arbre T1 est static , contient  déja  (l'étapde de construction et de suppression)
    	Output.println("l'arbre après suppression(affichage INORDER ) :");
    	T1.inorder1();
    	Output.printlnTree(T1.getS1());

    }
    
    /*
     * == Algorithme pour ABR :validation d'un ABR
     */
    public static void tri9Iteratif(double[] input) {
    	Output.println("ABR :il faut tapper n'importe quel réel pour visualiser le résultat ");
    	Output.println("");
    	Output.println("est ce que l'arbre qu'on a construit est un arbre binaire de recherche ?  ");
    	Output.println("");
    	if(T.isBST())
    	{
    		Output.println("Oui ,l'arbre construit est un ABR");
    	}
    	else
    		Output.println("Non ,l'arbre construit n'est pas un ABR");
    }
     /*
     * == Algorithme pour AVL:validation d'un ABR
     */
    public static void tri9Recursive(double[] input) {
    	Output.println("AVL");
    	Output.println("est ce que l'arbre qu'on a construit est un arbre binaire de recherche ?  ");
        if (T1.isBST() && T1.isBalanced(T1.root1))
        {
        	System.out.println("l'arbre construit est un AVL");
        	Output.println("Oui ,l'arbre construit est un AVL");
        }
            

        else
        {
        	System.out.println("l'arbre construit n'est pas un AVL");
        	Output.println("Non ,l'arbre construit n'est pas un AVL");
        }      
    }
    
     /*
     * == Algorithme pour ABR
     */
    public static void tri10Iteratif(double[] input) {

    }
     /*
     * == Algorithme pour AVL:rotation d'un ABR
     */
    public static void tri10Recursive(double[] input) {
    	Output.println("AVL");
    	Output.println("");
    	Output.println("les rotations sont implicitement appliquer dans les algoritmes d'insertion !");
    }
    
    /*
     * == Tour Hanoi
     */
    public static void tourHanoi(int n, String dep, String temp, String arr) {
    	Output.println(" tours de hanoi ");
    	Output.println("Nombre de disques: " + n);
    	Output.println("la tour de départ :"+dep);
    	Output.println("la tour auxiliaire :"+temp);
    	Output.println("la tour de destination :"+arr);
    	towerOfHanoi(n,dep,arr,temp);
    }
    
    /*
     * == Multiplication Matrices 1:par la méthode de strassen(les matrices doivent être carrées de dimensions en Puissance de 2)
     */
    
    public static void mat1(double[][] mat1, double[][] mat2) {
    	Output.println("Matrice 1");
    	Output.printMatrice(mat1);
    	Output.println("");
    	Output.println("Matrice 2");
    	Output.printMatrice(mat2);
    	Output.println("");
    	Output.println("la multiplication des deux matrices donne :");
    	//int row = mat1.length;
    	//int col = mat2[0].length;
    	double[][] mat=multiplyStrassen(mat1,mat2);
    	Output.printMatrice(mat);
    }
    
    /*
     * == Multiplication Matrices 2:multiplication simple(les matrices doivent être carrées )
     */
    
    public static void mat2(double[][] mat1, double[][] mat2) {
    	Output.println("Matrice 1");
    	Output.printMatrice(mat1);
    	Output.println("");
    	Output.println("Matrice 2");
    	Output.printMatrice(mat2);
    	Output.println("");
    	Output.println("la multiplication des deux matrices donne :");
    	int row = mat1.length;
    	int col = mat1[0].length;
    	double[][] res=new double[row][col];
    	multiply(mat1,mat2,res);
    	Output.printMatrice(res);
    }
    
    /*
     * You can create your own methods and use them
     * but they have to be "static"
     */
    
    public static void swap(double arr[], int i, int j)
    {
    	double temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }
    //bubble sort recursive
    private static int itbubblerecursion;
    public static void bubblerecursion(double[] input,int taille)
    {
    	itbubblerecursion=1;
    		for (int i = 0;i<taille-1;i++) {
    			if (input[i]>input[i+1]) {
    				swap(input, i, i + 1);
    			}
    			Output.println("iteration :"+ itbubblerecursion++);
    	        Output.printTable(input);
    	        Output.println(" ");
    		}
    		if (taille-1>1) {
    			bubblerecursion(input, taille-1);
    		}
    		}
    //merge sort
    //iterative
    public static void mergeSortiteratif(double arr[], int n) 
    {          
        // For current size of subarrays to 
        // be merged curr_size varies from  
        // 1 to n/2 
        int curr_size;  
                      
        // For picking starting index of  
        // left subarray to be merged 
        int left_start; 
                          
          
        // Merge subarrays in bottom up  
        // manner. First merge subarrays  
        // of size 1 to create sorted  
        // subarrays of size 2, then merge 
        // subarrays of size 2 to create  
        // sorted subarrays of size 4, and 
        // so on. 
        for (curr_size = 1; curr_size <= n-1;  
                      curr_size = 2*curr_size) 
        { 
              
            // Pick starting point of different 
            // subarrays of current size 
            for (left_start = 0; left_start < n-1; 
                        left_start += 2*curr_size) 
            { 
                // Find ending point of left  
                // subarray. mid+1 is starting  
                // point of right 
                int mid = Math.min(left_start + curr_size - 1, n-1); 
          
                int right_end = Math.min(left_start  
                             + 2*curr_size - 1, n-1); 
          
                // Merge Subarrays arr[left_start...mid] 
                // & arr[mid+1...right_end] 
                merge1(arr, left_start, mid, right_end);
                
            } 
        } 
    } 
      
    /* Function to merge the two halves arr[l..m] and 
    arr[m+1..r] of array arr[] */
    public static void merge1(double arr[], int l, int m, int r) 
    { 
        int i, j, k; 
        int n1 = m - l + 1; 
        int n2 = r - m; 
      
        /* create temp arrays */
        double L[] = new double[n1]; 
        double R[] = new double[n2]; 
      
        /* Copy data to temp arrays L[] 
        and R[] */
        for (i = 0; i < n1; i++) 
            L[i] = arr[l+i]; 
        Output.println("le 1er tableau :");
        Output.printTable(L);
        Output.println("");
        for (j =0;j<n2;j++) 
            R[j]=arr[m+1+j]; 
        Output.println("le 2éme tableau :");
        Output.printTable(R);
        Output.println("");
      
        /* Merge the temp arrays back into 
        arr[l..r]*/
        i = 0; 
        j = 0; 
        k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
      
        /* Copy the remaining elements of  
        L[], if there are any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
      
        /* Copy the remaining elements of 
        R[], if there are any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
        Output.println("le tableau après la fusion :");
        Output.printTable(arr);
        Output.println("");
    } 
    //recursif
    public static void merge2(double arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        double L[] = new double [n1]; 
        double R[] = new double [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; i++) 
        {
        	L[i] = arr[l+i];
        }
            
        Output.println("le 1er tableau :");
        Output.printTable(L);
        Output.println("");
        for (int j=0; j<n2; j++) 
        {
        	R[j] = arr[m+1+j]; 
        }   
        Output.println("le 2éme tableau :");
        Output.printTable(R);
        Output.println("");

        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++;
        } 
        Output.println("le tableau après le fusion :");
        Output.printTable(arr);
        Output.println("");
    } 
  
    public static void mergesortrecursif(double arr[],int l,int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m =(int)(l+r)/2; 
  
            // Sort first and second halves 
            mergesortrecursif(arr, l,m); 
            mergesortrecursif(arr,m+1,r); 
  
            // Merge the sorted halves 
            merge2(arr, l, m, r);
        } 
     }
    //quiqsort
    private static int quiqsortiterationiter=1;
    public static int partitionIteratif(double arr[], int l, int h) 
{ 
    double x = arr[h]; 
    int i = (l - 1); 

    for (int j = l; j <= h - 1; j++) { 
        if (arr[j] <= x) { 
            i++; 
            // swap arr[i] and arr[j] 
            swap(arr, i, j); 
            Output.println("itération:"+ quiqsortiterationiter++);
            Output.printTable(arr);
            Output.println("");
        } 
    } 
    // swap arr[i+1] and arr[h] 
    swap(arr, i + 1, h); 
    Output.println("itération:"+ quiqsortiterationiter++);
    Output.printTable(arr);
    Output.println("");
    return (i + 1); 
} 
// Sorts arr[l..h] using iterative QuickSort 
public static void QuickSortIteratif(double arr[], int l, int h) 
{ 
    // create auxiliary stack 
    int stack[] = new int[h - l + 1]; 

    // initialize top of stack 
    int top = -1; 

    // push initial values in the stack 
    stack[++top] = l; 
    stack[++top] = h; 

    // keep popping elements until stack is not empty 
    while (top >= 0) { 
        // pop h and l 
        h = stack[top--]; 
        l = stack[top--]; 

        // set pivot element at it's proper position 
        int p = partitionIteratif(arr, l, h); 

        // If there are elements on left side of pivot, 
        // then push left side to stack 
        if (p - 1 > l) { 
            stack[++top] = l; 
            stack[++top] = p - 1; 
        } 

        // If there are elements on right side of pivot, 
        // then push right side to stack 
        if (p + 1 < h) { 
            stack[++top] = p + 1; 
            stack[++top] = h; 
        }
    }
}
/* This function takes last element as pivot, 
places the pivot element at its correct 
position in sorted array, and places all 
smaller (smaller than pivot) to left of 
pivot and all greater elements to right 
of pivot */
private static int quiqsortiterationrec=1;
public static int partitionrecursif(double arr[], int low, int high) 
{ 
 
 double pivot = arr[high];  
 int i = (low-1); // index of smaller element 
 for (int j=low; j<high; j++) 
 { 
     // If current element is smaller than the pivot 
     if (arr[j] < pivot) 
     { 
         i++; 

         // swap arr[i] and arr[j] 
         swap(arr,i,j);
         Output.println("itération:"+quiqsortiterationrec++);
         Output.printTable(arr);
         Output.println("");
         
     } 
 } 

 // swap arr[i+1] and arr[high] (or pivot) 
 swap(arr,i+1,high);
 Output.println("itération:"+quiqsortiterationrec++);
 Output.printTable(arr);
 Output.println("");
 return i+1; 
} 


/* The main function that implements QuickSort() 
arr[] --> Array to be sorted, 
low  --> Starting index, 
high  --> Ending index */
public static void quiqsortrecursif(double arr[], int low, int high) 
{ 
 if (low < high) 
 { 
     /* pi is partitioning index, arr[pi] is  
       now at right place */
     int pi = partitionrecursif(arr, low, high); 

     // Recursively sort elements before 
     // partition and after partition 
     quiqsortrecursif(arr, low, pi-1); 
     quiqsortrecursif(arr, pi+1, high); 
 } 
} 
//sélectionSor
public static void selectionSortIter(double[] arr){
	int iteration=1;
    for (int i = 0; i < arr.length - 1; i++)  
    {  
        int index = i;  
        for (int j = i + 1; j < arr.length; j++){  
            if (arr[j] < arr[index]){  
                index = j;//searching for lowest index  
            }        
        }  
        double smallerNumber = arr[index];   
        arr[index] = arr[i];  
        arr[i] = smallerNumber; 
        Output.println("itération:"+ iteration++);
        Output.printTable(arr);
        Output.println("");
    }  
}  

//Return minimum index 
public static int minIndex(double a[], int i, int j) 
{ 
    if (i == j) 
        return i; 
   
    // Find minimum of remaining elements 
    int k = minIndex(a, i + 1, j); 
   
    // Return minimum of current and remaining. 
    return (a[i] < a[k])? i : k; 
} 
   
// Recursive selection sort. n is size of a[] and index 
// is index of starting element. 
private static int SelectionSortiterationrec=1;
public static void SelectionSortrec(double a[], int n, int index) 
{ 
    // Return when starting and size are same 
    if (index==n) 
       return; 
   
    // calling minimum index function for minimum index 
    int k = minIndex(a,index,n-1); 
   
    // Swapping when index nd minimum index are not same 
    if (k != index){ 
       // swap 
       swap(a,index,k);
       Output.println("itération:"+ SelectionSortiterationrec++);
       Output.printTable(a);
       Output.println(""); 
    } 
    // Recursively calling selection sort function 
    SelectionSortrec(a,n,index+1); 
} 
//insertionSor
public static void insertionSortIter(double[] arr)
{
	int iteration=1;
	// Start from the second element
	// (element at index 0 is already sorted)
	for (int i = 1; i < arr.length; i++)
	{
		double value = arr[i];
		int j = i;

		// Find the index j within the sorted subset arr[0..i-1]
		// where element arr[i] belongs
		while (j > 0 && arr[j - 1] > value)
		{
			arr[j] = arr[j - 1];
			j--;
			 Output.println("itération:"+ iteration++);
		     Output.printTable(arr);
		     Output.println(""); 
		}

		// Note that sub-array arr[j..i-1] is shifted to
		// the right by one position i.e. arr[j+1..i]

		arr[j] = value;
		Output.println("itération:"+ iteration++);
	     Output.printTable(arr);
	     Output.println("");
	}
}
//Recursive function to perform insertion sort on sub-array arr[i..n]
private static int insertionSortiteration=1;
	public static void insertionSortrec(double[] arr, int i, int n)
	{
		double value = arr[i];
		int j = i;

		// Find index j within the sorted subset arr[0..i-1]
		// where element arr[i] belongs
		while (j > 0 && arr[j-1] > value)
		{
			arr[j] = arr[j - 1];
			j--;
			Output.println("itération:"+ insertionSortiteration++);
		    Output.printTable(arr);
		    Output.println(""); 
		}

		arr[j] = value;
		Output.println("itération:"+ insertionSortiteration++);
	    Output.printTable(arr);
	    Output.println(""); 

		// Note that subarray arr[j..i-1] is shifted to
		// the right by one position i.e. arr[j+1..i]

		if (i + 1 <= n) {
			insertionSortrec(arr, i + 1, n);
		}
	}

	//towers of hanoi recursive 
	// Java recursive function to solve tower of hanoi puzzle 
    public static void towerOfHanoi(int n, String from_rod,String to_rod,String aux_rod) 
    { 
        if (n == 1) 
        { 
            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod); 
            return; 
        } 
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
        Output.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod); 
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod); 
    } 

    //algorithme de strassen pour la mmultiplication de 2 matrices
    /** Function to multiply matrices **/

    public static double[][] multiplyStrassen(double[][] A,double[][] B)

    {        

        int n = A.length;

        double[][] R = new double[n][n];

        /** base case **/

        if (n == 1)

            R[0][0] = A[0][0] * B[0][0];

        else

        {

        	double[][] A11 = new double[n/2][n/2];
 
        	double[][] A12 = new double[n/2][n/2];

        	double[][] A21 = new double[n/2][n/2];

        	double[][] A22 = new double[n/2][n/2];

        	double[][] B11 = new double[n/2][n/2];

        	double[][] B12 = new double[n/2][n/2];

        	double[][] B21 = new double[n/2][n/2];

        	double[][] B22 = new double[n/2][n/2];

 

            /** Dividing matrix A into 4 halves **/

            split(A, A11, 0 , 0);

            split(A, A12, 0 , n/2);

            split(A, A21, n/2, 0);

            split(A, A22, n/2, n/2);

            /** Dividing matrix B into 4 halves **/

            split(B, B11, 0 , 0);

            split(B, B12, 0 , n/2);

            split(B, B21, n/2, 0);

            split(B, B22, n/2, n/2);

 

            /** 

              M1 = (A11 + A22)(B11 + B22)

              M2 = (A21 + A22) B11

              M3 = A11 (B12 - B22)

              M4 = A22 (B21 - B11)

              M5 = (A11 + A12) B22

              M6 = (A21 - A11) (B11 + B12)

              M7 = (A12 - A22) (B21 + B22)

            **/

 

            double [][] M1 = multiplyStrassen(add(A11, A22), add(B11, B22));

            double [][] M2 = multiplyStrassen(add(A21, A22), B11);

            double [][] M3 = multiplyStrassen(A11, sub(B12, B22));

            double [][] M4 = multiplyStrassen(A22, sub(B21, B11));

            double [][] M5 = multiplyStrassen(add(A11, A12), B22);

            double [][] M6 = multiplyStrassen(sub(A21, A11), add(B11, B12));

            double [][] M7 = multiplyStrassen(sub(A12, A22), add(B21, B22));

 

            /**

              C11 = M1 + M4 - M5 + M7

              C12 = M3 + M5

              C21 = M2 + M4

              C22 = M1 - M2 + M3 + M6

            **/

            double [][] C11 = add(sub(add(M1, M4), M5), M7);

            double [][] C12 = add(M3, M5);

            double [][] C21 = add(M2, M4);

            double [][] C22 = add(sub(add(M1, M3), M2), M6);

 

            /** join 4 halves into one result matrix **/

            join(C11, R, 0 , 0);

            join(C12, R, 0 , n/2);

            join(C21, R, n/2, 0);

            join(C22, R, n/2, n/2);

        }

        /** return result **/    

        return R;

    }

    /** Funtion to sub two matrices **/

    public static double[][] sub(double[][] A, double[][] B)

    {

    	int n = A.length;

    	double[][] C = new double[n][n];

        for (int i = 0; i < n; i++)

            for (int j = 0; j < n; j++)

                C[i][j] = A[i][j] - B[i][j];

        return C;

    }

    /** Funtion to add two matrices **/

    public static double[][] add(double[][] A, double[][] B)

    {

        int n = A.length;

        double[][] C = new double[n][n];

        for (int i = 0; i < n; i++)

            for (int j = 0; j < n; j++)

                C[i][j] = A[i][j] + B[i][j];

        return C;

    }

    /** Funtion to split parent matrix into child matrices **/

    public static void split(double[][] P, double[][] C, int iB, int jB) 

    {

        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)

            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)

                C[i1][j1] = P[i2][j2];

    }

    /** Funtion to join child matrices intp parent matrix **/

    public static void join(double[][] C,double[][] P, int iB, int jB) 

    {

        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)

            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)

                P[i2][j2] = C[i1][j1];

    }    

    //multiplication simple de deux matrices 

 // This function multiplies mat1[][] 
    // and mat2[][], and stores the result 
    // in res[][] 
    public static void multiply(double mat1[][],double mat2[][], double res[][]) 
    { 
    	int N=mat1.length;
        int i, j, k; 
        for (i = 0; i < N; i++) 
        { 
            for (j = 0; j < N; j++) 
            { 
                res[i][j] = 0; 
                for (k = 0; k < N; k++) 
                    res[i][j] += mat1[i][k]* mat2[k][j]; 
            } 
        } 
    } 
    
} 
