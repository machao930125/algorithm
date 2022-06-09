package org.chao.leetcode;

/**
 * 字符串相加
 */
public class Code_415_addString {
    public String addString(String num1, String num2){
        int i = num1.length() -1;
        int j = num2.length() -1;
        int add = 0;

        StringBuffer buffer = new StringBuffer();
        while (i >= 0 || j >= 0 || add > 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0':0;
            int n2 = j >= 0 ? num2.charAt(j) - '0':0;

            int sum = n1 + n2 + add;
            add = sum/10;
            buffer.append(sum%10);
            i --; j --;
        }
        return buffer.reverse().toString();
    }

}
