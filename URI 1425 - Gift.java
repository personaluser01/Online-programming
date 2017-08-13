//Formatted solution

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
class Main
{
    public static void Check(int n,int m)
    {
     int i=1;
	 int jdis=0;									//distance of jump of frog
	 int rno=0;										//rock no at which frog is right now (assume start from rock 0)
	 while(true)
	 {
		 if(rno!=m)
		 {
			 if(rno>=0 && rno<n+1)
			 {
				 jdis=2*i-1;
				 if(jdis+rno<n+1)
				 {
					 rno+=jdis;
				 }
				 else if(rno-jdis>0)
				 {
					 rno-=jdis;
				 }
				 else {
					 System.out.println("Don't make fun of me!");
					 break;
				 }
			 }
		 }
		 else{
			 System.out.println("Let me try!");
		    break;
		 }
		 i++;
	  }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int m,n;
        while(true)
        {
            n=sc.nextInt();						//total number of rocks
            m=sc.nextInt();						//number of the rock on which the gift is located
			if(n>50 || m==1)										
			 System.out.println("Let me try!");
     		else
			{
			if(n==0 && m==0)
                break;
            Check(n,m);
			}
		}
		}
    }
