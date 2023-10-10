package MinimumSpanningTrees;

import java.util.*;

public class Prims {

    class Pair {
        int dest;
        int cost;
        public Pair(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }

    public List<List<Pair>> adj;
    public int minCost;

    public Prims() {
        this.adj = new LinkedList<>();
        minCost = 0;
        for (int i = 0; i < 7; i++) adj.add(new LinkedList<>());
    }


    public void buildGraph(int src, int dest, int cost){
        adj.get(src).add(new Pair(dest,cost));
        adj.get(dest).add(new Pair(src,cost));
    }

    public void printGraph(int[] visited, int curr, int parent, int cost){
        if (visited[curr] == -1) return;
        visited[curr] = -1;
        System.out.println("The node here is and the cost and parent is: " + curr + " " + parent + " " + cost);

        List<Pair> neighbors = adj.get(curr);
        for (Pair p : neighbors){
            printGraph(visited, p.dest, curr, p.cost);
        }
    }

    public List<int[]> getMST(int src){
        List<int[]> ans = new LinkedList<>();

        // Key point here : use visited but mark it as visited only after we remove it from the priority queue
        // unlike other bfs algos which mark when we add to queue
        int[] visited = new int[7];
        
        // Stores [curr,parent,edge cost]
        Queue<int[]> heap = new PriorityQueue<>((a,b) -> a[2] - b[2]);

        heap.add(new int[]{0,-1,0});

        while (!heap.isEmpty()){
            int[] group = heap.remove();
            int curr = group[0];
            int parent = group[1];
            int cost = group[2];
            
            // If this node has already been visited, skip it
            if (visited[curr] == -1) continue;
            
            // Mark as visited when we remove from the heap
            visited[curr] = -1;

            // Ensure it is not the starting node. Add the pair and update its cost to the class' cost 
            if (curr != src){
                int[] mstPair = new int[]{curr,parent};
                ans.add(mstPair);
                minCost += cost;
            }

         
            List<Pair> neighbors = adj.get(curr);
            for (Pair p : neighbors){
                int dest = p.dest;
                int weight = p.cost;

                // If this neighboring node has not been visited, add it
                if (visited[dest] != -1){
                    heap.add(new int[]{dest,curr,weight});
                }
            }

        }


        return ans;
    }

    


    public static void main(String[] args) {
        Prims p = new Prims();
        p.buildGraph(0,1, 2);
        p.buildGraph(3,0, 6);
        p.buildGraph(3,1, 8);
        p.buildGraph(1,4, 5);
        p.buildGraph(1,2, 3);
        p.buildGraph(4,2, 7);


        // int[] visited = new int[7];
        // p.printGraph(visited, 0, -1, 0);
        List<int[]> mst = p.getMST(0);

        for(int[] pair : mst){
            System.out.println("These are the vertices in the MST: " + pair[0] + " " + pair[1]);
        }
        System.out.println("The cost of the mst is :" + p.minCost);

    }
}
