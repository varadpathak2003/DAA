//Enter the no of nodes :
// 3
// Enter source :
// 0
// Enter the adjacency matrix (999 for no edge):
// 0 1 3
// 1 0 2
// 3 2 0

import java.util.*;

public class GraphExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of nodes : ");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter source : ");
        int src = sc.nextInt();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        int[][] adj = new int[n][n];
        System.out.println("Enter the adjacency matrix (999 for no edge):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = sc.nextInt();
                if (adj[i][j] == 999) adj[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0});

        boolean[] visited = new boolean[n];
        List<int[]> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int node = edge[0];
            int wt = edge[1];

            if (visited[node]) continue;

            visited[node] = true;
            ans.add(new int[]{node, wt});

            for (int i = 0; i < n; i++) {
                if (adj[node][i] != Integer.MAX_VALUE) {
                    int currWt = wt + adj[node][i];
                    if (dist[i] > currWt) {
                        dist[i] = currWt;
                        pq.add(new int[]{i, currWt});
                    }
                }
            }
        }

        // Output the result MST
        for (int[] a : ans) {
            System.out.println(Arrays.toString(a));
        }
    }
}
