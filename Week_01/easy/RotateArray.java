public class RotateArray {


    // 189. 旋转数组

    //给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
    //
    //示例 1:
    //
    //输入: [1,2,3,4,5,6,7] 和 k = 3
    //输出: [5,6,7,1,2,3,4]
    //解释:
    //向右旋转 1 步: [7,1,2,3,4,5,6]
    //向右旋转 2 步: [6,7,1,2,3,4,5]
    //向右旋转 3 步: [5,6,7,1,2,3,4]
    //示例 2:
    //
    //输入: [-1,-100,3,99] 和 k = 2
    //输出: [3,99,-1,-100]
    //解释:
    //向右旋转 1 步: [99,-1,-100,3]
    //向右旋转 2 步: [3,99,-1,-100]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/rotate-array
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void rotate(int[] nums, int k) {
        // 暴力
        for (int i = 0; i < k; i++) {
            int val = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = val;
        }
    }

    public static void rotate2(int[] nums, int k) {
        k %= nums.length;
        // 翻转 k 和 length - k 个元素
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[right];
            nums[right--] = nums[left];
            nums[left++] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        rotate2(nums, 3);
        for (int i : nums) {
            System.out.print(i);
        }
    }
}
