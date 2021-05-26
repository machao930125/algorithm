package org.chao;

/**
 * 括号有效配对是指：
 * 1）任何一个左括号都能找到和其正确配对的右括号
 * 2）任何一个右括号都能找到和其正确配对的左括号
 * 有效的：    (())  ()()   (()())  等
 * 无效的：     (()   )(     等
 * 问题一：怎么判断一个括号字符串有效？
 * 问题二：如果一个括号字符串无效，返回至少填几个字符能让其整体有效
 * 问题三：最大有效括号，子字符串长度
 * 问题四：最大有效括号深度
 */
public class Code002_Parentheses {

    public static void main(String[] args) {
        String str = "(()))(";
        System.out.println(valid(str));
        System.out.println(needParentheses(str));
    }

    // 是否是有效字符串
    public static boolean valid(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            count += '(' == chars[i] ? 1 : -1;
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    // 需要多少个括号将其整体有效
    public static int needParentheses(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        int needNum = 0;
        for (int i = 0; i < chars.length; i++) {
            count += '(' == chars[i] ? 1 : -1;
            if (count < 0) {
                needNum++;
                count = 0;
            }
        }
        return count + needNum;
    }

    // 最大有效子字符串长度
    public static int maxLength(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] str = s.toCharArray();
        int[] dp = new int[str.length];
        int pre = 0;
        int ans = 0;
        // dp[0] = 0;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == ')') {
                pre = i - dp[i - 1] - 1; // 与str[i]配对的左括号的位置 pre
                if (pre >= 0 && str[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // 最大深度
    public static int deep(String s){
        if (!valid(s)){
            return 0;
        }
        char[] chars = s.toCharArray();
        int count = 0;
        int max = 0;
        for (int i = 0 ; i < chars.length; i ++){
            if ('(' == chars[i]){
                count ++;
                max = Math.max(max, count);
            }else {
                count --;
            }
        }
        return max;
    }
}
