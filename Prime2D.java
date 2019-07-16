package com.bridgelab.datastructure;

import java.util.ArrayList;

import com.bridgelab.util.Utility;

public class Prime2D
{
	public static void main(String[]args)
	{
		ArrayList<Integer> a=Utility.Prime2();
		
		int size = a.size();
	    int[] e = new int[size];
	     
	    for(int i = 0; i < size; i++)
	    {
	    	e[i] = a.get(i);
	    }
	    
	    int[][] f= new int[10][e.length];
	    int b=0,c;
		for(int i=0;i<10;i++)
		{
			c=b;
			b=c+100;
			for(int j=0;j<e.length;j++)
			{
				if(e[j]>c&&e[j]<=b)
				{
					f[i][j]=e[j];
					System.out.print(f[i][j]+",");
				}
				else if(e[j]>b)
					j=e.length;
			}
			System.out.println();
		}
		
	}
}
