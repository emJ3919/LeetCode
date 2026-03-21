public class LC_189 {
    //
    public void solution1(int[] nums, int k){
        int len = nums.length;
        k = k % len;
        int[] tmp = new int[k];
        for (int i = len - k; i < len; i++){
            tmp[i - len + k] = nums[i];
        }
        for (int i = len - 1; i >= k; i--){
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++){
            nums[i] = tmp[i];
        }
    }
    public void solution2(int[] nums, int k){
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }
    public void reverse(int[]nums, int start, int end){
        int l = start;
        int r = end;
        while(l < r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            r--;
            l++;
        }
    }
}
