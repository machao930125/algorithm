package org.chao.leetcode;

import java.util.Arrays;

/**
 * 双指针
 */
public class Code_334_ReverseString {
    // 翻转字符串
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'s', 'b', 'f', 'h'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
