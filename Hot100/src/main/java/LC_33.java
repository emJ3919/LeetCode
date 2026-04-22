/**
 * 题目：搜索旋转排序数组
 * 思路：二分查找。
 * 旋转数组被旋转点分为两段升序数组。
 * 根据mid与左端点的关系判断升序区间
 * 中间元素大于等于左端点说明[l,mid]升序，否则[mid, r]升序。
 * 判断target是否在升序区间内，是则在该区间二分查找。
 * 否则target在另一半区间，继续上述逻辑。
 * 时间复杂度：O(log n)，空间复杂度：O(1)。
 */
public class LC_33 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l)/2;
            // [l,mid]升序
            if (nums[l] <= nums[mid]){
                // target在升序区间
                if (nums[mid] >= target && nums[l] <= target)
                    // 二分查找[l, mid]升序区间
                    return binarySearch(nums, target, l, mid);
                // target 在另一个区间
                else {
                    l = mid + 1;
                }
            }
            // [mid, r]升序
            else {
                if (nums[mid] <= target && nums[r] >= target){
                    return binarySearch(nums, target, mid, r);
                }else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
    // 二分查找
    private int binarySearch (int[] nums, int target, int l, int r){
        while (l <= r){
            int mid = l + (r - l)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
