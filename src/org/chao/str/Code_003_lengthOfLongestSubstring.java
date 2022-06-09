package org.chao.str;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 */
public class Code_003_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i ++){
            Character c = s.charAt(i);

            while(set.contains(c)){
                set.remove(s.charAt(left++));
            }

            set.add(c);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
