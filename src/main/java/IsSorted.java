/**
 * Utility class to determine if an array of integers is sorted in either ascending or descending order.
 */
public class IsSorted {

    /**
     * Checks if the given array is sorted in ascending or descending order.
     *
     * @param array The array of integers to check.
     * @return true if the array is sorted in either ascending or descending order, false otherwise.
     */
    public static boolean isSorted(int[] array) {
        if (array.length < 2) return true; // An array with less than 2 elements is considered sorted

        boolean ascending = true;   // Flag to track if the array is ascending
        boolean descending = true;  // Flag to track if the array is descending

        // Loop through the array to determine sorting order
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                ascending = false; // If current element is less than previous, not ascending
            }
            if (array[i] > array[i - 1]) {
                descending = false; // If current element is greater than previous, not descending
            }
        }
        return ascending || descending; // Return true if either flag is still true
    }
}
