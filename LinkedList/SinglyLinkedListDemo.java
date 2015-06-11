package list;

public class SinglyLinkedListDemo {

	public static void main(String[] args) {

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
	}

}
