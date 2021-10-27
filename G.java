import java.math.BigInteger;
import java.util.Scanner;
// Problem Link: https://open.kattis.com/contests/vm8cd3/problems/locustlocus
public class G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++)
        {
            // read input
            int y = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            // find the y + lcm(a, b) sum with lowest value
            min = Math.min(y + lcm(a, b), min);
        }
        System.out.println(min);
    }
    // Greatest common divisor method (using Euclidian algorithm)
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    // Least common multiplier method 
    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }

}
