package list;

public class DoublyLinkedList {

	private Node head;
	private int size;
	
	public DoublyLinkedList() {
		head = null;
		size = 0;
	}
	
	public void addFirst(int data) {
		Node n = new Node(data);
		if(head == null) {
			head = n;
			n.next = n.prev = head;
		} else {
			n.prev = head.prev;
			head.prev.next = n;
			n.next = head;
			head.prev = n;
			head = n;
		}
		size++;
	}
	
	public void addAtPosition(int data, int pos) {
		if(pos == -1 || pos > size+1)
			System.out.println("Target position is not valid !");
		
		if(pos == 1)
			addFirst(data);
		else if(pos == size+1)
			addLast(data);
		else {
			Node currentNode = head;
			int count = 1;
			while(count++ < pos-1) {
				currentNode = currentNode.next;
			}
			
			Node n = new Node(data);
			n.next = currentNode.next;
			currentNode.next.prev = n;
			currentNode.next = n;
			n.prev = currentNode;
			
			size++;
		}
	}
	
	public void addLast(int data) {
		Node n = new Node(data);
		if(head == null) {
			head = n;
			n.next = n.prev = head;
		} else {
			Node lastNode = head.prev;
			lastNode.next = n;
			n.next = head;
			n.prev = lastNode;
			head.prev = n;
		}
		size++;
	}
	
	public void deleteFirst() {
		if(head == null)
			System.out.println("List is empty, nothing to delete!");
		
		Node firstNode = head;
		firstNode.prev.next = firstNode.next;
		firstNode.next.prev = firstNode.prev;
		head = firstNode.next;
		
		firstNode.prev = firstNode.next = null;
		firstNode = null;
		
		size--;
	}
	
	public void deleteAtPosition(int pos) {
		if(pos == -1 || pos > size)
			System.out.println("Target position is not valid !");
		
		if(pos == 1) {
			deleteFirst();
		} else if(pos == size) {
			deleteLast();
		} else {
			Node currentNode = head;
			int count = 1;
			while(count++ < pos-1) {
				currentNode = currentNode.next;
			}
			Node deleteNode = currentNode.next;
			currentNode.next = deleteNode.next;
			deleteNode.next.prev = currentNode;
			deleteNode = null;
			size--;
		}
	}
	
	public void deleteLast() {
		if(head == null)
			System.out.println("List is empty, nothing to delete!");
		
		Node lastNode = head.prev;
		head.prev = lastNode.prev;
		lastNode.prev.next = head;
		lastNode = null;
		
		size--;
	}
	
	public int countNodes() {
		if(head == null)
			return 0;
		
		int count = 1;
		Node nextNode = head;
		while(nextNode.next != head) {
			nextNode = nextNode.next;
			count++;
		}
		return count;
	}
	
	@Override
	public String toString() {
		if(head == null)
			return "[]";
		
		StringBuilder list = new StringBuilder();
		
		Node currentNode = head;
		list.append("[").append(currentNode.data);
		
		while(currentNode.next != head) {
			list.append(" -> ").append(currentNode.next.data);
			currentNode = currentNode.next;
		}
		
		list.append("]");
		
		return list.toString();
	}
	
	private static class Node {
		private int data;
		private Node prev;
		private Node next;
		
		public Node(int data) {
			this.data = data;
			prev = next = null;
		}
	}
}
