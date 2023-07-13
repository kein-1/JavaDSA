package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(115);
        maxHeap.add(5);
        maxHeap.add(12);
        maxHeap.add(15);
        maxHeap.add(20);

        // for (Integer i: maxHeap){
        //     System.out.println(i);
        // }

        while (!maxHeap.isEmpty()){
            System.out.println(maxHeap.remove());
        }

    }
}
