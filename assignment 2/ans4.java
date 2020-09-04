import java.util.Scanner;
public class Main
{
   
	public static void main(String[] args) {
	    long sum = 1; 
	    long num = 1;
	    while(num<=Integer.MAX_VALUE){
	        if(sum==num*num){
	            System.out.println(num);
	        }
	        num++;
	        sum+=num;
	    }
	}
}