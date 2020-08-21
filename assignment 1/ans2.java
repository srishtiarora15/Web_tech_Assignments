import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.*;

public class WordReplacer {
    public static void main(String[] args) {
        Vector substrings = new Vector();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of substrings you want to change");
        int n = sc.nextInt();
        for(int i=0; i<=n; i++){
            String str = sc.nextLine();
            substrings.addElement(str);
        }

        List <String> wordsToReplace = substrings;

        System.out.println("enter the paragraph");
        String para = sc.nextLine();
        System.out.println(replaceWords(para, wordsToReplace));
    }

    private static String replaceWords(String word, List <String> wordsToReplace) {
        for (String s : wordsToReplace) {
            Pattern p = Pattern.compile(s, Pattern.CASE_INSENSITIVE); 
            Matcher m = p.matcher(word); 
            StringBuilder sb = new StringBuilder();
            if (m.find()) { 
                for (int i = 0; i < s.length(); i++) {
                    sb.append("*");
                }
            }

            word = m.replaceAll(sb.toString()); 
        }

        return word; 
    }
}