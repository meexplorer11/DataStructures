package sort;

import java.util.Arrays;

public class InsertionSortDemo {

	public static void main(String[] args) {
		InsertionSortDemo.InsertionSort<Integer> inSort = new InsertionSortDemo().new InsertionSort<Integer>(new Integer[]{1,4,2,5});
		inSort.search();
	}

	private class InsertionSort<K extends Object & Comparable<? super K>> {
		K[] input;
		
		public InsertionSort(K[] input) {
			if(input == null)
				throw new IllegalArgumentException();
			
			this.input = input;
		}
		
		private void search() {
			System.out.println("Array before sorting- "+Arrays.toString(input));
			if(input.length == 1)
				System.out.println("Arrays is already sorted.");
			else {
				for(int i=1; i<input.length; i++) {
					K ith = input[i];
					int j=i-1;
					for(;(j>=0 && input[j].compareTo(input[i])==1); j--) {
						input[j+1] = input[j];
					}
					input[j+1] = ith;
				}
			}
			System.out.println("Array after sorting- "+Arrays.toString(input));
		}
	}
}
