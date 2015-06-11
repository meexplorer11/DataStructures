package list;

public class SinglyLinkedList {

	private Node head;
	private int size;
	
	public SinglyLinkedList() {
		head = null;
		size = 0;
	}
	
	public void addFirst(int data) {
		Node n = new Node(data);
		if(head == null) {
			head = n;
		} else {
			n.next = head;
			head = n;
		}
		size++;
	}
	
	public void addAtPosition(int data, int pos) {
		if(pos == -1 || pos > size+1)
			System.out.println("Target position is not valid !");
		
		if(pos == 1) {
			addFirst(data);
		} else if(pos == size+1) {
			addLast(data);
		} else {
			Node prevNode = head;
			int count = 1;
			while(count < pos-1) {
				prevNode = prevNode.next;
				count++;
			}
			Node n = new Node(data);
			n.next = prevNode.next;
			prevNode.next = n;
		}
	}
	
	public void addLast(int data) {
		Node n = new Node(data);
		if(head == null) {
			head = n;
		} else {
			Node currentNode = head;
			while(currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = n;
		}
		size++;
	}
	
	public int countNodes() {
		if(head == null)
			return 0;
		
		int count = 1;
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
			count++;
		}
		
		return count;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		if(head == null)
			return "[]";
		
		StringBuilder list = new StringBuilder();
		list.append("[").append(head.data);
		Node temp = head;
		while(temp.next != null) {
			list.append(" -> ").append(temp.next.data);
			temp = temp.next;
		}
		list.append("]");
		return list.toString();
	}
	
	private static final class Node {
		private int data;
		private Node next;
		
		private Node(int data) {
			this.data = data;
			next = null;
		}
	}
}