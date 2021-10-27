import java.math.BigInteger;
import java.util.Scanner;
// Problem Link: https://open.kattis.com/contests/vm8cd3/problems/anti11
public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        // initialize array
        BigInteger[] arr = new BigInteger[10010];
        arr[1] = new BigInteger(String.valueOf(2));
        arr[2] = new BigInteger(String.valueOf(3));
        // find the nth fibonacci value up to 10000 and store them in array
        for (int i = 3; i <= 10000; i++)
        {
            arr[i] = arr[i-1].add(arr[i-2]).mod(new BigInteger("1000000007"));
        }
        for (int i = 0; i < T; i++)
        {
            // call index n from array
            int n = sc.nextInt();
            System.out.println(arr[n].mod(new BigInteger("1000000007")));
        }
    }
    // fibonacci method using recursion
    // sequence: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

}
