import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSortedArray {

    //88.Merge Sorted Array

    //Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
    //
    //Note:
    //
    //The number of elements initialized in nums1 and nums2 are m and n respectively.
    //You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
    //Example:
    //
    //Input:
    //nums1 = [1,2,3,0,0,0], m = 3
    //nums2 = [2,5,6],       n = 3
    //
    //Output: [1,2,2,3,5,6]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/merge-sorted-array
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = new int[m];
        System.arraycopy(nums1, 0, copy, 0, m);
        int index1 = 0, index2 = 0;

        for (int i = 0; index1 < m && index2 < n; i++) {
            if (copy[index1] < nums2[index2]) {
                nums1[i] = copy[index1++];
            } else {
                nums1[i] = nums2[index2++];
            }
        }

        if (index1 < m) {
            System.arraycopy(copy, index1, nums1, index1 + index2, m + n - index1 - index2);
        }

        if (index2 < n) {
            System.arraycopy(nums2, index2, nums1, index1 + index2, m + n - index1 - index2);
        }
    }

    public static void main(String[] args) {
        // [4,5,6,0,0,0]
        //3
        //[1,2,3]
        //3
        int[] nums1 = new int[]{4,5,6,0,0,0};
        int[] nums2 = new int[]{1,2,3};
        merge2(nums1,3,nums2,3);
    }
}
