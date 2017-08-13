//Formatted solution

// Problem 1088

import java.util.*;
import java.lang.String;
public class Main {
    static long a[];
    static long swapcount;
    static long merge(int low, int mid, int high) {
        int lsize, rsize;
        long res = 0;
        lsize = mid - low + 1;
        rsize = high - mid;
        long left[] = new long[lsize + 1];
        long right[] = new long[rsize + 1];
        int i, j, k;
        k = 0;
        for (i = low; i <= mid; ++i) {
            left[k++] = a[i];
        }
        k = 0;
        for (j = mid + 1; j <= high; ++j) {
            right[k++] = a[j];
        }
        right[rsize] = left[lsize] = Long.MAX_VALUE;
        i = j = 0;
        for (k = low; k <= high; ++k) {
            if (left[i] > right[j]) {
                res += (lsize - i);								//count no of swaps
                a[k] = right[j++];
            } else {
                a[k] = left[i++];
            }
        }
        return res;
    }
    static long merge_sort(int low, int high) {
        if (low < high) {
            long left = 0, right = 0, total = 0;
            int mid = (low + high) / 2;
            left = merge_sort(low, mid);

            right = merge_sort(mid + 1, high);

            total = left + right;								//count for both left and right part
            total += merge(low, mid, high);						//final total swap
            return total;
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 1;
        while (true) {
            n = sc.nextInt();

            if (n == 0)
                break;
            a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            swapcount = merge_sort(0, n - 1);				//we use merge sort to count number of consecutive swapping to sort the array

            long k = swapcount % 2;							//to find even or odd 
            if (k == 1)										//if odd then Marcelo
                System.out.println("Marcelo");
            else											//if even then carlos
                System.out.println("Carlos");

        }
    }
}