package sort;

import java.util.Arrays;

public class ShellSortDemo {

	public static void main(String[] args) {
		ShellSort<Integer> qukSort = new ShellSortDemo().new ShellSort<Integer>(new Integer[]{10,7,8,9,15});
		qukSort.sort();
	}

	private class ShellSort<K extends Object & Comparable<? super K>> {
		K[] a;
		
		public ShellSort(K[] a) {
			this.a = a;
		}
		
		/**
		 * Robert Sedgewick and Kevin Wayne Implementation
		 */
		private void sort() {
			System.out.println("Array before sorting- "+Arrays.toString(a));
			long start = System.currentTimeMillis();
			int N = a.length;

	        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
	        int h = 1;
	        while (h < N/3) h = 3*h + 1; 

	        while (h >= 1) {
	            // h-sort the array
	            for (int i = h; i < N; i++) {
	                for (int j = i; j >= h && (a[j].compareTo(a[j-h]) == -1); j -= h) {
	                    swap(j, j-h);
	                }
	            }
	            h /= 3;
	        }
	        
			long end = System.currentTimeMillis();
			System.out.println("Time taken= "+(end-start)+"\nArray after sorting- "+Arrays.toString(a));
		}

		private void swap(int i, int j) {
			K temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}
}
