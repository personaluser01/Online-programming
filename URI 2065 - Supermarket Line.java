//Formatted solution


// Problem 2065

import java.util.*;
public class Main {
	
    public static int least(int a[]) {						//Find which desk is free
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[c] > a[i]) {
                c = i;
            }
        }

        return c;
    }
    public static int max(int a[]) {					//find the max time
        int c = a[0];

        for (int i = 0; i < a.length; i++) {
            if (c < a[i]) {
                c = a[i];
            }
        }

        return c;
    }
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int desk, client;
        desk = sc.nextInt();
        client = sc.nextInt();
        int dt[][] = new int[2][desk];						//one column will store  each desk time to process one item  and another column to store total time he took for customers
        int ct[] = new int[client];
        for (int i = 0; i < desk; i++)
            dt[1][i] = 0;
        for (int i = 0; i < desk; i++) {
            dt[0][i] = sc.nextInt();
        }
        for (int i = 0; i < client; i++) {
            ct[i] = sc.nextInt();
        }
      
        if (desk > client)									
            for (int i = 0; i < client; i++) {
                dt[1][i] = dt[0][i] * ct[i];
            }
        else
            for (int i = 0; i < desk; i++) {
                dt[1][i] = dt[0][i] * ct[i];
            }
		int x = client - desk;									//Find how many customers are left more for checkout
        
		int point = desk - 1;									//desk size
        int q = client - 1;										//client size
        if (x > 0)
            while (point != q) {								// Now start the client array from desk-1 position
                point++;
                int s = least(dt[1]);							//Find which desk is free 
                dt[1][s] = dt[1][s] + dt[0][s] * ct[point];

            }


        int s = max(dt[1]);										//as everything is parrallel so the maximum desk time will be the total time to attend all clients
        System.out.println(s);
    }
}