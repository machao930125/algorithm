package org.chao.leetcode;

public class Code_557_ReverseString {
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' '){
                reverseChars(chars, left, i - 1);
                left = i + 1;
            }
            if (i == chars.length -1){
                reverseChars(chars, left, i);
            }
        }
        return String.valueOf(chars);
    }

    public static void reverseChars(char[] chars, int left, int right){
        while (left < right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left ++;
            right --;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
