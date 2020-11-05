package Problem1;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null) {
            return null;
        }

        if (nums.length == 0) {
            List<Integer> empty = new ArrayList<>();
            result.add(empty);
        }

        if (nums == null) {
            return null;
        }

        permute(nums, 0, result);
        return result;
    }

    private static void permute(int[] nums, int position, List<List<Integer>> result) {
        if (position == nums.length-1) {
            List<Integer> newList = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                newList.add(nums[i]);
            }

            result.add(newList);
            return;
        }

        for (int i = position; i < nums.length; i++) {
            swap(nums, i, position);
            permute(nums, position+1, result);
            swap(nums, i, position);
        }

    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
