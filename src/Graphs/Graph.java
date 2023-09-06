package Graphs;

import java.util.*;

public class Graph {

    public List<List<Pair>> adjList;
    
    public Graph(int n){
        adjList = new LinkedList<>();
        for (int i = 0; i <= n; i++){
            adjList.add(new LinkedList<>());
        }
    }
}
