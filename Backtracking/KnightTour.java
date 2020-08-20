import java.util.*;

class KnightTour{

    static int rowMove[] = {-2,-2,-1,-1,1,1,2,2};
    static int colMove[] = {1,-1,-2,2,-2,2,-1,1};
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Board[][] = new int[N][N];
        for(int i=0;i<N;i++)
        {
            Arrays.fill(Board[i],0);
        }
        int srcRow = sc.nextInt(),srcCol = sc.nextInt();
        solve(N,Board,srcRow,srcCol);
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                System.out.print(Board[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    private static void solve(int n, int[][] board, int row, int col) {
        if(count == n*n) return ;
        if(row>=0 && row<n && col>=0 && col<n)
        {
            if(board[row][col] == 0 )
            {
                board[row][col] = ++count;
                for(int i=0;i<8;i++)
                {
                    solve(n,board,row+rowMove[i],col+colMove[i]);
                }
            }
        }
    }
}