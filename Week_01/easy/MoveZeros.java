public class MoveZeros {

    //283. Move Zeroes

    //Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    //
    //Example:
    //
    //Input: [0,1,0,3,12]
    //Output: [1,3,12,0,0]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/move-zeroes
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public void moveZeroes(int[] nums) {
        // 双指针 i 0, j 非0
        for (int i = 0, j = 0; j < nums.length; ++j) {
            if (nums[j] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i++] = temp;
            }
        }
    }
}
