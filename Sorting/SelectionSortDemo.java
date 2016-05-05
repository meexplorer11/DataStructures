package algos.sort;

import java.util.Arrays;

public class SelectionSortDemo {

	public static void main(String[] args) {
		SelectionSortDemo.SelectionSort<Integer> selSort = new SelectionSortDemo().new SelectionSort<Integer>(new Integer[]{1, 4, 2, 3});
		selSort.sort();
	}

	private class SelectionSort<K extends Object & Comparable<? super K>> {
		K[] input;
		
		public SelectionSort(K[] input) {
			if(input == null)
				throw new IllegalArgumentException("Input array must be non-null.");
			
			this.input = input;
		}
		
		public void sort() {
			System.out.println("Array before sorting- "+Arrays.toString(input));
			long start = System.currentTimeMillis();
			if(input.length == 1)
				System.out.println("Already sorted!");
			else {
				int minIndex = -1;
				for(int i=0; i<input.length-1; i++) {
					minIndex = i;
					boolean isSwapRequired = false;
					for(int j=i+1; j<input.length; j++) {
						if(input[j].compareTo(input[minIndex]) == -1) {
							minIndex = j;
							isSwapRequired = true;
						}
					}
					if(isSwapRequired)
						swap(i,minIndex);
				}
			}
			long end = System.currentTimeMillis();
			System.out.println("Time taken in sorting= "+(end-start)+"\nArray after sorting- "+Arrays.toString(input));
		}

		private void swap(int i, int minIndex) {
			K temp = input[i];
			input[i] = input[minIndex];
			input[minIndex] = temp;
		}
	}
}
