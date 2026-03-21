import java.util.*;

public class LC_438 {
        public List<Integer> findAnagrams(String s, String p) {
            int[] sCount = new int[26];
            int[] pCount = new int[26];
            int sLen = s.length();
            int pLen = p.length();
            List<Integer> ans = new ArrayList<>();
            if (sLen < pLen){
                return ans;
            }
            //初始化窗口频次，窗口大小就是pLen
            for (int i = 0; i < pLen; i++){
                sCount[s.charAt(i) - 'a']++;
                pCount[p.charAt(i) - 'a']++;
            }
            //窗口在初始位置直接进行下比较
            if (Arrays.equals(sCount, pCount)){
                ans.add(0);
            }
            for (int i = 0; i < sLen - pLen; i++){
                //计算右移窗口后的频次
                sCount[s.charAt(i) - 'a']--;
                sCount[s.charAt(i + pLen) - 'a']++;
                if (Arrays.equals(sCount, pCount)){
                    ans.add(i + 1);
                }
            }
            return ans;
    }
}
