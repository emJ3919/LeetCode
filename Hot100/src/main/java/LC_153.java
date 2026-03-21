public class LC_153 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = nums[0];
        while (l <= r){
            int mid = l + (r - l)/2;
            // [l,mid]有序
            if (nums[l] <= nums[mid]){
                // 找到左边有序的最小
                min = Math.min(nums[l], min);
                // 去右边找
                l = mid + 1;
            }
            // 右边有序
            else {
                min = Math.min(nums[mid], min);
                // 去左边
                r = mid - 1;
            }
        }
        return min;
    }
}
