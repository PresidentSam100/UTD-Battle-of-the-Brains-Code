import java.math.BigInteger;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] X = new int[n];
        int[] Y = new int[n];
        int[] R = new int[n];
        for (int i = 0; i < n; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int r = sc.nextInt();
            X[i] = x;
            Y[i] = y;
            R[i] = r;
        }
        double num=0;
        for (double xx = -10; xx <= 20; xx+=0.01)
        {
            for (double yy = -10; yy <= 20; yy+=0.01)
            {
                boolean work = false;
                for (int i = 0; i < n; i++)
                {
                    if (isInside(X[i], Y[i], R[i], xx, yy)) {
                        work = true;
                        break;
                    }
                }
                if (work)
                    num++;

            }
        }
        System.out.println(num/10000);
    }


    static boolean isInside(int circle_x, int circle_y, int rad, double x, double y)
    {
        if ((x - circle_x) * (x - circle_x) + (y - circle_y) * (y - circle_y) <= rad * rad)
            return true;
        else
            return false;
    }

}
