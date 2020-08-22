import java.util.*;


public class StairCase {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Solve(N);
    }
    public static void Solve(int N)
    {
        int dp[] = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=N;i++)
        {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        System.out.print("Solution " + dp[N]);
    }
}