import java.io.*; 
import java.util.Arrays; 
import java.util.Collections;
import java.util.Scanner;
  
class solution { 
  
    
    static boolean isAnagram(String str1, String str2) 
    { 
         
        int n1 = str1.length(); 
        int n2 = str2.length(); 
  
        
        if (n1 != n2) 
            return false; 
            
        char tempArray1[] = str1.toCharArray();
        char tempArray2[] = str2.toCharArray();
  
         
        Arrays.sort(tempArray1); 
        Arrays.sort(tempArray2); 
  
        
        for (int i = 0; i < n1; i++) 
            if (tempArray1[i] != tempArray2[i]) 
                return false; 
  
        return true; 
    } 
  
    
    public static void main(String args[]) 
    { 
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the first string");
        String str1 = sc.nextLine();
        System.out.println("enter the second string");
        String str2 = sc.nextLine();
        if (isAnagram(str1, str2)) 
            System.out.println("The two strings are"
                               + " anagram of each other"); 
        else
            System.out.println("The two strings are not"
                               + " anagram of each other"); 
    } 
} 