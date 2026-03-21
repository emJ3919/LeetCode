import java.util.HashSet;
import java.util.Set;

public class LC_3 {
    public int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>();
        int window = -1;
        int len = s.length();
        int max_len = 0;
        for (int i = 0; i < len; i++){
            if (i !=0 ){
                set.remove(s.charAt(i - 1));
            }
            while (window + 1 < len && !set.contains(s.charAt(window + 1))){
                window++;
                set.add(s.charAt(window));
                max_len = Math.max(max_len, window - i + 1);
            }
        }
        return max_len;
    }

}
