//Formatted solution


// Problem 1042

import java.io.IOException;
import java.util.*;
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Main {

    public static void main(String[] args) throws IOException {

        /**
         * Escreva a sua solução aqui
         * Code your solution here
         * Escriba su solución aquí
         */

        Scanner sc = new Scanner(System.in);
        int a[] = new int[3];
        int b[] = new int[3];
        int i, j;
        for (i = 0; i < 3; i++) {
            a[i] = sc.nextInt();
            b[i] = a[i];
        }

        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int c = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = c;
                }
            }
        }
        for (i = 0; i < 3; i++)
            System.out.println(a[i]);
        System.out.println();
        for (i = 0; i < 3; i++)
            System.out.println(b[i]);



    }


}