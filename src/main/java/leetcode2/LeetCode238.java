package leetcode2;

/**
 * @author Mr.黄
 * @description 除自身以外数组的乘积
 * @since 2024/6/15 13:12
 **/
public class LeetCode238 {
    // 使用除法
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        boolean hasZero = false;
        boolean isAllZero = true;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product *= nums[i];
                isAllZero = false;
            } else {
                hasZero = true;
                zeroCount++;
            }
        }
        if (isAllZero || zeroCount > 1) {
            product = 0;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (hasZero && nums[i] == 0) {
                result[i] = product;
            } else if (hasZero && nums[i] != 0) {
                result[i] = 0;
            } else {
                result[i] = product / nums[i];
            }
        }
        return result;
    }

    // 不使用除法
    public int[] productExceptSelf2(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = right[nums.length - 1] = 1;
        // 构建left
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        // 构建right
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
