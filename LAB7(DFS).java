// Is Graph Directed  ?: 
// false
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
// Enter starting node : 
// 0
// [0, 1, 3, 2]
import java.util.*;  

public class GraphExample {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Is Graph Directed  ?: ");
        boolean directed=sc.nextBoolean();
        System.out.println("Enter the no of nodes : ");
        int n=sc.nextInt();
        sc.nextLine();
        
         List< List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i=0;i<n;i++){
            System.out.println("Enter neighbours of "+i+": ");
            String line=sc.nextLine().trim();
            
            String []parts=line.split(" ");
            for (String part : parts){
                int next=Integer.parseInt(part);
                adj.get(i).add(next);
                if (!directed){
                    adj.get(next).add(i);
                }
            }
        }
        System.out.println("Enter starting node : ");
        int start=sc.nextInt();
        
        boolean [] visited=new boolean[n];
        List <Integer> ans=new ArrayList<>();
        dfs(start,adj,visited,ans);
        System.out.println(ans);
        
        for (int i=0;i<n;i++){
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, adj, visited, component);
                System.out.println(component);
            }
        }
    }
    
    public static List<Integer> dfs(int node,List <List <Integer>> adj,boolean []visited,List <Integer> ans){
        if (visited[node]){
            return ans;
        }
        visited[node]=true;
        ans.add(node);
        List <Integer> list=adj.get(node);
        for (int neighbor : list) dfs(neighbor,adj,visited,ans);
        return ans;
    }
}
