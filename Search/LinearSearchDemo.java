/**
 * 
 * @author Javargon
 *
 */
public class LinearSearchDemo {

	public static void main(String[] args) {
		LinearSearchDemo.LinearSearch<Integer> linSe = new LinearSearchDemo().new LinearSearch<Integer>(new Integer[]{1, 4, 2, 6}, 2);
		linSe.search();
	}

	private class LinearSearch<K> {
		K[] input;
		K searchItem;
		int index = -1;
		
		public LinearSearch(K[] input, K searchItem) {
			if(input == null)
				throw new IllegalArgumentException("Input array must be non-null..");
			
			this.input = input;
			this.searchItem = searchItem;
		}
		
		private boolean search() {
			long start = System.currentTimeMillis();
			for(K elem : input) {
				++index;
				if(elem.equals(searchItem)) {
					long end = System.currentTimeMillis();
					System.out.println("Element found at index > "+index+", time taken= "+(end-start));
					return true;
				}
			}
			long end = System.currentTimeMillis();
			System.out.println("Element doesn't exist in this array, time taken="+(end-start));
			return false;
		}
	}
}
