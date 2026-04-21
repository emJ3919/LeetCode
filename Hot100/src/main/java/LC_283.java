


/**
 * 题目：移动零
 * 思路：指针指向下一个非0数应该放的位置
 *     遍历数组，非零数就移到指针位置，指针前移。最后把后面的都填0。
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */

public class LC_283 {
    public void moveZero(int[] nums){
        // 记录下一个非0数应该放的位置
        int current = 0;
        // 遍历将非0数放到正确位置
        for (int i = 0; i < nums.length; i += 1){
            if (nums[i] != 0){
                nums[current] = nums[i];
                // 下一个应该放的位置往后移
                current++;
            }
        }
//        补全0
        for (int i = current; i < nums.length; i += 1){
            nums[i] = 0;
        }
    }
}
