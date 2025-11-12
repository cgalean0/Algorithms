import java.util.Random;
public class RandomizedQuickSort<T extends Comparable<T>> {
	public RandomizedQuickSort() {}

	public void quickSort(T[] arr) {
		int n = arr.length;
		sort(arr, 0, n - 1);
	}

	private void sort(T[] arr, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(arr, lo, hi);
		sort(arr, lo, j - 1);
		sort(arr, j + 1, hi);
	}

	private int partition(T[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Random r = new Random();
		int piv = lo + r.nextInt(hi - lo + 1);
		swap(a, piv, lo);
		T value = a[lo];
		while (true) {
			//scan right
			while (isLess(a[++i], value)) if (i == hi) break;
			//scan left
			while (isLess(value, a[--j])) if (j == lo) break;

			if (i >= j) break;
			swap(a, i, j);
		}
		swap(a, lo, j);
		return j;
	}

	private void swap(T[] arr, int i, int j) {
		T v = arr[i];
		arr[i] = arr[j];
		arr[j] = v;
	}

	private boolean isLess(T i, T j) {
		return i.compareTo(j) < 0;
	}
}