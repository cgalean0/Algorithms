public class BubbleSort {
	public BubbleSort() {}

	public void bubbleSort(Integer[] arr) {
		int n = arr.length;
		for (int i = 0; i < n ; i++) {
			int k = i + 1;
			while (k > 0) {
				if (arr[k - 1] > arr[k]){
					int curr = arr[k - 1];
					arr[k - 1] = arr[k];
					arr[k] = curr;
				}
				k--;
			}
		}
	}
}