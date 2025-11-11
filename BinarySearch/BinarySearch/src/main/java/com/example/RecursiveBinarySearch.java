package com.example;

public class RecursiveBinarySearch {
    public RecursiveBinarySearch() {} // Default Constructor

    /**
     * @Precondition
     * We assume that the array is ordered by an algorithm of efficiente sort such as MergeSort.
     * @Postcondition
     * returns the position of the element iff it exist in the array or -1 if don't exist
     */
    public static int recursivesearch(int[] arr, int value) {
        int n = arr.length;
        return search(arr, value, 0, n - 1);
    }

    private static int search(int[] arr, int value, int lo, int hi) {
        if (lo > hi) return -1;
        
        int mid = lo + (hi - lo) / 2;
        // Found
        if (arr[mid] == value)
            return mid;
        // Search Right half
        else if (value > arr[mid]) 
            return search(arr, value, mid + 1, hi);
        // Search left half
        else if (value < arr[mid]) 
            return search(arr, value, lo, mid - 1);
        // Not found
	return -1;
    }

}
