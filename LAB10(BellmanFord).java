// Enter number of nodes and edges:
// 5 8
// Enter each edge in format: from to weight
// 0 1 -1
// 0 2 4
// 1 2 3
// 1 3 2
// 1 4 2
// 3 2 5
// 3 1 1
// 4 3 -3

import java.util.*;  
public class GraphExample {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of nodes and edges : ");
        int n=sc.nextInt();
        int edge=sc.nextInt();
        sc.nextLine();
        List<Edge> edges = new ArrayList<>();
        System.out.println("Enter each edge in format: from to weight");
        for (int i = 0; i < edge; i++) {
            int node = sc.nextInt();
            int next = sc.nextInt();
            int wt = sc.nextInt();
            edges.add(new Edge(node, next, wt));
        }
        
        int dist[]=new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.node] != Integer.MAX_VALUE && dist[e.node] + e.wt < dist[e.next]) {
                    dist[e.next] = dist[e.node] + e.wt;
                }
            }
        }
        for (int i = 0; i <n; i++) {
            System.out.println("Distance to node "+i+" : \n"+dist[i]);
        }
    }
}
class Edge{
    int node;
    int next;
    int wt;
    Edge (int node,int next,int wt){
        this.node=node;
        this.next=next;
        this.wt=wt;
    }
}
