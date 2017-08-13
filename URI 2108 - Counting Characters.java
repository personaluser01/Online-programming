//Formatted solution

// Problem 2108

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
        String w = "";
        int b[] = new int[2];
        b[0] = 0;
        String big = "";								//it is used to store the biggest string
        while (!sc.hasNextInt()) {
            String s = sc.nextLine();
            String[] array = s.split(" ");
            w = w + array[0].length();
            if (array[0].length() >= b[0]) {
                b[0] = array[0].length();
                b[1] = 0;
                int q = b[1];
                big = array[q];
            }
            for (int i = 1; i < array.length; i++) {
                int l = array[i].length();
                if (l >= b[0]) {
                    b[0] = l;
                    b[1] = i;
                    int q = b[1];
                    big = array[q];
                }
                w = w + "-" + l;

            }

            w = w + "\n";
        }

        System.out.println(w);
        System.out.println("The biggest word: " + big);
    }
}