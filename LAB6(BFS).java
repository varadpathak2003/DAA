import java.util.*;  

public class GraphExample {
    static int visitedCount=0;
    public static void main(String[] args) {
        int n = 6; // Number of nodes in the graph
        List< List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        adj.get(0).add(1);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(4);
        adj.get(2).add(1);
        adj.get(2).add(5);
        adj.get(3).add(0);
        adj.get(3).add(4);
        adj.get(4).add(1);
        adj.get(4).add(3);
        adj.get(5).add(2);
        
        Queue <Integer> q=new LinkedList<>();
        boolean [] visited=new boolean[n];
        
        for (int i=0;i<n;i++){
            if (!visited[i]){
                List <Integer> ans=new ArrayList<>();
                q.add(i);
                visited[i]=true;
                bfs(ans,q,adj,visited);
                System.out.println(ans.toString());
            }
        }
         System.out.println("Nodes visited : "+visitedCount);
    }
    
    public static List<Integer> bfs(List <Integer> ans,Queue <Integer> q,List <List <Integer>> adj,boolean []visited){
        
        while (!q.isEmpty()){
            visitedCount++;
            int node=q.poll();
            ans.add(node);
            
            List <Integer> list=adj.get(node);
            for (int neighbor : list){
                if (visited[neighbor]) continue;
                visited[neighbor]=true;
                q.add(neighbor);
            }
        }
        return ans;
    }
}
