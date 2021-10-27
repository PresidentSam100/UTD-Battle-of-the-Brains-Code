import java.math.BigInteger;
import java.util.Scanner;
// Problem Link: https://open.kattis.com/contests/vm8cd3/problems/grazedgrains
public class C {
    public static void main(String[] args) {
        // initialize scanner
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // arrays for describing the circles
        int[] X = new int[n];
        int[] Y = new int[n];
        int[] R = new int[n];
        // Read input
        for (int i = 0; i < n; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int r = sc.nextInt();
            X[i] = x; // x-coordinate of center
            Y[i] = y; // y-coordinate of center
            R[i] = r; // radius of circle
        }
        // estimate area using Monte Carlo        
        double num=0;
        // iterate through x
        for (double xx = -10; xx <= 20; xx+=0.01)
        {
            // iterate through y
            for (double yy = -10; yy <= 20; yy+=0.01)
            {
                // check if point is contained within at least one circle
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
        // divide to satisfy the expected area
        System.out.println(num/10000);
    }

    // Circle forumula: (x - h)^2 + (y - k)^2 = r^2
    // (x,y) center of circle
    // (h,k) test point
    // r: radius
    static boolean isInside(int circle_x, int circle_y, int rad, double x, double y)
    {
        // test point will be in circle if it would be mapped on another circle with the same center and smaller radius
        if ((x - circle_x) * (x - circle_x) + (y - circle_y) * (y - circle_y) <= rad * rad)
            return true;
        else
            return false;
    }

}
