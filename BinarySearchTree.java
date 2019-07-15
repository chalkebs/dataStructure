package com.bridgelab.datastructure;

import java.util.Scanner;

public class BinarySearchTree
{

	static Node root;
	static class Node
	{
		int data;
		Node left;
		Node right;
		Node(int d)
		{
			data=d;
			right=null;
			left=null;
		}
	}
	public void insert(int data)
	{
		root=insert(root,data);	
	}
	public Node insert(Node root, int data) 
	{
		if(root==null)
			root=new Node(data);
		
		if(data<root.data)
			root.left=insert(root.left,data);
		else if(data>root.data)
			root.right=insert(root.right,data);
		else
			return root;
		return root;	
	}
	public static void printList(Node root) {
		
		 if (root!= null)
		 {
		        printList(root.left);
		        System.out.print(" " + root.data);
		        printList(root.right);
		    }
	}
	public static void totalBST(int n)
	{
		int t = fact(2*n)/(fact(n)*fact(n+1));		
		System.out.println();
		System.out.println("Total number of trees from "+n+ " nodes are: "+t); 
	}

	public static int fact(int n) 
	{
		return (n == 1 || n == 0) ? 1 : n * fact(n - 1); 		
	}
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		BinarySearchTree bst=new BinarySearchTree();
		System.out.println("How many nodes you want to insert:");
		int n=s.nextInt();
		System.out.println("Enter the elements:");
		for(int i=0;i<n;i++)
			bst.insert(s.nextInt());
		System.out.print("no. of Tree's are form..."); 
		BinarySearchTree.printList(root);
		totalBST(n);

   }
}
