// Enter the no of nodes : 
// 3
// Enter the weight between 0 and 0 : 
// 0
// Enter the weight between 0 and 1 : 
// 3
// Enter the weight between 0 and 2 : 
// 4
// Enter the weight between 1 and 0 : 
// 999
// Enter the weight between 1 and 1 : 
// 0
// Enter the weight between 1 and 2 : 
// 1
// Enter the weight between 2 and 0 : 
// 999
// Enter the weight between 2 and 1 : 
// 999
// Enter the weight between 2 and 2 : 
// 0
// Distance from node 0 : 

// To 0 : 0
// To 1 : 3
// To 2 : 4
//  Distance from node 1 : 

// To 0 : 1000000000
// To 1 : 0
// To 2 : 1
//  Distance from node 2 : 

// To 0 : 1000000000
// To 1 : 1000000000
// To 2 : 0
import java.util.*;  

public class GraphExample {
    public static void main(String[] args) {
        int inf=(int)1e9;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of nodes : ");
        int n=sc.nextInt();
        sc.nextLine();
        
       int [][]adj=new int[n][n];
       int dist[][]=new int[n][n];
       
       for (int i=0;i<n;i++){
           for (int j=0;j<n;j++){
              System.out.println("Enter the weight between "+i+" and "+j+" : "); 
              adj[i][j]=sc.nextInt();
              if (adj[i][j]==999){
                  adj[i][j]=inf;
              }
               dist[i][j]=adj[i][j];
           }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != inf && dist[k][j] != inf) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        
        for (int i = 0; i <n; i++) {
            System.out.println("Distance from node "+i+" : \n");
            for (int j=0;j<n;j++){
                System.out.println("To "+j+" : "+dist[i][j]);
            }
            System.out.print(" ");
        }
    }
}
