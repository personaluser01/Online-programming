//Formatted solution
// Problem 1429
import java.io.IOException;
import java.util.*;
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Main {

    public static int fact(int a) {
        int f = 1;
        for (int i = a; i > 1; i--)
            f = f * i;
        return f;
    }
    public static void main(String[] args) throws IOException {

        /**
         * Escreva a sua solução aqui
         * Code your solution here
         * Escriba su solución aquí
         */
        int n = 1;
        int p = 0;
        int i;
        int q;
        Scanner sc = new Scanner(System.in);
        while (n != 0) {
            i = 1;
            p = 0;
            n = sc.nextInt();
            if (n == 0)
                break;
            q = n;
            while (q > 0) {
                p = p + (q % 10) * fact(i);
                i++;
                q = q / 10;
            }
            System.out.println(p);
        }



    }

}