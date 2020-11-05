package Problem1;

public class BinarySearch {
    // This is to be done recursively
    // Do not change signature (return type, function name, parameter types)
    // Add a helper function for recursion calls
    public static int binarySearch(int[] data, int target) {
        return binarySearch (data, target, 0, data.length-1);
    }

    private static int binarySearch (int[] data, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (data[mid] == target) { // check if target is present at midpoint
                return mid;
            }

            if (data[mid] < target) { // ignore left half if target is greater
                return binarySearch(data, target, mid+1, right);
            }

            return binarySearch(data, target, left, mid-1); // ignore right side if target is smaller
        }
        return -1; // target was not found.
    }
}
