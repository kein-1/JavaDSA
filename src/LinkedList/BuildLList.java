package LinkedList;

public class BuildLList {
    

    ListNode head;

    public BuildLList(){
        this.head = null;
    }

    public ListNode buildListRecursively(int nums[],int p1){
        if (p1 + 1 == nums.length){
            return new ListNode(nums[p1]);
        }

        ListNode newNode = new ListNode(nums[p1]);
        newNode.next = buildListRecursively(nums, ++p1);
        return newNode;

    }

    public void printList(ListNode node){
        ListNode curr = node;
        while (curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
    }


    public static void main(String[] args) {
        BuildLList list = new BuildLList();
        int[] nums = new int[]{1,2,3,4,5};
        list.head = list.buildListRecursively(nums, 0);
        list.printList(list.head);
    }


    private class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }


}

