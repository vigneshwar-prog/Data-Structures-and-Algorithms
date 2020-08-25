import java.util.*;

public class IslandCount {

    static int max = -99999;
    static int length = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[][] = new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            arr[i][j] = sc.nextInt();
        }
        for(int i=0;i<N;i++)
        {
            for(int j =0;j<N;j++)
            {
                if(arr[i][j] == 1){
                    arr[i][j] = 0;
                    length+=1;
                    dfsTraverse(arr,i+1,j,N);
                    dfsTraverse(arr,i-1,j,N);
                    dfsTraverse(arr,i,j-1,N);
                    dfsTraverse(arr,i,j+1,N);
                }
                length = 0;
            }
        }
        System.out.print(max);
    }
    static void dfsTraverse(int arr[][],int r,int c,int N)
    {
        if(r>=0 && r<N && c>=0 && c<N){
            if(arr[r][c] == 1)
            {
                arr[r][c] = 0;
                length+=1;
                dfsTraverse(arr,r+1,c,N);
                dfsTraverse(arr,r-1,c,N);
                dfsTraverse(arr,r,c-1,N);
                dfsTraverse(arr,r,c+1,N);
            }
            max = Math.max(length,max);
        }

    }
    
}