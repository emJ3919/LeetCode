/**
 * 题目：寻找旋转排序数组中的最小值
 * 思路：二分查找。
 * 判断有序区间：若左端点 <= 中间点，则左区间升序；否则右区间升序。
 * 找最小值：升序区间的最小值就是左端点。
 * 继续寻找：左区间升序时，可能右侧还有最小值；右区间升序时，可能左侧还有最小值。
 * 用变量记录遍历过程中的最小值，最后返回。
 * 时间复杂度：O(log n)，空间复杂度：O(1)。
 */
public class LC_153 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = nums[0];
        while (l <= r){
            int mid = l + (r - l)/2;
            // [l,mid]有序，能找到这部分的最小值
            if (nums[l] <= nums[mid]){
                // 找到左边有序的最小
                min = Math.min(nums[l], min);
                // 去右边无序的地方找
                l = mid + 1;
            }
            // 右边有序
            else {
                min = Math.min(nums[mid], min);
                // 去左边无序的地方找
                r = mid - 1;
            }
        }
        return min;
    }
}
