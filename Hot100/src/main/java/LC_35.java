/**
 * 题目：搜索插入位置
 * 思路：二分查找。
 * 使用双指针维护搜索区间，根据中间元素与目标值的大小关系调整搜索范围。
 * 若中间元素等于目标值则返回中间位置。
 * 若目标值不在数组中，循环结束后左指针指向的位置即为插入位置。
 * 时间复杂度：O(log n)，空间复杂度：O(1)。
 */
public class LC_35 {
    public int searchInsert(int[] nums, int target) {
        // 二分查找 双指针 l, r
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if (nums[mid] == target) return mid;
            // 目标值在mid右侧
            if (nums[mid] < target){
                l = mid + 1;
            }else {// 目标值在mid左侧
                r = mid - 1;
            }
        }
        // 目标值不在数组中，返回插入位置
        return l;
    }
}
