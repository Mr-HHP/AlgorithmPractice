package leetcode;

/**
 * 搜索旋转排序数组
 *
 * @author Mr.黄
 * @date 2022/03/24
 **/
public class Leetcode33 {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}