import java.util.Arrays;
import java.util.Objects;

public class PlusOne {

    //66. Plus One

    //Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
    //
    //The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
    //
    //You may assume the integer does not contain any leading zero, except the number 0 itself.
    //
    //Example 1:
    //
    //Input: [1,2,3]
    //Output: [1,2,4]
    //Explanation: The array represents the integer 123.
    //Example 2:
    //
    //Input: [4,3,2,1]
    //Output: [4,3,2,2]
    //Explanation: The array represents the integer 4321.
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/plus-one
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = digits[i] + 1 - 10;
                if (i == 0) {
                    digits = new int[digits.length + 1];
                    System.arraycopy(digits, 0,digits,0,digits.length);
                    digits[i] = 1;
                }
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] % 10 != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{9,9};
        int[] ints = plusOne(nums);
        for (int n : ints) {
            System.out.println(n);
        }
    }


}
