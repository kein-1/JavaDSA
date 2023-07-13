package LinkedList;
public class LinkedList {

    class Node {
      int val;
      Node next;
      
      public Node(int x){
          this.val = x;
      }
    }
      public Node headNode;
      public Node tailNode;
      public Node getLastNode(){
          Node p = headNode;
          while (p.next != null){
              p = p.next;
          }
          return p;
      }
      
	public void addNode(int val){
          
        Node n = new Node(val);
        if (headNode == null){
            this.headNode = n;
            this.tailNode = n;
            return;
        }
        
        // Operation without tail node 
        // Node p = headNode;
        // while (p.next != null){
        //     p = p.next;
        // }
        // p.next = n;
        
        // Operation with tail node. Tail node getting updated each time an element is added 
        // No need to traverse the list 
        tailNode.next = n;
        tailNode = tailNode.next;
          
      }
      
	public void printList(){
        Node p = headNode;
        while (p != null){
            System.out.print(p.val + " -> ");
            p = p.next;
        }
      }
      
	public void deleteNode(int val){
        Node prev = null;
        Node curr = headNode;
        
        while (curr.val != val){
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
      }
      
	public void reverseList(){
        Node prev = null;
        Node curr = headNode;
        
        while (curr != null){
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        this.headNode = prev;
	}


	public Node reverseSecondHalf(){

		Node slow = headNode;
        Node fast = headNode;

        while (fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next.next;
        }

		Node prev = null;
        Node curr =	slow;
        
        while (curr != null){
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
		return prev;
	}

	public Node getPrevPoint(){
        Node slow = headNode;
        Node fast = headNode;
		Node prev = null;
        while (fast != null && fast.next != null){
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
        }
		return prev;
    }
  
	public static void main(String[] args) {
        LinkedList head = new LinkedList();
          
        head.addNode(1);
        head.addNode(2);
        head.addNode(3);
        head.addNode(4);
        head.addNode(5);
        head.addNode(6);
        head.printList();
		Node prevPoint = head.getPrevPoint();
		Node prev = head.reverseSecondHalf();
		// prevPoint.next = prev;
		System.out.println("");		
        head.printList();
      }
  }
  
  
  