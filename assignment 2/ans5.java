import java.util.*;
import java.util.Scanner;
import java.util.HashSet;


public class Main{
    private static boolean search(int A[], int i) {

        for (int k = 0; k < A.length; k++) {
            if (A[k] == i) {
                return true;
            }
        }
        return false;
    }

    //union using arrays
    private static void union(int A[], int B[]) {

        int i = 0;
        int count = 0;
        int C[] = new int[A.length + B.length];

        for (; i < A.length; i++) {
            if (!(search(B, A[i]))) {
                C[count] = A[i];
                count++;
            }
        }

        for (; i < (A.length + B.length); i++) {
            C[count] = B[i - A.length];
            count++;
        }

        System.out.println("This is Union Of 2 Arrays ");
        System.out.println();

        for (int k = 0; k < count; k++) {
            System.out.println(C[k]);
        }
        System.out.println();

    }
    //intersection using arrays
    private static void intersection(int A[], int B[]){
        int m = A.length;
        int n = B.length;
        int i=0, j=0;
        System.out.println("intersection of arrays is: ");
        while(i<m && j<n){
            if(A[i]<B[i]){
                i++;
            }
            else if(B[j]<A[i]){
                j++;
            }
            else{
                System.out.println(B[j++]+" ");
            }
        }
    }
    //complement uisng arrays
    private static void complement(int A[]){
        int n = A.length;
        int ans[] = new int[n];
        for(int i=0; i<n; i++){
            if(A[i]==0){
                ans[i]=1;
            }
        }
        System.out.println("complement of set using array");
        for(int i=0; i<n; i++){
            if(ans[i]==1){
                System.out.println(i+" ");
            }
        }
    }
    
    //union using sets
    private static HashSet<Integer> h_union(HashSet<Integer> A, HashSet<Integer> B){
        HashSet<Integer> ans = new HashSet<Integer>(A);
        ans.addAll(B);
        System.out.println("union using set: "+ans);
        return ans;
    }
    
    private static HashSet<Integer> h_intersection(HashSet<Integer> A, HashSet<Integer> B){
        HashSet<Integer> ans = new HashSet<Integer>(A);
        ans.retainAll(B);
        System.out.println("intersection using set: "+ans);
        return ans;
    }
    
    private static HashSet<Integer> h_complement(HashSet<Integer>universal, HashSet<Integer> A){
        HashSet<Integer> ans = new HashSet<Integer>(universal);
        ans.removeAll(A);
        System.out.println("complement using set: "+ans);
        return ans;
    }

        
        
    public static void main(String[] args){
        int total = 11; 
        int[] universal = new int[total];
        for(int i=0; i<total; i++){
            universal[i]=1;
        }
        
        HashSet<Integer> universal_set = new HashSet<Integer>();
        for(int i=0; i<total; i++){
            universal_set.add(i);
        }
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("enter size of set A");
        int a = sc.nextInt();
        int[] A = new int[total];
        HashSet<Integer> A_set = new HashSet<Integer>();
        for(int i=0; i<a; i++){
            System.out.println("element of set A");
            int num = sc.nextInt();
            A[num]=1;
            A_set.add(num);
        }
        System.out.println("enter size of set B");
        int b = sc.nextInt();
        int[] B = new int[total];
        HashSet<Integer> B_set =new HashSet<Integer>();
        for(int i=0; i<b; i++){
            System.out.println("element of set B");
            int num = sc.nextInt();
            B[num]=1;
            B_set.add(num);
        }
        
        //union using arrays
        long startTime = System.nanoTime();
        union(A, B);
        System.out.println();
        long stopTime = System.nanoTime();
        long timeElapsed1 = (stopTime-startTime)/1000;
        
        //union using set
        startTime = System.nanoTime();
        h_union(A_set, B_set);
        stopTime = System.nanoTime();
        long timeElapsed2 = (stopTime-startTime)/1000;
        
        
        System.out.println("The time taken for union using ARRAYS: "+timeElapsed1+"ms");
        System.out.println("The time taken for union using SETS: "+timeElapsed2+"ms");
        
        //intersection using arrays
        startTime = System.nanoTime();
        intersection(A, B);
        System.out.println();
        stopTime = System.nanoTime();
        timeElapsed1 = (stopTime-startTime)/1000;
        
        //intersection using sets
        startTime=System.nanoTime();
        h_intersection(A_set, B_set);
        stopTime = System.nanoTime();
        timeElapsed2 = (stopTime-startTime)/1000;
        
        System.out.println("The time taken for intersection using ARRAYS: "+timeElapsed1+"ms");
        System.out.println("The time taken for intersection using SETS: "+timeElapsed2+"ms");
        
        //complement using arrays
        startTime=System.nanoTime();
        complement(A);
        System.out.println();
        stopTime=System.nanoTime();
        timeElapsed1=(stopTime-startTime)/1000;
        
        //complement using sets
        startTime=System.nanoTime();
        h_complement(universal_set, A_set);
        stopTime= System.nanoTime();
        timeElapsed2=(stopTime-startTime)/1000;
        
        System.out.println("The time taken for complement using ARRAYS: "+timeElapsed1+"ms");
        System.out.println("The time taken for complement using SETS: "+timeElapsed2+"ms");
        
        System.out.println("Sets is more effecient than arrays since they consume less time to evaluate set operations")
    }
}