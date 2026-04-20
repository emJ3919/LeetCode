import java.util.HashSet;
import java.util.Set;

public class LC_136 {
    // 哈希表
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            if (set.contains(num)){
                set.remove(num);
            }else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }
    // 异或运算
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int num: nums){
            ans = ans ^ num; // xor
        }
        return ans;
    }
}
