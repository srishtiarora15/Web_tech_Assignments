
import java.util.Scanner;
public class Main
{
   
	public static void main(String[] args) {
		int[] limit = new int[21];
		for(int i=0; i<21; i++){
		    limit[i]=0;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number of elements you want too sort");
		int n = sc.nextInt();
		for(int i=0; i<n; i++){
		  //  limit[num]++;
	        System.out.println("enter the number");
	        int num = sc.nextInt();
	        limit[num]++;
		}
		System.out.println("sorted array:");
		for(int i=0; i<21; i++){
		    while(limit[i] > 0){
		        System.out.println(i+" ");
		        limit[i]--;
		    }
		}
	}
}
