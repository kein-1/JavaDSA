package Graphs;

import java.util.*;

public class DirectedGraph {
    // public List<List<Integer>> adjList;

    public List<List<Pair>> adjList;
    

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


    public boolean detectCycleDFS(int[] visited, int[] path){

        for (int i = 1; i < visited.length; i++){
            // Not visited, so start a DFS here and check if there is a cycle present
            if (visited[i] != -1){

                // If true, it means there is a cycle in this path. We return true 
                if (detectCycleDFSHelper(visited, path, i)){
                    return true; 
                }
            }
        }
        return false;

        
    }


    public boolean detectCycleDFSHelper(int[] visited, int[] path, int curr){
        

        // We been here BUT this node is in our current path. Return true; 
        if (visited[curr] == -1 && path[curr] == -1){
            // System.out.println("This node is in our cycle: " + curr);
            return true;
        }
        
        // We been here AND this node is not in our path, return false 
        // if (visited[curr] == -1 && path[curr] == 0) return false;


        visited[curr] = -1;
        path[curr] = -1;
        List<Integer> neighbors = adjList.get(curr);
        System.out.println(Arrays.toString(path));
        for (int v : neighbors){

            
            // Otherwise, we run a DFS on this vertex since it has not been explored
            // We return true IF there is a cycle somewhere in this path 
            if (detectCycleDFSHelper(visited, path, v)){
                System.out.println("This node is in our cycle: " + curr);
                return true;
            }

        }
        // Done with this node, so set path back to 0
        path[curr] = 0;

        return false;


    }


    public boolean detectCycleBFS(int[] visited, int curr, int parent){

        
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

    public void buildGraph(DirectedGraph g){
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

    }


    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(11);
        g.buildGraph(g);

        int[] visited = new int[11];
        int[] path = new int[11];

        visited[0] = -1;

        System.out.println(g.detectCycleDFS(visited, path));
        // g.printGraphDFS(visited);
        // g.printGraphBFS(visited, 0);
        // System.out.println(g.detectCycleDFS(visited, 0, -1));
        // System.out.println(g.detectCycleBFS(visited, 0, -1));
    }
}

