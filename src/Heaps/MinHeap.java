package Heaps;

import java.util.*;

public class MinHeap {
    public static void main(String[] args) {
        
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(8);
        pq.add(1);
        pq.add(90);
        pq.add(44);
        pq.add(9);


        while (!pq.isEmpty()){
            int i = pq.remove();
            System.out.println(i);
        }

    }
}
