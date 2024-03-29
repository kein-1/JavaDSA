package Graphs;

import java.util.*;

// Undirected graph 

public class UndirectedGraph {
    // public List<List<Integer>> adjList;
    public List<List<Pair>> adjList;


    public UndirectedGraph(int n){
        adjList = new LinkedList<>();
        for (int i = 0; i < n; i++){
            adjList.add(new LinkedList<>());
        }
    }
        
    public void printGraphDFS(int[] visited, int curr){
        if (visited[curr] == -1) return;
        
        visited[curr] = -1;
        System.out.println("Curr node : " + curr);
        
        List<Integer> neighbors = adjList.get(curr);
        for (int i : neighbors){
            printGraphDFS(visited, i);
        }
    }

    public boolean detectCycleDFS(int[] visited, int curr, int parent){

        // We can't run a visited[curr] == -1 return here because we are checking for a cycle 

        visited[curr] = -1;

        List<Integer> neighbors = adjList.get(curr);
        for (int i : neighbors){
            
            // Equal to parent, so skip and continue
            if (i == parent) continue;

            // Node has been visited but that node is NOT a parent of this current node. So return true since 
            // cycle has been found 
            if (visited[i] == -1 && i != parent) return true; 

            // Don't need to check visited. Just run the DFS on this node 
            if (detectCycleDFS(visited,i,curr)) return true;
        }

        // No cycle present so return false. We reach here if say this is a node and its only edge is to its parent
        // The first condition above would not run since i == parent 
        // Second condition would not run since visited[i] is == -1 (the parent is visited)

        return false;
    }



    public boolean detectCycleBFS(int[] visited, int curr, int parent){

        visited[curr] = -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{curr,parent});

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++){
                int[] pair = queue.remove();
                int val = pair[0], valParent = pair[1];

                // Get current node's neighbors
                List<Integer> neighbors = adjList.get(val);
                
                // Get its neighbors. If the node has neighbors that have been visited and it is not the node's parent, return false 
                // Otherwise, just check if it has not been visited 

                for (int vertex : neighbors){
                    // Equal to parent, so skip and continue
                    if (vertex == valParent) continue;

                    if (visited[vertex] == -1 && vertex != valParent) return true;

                    // Mark it as visited and add to queue 
                    if (visited[vertex] != -1){
                        visited[vertex] = -1;
                        queue.add(new int[]{vertex,val});
                    }
                }

            }
        }
        return false;
    }



    public void printGraphBFS(int[] visited, int curr){
        
        Queue<Integer> queue = new LinkedList<>();
        visited[curr] = -1;
        queue.add(curr);
        int layer = 0;
        // BFS layer by layer 
        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++){
                int val = queue.remove();
                System.out.println("Curr node and layer: " + val + " " + layer);
                List<Integer> neighbors = adjList.get(val);
                for (int nodeVal : neighbors){
                    if (visited[nodeVal] != -1){
                        visited[nodeVal] = -1;
                        queue.add(nodeVal);
                    }
                }
            }
            layer++;
            System.out.println("");
        }
    }

    // Calculates the shorest path to every node 
    public void bfsDistance(int[] dist, int src){
        if (src > dist.length) return;
        // Set source node's distance to 0;
        dist[src] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int nodeVal = queue.remove();
                List<Integer> neighbors = adjList.get(nodeVal);
                for (int vertex : neighbors){
                    if (dist[vertex] == Integer.MAX_VALUE){
                        dist[vertex] = dist[nodeVal] + 1;
                        queue.add(vertex);
                    }
                }
            }
        }
        for (int i = 0; i < adjList.size(); i++){
            System.out.println(i + " "+  dist[i]);
        }
    }


    public static void main(String[] args) {
        UndirectedGraph g = new UndirectedGraph(8);
        g.adjList.get(0).add(1);
        g.adjList.get(1).add(0);
        g.adjList.get(1).add(2);
        g.adjList.get(1).add(3);
        g.adjList.get(2).add(1);
        g.adjList.get(2).add(4);
        g.adjList.get(3).add(1);
        g.adjList.get(3).add(4);
        
        g.adjList.get(4).add(3);
        g.adjList.get(4).add(2);

        g.adjList.get(3).add(5);
        g.adjList.get(5).add(3);

        g.adjList.get(4).add(6);
        g.adjList.get(6).add(4);
        g.adjList.get(2).add(6);
        g.adjList.get(6).add(7);
        g.adjList.get(7).add(6);

        int[] visited = new int[g.adjList.size()];
        int[] dist = new int[g.adjList.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);

        g.bfsDistance(dist, 2);




    }
}
