package Graphs;

import java.util.*;



// Topological sort 
public class DirectedGraph2 {
    public List<List<Integer>> adjList;
    public List<Integer> topologicalSortedListDFS;
    public List<Integer> topologicalSortedListBFS;


    public DirectedGraph2(int n){
        adjList = new LinkedList<>();
        topologicalSortedListDFS = new LinkedList<>();
        topologicalSortedListBFS= new LinkedList<>();
        for (int i = 0; i < n; i++){
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
        if (visited[curr] == -1 && path[curr] == 0) return false;


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

    public void topologicalSortDFS(){

    }

    public void topologicalSortBFS(int n){
        int[] inDegree = new int[n];
        inDegree[0] = -1;
        // Go through the graph once and calculate all the indegrees for each node
        // If we have a->b, then b will increase its indegree by 1 
        // So inDegree[b]++;
        for (int i = 0; i < n; i++){
            List<Integer> neighbors = adjList.get(i);
            for (int v : neighbors){
                inDegree[v]++;
            }
        }
        for (int i = 0; i < n; i++){
            System.out.println("vertex and indegree: " + i + " " + inDegree[i]);
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add all nodes with 0 indgrees into the queue 
        for (int i = 0; i < n; i++){
            if (inDegree[i] == 0) queue.add(i);
        }

        // Remove from the queue. This is effectively removing an edge from u to v. So for each of 
        // the removed node's neighbors, decrease their indegree by 1. 
        // If it reaches 0, add this node to the queue. We only add nodes with indegree of 0 to queue 
        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++){
                int val = queue.remove();
                topologicalSortedListBFS.add(val); // add to our list 
                List<Integer> neighbors = adjList.get(val);
                
                // For each of this node's neighbors, decrease their indegree count by 1
                for (int v : neighbors){
                    inDegree[v]--;
                    if (inDegree[v] == 0){
                        queue.add(v);
                    }
                }
            }
            
        }
    }


    public void buildGraph(DirectedGraph2 g){
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
        g.adjList.get(8).add(10);
        // g.adjList.get(10).add(8); // add this and comment out the above code to add cycle 


    }


    public static void main(String[] args) {
        DirectedGraph2 g = new DirectedGraph2(11);
        g.buildGraph(g);
        g.topologicalSortBFS(g.adjList.size());

        for (int i : g.topologicalSortedListBFS){
            System.out.println(i);
        }
    }
}

