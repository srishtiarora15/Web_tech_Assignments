import java.util.*;
public class solution
{
       int paths[];
       int vertices;
       public static final int MAX_VALUE = 999;
  
    public solution(int vertices)
    {
        this.vertices = vertices;
        paths = new int[vertices + 1];
    }
 
    public void SolutionEvaluation(int source, int am[][])
    {
        for (int node = 1; node <= vertices; node++)
        {
            paths[node] = MAX_VALUE;
        }
 
        paths[source] = 0;
        for (int node = 1; node <= vertices - 1; node++)
        {
            for (int sr= 1; sr<= vertices; sr++)
            {
                for (int des = 1; des<= vertices; des++)
                {
                    if (am[sr][des] != MAX_VALUE)
                    {
                        if (paths[des] > paths[sr]  + am[sr][des])paths[des] =paths[sr] + am[sr][des];
                    }
                }
            }
        }
 
        for (int sr= 1; sr <= vertices;sr++)
        {
            for (int des = 1; des <= vertices; des++)
            {
                if (am[sr][des] != MAX_VALUE)
                {
                    if (paths[des] > paths[sr]
                           + am[sr][des])
                        System.out.println("The Graph contains negative egde cycle");
                }
            }
        }
 
        for (int v = 1; v <= vertices; v++)          // vertex
        {
            System.out.println("distance of source  " + source + " to "
                      + v + " is " + paths[v]);
        }
    }
 
    public static void main(String[] arg)
    {
        int vertices= 0;           //Number of vertices present
        int source;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        vertices=sc.nextInt();
		sc.nextLine();
       
 
        int am[][] = new int[vertices+ 1][vertices + 1];     // matrix
        
        System.out.println("Enter the adjacency matrix");
        for (int sr = 1; sr<=vertices; sr++)      // for source nodes
        {
            for (int des = 1; des <= vertices; des++)   // destination nodes
            {
                am[sr][des] = sc.nextInt();
 	        if (sr == des)
                {
                    am[sr][des] = 0;
                    continue;
                }
            if (am[sr][des] == 0)
                {
                    am[sr][des] = MAX_VALUE;                 
                }
            }
        }
 
        System.out.println("Enter the source vertex");
        source = sc.nextInt();
 
        solution sol = new solution(vertices);
        sol.SolutionEvaluation(source, am);
        sc.close();	
    }
}