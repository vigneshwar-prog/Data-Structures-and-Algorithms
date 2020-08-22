import java.util.*;

public class MinPartition {
    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    ArrayList<Integer> list = new ArrayList<Integer>();
    int sum = 0;
    for(int i=0;i<N;i++)
    {
        int k = sc.nextInt();
        sum += k;
        list.add(k);
    }
    int T = sum/2;
    boolean dp[][] = new boolean[N+1][T+1];
        for(int i=0;i<=N;i++)
        {
            Arrays.fill(dp[i],false);
        }
        dp[0][0] = true;
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=T;j++)
            {
                if(j==list.get(i-1)){
                    dp[i][j] = true;
                }
                else{
                    dp[i][j] = dp[i-1][j] || (j > list.get(i-1) && dp[i-1][j - list.get(i-1)]);
                }
            }
        }
        int i=0;
        while(!dp[N][T-i]) i++;
        int minDifference = (sum - (T-i)) - (T-i);
        System.out.print(minDifference);
    }
}