package sort;

import java.util.Arrays;

public class QuickSortDemo {

	public static void main(String[] args) {
		QuickSort<Integer> qukSort = new QuickSortDemo().new QuickSort<Integer>(new Integer[]{10,7,8,9,15});
		qukSort.sort();
	}

	private class QuickSort<K extends Object & Comparable<? super K>> {
		K[] a;
		
		public QuickSort(K[] a) {
			this.a = a;
		}
		
		private void sort() {
			System.out.println("Array before sorting- "+Arrays.toString(a));
			long start = System.currentTimeMillis();
			quickSort(0, a.length-1);
			long end = System.currentTimeMillis();
			System.out.println("Time taken= "+(end-start)+"\nArray after sorting- "+Arrays.toString(a));
		}

		private void quickSort(int low, int high) {
			int pivotIdx = (low+high) >>> 1;
			K pivot = a[pivotIdx];
			int i = low;
			int j = high;
			
			while(i <= j) {
				while(a[i].compareTo(pivot) == -1)
					i++;
				while(a[j].compareTo(pivot) == 1)
					j--;
				
				if(i <= j) {
					swap(i,j);
					i++;
					j--;
				}
			}
			if(low < j)
				quickSort(low, j);
			if(i < high)
				quickSort(i, high);
		}

		private void swap(int i, int j) {
			K temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}
}
