package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author suntao
 * @date 2020/7/13 17:29
 */
public class IntersectionTwoArrays {

    // 349.Intersection of Two Arrays

    //Given two arrays, write a function to compute their intersection.
    //
    //Example 1:
    //
    //Input: nums1 = [1,2,2,1], nums2 = [2,2]
    //Output: [2]

    //Example 2:
    //
    //Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    //Output: [9,4]

    //Note:
    //
    //Each element in the result must be unique.
    //The result can be in any order.

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums2) {
            set1.add(num);
        }

        set.retainAll(set1);

        int[] res = new int[set.size()];
        int i = 0;
        for (int num : set) {
            res[i++] = num;
        }
        return res;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums2) {
            set1.add(num);
        }
        if (set1.size() < set.size()) {
            return set_intersection(set1,set);
        } else {
            return set_intersection(set,set1);
        }
    }

    private static int[] set_intersection(Set<Integer> set1, Set<Integer> set2) {

        int[] nums = new int[set1.size()];
        int i = 0;
        for (int num : set1) {
            if (set2.contains(num)) {
                nums[i++] = num;
            }
        }

        return Arrays.copyOf(nums,i);
    }


    public static int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        int[] nums = new int[res.size()];
        int i = 0;
        for (int num : res) {
            nums[i++] = num;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        int[] intersection = intersection3(nums1, nums2);
        for (int num : intersection) {
            System.out.println(num);
        }
    }
}
