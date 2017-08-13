//Formatted solution

//Problem 1253

import java.io.IOException;
import java.util.*;
import java.lang.String;
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
        char a[] = new char[2000];
        String s;
        int testcase;
        int b;
        int h = 0;
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            s = sc.next();

            b = sc.nextInt();
            a = s.toCharArray();
            for (int j = 0; j < a.length; j++) {
                int e = (int) a[j];
                e = e - b;
                
                if (e < 65) {
                    e = 91 - (65 - e);

                }
                a[j] = (char) e;

            }
            for (int k = 0; k < a.length; k++)
                System.out.print(a[k]);
            System.out.println();
        }

    }


}