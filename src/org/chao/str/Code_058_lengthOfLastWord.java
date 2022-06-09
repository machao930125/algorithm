package org.chao.str;

/**
 * 最后一个单次长度
 */
public class Code_058_lengthOfLastWord {
    public int lengthOfLastWord(String s){
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' '){
            index --;
        }
        int len = 0;
        while (index >= 0 && s.charAt(index) == ' '){
            index --;
            len ++;
        }
        return len;
    }
}
