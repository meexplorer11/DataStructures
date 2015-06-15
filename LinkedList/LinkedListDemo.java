package list;

public class LinkedListDemo {

	public static void main(String[] args) {
		//singlyLinkedList();
		
		doublyLinkedList();
	}

	private static void singlyLinkedList() {
		SinglyLinkedList list = new SinglyLinkedList();

		System.out.println("Adding elements at first position-");
		int[] input = {1,2,3,4,5};
		for(int i : input) {
			list.addFirst(i);
		}
		System.out.println("List after adding elements at first position- "+list);
		
		System.out.println("\nAdding elements at last position-");
		list = new SinglyLinkedList();
		for(int i : input) {
			list.addLast(i);
		}
		System.out.println("List after adding elements at last position-  "+list);
		
		System.out.println("\nCount nodes- "+list.countNodes());
		
		System.out.println("\nAdding at position 3- ");
		list.addAtPosition(6, 3);
		System.out.println(list);
		
		System.out.println("\nDeleting first node-");
		list.deleteFirst();
		System.out.println(list);
		
		System.out.println("\nDeleting last node-");
		list.deleteLast();
		System.out.println(list);
		
		System.out.println("\nDeleting at position 3-");
		list.deleteAtPosition(3);
		System.out.println(list);
	}
	
	private static void doublyLinkedList() {
		DoublyLinkedList dll = new DoublyLinkedList();
		System.out.println(dll);
		
		System.out.println("Adding elements at first position-");
		int[] input = {1,2,3,4,5};
		for(int i : input) {
			dll.addFirst(i);
		}
		System.out.println("List after adding elements at first position- "+dll);
		
		System.out.println("\nAdding elements at last position-");
		dll = new DoublyLinkedList();
		for(int i : input) {
			dll.addLast(i);
		}
		System.out.println("List after adding elements at last position-  "+dll);
		
		System.out.println("\nAdding at position 3- ");
		dll.addAtPosition(6, 3);
		System.out.println(dll);
		
		System.out.println("\nCount nodes- "+dll.countNodes());
	}
}
