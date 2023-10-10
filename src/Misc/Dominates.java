package Misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dominates {


    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        List<Pair> list1 = new ArrayList<>();
        list1.add(new Pair(4, 15));
        list1.add(new Pair(16, 7));
        list1.add(new Pair(8, 9));

        list1.add(new Pair(6, 5));
        list1.add(new Pair(18, 2));
        list1.add(new Pair(7, 4));

        List<Pair> ans = function(list1,0,list1.size()-1);
        System.out.println(ans.size());
        for (Pair p : ans){
            System.out.println(p.x + " " + p.y);
        }
          
    }

    public static List<Pair> function(List<Pair> list, int start, int end){
        if (start == end){
            List<Pair> l = new LinkedList<>();
            Pair temp = list.get(start);
            l.add(new Pair(temp.x,temp.y));

            return l;
        }
        int mid = start + (end-start)/2;
        List<Pair> left = function(list,start,mid);
        List<Pair> right = function(list,mid+1,end);


        List<Pair> merged = merge(left,right);

     

        return merged;

    }
    public static List<Pair> merge(List<Pair> list1, List<Pair> list2){

        List<Pair> ans = new LinkedList<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for (Pair p : list1){
            minX = Math.min(p.x, minX);
            minY = Math.min(p.y,minY);
            maxX = Math.max(p.x,maxX);
            maxY = Math.max(p.y,maxY);
            ans.add(p);
        }
        System.out.println("Numbs " + minX + " " + minY + " " + maxX + " " + maxY);

        for (Pair p : list2){
            System.out.println("my p.x and p.y " + p.x + " " + p.y);
            if (p.x >= maxX || p.y >= maxY) {
                ans.add(p);
            } else if (p.x >= minX && p.x <= maxX && p.y >= minY && p.y <= maxY){
                ans.add(p);
            } 
            else {
                System.out.println("dominates");
            }
        }
        return ans;

    }

}
