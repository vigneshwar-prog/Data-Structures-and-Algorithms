import java.util.*;

public class InsertSequence {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int len1 = str1.length();
        int len2 = str2.length();
        int mat[][] = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++)
        Arrays.fill(mat[i],0);

        for(int i=1;i<=len1;i++)
        {
            for(int j=1;j<=len2;j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                {
                    mat[i][j] = 1+mat[i-1][j-1];
                }
                else{
                    mat[i][j] = Math.max(mat[i-1][j],mat[i][j-1]);
                }
            }
        }
        int len = mat[len1][len2];
        System.out.print(len1 - len);
    }
}
