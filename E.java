import java.math.BigInteger;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        BigInteger[] arr = new BigInteger[10010];
        arr[1] = new BigInteger(String.valueOf(2));
        arr[2] = new BigInteger(String.valueOf(3));
        for (int i = 3; i <= 10000; i++)
        {
            arr[i] = arr[i-1].add(arr[i-2]).mod(new BigInteger("1000000007"));
        }
        for (int i = 0; i < T; i++)
        {
            int n = sc.nextInt();
            System.out.println(arr[n].mod(new BigInteger("1000000007")));
        }
    }
    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

}
