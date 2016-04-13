package list;

/**
 * Singly Linked List implementation 
 * @author Vivek Maurya
 */
public class SinglyLinkedList {

	private Node head;
	private int size;

	public SinglyLinkedList() {
		head = null;
		size = 0;
	}

	public void addFirst(int data) {
		Node n = new Node(data);
		if (head != null)
			n.next = head;
		head = n;
		incrementSize();
	}

	public void deleteFirst() {
		if (head == null)
			System.out.println("List is empty, nothing to delete.");
		else {
			Node temp = head;
			head = head.next;
			temp = null;
			decrementSize();
		}
	}

	public void addLast(int data) {
		Node n = new Node(data);
		if (head == null)
			head = n;
		else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = n;
		}
		incrementSize();
	}

	public void deleteLast() {
		if (head == null)
			System.out.println("List is empty, nothing to delete.");
		else {
			Node temp = head;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;
			decrementSize();
		}
	}

	public void addAt(int pos, int data) {
		if (pos == -1 || pos > size + 1)
			System.out.println("Invalid position!");
		if (pos == 1)
			addFirst(data);
		else if (pos == size + 1)
			addLast(data);
		else {
			int count = 1;
			Node prevNode = head;
			while (count++ < pos - 1) {
				prevNode = prevNode.next;
			}
			Node n = new Node(data);
			n.next = prevNode.next;
			prevNode.next = n;
		}
		incrementSize();
	}

	public void deleteAt(int pos) {
		if (pos == -1 || pos > size)
			System.out.println("Invalid position!");
		int count = 1;
		Node currentNode = head;
		while (count++ < pos - 1) {
			currentNode = currentNode.next;
		}
		Node temp = currentNode.next;
		currentNode.next = currentNode.next.next;
		temp = null;
		decrementSize();
	}

	public boolean addAll(int[] input, boolean isReverse) {
		if (input == null)
			return false;
		for (int item : input) {
			if (isReverse)
				addFirst(item);
			else
				addLast(item);
		}
		return true;
	}

	public int findNthFromLast(int nthNode) {
		if (nthNode == -1 || !(size - nthNode > 0))
			throw new IllegalArgumentException("Invalid nth node.");

		int reqNode = size - nthNode;
		int count = 1;
		Node currenNode = head;
		while (count++ < reqNode) {
			currenNode = currenNode.next;
		}
		return currenNode.data;
	}

	public void insertInSortedList(int data) {
		if (head == null)
			addFirst(data);

		Node n = new Node(data);
		Node NextNode = head;
		Node currentNode = head;
		int count = 1;
		while (NextNode.next != null && NextNode.data < data) {
			currentNode = NextNode;
			NextNode = NextNode.next;
			count++;
		}
		n.next = NextNode;
		if (count == 1)
			head = n;
		else
			currentNode.next = n;
	}

	public void midNode() {
		Node fast = head;
		Node slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println("Mid element is-- " + slow.data);
	}

	public int frequency(int item) {
		if (head == null)
			return 0;
		int count = 0;
		Node temp = head;
		if (temp.data == item)
			count++;

		while ((temp = temp.next) != null) {
			if (temp.data == item)
				count++;
		}
		return count;
	}

	private void incrementSize() {
		size++;
	}

	private void decrementSize() {
		size--;
	}

	@Override
	public String toString() {
		if (head == null)
			return "[]";
		StringBuilder content = new StringBuilder("[").append(head.data);
		Node temp = head;
		while ((temp = temp.next) != null) {
			content.append("->").append(temp.data);
		}
		content.append("]");
		return content.toString();
	}

	private static final class Node {
		private int data;
		private Node next;

		private Node(int data) {
			this.data = data;
		}
	}

}
