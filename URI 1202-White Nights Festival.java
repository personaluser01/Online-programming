//formatted solution

// Problem 1202
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
    public static int exp(int p, int q) {
        int r = 1;
        while (q != 0) {
            if (q % 2 == 1) { // q is odd
                r = (r * p) % 1500;
                q--;
            }
            p = (p * p) % 1500;
            q /= 2;
        }
        return r;
    }

    public static void main(String[] args) throws IOException {

        /**
         * Escreva a sua solução aqui
         * Code your solution here
         * Escriba su solución aquí
         */

        long fab[] = new long[2000];
        
        String x;
        fab[0] = 0;
        fab[1] = 1;
        for (int i = 2; i < 1510; i++)
            fab[i] = (fab[i - 1] + fab[i - 2]) % 1000;
        Scanner sc = new Scanner(System.in);
        int n;
        int a;
        int s = 0;
        String r;
        int q = 0;
        int u = 0;
        n = sc.nextInt();
        for (int j = 0; j < n; j++) {
            s = 0;
            q = 0;
            x = sc.next();
            char ab[] = x.toCharArray();
            for (int k = x.length() - 1; k >= 0; k--) {							//decode binary into decimal
                if (ab[k] == '1')
                    s = (s + exp(2, q)) % 1500;
                q++;
            }

            System.out.println(String.format("%03d", fab[s]));					//find the fibonacci no. stored at that position
            

        }


    }

}