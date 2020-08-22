
import java.util.*;
import java.lang.*;
import java.io.*;

class LongestPath {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
		    T--;
		    int N = sc.nextInt();
		    int matrix[][] = new int[N+2][N+2];
		    for(int i=0;i<=N+1;i++)
		    {
		        Arrays.fill(matrix[i],0);
		    }
		    for(int i=1;i<=N;i++)
		    {
		        for(int j=1;j<=N;j++)
		        {
		            matrix[i][j] = sc.nextInt();
		        }
		    }
		    for(int i=2;i<N+1;i++)
		    {
		        for(int j=1;j<N+1;j++)
		        {
		            matrix[i][j] += Math.max(matrix[i-1][j],Math.max(matrix[i-1][j-1],
		                                                        matrix[i-1][j+1]));
		        }
		        
		    }
		    int max = -9999;
		    for(int i=0;i<N+1;i++)
		    {
		        max = Math.max(matrix[N][i],max);
		    }
		    System.out.println(max);
		}
	}
}