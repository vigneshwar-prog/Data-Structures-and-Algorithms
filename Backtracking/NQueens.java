import java.util.*;

public class NQueens {

    int LeftD = new int[10];
    int RightD = new int[10];
    
    public static CanFillRow(int board[][], int Row,int N)
    {
        for(int i =0 ;i<N;i++)
        {
            if(board[Row][i] == 1)return false;
        }
        return true;
    }
    public static CanFillCol(int board[][], int Col,int N)
    {
        for(int i =0 ;i<N;i++)
        {
            if(board[i][Col] == 1)return false;
        }
        return true;
    }
    public static boolean Solve(int board[][],int N)
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(CanFillRow(board,i,N) && CanFillCol(board,j,N) && canFillLD(board,i,j,N) && canFillRD(board,i,j,N)){
                    board[i][j] = 1;
                    
                    if(Solve(board,N)){
                        return true;
                    }
                    else{
                        board[i][j] = 0;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Board[][] = new int[N][N];
        for(int i=0;i<N;i++)
        {
            Arrays.fill(Board[i],0);
        }
        if(Solve(Board,N)){
            System.out.print("Solved");
        }
        else{
            System.out.print("Not Solved");
        }
    }
}