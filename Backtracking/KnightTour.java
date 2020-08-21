import java.util.*;


class KnightTour
{
    static int Board[][];
    static int N;
    static int x[] = {-2,-2,-1,-1,1,1,2,2};
    static int y[] = {-1,1,-2,2,-2,2,-1,1};
    KnightTour(int N)
    {
        Board  =new int[N][N];
        this.N = N;
        for(int i=0;i<N;i++)
        {
           Arrays.fill(Board[i], 0); 
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        KnightTour obj = new KnightTour(N);
        Board[0][0] = 1;
        if(Solve(0,0,2)){
            System.out.println("Solved");
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    System.out.print(" " + Board[i][j] +" ");
                }
                System.out.println("");
            }
        }
        else{
            System.out.print("Not Solved");
        }
        
    }
    private static boolean Solve(int row, int col, int count) {

         for(int i=0;i<8;i++)
        {
            int nextRow = row+x[i],nextCol = col+y[i];
            if(isSafe(nextRow,nextCol)){
                Board[nextRow][nextCol] = count;
                if(count == N*N || Solve(nextRow,nextCol,count+1))
                return true;
                else Board[nextRow][nextCol] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(int nextRow, int nextCol) {

        if(nextRow >=0 && nextRow < N && nextCol >=0 && nextCol < N && Board[nextRow][nextCol] == 0){
            return true;
        }
        return false;
    }
}