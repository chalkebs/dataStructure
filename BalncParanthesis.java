package com.bridgelab.datastructure;
import java.util.Scanner;

public class BalncParanthesis 
{
	static int top=-1; 
	static char items[] = new char[100]; 

	public static void main(String[] args) 
	{ 
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Expression : ");
		String s1=s.nextLine();
		char[] exp = s1.toCharArray(); 
		if (check(exp)) 
			System.out.println("Parenthesis are Balanced..."); 
		else
			System.out.println("Parenthesis are not Balanced..."); 
	}
	
	private static BalncParanthesis push(char x) 
	{ 
		if (top == 99) 
		{ 
			System.out.println("Stack Overflow..."); 
		} 
		else
		{ 
			items[++top] = x; 
		}
		return null; 
	} 

	private static char pop() 
	{ 
		if (top == -1) 
		{ 
			System.out.println("Stack Underflow..."); 
			return '\0'; 
		} 
		else
		{ 
			char element = items[top]; 
			top--; 
			return element; 
		} 
	} 

	static boolean isEmpty() 
	{ 
		return (top == -1) ? true : false; 
	}  
	
	static boolean match(char character1, char character2) 
	{ 
			if (character1 == '(' && character2 == ')') 
				return true; 
			else if (character1 == '{' && character2 == '}') 
				return true; 
			else if (character1 == '[' && character2 == ']') 
				return true; 
			else
				return false; 
	} 
			
	static boolean check(char exp[]) 
	{ 
			for(int i=0;i<exp.length;i++) 
			{ 
				if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[') 
					push(exp[i]); 
			
				if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') 
				{ 
					if (isEmpty()) 
					{ 
						return false; 
					} 
					else if ( !match(pop(), exp[i]) ) 
					{ 
						return false; 
					} 
				} 
					
			} 
			
			if (isEmpty()) 
				return true; 
			else
				{
					return false; 
				} 
	} 
			 
}
