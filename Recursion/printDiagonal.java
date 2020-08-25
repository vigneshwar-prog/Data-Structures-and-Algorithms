import java.util.*;


public class printDiagonal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt();
        int mat[][] = new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                mat[i][j] = sc.nextInt();
            }
        }
        for(int i=N-1;i>0;i--)
        printElements(mat,N,i,0,"");

        for(int i=0;i<N;i++)
        printElements(mat, N, 0, i, "");

    }
    
    public static void printElements(int [][]mat,int N,int row,int col,String output)
    {
        if(row < N && col < N){
            printElements(mat,N,row+1,col+1,output+" "+mat[row][col]);
        }
        else{
            System.out.println(output.trim());
        }
    }
    
    
}