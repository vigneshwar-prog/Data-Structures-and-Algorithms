import java.util.*;


public class WordBreak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String dict[] = sc.nextLine().split("\\s+");
        String input = sc.nextLine();
        List<String> list = Arrays.asList(dict);          
        Solve(list,input,0,"");
    }
    

    private static void Solve(List<String> dict, String input, int index, String output) {
        if(index == input.length())
        {
            System.out.println(output.trim());
        }
        
        for(int i=index;i<input.length();i++)
        {
            String dummy = input.substring(index,i+1);
            if(dict.contains(dummy))
            {
                Solve(dict,input,i+1,output+dummy+" ");
            }
        }
    }
}