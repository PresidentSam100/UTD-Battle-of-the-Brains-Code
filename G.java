import java.math.BigInteger;
import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++)
        {
            int y = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            min = Math.min(y + lcm(a, b), min);
        }
        System.out.println(min);
    }
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }

}
