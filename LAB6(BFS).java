// Enter the no of nodes : 
// 4
// Enter neighbours of 0: 
// 1 2
// Enter neighbours of 1: 
// 0 3
// Enter neighbours of 2: 
// 0 3
// Enter neighbours of 3: 
// 1 2
// [0, 1, 2, 3]
// Nodes visited : 4
import java.util.*;  

public class GraphExample {
    static int visitedCount=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List< List<Integer>> adj = new ArrayList<>();
        
        System.out.println("Enter the no of nodes : ");
        int n=sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i=0;i<n;i++){
            System.out.println("Enter neighbours of "+i+": ");
            String line=sc.nextLine().trim();
            
            String []parts=line.split(" ");
            for (String part : parts){
                adj.get(i).add(Integer.parseInt(part));
            }
        }
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
