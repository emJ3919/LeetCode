public class LC_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        // 找左边第一个target
        while (l <= r){
            mid = l + (r - l)/2;
            if (nums[mid] >= target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        //
        int left = l;
        l = 0;
        r = nums.length - 1;
        // 找右边第一个target
        while (l <= r){
            mid = l + (r - l)/2;
            if (nums[mid] <= target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        int right = r;
        if (left >= nums.length || nums[left] != target) return ans;
        ans[1] = right;
        ans[0] = left;
        return ans;
    }
}
