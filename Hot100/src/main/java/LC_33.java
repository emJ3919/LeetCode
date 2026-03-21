public class LC_33 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l)/2;
            // [l,mid]升序，注意必须要等于
            // 如果没有=，在l = mid且就是target元素的时候，会跳到else，然后r = mid - 1退出循环了。
            if (nums[l] <= nums[mid]){
                // target在升序区间
                if (nums[mid] >= target && nums[l] <= target)
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
