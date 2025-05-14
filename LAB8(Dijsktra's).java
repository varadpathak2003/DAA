// Enter the no of nodes : 
// 4
// Enter the weight between 0 and 0 : 
// 0
// Enter the weight between 0 and 1 : 
// 10
// Enter the weight between 0 and 2 : 
// 5
// Enter the weight between 0 and 3 : 
// -1
// Enter the weight between 1 and 0 : 
// 10
// Enter the weight between 1 and 1 : 
// 2
// Enter the weight between 1 and 2 : 
// 1
// Enter the weight between 1 and 3 : 
// 5
// Enter the weight between 2 and 0 : 
// 2
// Enter the weight between 2 and 1 : 
// 0
// Enter the weight between 2 and 2 : 
// 9
// Enter the weight between 2 and 3 : 
// -1
// Enter the weight between 3 and 0 : 
// 1
// Enter the weight between 3 and 1 : 
// 9
// Enter the weight between 3 and 2 : 
// 0
// Enter the weight between 3 and 3 : 
// 5
// Enter starting node : 
// 0

import java.util.*;  

public class GraphExample {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of nodes : ");
        int n=sc.nextInt();
        sc.nextLine();
        
       int [][]adj=new int[n][n];
       
       for (int i=0;i<n;i++){
           for (int j=0;j<n;j++){
              System.out.println("Enter the weight between "+i+" and "+j+" : "); 
              adj[i][j]=sc.nextInt();
           }
       }
        System.out.println("Enter starting node : ");
        int start=sc.nextInt();
        sc.nextLine();
        
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;
        
        PriorityQueue <int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{start,0});
        while (!pq.isEmpty()){
            int edge[]= pq.poll();
            int node=edge[0];
            int wt=edge[1];
            for (int i=0;i<n;i++){
                if (adj[node][i]==-1) continue;
                
                int currWt=wt+adj[node][i];
                
                if (currWt<dist[i]){
                    dist[i]=currWt;
                    pq.add(new int[]{i,currWt});
                }
            }
        }
        for (int i = 0; i <n; i++) {
                System.out.println("Shortest Path To node " + i + " : " + dist[i]);
        }
    }
}
