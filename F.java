import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean work = true;
        for (int i = 0; i < N; i++)
        {
            String a = sc.next();
            String test = sc.next();
            String b = sc.next();
            int min = Math.min(3, Math.min(a.length(), b.length()));
            a = a.substring(a.length()-min);
            b = b.substring(b.length()-min);
            if (a.equals(b) && test.equals("is") || !a.equals(b) && test.equals("not"))
            {

            }
            else
                work = false;
        }
        if (work)
            System.out.println("yes");
        else
            System.out.println("wait what?");
    }
}
