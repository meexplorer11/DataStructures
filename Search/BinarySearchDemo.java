package algos.search;

public class BinarySearchDemo {

	public static void main(String[] args) {
		BinarySearchDemo.BinarySearch<Integer> binSearch = new BinarySearchDemo().new BinarySearch<Integer>(new Integer[]{1, 2, 4, 5}, 2);
		binSearch.search();
	}

	private class BinarySearch<K extends Object & Comparable<? super K>> {
		K[] input;
		K searchItem;
		
		public BinarySearch(K[] input, K searchItem) {
			if(input == null)
				throw new IllegalArgumentException("Input array must be non-null..");
			
			this.input = input;
			this.searchItem = searchItem;
		}
		
		private void search() {
			long start = System.currentTimeMillis();
			int index = binarySearch(0, input.length-1);
			long end = System.currentTimeMillis();
			System.out.println("Item found at index= "+index+", Time taken= "+(end-start));
		}
		
		private int binarySearch(int low, int high) {
			while (low <= high) {
	            int mid = (low + high) >>> 1;
	            K midVal = input[mid];
	            System.out.println("low="+low+", high="+high+", mid="+mid+", midele="+input[mid]);
	            if (midVal.compareTo(searchItem) == -1)
	                low = mid + 1;
	            else if (midVal.compareTo(searchItem) == 1)
	                high = mid - 1;
	            else
	                return mid;
	        }
	        return -1;
		}
	}
}
