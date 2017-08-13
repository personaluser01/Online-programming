//Formatted solution

// Problem 1340
// 
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
        int c = 0;
        int p, d;
        int st, qu, pq;
        boolean _p, _q, _s;

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            p = sc.nextInt();
            c = 0;
            Stack s1 = new Stack();
            ArrayDeque s2 = new ArrayDeque();
            PriorityQueue s3 = new PriorityQueue();
            _p = true;
            _q = true;
            _s = true;
            for (int i = 0; i < p; i++) {
                d = sc.nextInt();
                c = sc.nextInt();
                if (d == 1) {
                    s1.push(c);
                    s2.add(c);
                    s3.add(-c);
                } else if (d == 2) {
                    int x = (int) s1.peek();
                    if (((int)(s1.peek())) != c) _s = false;

                    if (((int) s2.peek()) != c) _q = false;

                    if ((-(int)(s3.peek())) != c) _p = false;

                    s1.pop();
                    s2.remove();
                    s3.remove();
                }
            }
            if ((_p && _q && _s) || (!_p && _q && _s) || (_p && !_q && _s) || (_p && _q && !_s))
                System.out.println("not sure");
            else if (_p && !_q && !_s)
                System.out.println("priority queue");
            else if (!_p && _q && !_s)
                System.out.println("queue");
            else if (!_p && !_q && _s)
                System.out.println("stack");
            else
                System.out.println("impossible");

        }

    }

}