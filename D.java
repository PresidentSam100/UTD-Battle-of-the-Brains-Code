import java.math.BigInteger;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ans = new int[100000];
        int N = sc.nextInt();
        int W = sc.nextInt();
        int H = sc.nextInt();
        if (N > W * H)
            N = W * H;
        for (int i = 0; i <= N; i++)
            if (i <= H)
                ans[i] = 1;
        for (int k = 2; k <= W; k++)
        {
            for (int i = k * H; i >= H + 1; i--)
                ans[i] = (ans[i] - ans[i - H - 1])%1000000007;
            for (int i = 1; i <= k * H; i++)
                ans[i] = (ans[i] + ans [i - 1])%1000000007;
        }
        int s= -1 - N / W;
        for(int i=0;i<=N;i++)
            s = (s + ans[i]) % 1000000007;
        System.out.println((s % 1000000007 + 1000000007) % 1000000007);

    }

}
