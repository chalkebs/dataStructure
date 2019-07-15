package com.bridgelab.datastructure;

import com.bridgelab.functional.Leap1;
import java.util.Scanner;

public class Calender
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		System.out.print("Enter Month : ");
		int m=s.nextInt();
		System.out.print("\nEnter Year : ");
		int y=s.nextInt();
		System.out.println();
		int a=calender(m,y);

		calenderJava(a,m,y);
		
	}
	private static void calenderJava(int a, int m, int y)
	{
		String[] b= {"Jan","Feb","March","April","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
		System.out.println(""+b[m-1]+" "+y);
		String[] c= {"Sun","Mon","Tue","Wed","Thus","Fri","Sat"};
		
		Leap1 s=new Leap1();
		int l=s.leap(y);
		
		int[] e= {31,l,31,30,31,30,31,31,30,31,30,31};
		int[][] f=new int[6][7];
		System.out.println();
		for(int i=0;i<c.length;i++)
		{
			System.out.print(c[i]+" ");
		}
		System.out.println();
		int d1=1;
		for(int i=a-1;i>=0;i--)
		{
			f[0][i]=0;
		}
		for(int i=a;i<7;i++)
		{
			f[0][i]=d1;
			d1++;
		}
		
		for(int i=1;i<6;i++)
		{
			for(int j=0;j<7;j++)
			{
				if(d1<=e[m-1])
				{
					f[i][j]=d1;
					d1++;
				}
			}
		}	
		
		int z=0;
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<7;j++)
			{
				if(f[i][j]<10)
					System.out.print(" "+f[i][j]+"  ");
				else if(f[i][j]>=10)
						System.out.print(" "+f[i][j]+" ");
				z++;
				if(z%7==0)
					System.out.println();
			}
		}
		
		
	}
	static int calender(int m,int y)
	{
		int y0= y-(14 - m) / 12;
		int x = y0 + y0/4 - y0/100 + y0/400;
		int m0 = m + 12 * ((14 - m) / 12) - 2;
		int d0 = (1 + x + 31*m0 / 12)%7;
		
		return d0;
	}
}
