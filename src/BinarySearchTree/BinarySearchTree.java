package BinarySearchTree;

import java.util.*;


public class BinarySearchTree {

	public class Node {
		int value;
		Node left;
		Node right;

		public Node(int value){
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public Node(int value, Node left, Node right){
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	Node rootNode;

	public BinarySearchTree(int value){
		rootNode = new Node(value);
	}


	Node addNode(int val, Node n){
		
		//Once it hits null, create the new node and return it
		if (n == null){
			Node newNode = new Node(val);
			return newNode;
		}
		
		int currVal = n.value;
		if (val < currVal){
			n.left = addNode(val, n.left);
		} else{
			n.right = addNode(val, n.right);
		}
		return n;
	}

	//Print elements level by level 
	void BFS(){
		if (this.rootNode == null){
			System.out.println("Empty head!");
			return;
		}

		Queue<Node> q = new ArrayDeque<>();

		q.add(rootNode);
		while (!q.isEmpty()){
			int size = q.size();
			System.out.println("Curr level values: ");
			for (int i = 0; i < size; i++){
				Node temp = q.remove();
				System.out.println(temp.value);
				if (temp.left != null) {
					q.add(temp.left);
				};
				if (temp.right != null) {
					q.add(temp.right);
				}
			}
			System.out.println("End of curr level");

		}
	}

	public static void main(String[] args) {
		System.out.println("Hi");

		BinarySearchTree bst = new BinarySearchTree(10);
		bst.rootNode = bst.addNode(5, bst.rootNode);
		bst.rootNode = bst.addNode(3, bst.rootNode);
		bst.rootNode = bst.addNode(1, bst.rootNode);
		bst.rootNode = bst.addNode(15, bst.rootNode);
		bst.rootNode = bst.addNode(20, bst.rootNode);
		bst.rootNode = bst.addNode(25, bst.rootNode);
		bst.rootNode = bst.addNode(30, bst.rootNode);
		bst.BFS();
		
	}
}
