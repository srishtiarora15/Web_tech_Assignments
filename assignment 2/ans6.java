/*package whatever //do not write package name here */
import java.util.*;
import java.util.Scanner;
import java.io.Console;
class hailstonenumbers{
    static int c; 
    static int HailStone(int n){
        System.out.print(n+" ");
        if(n==1&&c==0){
            return c;
        }
        else if(n==1&&c!=0){
            c++;
            return c;
        }
        else if(n%2==0){
            c++;
            HailStone(n/2);
        }
        else if(n%2!=0){
            c++;
            HailStone(3*n+1);
        }
        return c;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        int x = HailStone(n);
        System.out.println("Number of steps: "+x);
    }
}