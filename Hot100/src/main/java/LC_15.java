import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_15 {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
                if (nums[l] + nums[r] < target){
                    l++;
                }
                else if (nums[l] + nums[r] > target){
                    r--;
                }
                else{
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l] == nums[l-1]) l++;
                    while(l<r && nums[r] == nums[r+1]) r--;
                }
            }
        }
        return ans;
    }
}
