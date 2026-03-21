public class LC_238 {
    public int[] productExceptSelf(int[] nums){
        int len = nums.length;
        int[] l_multi = new int[len];
        l_multi[0] = 1;
        int[] r_multi = new int[len];
        r_multi[len - 1] = 1;
        for (int i = 1; i < len; i++){
            l_multi[i] = l_multi[i - 1] * nums[i - 1];
            r_multi[len - i - 1] = r_multi[len - i] * nums[len - i];
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++){
            ans[i] = l_multi[i] * r_multi[i];
        }
        return ans;
    }

    public int[] solution2(int[] nums){
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        int r = 1;
        for (int i = 1; i < len; i++){
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >=0; i--){
            r = r * nums[i + 1];
            ans[i] = ans[i] * r;
        }
        return ans;
    }
}
