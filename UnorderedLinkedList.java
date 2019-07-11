package com.bridgelab.datastructure;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class UnorderedLinkedList
{
  Node root;
  static class Node
  {
	String d;
	Node nt;
	Node(String s4)
	{
	  d=s4;
	  nt=null;
	}
  }

  private static UnorderedLinkedList insert(UnorderedLinkedList l,String s1)
  {
	Node n1=new Node(s1);
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

  private static UnorderedLinkedList search(UnorderedLinkedList l,String s3)
  {
	  Node currentNode=l.root,prev=null;
		 if (currentNode != null && s3.compareTo(currentNode.d)==0)
		 { 
	            l.root = currentNode.nt; 
	            System.out.println(s3 + " is found...it is deleted..."); 
	            return l; 
	      }
		 while (currentNode != null && s3.compareTo(currentNode.d)!=0) 
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

  private static void showList(UnorderedLinkedList l) 
  {
	  Node currentNode=l.root;
	  
	  System.out.print("LinkedList: "); 
	  ArrayList<String> list=new ArrayList<String>();
	  while (currentNode != null) 
	  {   
		  System.out.print(currentNode.d + " ");
		  String s1=currentNode.d;
		  list.add(s1);
	      currentNode = currentNode.nt;             
	  }
	  try
	  {
		  PrintWriter writer = new PrintWriter("/home/admin28/eclipse-workspace/BridgelabzJavaCode/src/file1.txt");
		  writer.print("");
		  writer.close();
		  FileWriter writer1 = new FileWriter("/home/admin28/eclipse-workspace/BridgelabzJavaCode/src/file1.txt"); 
		  for(String str: list) {
		    writer1.write(str + " ");
		  }
		  writer1.close();  
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  
  public static void main(String[] args)
  {
	BufferedReader br;
	try
	{
		File f=new File("/home/admin28/eclipse-workspace/BridgelabzJavaCode/src/file1.txt");
		br=new BufferedReader(new FileReader(f));
		Scanner s=new Scanner(System.in);
		String[] s1=new String[20];
		UnorderedLinkedList l=new UnorderedLinkedList();
		String s2=br.readLine();	
		while(s2!=null)
		{
		  s1=s2.split("\\s");
		  s2=br.readLine();
		}
		for(int i=0;i<s1.length;i++)
		{
		  l=insert(l,s1[i]);
		}
		System.out.println("Enter the string which you want to search...");
		String s3=s.nextLine();
		search(l,s3);
		showList(l);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
  }
}

