package Graphs;

import java.util.*;

public class DirectedGraph {
    public List<List<Integer>> adjList;

    public DirectedGraph(int n){
        adjList = new LinkedList<>();
        for (int i = 0; i <= n; i++){
            adjList.add(new LinkedList<>());
        }
    }
        
    public void printGraphDFS(int[] visited){

        int componentCount = 0;
        for (int i = 1; i < visited.length; i++){
            if (visited[i] != -1){
                printHelperDFS(visited, i);
                componentCount++;
                System.out.println("Compoenents : " + componentCount);
                System.out.println(" ");

            }
        }
    }

    public void printHelperDFS(int[] visited, int curr){
        if (visited[curr] == -1) return;
        System.out.println("Curr node : " + curr);
        visited[curr] = -1;
        List<Integer> neighbors = adjList.get(curr);
        for (int i : neighbors){
            printHelperDFS(visited, i);
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


    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(11);
        g.adjList.get(1).add(2);
        g.adjList.get(2).add(3);
        g.adjList.get(3).add(4);
        g.adjList.get(3).add(7);
        g.adjList.get(4).add(5);
        g.adjList.get(5).add(6);
        g.adjList.get(7).add(5);

        g.adjList.get(8).add(2);
        g.adjList.get(8).add(9);
        g.adjList.get(9).add(10);
        g.adjList.get(10).add(8);

        int[] visited = new int[11];
        visited[0] = -1;


        g.printGraphDFS(visited);
        // g.printGraphBFS(visited, 0);
        // System.out.println(g.detectCycleDFS(visited, 0, -1));
        // System.out.println(g.detectCycleBFS(visited, 0, -1));
    }
}

