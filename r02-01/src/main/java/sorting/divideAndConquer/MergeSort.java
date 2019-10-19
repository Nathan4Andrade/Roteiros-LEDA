package sorting.divideAndConquer;

import sorting.AbstractSorting;
import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if((isValid(array, leftIndex, rightIndex) && (array.length > 1))){
			int middleIndex = (rightIndex + leftIndex) / 2;

			this.sort(array, leftIndex, middleIndex);
			this.sort(array, middleIndex + 1, rightIndex);

			merge(array, leftIndex, middleIndex, rightIndex);

		}

	}

	public void merge(T[] array, int leftIndex, int middleIndex, int rightIndex){
		T[] copy = Arrays.copyOf(array, array.length);

		int i = leftIndex;
		int j = leftIndex;
		int k = middleIndex + 1;

		while ((i <= middleIndex) && (k < rightIndex)){
			if (copy[i].compareTo(copy[k]) < 0){
				array[j] = copy[i++];
			}
			else {
				array[j] = copy[k++];
			}
			j++;
		}

		while (i <= middleIndex) {
			array[j++] = copy[i++];
		}

		while (k <= middleIndex) {
			array[j++] = copy[k++];
		}
	}

	public boolean isValid(T[] array, int leftIndex, int rightIndex){
		if(array == null || array.length < 2 || leftIndex < 0 || rightIndex >= array.length ||
				leftIndex >= rightIndex)
			return true;
		else
			return false;
	}
}
