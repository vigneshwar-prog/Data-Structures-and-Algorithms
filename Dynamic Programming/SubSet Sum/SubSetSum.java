import java.util.*;

public class SubSetSum {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(),T = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<N;i++)
        {
            list.add(sc.nextInt());
        }
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
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - list.get(i-1)];
                }
            }
        }
        for(int i=0;i<=N;i++)
        {
            for(int j=0;j<T+1;j++)
            {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println("");
        }
    }
}