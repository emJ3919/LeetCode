import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_128 {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }
        for (int num: set){
            if (!set.contains(num - 1)){
                int currentNum = num;
                int currentLength = 1;
                while (set.contains(currentNum + 1)){
                    currentLength++;
                    currentNum++;
                }
                max = Math.max(max, currentLength);
            }
        }
        return max;
    }
}
