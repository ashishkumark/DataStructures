package com.ashish.prep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.List;

public class BreadthFirstLevelOrderTraversal {

	public static void printLevelOrder(Node root) {
//		int front, rear;
		Queue<Node> queue = new ArrayDeque<Node>();
		Node current = root;
		
		while(current != null){
			System.out.println(current.key);
			
			if (current.leftChild != null) {
				queue.offer(current.leftChild);
			}
			if (current.rightChild != null) {
				queue.offer(current.rightChild);
			}
			
			current = queue.poll();
		}
	}
	
	public static void main(String[] args) {
//		LinkedList<Node> list = new LinkedList<Node>();
//		list.add(new Node(10, null));
//		list.add(new Node(20, null));
//		list.add(new Node(30, null));
//		list.add(new Node(40, null));
//		list.add(new Node(50, null));
//		list.add(new Node(60, null));
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.addNode(50, "Manager");
		bst.addNode(40, "Associate Manager");
		bst.addNode(30, "Secretary");
		bst.addNode(20, "Support Staff");
		bst.addNode(10, "Jr. Staff");
		bst.addNode(70, "Sr. Manager");
		bst.addNode(80, "Program Manager");
//		printLevelOrder(bst.root);
//		printEachLevelOrder(bst.root);
//		printEachLevel(bst.root);
		getEachLevelList(bst.root);
	}
	

	// Alternate scenarios
	
	public static void printEachLevelOrder(Node root) {

		if (root == null)  return;
		
		Queue<Node> queue = new ArrayDeque<Node>();
		Node current = root;
		int level = 0;

		ArrayList<Node> levelList = new ArrayList<Node>();
		current.level = level;
		levelList.add(current);
	
		while(current != null){
			
			if (current.leftChild != null) {
				queue.offer(current.leftChild);
				current.leftChild.level = current.level + 1;
				levelList.add(current.leftChild);
			}
			if (current.rightChild != null) {
				queue.offer(current.rightChild);
				current.rightChild.level = current.level + 1;
				levelList.add(current.rightChild);
			}

			current = queue.poll();
		}
		
		System.out.println("************");
		for (Node node : levelList) {
			if (level == node.level) {
				System.out.print(node.key + " ");
			} else {
				System.out.println();
				System.out.print(node.key + " ");
				level++;
			}
		}
	}

	public static void printEachLevel(Node root) {

		if (root == null)  return;
		
		Queue<Node> queue = new ArrayDeque<Node>();
		Node current = root;
//		List<ArrayList<Node>> eachLevelList = new ArrayList<ArrayList<Node>>();
		int level = 1;
		int cntrNext = 0;
		ArrayList<Node> levelList = new ArrayList<Node>();

//		eachLevelList.add(levelList);
		
		while(current != null){
			
			levelList.add(current);
			
			if (current.leftChild != null) {
				queue.offer(current.leftChild);
				cntrNext++;
//				levelList.add(current.leftChild);
			}
			if (current.rightChild != null) {
				queue.offer(current.rightChild);
				cntrNext++;
//				levelList.add(current.rightChild);
			}
			level--;
			
			if (level == 0) {
				level = cntrNext;
				cntrNext = 0;
				levelList.add(new Node(0, null));
			}

			current = queue.poll();
		}
		
		System.out.println("************");
		for (Node node : levelList) {
			if (node.key == 0) {
				System.out.println("    |");
				System.out.println("    |");
				System.out.println("    V");
			} else {
				System.out.println(node);// + " ,");
			}
		}
		System.out.println("null");
	}

	public static List<ArrayList<Node>> getEachLevelList(Node root) {

		if (root == null)  return null;
		
		Queue<Node> queue = new ArrayDeque<Node>();
		Node current = root;
		List<ArrayList<Node>> eachLevelList = new ArrayList<ArrayList<Node>>();
		int cntr = 1;
		int cntrNext = 0;
		int level = 0;
		ArrayList<Node> levelList = new ArrayList<Node>();

//		eachLevelList.add(levelList);
		
		while(current != null){
			
			levelList.add(current);
						
			if (current.leftChild != null) {
				queue.offer(current.leftChild);
				cntrNext++;
			}
			if (current.rightChild != null) {
				queue.offer(current.rightChild);
				cntrNext++;
			}
			cntr--;
			
			if (cntr == 0) {
				cntr = cntrNext;
				cntrNext = 0;
				level++;
				eachLevelList.add(levelList);
				levelList = new ArrayList<Node>();
			}
			
			current = queue.poll();
		}
		
		System.out.println("************");
		for (ArrayList<Node> node : eachLevelList) {
			System.out.println(node);
		}
		
		return eachLevelList;
	}

}
//class TreeNode {
//	int key;
////	String role;
//	
//	TreeNode leftChild;
//	TreeNode rightChild;
//	
//	public TreeNode(int key, String role) {
//		this.key = key;
////		this.role = role;
//	}
//	
////	public String toString() {
////		return role + " has a key of " + key;
////	}
//}