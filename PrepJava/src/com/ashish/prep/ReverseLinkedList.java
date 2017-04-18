package com.ashish.prep;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node head;
		Node n1 = new Node(1, "A");
		Node n2 = new Node(2, "B");
		Node n3 = new Node(3, "C");
		Node n4 = new Node(4, "D");
		
		head = n1;
		n1.rightChild = n2;
		n2.rightChild = n3;
		n3.rightChild = n4;
		printLinkedList(head);
		head = reverseLinkedList(head);
		printLinkedList(head);
		head = Reverse(head);
		printLinkedList(head);
		sizeOf(int.class);
		sizeOf(boolean.class);
		sizeOf(Boolean.TYPE);
		sizeOf(Integer.TYPE);
		sizeOf(java.lang.Class.class);
//		System.out.println(Integer.BYTES);
		System.out.println(Integer.TYPE);
		System.out.println(Integer.class);
		System.out.println(int.class);
	}

	private static void sizeOf(Class<?> class1) {

		if (class1 == int.class || class1 == Integer.class) System.out.println(4);
		else if (class1 == boolean.class || class1 == Boolean.class) System.out.println(1);
	}

	private static Node reverseLinkedList(Node head) {

		if (head == null || head.rightChild == null) return head;
		
		Node t1 = null, t2 = head, t3 = null;
		while (t2 != null) {
			t3 = t2.rightChild;
			t2.rightChild = t1;
			t1 = t2;
			t2 = t3;
		}
		
		head = t1;
		return head;
	}

	private static void printLinkedList(Node head) {
		while(head != null) {
			System.out.print("[" + head.key +","+head.role+"] -> ");
			head = head.rightChild;
		}
		System.out.println("null");
	}
	
	public static Node Reverse(Node list)
	{
	    if (list == null) return null; // first question

	    if (list.rightChild == null) return list; // second question

	    // third question - in Lisp this is easy, but we don't have cons
	    // so we grab the second element (which will be the last after we reverse it)

	    Node secondElem = list.rightChild;

	    // bug fix - need to unlink list from the rest or you will get a cycle
	    list.rightChild = null;

	    // then we reverse everything from the second element on
	    Node reverseRest = Reverse(secondElem);

	    // then we join the two lists
	    secondElem.rightChild = list;

	    return reverseRest;
	}
}
