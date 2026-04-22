/**
 * 题目：在排序数组中查找元素的第一个和最后一个位置
 * 思路：两次二分。
 * 第一次二分找左边界：即使找到target也继续向左缩小区间，最后左指针指向第一个target。
 * 第二次二分找右边界：即使找到target也继续向右缩小区间，最后右指针指向最后一个target。
 * 最后判断target是否存在，若不存在或越界则返回[-1,-1]。
 * 时间复杂度：O(log n)，空间复杂度：O(1)。
 */
public class LC_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        // 找左边第一个target
        while (l <= r){
            mid = l + (r - l)/2;
            // 即使找到target，也继续向左缩小区间
            if (nums[mid] >= target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        // r找到了target，也继续向左缩小区间
        // 最后当l和r错开时，r指向最后一个<target的位置
        // l指向左边第一个target的位置
        int left = l;
        l = 0;
        r = nums.length - 1;
        // 找右边第一个target
        while (l <= r){
            mid = l + (r - l)/2;
            // 即使找到target，也继续向右缩小区间
            if (nums[mid] <= target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        int right = r;
        // 筛掉target比数组里所有的数都大||比所有数都小，或者不存在target的情况
        if (left >= nums.length || nums[left] != target) return ans;
        ans[1] = right;
        ans[0] = left;
        return ans;
    }
}
