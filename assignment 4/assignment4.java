import java.util.Scanner;
public class assignment4{
    public static void main(String[] args){
        int n;
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    int m;
    m = in.nextInt();
   
    String[] crops = new String[n];
    for (int i=0;i<m;i++){
        String input = null;
        while(input == null || input.length()!=m){
            input=in.next();
        }
        crops[i]=input;
    }
    in.close();

    System.out.print(replant(crops));
}
    public static int replant(String[] crops){
    // Write your code here
    // Return the number of replanted crops
    return 0;
        
    }
}


import java.util.Scanner;
import java.util.*;
import java.lang.Math.*;
public class assignment4
{
    public static void main(String[] args)
    {
        int n, m;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        in.nextLine(); 
        String temp;
        String[] crops = new String[n];
        for (int i=0;i<n;i++)
        {
            crops[i]=in.nextLine().trim();
        }
        char[][] crops_matrix = new char[n][m];
        for(int i=0; i<n; i++)
        {
            for(int j=0;j<m; j++)
            {
                crops_matrix[i][j] = crops[i].charAt(j);
            }
        }
        char[] types = new char[26];
        for(char c='a'; c<'z'; c++)
        {
            types[c-'a'] = c;
        }
//         System.out.println(n + " " + m);
//         for(int i=0; i<n; i++)
//         {
//             for(int j=0;j<m;j++)
//             {
//                 System.out.println(crops_matrix[i][j] + " ");
//             }
//             System.out.println();
//         }
        System.out.println(replant(crops_matrix, 0, 0, n, m, 0, n*m, types));
    }

    public static int replant(char[][] crops_matrix, int current_row, int current_col, int n, int m, int current_count, int min_count, char[] types)
    {
        Set<Character> left_up = new HashSet<Character>();
        if(current_row!=0)
        {
            left_up.add(crops_matrix[current_row-1][current_col]);
        }
        if(current_col!=0)
        {
            left_up.add(crops_matrix[current_row][current_col-1]);
        }
        Set<Character> right_down = new HashSet<Character>();
        if(current_row!=n-1)
        {
            right_down.add(crops_matrix[current_row+1][current_col]);
        }
        if(current_col!=m-1)
        {
            right_down.add(crops_matrix[current_row][current_col+1]);
        }
        boolean present_left_up = false;
        if(left_up.contains(crops_matrix[current_row][current_col]))
        {
            present_left_up = true;
        }
        char[][] new_crops_matrix = new char[n][m];
        if(right_down.contains(crops_matrix[current_row][current_col]))
        {
            if(present_left_up)
            {
                for(int k=0; k<26; k++)
                {
                    if(!left_up.contains(types[k]) && !right_down.contains(types[k]))
                    {
                        for(int i=0; i<n; i++)
                        {
                            for(int j=0;j<m;j++)
                            {
                                new_crops_matrix[i][j] = crops_matrix[i][j];
                            }
                        }
                        new_crops_matrix[current_row][current_col] = types[k];
                        if(current_col<m-1)
                        {
                            min_count = Math.min(min_count, replant(new_crops_matrix, current_row, current_col+1, n, m, current_count+1, min_count, types));
                        }
                        else if(current_row<n-1)
                        {
                            min_count = Math.min(min_count, replant(new_crops_matrix, current_row+1, 0, n, m, current_count+1, min_count, types));
                        }
                        else
                        {
                            return Math.min(current_count+1, min_count);
                        }
                        break;
                    }
                }
            }
            else
            {
                if(current_col<m-1)
                {
                    min_count = Math.min(min_count, replant(crops_matrix, current_row, current_col+1, n, m, current_count, min_count, types));
                }
                else if(current_row<n-1)
                {
                    min_count = Math.min(min_count, replant(crops_matrix, current_row+1, 0, n, m, current_count, min_count, types));
                }
                else
                {
                    return Math.min(current_count, min_count);
                }
                for(int k=0; k<26;k++)
                {
                    if(!left_up.contains(types[k]) && !right_down.contains(types[k]))
                    {
                        for(int i=0; i<n; i++)
                        {
                            for(int j=0; j<m; j++)
                            {
                                new_crops_matrix[i][j] = crops_matrix[i][j];
                            }
                        }
                        new_crops_matrix[current_row][current_col] = types[k];
                        if(current_col<m-1)
                        {
                            min_count = Math.min(min_count, replant(new_crops_matrix, current_row, current_col+1, n, m, current_count+1, min_count, types));
                        }
                        else if(current_row<n-1)
                        {
                            min_count = Math.min(min_count, replant(new_crops_matrix, current_row+1, 0, n, m, current_count+1, min_count, types));
                        }
                        else
                        {
                            return Math.min(current_count+1, min_count);
                        }
                        break;
                    }
                }

            }
        }
        else
        {
            if(present_left_up)
            {
                for(int k=0; k<26;k++)
                {
                    if(!left_up.contains(types[k]) && !right_down.contains(types[k]))
                    {
                        for(int i=0; i<n; i++)
                        {
                            for(int j=0;j<m;j++)
                            {
                                new_crops_matrix[i][j] = crops_matrix[i][j];
                            }
                        }
                        new_crops_matrix[current_row][current_col] = types[k];
                        if(current_col<m-1)
                        {
                            min_count = Math.min(min_count, replant(new_crops_matrix, current_row, current_col+1, n, m, current_count+1, min_count, types));
                        }
                        else if(current_row<n-1)
                        {
                            min_count = Math.min(min_count, replant(new_crops_matrix, current_row+1, 0, n, m, current_count+1, min_count, types));
                        }
                        else
                        {
                            return Math.min(current_count+1, min_count);
                        }
                        break;
                    }
                }
            }
            else
            {
                if(current_col<m-1)
                {
                    min_count = Math.min(min_count, replant(crops_matrix, current_row, current_col+1, n, m, current_count, min_count, types));
                }
                else if(current_row<n-1)
                {
                    min_count = Math.min(min_count, replant(crops_matrix, current_row+1, 0, n, m, current_count, min_count, types));
                }
                else
                {
                    return Math.min(current_count, min_count);
                }
            }
        }
        return min_count;
    }
}

// Points:
// 1. Java Generics work for objects and not for primitive data types. To
// store primitive data types, their corresponding wrapper class objects
// are used. These classes just "wrap" around primitive data type to give
// them an object appearance.
// For char, the corresponding wrapper class is Character