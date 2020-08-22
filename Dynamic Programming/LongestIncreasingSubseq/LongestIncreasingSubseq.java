import java.util.*;

public class LongestIncreasingSubseq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<N;i++)
        {
            list.add(sc.nextInt());
        }
        int dp[] = new int[N];
        Arrays.fill(dp,1);
        for(int i=0;i<N;i++)
        {
            int j=0;
            while(j<i)
            {
                if(list.get(i) > list.get(j))
                {
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
                j+=1;
            }
        }
        for(int i:dp) System.out.print(i+" ");
        System.out.println("");
        System.out.print("Length of the Inreasing Sub Sequence " + dp[dp.length-1]);
    }
}