//formatted solution

// Problem 1252

import java.io.IOException;
import java.util.*;
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
class QuickSort {						//Defined QuickSort to swap Rows of array

    private int input[][];
    private int length;

    public void sort(int[][] numbers, int len) {

        if (numbers == null || numbers.length == 0) {
            return;
        }
        this.input = numbers;
        length = len;
        quickSort(0, length - 1);
    }


    private void quickSort(int low, int high) {
        int i = low;
        int j = high;


        int pivot = input[low + (high - low) / 2][0];


        while (i <= j) {

            while (input[i][0] < pivot) {
                i++;
            }
            while (input[j][0] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(low, j);
        }

        if (i < high) {
            quickSort(i, high);
        }
    }

    private void swap(int i, int j) {						//swap rows
        int temp[] = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}



public class Main {

    public static void main(String[] args) throws IOException {

        /**
         * Escreva a sua solução aqui
         * Code your solution here
         * Escriba su solución aquí
         */
        int n, m;
        int e[][] = new int[10000][2];				//even
		int o[][] = new int[10000][2];				//odd


        Scanner sc = new Scanner(System.in);
        while (true) {
            n = sc.nextInt();
            m = sc.nextInt();
            if (n == 0 && m == 0)
                break;
            int a[] = new int[n];
            QuickSort qw = new QuickSort();
            int i, j;
            int k = 0, p = 0;
            for (i = 0; i < n; i++)
                a[i] = sc.nextInt();
            for (i = 0; i < n; i++) {				//separate odd and even numbers and also store their modulus
                if (a[i] % 2 == 0) {
                    e[k][1] = a[i];
                    e[k][0] = a[i] % m;
                    k++;
                } else {
                    o[p][1] = a[i];
                    o[p][0] = a[i] % m;
                    p++;
                }
            }
            qw.sort(e, k);						//sort
            qw.sort(o, p);

            for (i = 0; i < k - 1; i++) {			//sort according to their modulus in only even numbers
                for (j = 0; j < k - i - 1; j++) {
                    if (e[j][0] == e[j + 1][0]) {
                        if (e[j][1] > e[j + 1][1]) {
                            int temp[] = e[j];
                            e[j] = e[j + 1];
                            e[j + 1] = temp;
                        }
                    }

                }
            }
            for (i = 0; i < p - 1; i++) {			//sort according to their modulus in only odd numbers
                for (j = 0; j < p - i - 1; j++) {
                    if (o[j][0] == o[j + 1][0]) {
                        if (o[j][1] < o[j + 1][1]) {
                            int temp[] = o[j];
                            o[j] = o[j + 1];
                            o[j + 1] = temp;
                        }
                    }

                }
            }
            int result[] = new int[k + p];			//sort according to their modulus in odd and even number and merge even and odd
            int ii = 0, jj = 0;
            for (int kk = 0; kk < (k + p); kk++) {
                if (ii >= k) {
                    result[kk] = o[jj][1];
                    jj++;
                } else if (jj >= p) {
                    result[kk] = e[ii][1];
                    ii++;
                } else {

                    if (e[ii][0] < o[jj][0]) {
                        result[kk] = e[ii][1];
                        ii++;
                    } else {
                        result[kk] = o[jj][1];
                        jj++;
                    }
                }
            }
            System.out.println(n + " " + m);
            for (i = 0; i < k + p; i++)
                System.out.println(result[i]);		//print
        }
        System.out.println("0 0");
    }
}