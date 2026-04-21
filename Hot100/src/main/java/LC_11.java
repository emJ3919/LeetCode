/**
 * 题目：盛水最多的容器
 * 思路：双指针从两端向中间收敛。水槽面积由短板决定，收敛时移动短板那边。
 *       因为移动长板只会让宽度变小而高度不会增加，所以没必要。
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */

public class LC_11 {
    public int maxArea(int[] height){
        // 记录最大容量
        int max = 0;
        // 左右指针
        int left = 0;
        int right = height.length - 1;
        while(left < right){
//            左指针更小，移动左指针，并更新最大值
            if(height[left] <= height[right]){
                max = Math.max(max, height[left] * (right - left));
                left++;
            }
//            右指针更小，移动右指针，并更新最大值
            else {
                max = Math.max(max, height[right] * (right - left));
                right--;
            }
        }
        return max;
    }
}
