import java.util.*;

public class NQueens {
    public static boolean CanFillRow(int board[][], int Row,int N)
    {
        for(int i =0 ;i<N;i++)
        {
            if(board[Row][i] == 1)return false;
        }
        return true;
    }
    public static boolean CanFillCol(int board[][], int Col,int N)
    {
        for(int i =0 ;i<N;i++)
        {
            if(board[i][Col] == 1)return false;
        }
        return true;
    }
    public static boolean canFillLD(int r,int c,ArrayList<Integer> LD)
    {
        if(LD.contains(r+c)) return false;
        return true;
    }
    public static boolean canFillRD(int r,int c,int N,ArrayList<Integer> RD)
    {
        if(RD.contains(c-r+N-1)) return false;
        return true;
    }
    public static boolean Solve(int board[][],int N,ArrayList<Integer> LD,ArrayList<Integer> RD,int count)
    {
        if(count == N)
        {
            return true;
        }
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(CanFillRow(board,i,N) && CanFillCol(board,j,N) && canFillLD(i,j,LD) && canFillRD(i,j,N,RD)){
                    board[i][j] = 1;
                    count++;
                    LD.add(i+j);
                    RD.add(j-i+N-1);
                    
                    if(Solve(board,N,LD,RD,count)){
                        return true;
                    }
                    else{
                        board[i][j] = 0;
                        count--;
                        LD.remove(LD.size()-1);
                        RD.remove(RD.size()-1);
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
         ArrayList<Integer> LD = new ArrayList<Integer>();
         ArrayList<Integer> RD = new ArrayList<Integer>();
        int Board[][] = new int[N][N];
        for(int i=0;i<N;i++)
        {
            Arrays.fill(Board[i],0);
        }
        Solve(Board,N,LD,RD,0);
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                System.out.print(Board[i][j]+" ");
            }
            System.out.println("");
        }
        
    }
}