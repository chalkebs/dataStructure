package com.bridgelab.datastructure;

import java.util.Scanner;

public class BankingCashCounter
{
	public static Node front,rear;
	public static int size;
	static class Node
	{
		int d;
		Node next;
		public Node(int data)
		{
			d=data;
			next=null;
			front=null;
			rear=null;
			size=0;
		}
	}
	
	public static boolean isEmpty()
	{
		return (size==0);
	}
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		char a='\0';
		int cash=0,p=0;
		size=0;
		do
		{
			int choice;
			System.out.println("******* Cash Counter *******\n");
			System.out.println("1. Deposite Money\n2. Withdraw Money\n");
			System.out.println("Enter your choice...");
			choice=s.nextInt();
			switch(choice)
			{
				case 1:
						int amount;
						System.out.println("\nEnter Amount which you want to Deposite...");
						amount=s.nextInt();
						deposite(amount);
						cash=cash+amount;
						p++;
						break;
				case 2:
						int amount1;
						System.out.println("\nEnter Amount to Withdraw...");
						amount1=s.nextInt();
						int c=withdraw(amount1);
						cash=cash-c;
						p++;
						break;
			}
			if(cash==0)
			{
				System.out.println("\nExpression is balanced...");
			}
			else
			{
				System.out.println("\nExpression is not balanced...");
				System.out.println("\nCASH : "+cash);
			}
			
			System.out.println("\nPeople who are visited : "+p);
			System.out.println("\nEnter y to continue...");
			a=s.next().charAt(0);
			
		}while(a=='Y'||a=='y');
		
		s.close();
	}

	private static void deposite(int amount)
	{
		Node rear1=rear;
		rear=new Node(amount);
		rear.d = amount;
		rear.next = null;
		if (isEmpty()) 
		{
			front = rear;
		}
		else 
		{
			rear1.next = rear;
		}
		size++;
	}

	private static int withdraw(int amount1) 
	{
		int data = front.d;
		front = front.next;
		if (isEmpty()) 
		{
		 rear = null;
		}
		size--;
		return amount1;
	}
}
