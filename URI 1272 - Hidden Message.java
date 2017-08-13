//formatted solution


//Problem 1272

import java.util.Scanner;
import java.lang.String;
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Escreva a sua solução aqui
         * Code your solution here
         * Escriba su solución aquí
         */


        char u[] = new char[100];
        int h = 0;
        int i;
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();
        while (testcase != 0) {
            String s = sc.nextLine();
            h = 0;
            char a[] = s.toCharArray();
            if (a[0] != ' ') {
                u[0] = a[0];
                h++;
            }
            for (i = 1; i < a.length; i++) {
                if (a[i - 1] == ' ' && a[i] != ' ') {
                    u[h] = a[i];
                    h++;
                }
            }
            for (int k = 0; k < h; k++)
                System.out.print(u[k]);
            System.out.println();
            testcase--;
        }
    }


}