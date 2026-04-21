/**
 * 题目：除自身以外数组的乘积
 * 思路：前缀积思想，避免除法。
 * 方法1：用两个数组分别记录每个元素左侧和右侧所有元素的乘积，最后相乘。
 * 时间复杂度：O(n)，空间复杂度：O(n)
 * 方法2（推荐）：空间优化，用一个数组存左乘积，变量存右乘积，两遍遍历完成。
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class LC_238 {
    public int[] productExceptSelf(int[] nums){
        int len = nums.length;
        // 记录每个元素左侧所有元素的乘积
        int[] l_multi = new int[len];
        l_multi[0] = 1;
        // 记录每个元素右侧所有元素的乘积
        int[] r_multi = new int[len];
        r_multi[len - 1] = 1;
        // 计算每个元素左、右侧所有元素的乘积                                                                                                                                                                          
        for (int i = 1; i < len; i++){
            l_multi[i] = l_multi[i - 1] * nums[i - 1];
            r_multi[len - i - 1] = r_multi[len - i] * nums[len - i];
        }
        int[] ans = new int[len];
        // 计算每个元素的乘积
        for (int i = 0; i < len; i++){
            ans[i] = l_multi[i] * r_multi[i];
        }
        return ans;
    }

    public int[] solution2(int[] nums){                                                                         
        int len = nums.length;
        int[] ans = new int[len];
        // 先存左侧所有元素的乘积
        ans[0] = 1;
        // 记录右侧所有元素的乘积
        int r = 1;
        // 先从左往右，计算左侧所有元素的乘积
        for (int i = 1; i < len; i++){
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        // 再从右往左，计算右侧所有元素的乘积
        for (int i = len - 2; i >=0; i--){
            r = r * nums[i + 1];
            // 左乘右，得到每个元素的乘积
            ans[i] = ans[i] * r;
        }
        return ans;
    }
}
