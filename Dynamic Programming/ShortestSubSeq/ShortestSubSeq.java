import java.util.*;

public class ShortestSubSeq {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int len1 = str1.length();
        int len2 = str2.length();
        int mat[][] = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++)
        Arrays.fill(mat[i],0);

        for(int i=0;i<len1;i++)
        {
            mat[i][0] = i;
        }
        for(int j=0;j<len2;j++)
        {
            mat[0][j] = j;
        }

        for(int i=1;i<=len1;i++)
        {
            for(int j=1;j<=len2;j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                {
                    mat[i][j] = 1+mat[i-1][j-1];
                }
                else{
                    mat[i][j] = 1 + Math.min(mat[i-1][j],mat[i][j-1]);
                }
            }
        }
        for(int i=0;i<=len1;i++)
        {
            for(int j=0;j<=len2;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("Length of the subsequence is "+ mat[len1][len2]);

        printSequence(mat,len1,len2,str1,str2,"");
    }
    public static void printSequence(int [][]mat,int len1,int len2,String str1,String str2,String out)
    {
        if(len1 == 0 || len2 == 0 )
        {
            System.out.println(out);
            return ;
        }

        
        if(str1.charAt(len1-1)== str2.charAt(len2-1))
        {
            printSequence(mat, len1-1, len2-1, str1, str2,str1.charAt(len1-1)+out);   
        }
        else{
            if(mat[len1-1][len2] == mat[len1][len2-1])
            {
                printSequence(mat, len1-1, len2, str1, str2,out);
                printSequence(mat, len1, len2-1, str1, str2,out);
            }
            else if(mat[len1-1][len2] < mat[len1][len2-1])
            {
                printSequence(mat, len1-1, len2, str1, str2,out);
            }
            else{
                printSequence(mat, len1, len2-1, str1, str2,out);
            }
        }
        
    }
}