/*package whatever //do not write package name here */
import java.util.*;
import java.util.Scanner;
public class Main
{
    public static int compare(String s1, String s2){
        for(int i=0; i<s1.length()&& i<s2.length(); i++){
            if((int)s1.charAt(i)==(int)s2.charAt(i)){
                continue;
            }
            else{
                return (int)s1.charAt(i)-(int)s2.charAt(i);
            }
        }
        if(s1.length()<s2.length()){
            return (s1.length()-s2.length());
        }
        else if(s1.length()>s2.length()){
            return (s1.length()-s2.length());
        }
        else{
            return 0;
        }
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter first string");
		String string1=sc.nextLine();
		System.out.println("enter second string");
		String string2=sc.nextLine();
		System.out.println(compare(string1, string2));
	}
}
