
import java.util.Scanner;
public class Main
{
   
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the first string");
		String a = sc.nextLine();
		System.out.println("enter the second string");
		String b = sc.nextLine();
		
		int x = a.length();
		int y = b.length();
		boolean found = false;
		for(int i=0; i<x; i++){
		    if(i>=y||a.charAt(i)>b.charAt(i)){
		        System.out.println("the smaller string is: "+b);
		        found = true;
		        break;
		    }
		    if(a.charAt(i)<b.charAt(i)){
		        System.out.println("the smaller string is: "+a);
		        found = true;
		        break;
		    }
		    if(!found&&y==x){
		        System.out.println("strings are similar");
		    }
		    else if(!found){
		        System.out.println("the smaller string is: "+a);
		    }
		}
	}
}
