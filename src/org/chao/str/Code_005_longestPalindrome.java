package org.chao.str;

/**
 * 最长回文字符串
 */
public class Code_005_longestPalindrome {

    public String longestPalindrome(String s) {
        int start = 0; int end =0;

        for (int i = 0; i < s.length(); i++) {
            int leng1 = expandAroundCenter(s, i, i);
            int leng2 = expandAroundCenter(s, i, i + 1);
            int max = Math.max(leng1, leng2);
            if (max > end - start){
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int i, int j){
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i --;
            j ++;
        }
        return j - i - 1;
    }

}
