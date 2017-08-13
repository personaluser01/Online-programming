//Formatted solution

// Problem 1176

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
        Scanner n = new Scanner(System.in);
        long fab[] = new long[61];
        int i, p, q;
        fab[0] = 0;
        fab[1] = 1;
        for (int j = 2; j <= 60; j++)
            fab[j] = fab[j - 1] + fab[j - 2];
        p = n.nextInt();
        for (i = 0; i < p; i++) {
            q = n.nextInt();

            System.out.println("Fib(" + q + ") = " + fab[q]);
        }
    }
}