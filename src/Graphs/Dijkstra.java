package Graphs;


import java.util.*;

class Pair {
    int dest;
    int cost;
    public Pair (int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }
}   

public class Dijkstra {
    
    // graph + distance array 
    Graph directedGraph; 
    Graph undirGraph;
    
    // Distances for directed and undirected 
    int[] dist; 
    int[] dist2;
    
    public Dijkstra(int n){
        directedGraph = new Graph(n);
        undirGraph = new Graph(n);
        dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

    }


    public void buildGraph(){
        directedGraph.adjList.get(1).add(new Pair(2, 2));
        directedGraph.adjList.get(1).add(new Pair(3, 4));
        directedGraph.adjList.get(2).add(new Pair(3, 1));
        directedGraph.adjList.get(2).add(new Pair(4, 7));
        directedGraph.adjList.get(3).add(new Pair(5, 3));
        directedGraph.adjList.get(5).add(new Pair(6, 5));
        directedGraph.adjList.get(5).add(new Pair(4, 2));
        directedGraph.adjList.get(4).add(new Pair(6, 1));

        // undirGraph.adjList.get(0).add(new Pair(1, 4));
        // undirGraph.adjList.get(0).add(new Pair(2, 4));
        
        // undirGraph.adjList.get(1).add(new Pair(0, 4));
        // undirGraph.adjList.get(1).add(new Pair(2, 2));

        // undirGraph.adjList.get(2).add(new Pair(0, 4));
        // undirGraph.adjList.get(2).add(new Pair(1, 2));
        // undirGraph.adjList.get(2).add(new Pair(3, 3));
        // undirGraph.adjList.get(2).add(new Pair(5, 6));
        // undirGraph.adjList.get(2).add(new Pair(4, 1));
        
        // undirGraph.adjList.get(3).add(new Pair(2, 3));
        // undirGraph.adjList.get(3).add(new Pair(5, 2));

        // undirGraph.adjList.get(5).add(new Pair(3, 2));
        // undirGraph.adjList.get(5).add(new Pair(4, 3));
        // undirGraph.adjList.get(5).add(new Pair(2, 6));

        // undirGraph.adjList.get(4).add(new Pair(2, 1));
        // undirGraph.adjList.get(4).add(new Pair(5, 3));


        
        undirGraph.adjList.get(1).add(new Pair(4, 1));
        undirGraph.adjList.get(1).add(new Pair(2, 2));

        undirGraph.adjList.get(4).add(new Pair(1, 1));
        undirGraph.adjList.get(4).add(new Pair(3, 3));

        undirGraph.adjList.get(3).add(new Pair(2, 4));
        undirGraph.adjList.get(3).add(new Pair(4, 3));
        undirGraph.adjList.get(3).add(new Pair(5, 1));
        

        undirGraph.adjList.get(2).add(new Pair(1, 2));
        undirGraph.adjList.get(2).add(new Pair(5, 5));
        undirGraph.adjList.get(2).add(new Pair(3, 4));

        undirGraph.adjList.get(5).add(new Pair(2, 5));
        undirGraph.adjList.get(5).add(new Pair(3, 1));
    }

    /**
     * Shortest path to each node starting from src node 
     * @param src - source node 
     * @param graph - graph 
     */

    public void dijkstraShortestPath(int src, Graph graph){
        // PQ - Store a pair of the node and its current shortest distance
        // Sorted by distance
        Queue<Pair> queue = new PriorityQueue<>( (a,b) -> a.cost - b.cost);
        dist[src] = 0;
        queue.add(new Pair(src,0));

        while (!queue.isEmpty()){

            Pair pair = queue.remove();
            int currNode = pair.dest;
            int currCost = pair.cost;

            List<Pair> neighbors = graph.adjList.get(currNode);
            for (Pair p : neighbors){
                int destNode = p.dest;
                int destCost = p.cost;

                // Cost to reach to this neighbor. If less than current dist, update and add to queue 
                int newCost = currCost + destCost;
                if (newCost < dist[destNode]){
                    dist[destNode] = newCost;
                    queue.add(new Pair(destNode,newCost));
                }
            }
        }
    }   

    /**
     * Prints shortest path from src to dest
     * @param graph - graph
     * @param src - starting node 
     * @param dest - destination node
     * @return list of nodes to travel to shortest path 
     */
    public List<Integer> printShortestPath(Graph graph, int src, int dest){
        List<Integer> ans = new LinkedList<>();
        
        // PQ - Store a pair of the node and its current shortest distance
        // Sorted by distance
        Queue<Pair> queue = new PriorityQueue<>( (a,b) -> a.cost - b.cost);
        dist[src] = 0;
        int[] parent = new int[7];
        queue.add(new Pair(src,0));

        while (!queue.isEmpty()){

            Pair pair = queue.remove();
            int currNode = pair.dest;
            int currCost = pair.cost;

            List<Pair> neighbors = graph.adjList.get(currNode);
            for (Pair p : neighbors){
                int destNode = p.dest;
                int destCost = p.cost;

                // Cost to reach to this neighbor. If less than current dist, update and add to queue 
                int newCost = currCost + destCost;
                if (newCost < dist[destNode]){
                    parent[destNode] = currNode;
                    dist[destNode] = newCost;
                    queue.add(new Pair(destNode,newCost));
                }
            }
        }

        int curr = dest;
        while (curr != src){
            ans.add(curr);
            curr = parent[curr];
        }
        ans.add(curr);

        Collections.sort(ans);
        return ans;
    }   

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra(7);
        dijkstra.buildGraph();
        // dijkstra.dijkstraShortestPath(1 ,dijkstra.undirGraph);
        // int[] dist = dijkstra.dist;
        // for (int i = 0; i < dist.length; i++){
        //     System.out.println(i + " " + dist[i]);
        // }

        System.out.println(dijkstra.printShortestPath(dijkstra.undirGraph, 1, 5));

       
        
    }

}
