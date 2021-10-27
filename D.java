import java.math.BigInteger;
import java.util.Scanner;
// Problem Link: https://open.kattis.com/contests/vm8cd3/problems/scenes
public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ans = new int[100000];
        int N = sc.nextInt(); // amount of ribbon available
        int W = sc.nextInt(); // width
        int H = sc.nextInt(); // height
        // N can only be as great as the area defined by W and H
        if (N > W * H)
            N = W * H;
        // set a value for elements less than both N and H
        for (int i = 0; i <= N; i++)
            if (i <= H)
                ans[i] = 1;
        // dynamic programming
        for (int k = 2; k <= W; k++)
        {
            for (int i = k * H; i >= H + 1; i--)
                ans[i] = (ans[i] - ans[i - H - 1])%1000000007;
            for (int i = 1; i <= k * H; i++)
                ans[i] = (ans[i] + ans [i - 1])%1000000007;
        }       
        // find total possible combinations (ignoring any rules) and subtract those that don't satisfy the height condition
        int s= -1 - N / W;
        for(int i=0;i<=N;i++)
            s = (s + ans[i]) % 1000000007;
        System.out.println((s % 1000000007 + 1000000007) % 1000000007);

    }

}
