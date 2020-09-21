import java.util.*;

class MatrixRCPattern{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt(),C = sc.nextInt();
        int matrix[][] = new int[R][C];
        for(int i = 0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                matrix[i][j] = sc.nextInt();
            }
        }
        int N = Math.min(R,C);
        for(int i=0;i<N;i++)
        {
            printRPattern(matrix,i,C-1,C);
            printCPattern(matrix,i+1,i,R);
            System.out.println("");
        }
    }
    public static void printRPattern(int[][] matrix,int r,int c,int N)
    {
        if(r<=c){
            System.out.print(matrix[r][c]+" ");
            printRPattern(matrix, r, c-1, N);
        }
    }
    public static void printCPattern(int[][] matrix,int r,int c,int N)
    {
        if(r<N ){
            System.out.print(matrix[r][c]+" ");
            printCPattern(matrix, r+1, c, N);
        }
    }
}