import java.util.*;

class Slot{
    int row,col;
    Boolean flag = false ;

    Slot(int matrix[][])
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(matrix[i][j] == 0)
                {
                    this.row = i;
                    this.col = j;
                    this.flag = true;
                    break;
                }
            }
            if (flag) break;
        }
    }
    public boolean getFreeSlot(){
        return flag;
    }

}
class Sudoku {


    public static boolean canFillRow(int matrix[][],int row,int data)
    {
        for(int i=0;i<9;i++)
        {
            if(matrix[row][i] == data) return false;
        }
        return true;
    }
    public static boolean canFillCol(int matrix[][],int col,int data)
    {
        for(int i=0;i<9;i++)
        {
            if(matrix[i][col] == data) return false;
        }
        return true;
    }
    public static boolean canFillSubMat(int matrix[][],int row,int col,int data)
    {
        int r = (row/3)*3;
        int c = (col/3)*3;
        for(int i = r;i<r+3;i++)
        {
            for(int j=c;j<c+3;j++)
            {
                if(matrix[i][j] == data)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solve(int matrix[][])
    {
        Slot slot = new Slot(matrix);
        if(slot.getFreeSlot()){
            int row = slot.row;
            int col = slot.col;

            for(int i=1;i<=9;i++)
            {
                if(canFillRow(matrix,row,i) && canFillCol(matrix,col,i) && canFillSubMat(matrix,row,col,i))
                {
                    matrix[row][col] = i;
                    if(solve(matrix))
                    {
                        return true;
                    }
                    else{
                        matrix[row][col] = 0;
                    }
                }
            }
        }
        else{
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = 9;
        int Matrix[][] = new int[9][9];
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                Matrix[i][j] = sc.nextInt();
            }
        }
        if(solve(Matrix))
        {
            System.out.println("Sudoku is solved");
            for(int i= 0 ;i<9;i++)
            {
                for(int j= 0;j<9;j++)
                {
                    System.out.print(Matrix[i][j] +" ");
                }
                System.out.println("");
            }
        }
        else{
            System.out.println("Sudoku is not solved");
        }
    }
    
}