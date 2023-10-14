package UnionFind;

public class UnionFind {

    // Array of each element's ultimate parent, which is initially itself
    int[] parents;
    
    // Array of elements ranks. Ranks represent the strength. We always merge smaller guys to bigger guys
    int[] ranks;

    public UnionFind(){
        this.parents = new int[8];
        this.ranks = new int[8];

        for (int i = 0; i < 8; i++){
            ranks[i] = 0;
            parents[i] = i;
        }
    }

    // Finds the representative of the letter c. Applies path compression along the way recursively
    // This means each along the way to find, we recursively set each node's parent to the ultimate parent node that we end up finding
    // Represented as tree like but when we recurse, we go reverse top down i.e 1->5->3, find(3) goes 3->5->1. We find 1 is the ultimate parent
    // so we return 1. then in 5's function call, it sets its parent to 1, then it also returns 1
    // Apply path compression
    public int find(int node){
        if (parents[node] == node) return parents[node];
        
        int ultimateParent = find(parents[node]);
        parents[node] = ultimateParent;
        return ultimateParent;
        
    }

    // Combines two elements into one set. Finds the representative of each value first 
    public void combine(int node1, int node2){
        int u = find(node1);
        int v = find(node2);
        // Same component
        if (u == v) return;

        // Same rank, so absorb v into u and increase ranking of u
        // Otherwise, smaller rank gets absorbed to larger
        if (ranks[u] == ranks[v]){
            parents[v] = u;
            ranks[u]++;
        } else if (ranks[u] < ranks[v]){
            parents[v] = u;
        } else {
            parents[u] = v;
        }
    }
    
    public void printRanks(){
        for (int i = 0; i < ranks.length; i++){
            System.out.println("My value is " + i + " and my rank is : " + ranks[i]);
        }
    }

    public void printParents(){
        for (int i = 0; i < parents.length; i++){
            System.out.println("My value is " + i + " and my representative is : " + parents[i]);
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind();
        uf.combine(1,2);
        uf.combine(2, 3);
        uf.combine(4, 5);
        uf.combine(6, 7);
        uf.combine(5, 6);
        uf.combine(3,7);
        uf.printParents();
        uf.printRanks();

    }
}
