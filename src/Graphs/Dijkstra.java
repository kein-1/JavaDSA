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

        undirGraph.adjList.get(0).add(new Pair(1, 4));
        undirGraph.adjList.get(0).add(new Pair(2, 4));
        
        undirGraph.adjList.get(1).add(new Pair(0, 4));
        undirGraph.adjList.get(1).add(new Pair(2, 2));

        undirGraph.adjList.get(2).add(new Pair(0, 4));
        undirGraph.adjList.get(2).add(new Pair(1, 2));
        undirGraph.adjList.get(2).add(new Pair(3, 3));
        undirGraph.adjList.get(2).add(new Pair(5, 6));
        undirGraph.adjList.get(2).add(new Pair(4, 1));
        
        undirGraph.adjList.get(3).add(new Pair(2, 3));
        undirGraph.adjList.get(3).add(new Pair(5, 2));

        undirGraph.adjList.get(5).add(new Pair(3, 2));
        undirGraph.adjList.get(5).add(new Pair(4, 3));
        undirGraph.adjList.get(5).add(new Pair(2, 6));

        undirGraph.adjList.get(4).add(new Pair(2, 1));
        undirGraph.adjList.get(4).add(new Pair(5, 3));


    }

    public void dijkstraShortestPath(int src, Graph graph){
        Queue<Integer> queue = new PriorityQueue<>( (a,b) -> dist[a] - dist[b]);
        dist[src] = 0;
        queue.add(src);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                System.out.println(queue);

                int node = queue.remove();
                List<Pair> neighbors = graph.adjList.get(node);
                for (Pair p : neighbors){
                    int destNode = p.dest;
                    int cost = p.cost;

                    // Cost to reach to this neighbor. If less than current dist, update and add to queue 
                    int destCost = dist[node] + cost;
                    if (destCost < dist[destNode]){
                        dist[destNode] = destCost;
                        queue.add(destNode);
                    }
                }
            }
        }
    }   

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra(7);
        dijkstra.buildGraph();
        dijkstra.dijkstraShortestPath(0,dijkstra.undirGraph);
        int[] dist = dijkstra.dist;
        for (int i = 0; i < dist.length; i++){
            System.out.println(i + " " + dist[i]);
        }

       
        
    }

}
