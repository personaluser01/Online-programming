//Formatter solution


// Problem 1256
import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
    public static void main(String arg[]) {
        int a[];
        int n, f;
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();

        a = new int[1000];
        char e = (char) 92;

        for (int k = 0; k < p; k++) {
            f = sc.nextInt();						//take mod with this number
            n = sc.nextInt();						//total number of inputs 
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();				

            }
            for (int i = 0; i < n - 1; i++) {						//arrange the input in increasing order according to their modulus.
                for (int j = 0; j < n - i - 1; i++) {
                    if (a[j] % f > a[j + 1] % f) {			
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;

                    }
                }

            }

            for (int i = 0; i < f; i++) {
                System.out.print(i + " -> ");
                for (int j = 0; j < n; j++) {						//printing
                    if (a[j] % f == i) {
                        System.out.print(a[j] + " -> ");

                    }

                }
                System.out.println(e);
            }
            if (k != p - 1)											//in the last case dont println
                System.out.println();
        }
    }
}