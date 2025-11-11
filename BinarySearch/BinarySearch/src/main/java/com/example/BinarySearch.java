package com.example;

public class BinarySearch{
    public BinarySearch() {}
    /**
     * @Precondition
     * We assume that the array is ordered by an algorithm of efficiente sort such as MergeSort.
     * @Postcondition
     * returns the position of the element iff it exist in the array or -1 if don't exist
     */
    public static int search(int[] arr, int value) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == value) {
                return mid;
            }
            if (value < arr[mid]) {
                hi = mid - 1;
            } else if (value > arr[mid]) {
                lo = mid + 1;
            }
        }
        return -1;
    }
}