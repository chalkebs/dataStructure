package com.bridgelab.datastructure;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StreamTokenizer;

public class OrderedLinkedList 
{
	 Node root;
	  static class Node
	  {
		int d;
		Node nt;
		Node(int a)
		{
		  d=a;
		  nt=null;
		}
	  }

	  private static OrderedLinkedList insert(OrderedLinkedList l,int a)
	  {
		Node n1=new Node(a);
		n1.nt=null;
			
		if(l.root==null)
		{
		  l.root=n1;
		}
		else
		{
		  Node n2=l.root;
		  
		  while(n2.nt!=null)
		  {
			n2=n2.nt;
		  }
		  n2.nt=n1;
		}
		return l;
	  }

	  private static OrderedLinkedList search(OrderedLinkedList l,int s3)
	  {
		  Node currentNode=l.root,prev=null;
			 if (currentNode != null && s3==currentNode.d)
			 { 
		            l.root = currentNode.nt; 
		            System.out.println(s3 + " is found...it is deleted..."); 
		            return l; 
		      }
			 while (currentNode != null && s3!=currentNode.d) 
			 { 
		            prev = currentNode; 
		            currentNode = currentNode.nt; 
		      } 
			  if (currentNode != null)
			  {   
		            prev.nt = currentNode.nt; 
		            System.out.println(s3 + " is found...it is deleted..."); 
		      } 
			  if (currentNode == null) { 
		          
		            System.out.println(s3 + " is not found...it is added...");
		            l = insert(l, s3);
		        } 
			return l;
			
	  }

	  private static OrderedLinkedList showList(OrderedLinkedList l) 
	  {
		  Node currentNode=l.root;

		  ArrayList<Integer> list=new ArrayList<Integer>();
		  while (currentNode != null) 
		  {   
			  int s1=currentNode.d;
			  list.add(s1);
		      currentNode = currentNode.nt;             
		  }
		  Collections.sort(list);
		  System.out.print("Ordered LinkedList : "+list);
		  try
		  {
			  PrintWriter writer = new PrintWriter("/home/admin28/eclipse-workspace/BridgelabzJavaCode/src/file2.txt");
			  writer.print("");
			  writer.close();
			  Collections.sort(list);
			  FileWriter writer1 = new FileWriter("/home/admin28/eclipse-workspace/BridgelabzJavaCode/src/file2.txt"); 
			  for(int str: list) {
			    writer1.write(str + " ");
			  }
			  writer1.close();  
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		return l;
	  }
	  
	  public static void main(String[] args)
	  {
		try
		{
			Reader r = new BufferedReader(new FileReader("/home/admin28/eclipse-workspace/BridgelabzJavaCode/src/file2.txt"));
		    StreamTokenizer stok = new StreamTokenizer(r);
		    stok.parseNumbers();
		    ArrayList<Integer> array=new ArrayList<Integer>();
		    stok.nextToken();
		    while (stok.ttype != StreamTokenizer.TT_EOF) {
		      if (stok.ttype == StreamTokenizer.TT_NUMBER)
		        array.add((int) stok.nval);
		      stok.nextToken();
		    }
		    
			Scanner s=new Scanner(System.in);
			int[] a=new int[array.size()];
			OrderedLinkedList l=new OrderedLinkedList();
			for(int i=0; i<array.size();i++)
				a[i]=array.get(i);
			
			for(int i=0;i<a.length;i++)
			{
			  l=insert(l,a[i]);
			}
			System.out.println("Enter the number...");
			int s3=s.nextInt();
			search(l,s3);
			showList(l);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	  }
}
