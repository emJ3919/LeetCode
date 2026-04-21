import java.util.*;


/**
 * 题目：三数之和
 * 思路：先排序。固定一个数i，用双指针找另外两个数使和为当前数的负数。
 *       指针从i+1和数组末尾向中间收缩，根据sum大小移动指针。
 *       收缩和遍历时跳过相同值，避免结果重复。
 * 时间复杂度：O(n²)，空间复杂度：O(1)
 */

public class LC_15 {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        // 排序方便后面双指针查找另外两个数
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            // 跳过重复数（之前计算过）
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
//            另外两个数和为：当前数的负数
            int target = -nums[i];
//            左右指针，因为已经排好序了
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
//                另外两个数和比target小，说明要更大的，左指针右移
                if (nums[l] + nums[r] < target){
                    l++;
                }
//                比target大，右指针左移
                else if (nums[l] + nums[r] > target){
                    r--;
                }
//                等于target，符合要求，加入结果
                else{
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
//                    这组数已经选了，移动指针继续寻找下一组
                    l++;
                    r--;
//                    剪枝，相同的没必要再判断了
                    while(l<r && nums[l] == nums[l-1]) l++;
                    while(l<r && nums[r] == nums[r+1]) r--;
                }
            }
        }
        return ans;
    }
}
