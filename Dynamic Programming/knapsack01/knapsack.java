import java.util.*;


public class knapsack {

    static class Item{
        int value;
        int weight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(),W = sc.nextInt();
        Item[] items = new Item[N];
        for(int i=0;i<N;i++) items[i] = new Item();
        for(int i=0;i<N;i++)
        {
            items[i].value= sc.nextInt();
            items[i].weight = sc.nextInt();
        }
        int dp[][] = new int[N+1][W+1];
        for(int i=0;i<W+1;i++)
        {
            dp[0][i] = 0;
        }
        for(int i=0;i<N+1;i++)
        {
            dp[i][0] = 0;
        }
        for(int i=1;i<N+1;i++)
        {
            for(int j=1;j<W+1;j++)
            {
                if(items[i-1].weight <= j)
                {
                    int k = j - items[i-1].weight;
                    dp[i][j] = Math.max( dp[i-1][k]+items[i-1].value,dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for(int i=0;i<=N;i++)
        {
            for(int j=0;j<=W;j++)
            {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println("");
        }


    }
    
}