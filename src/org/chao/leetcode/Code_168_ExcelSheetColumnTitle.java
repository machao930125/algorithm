package org.chao.leetcode;

/**
 * 匹配标题号
 * <p>
 * 来源：力扣（LeetCode）
 * https://leetcode-cn.com/problems/excel-sheet-column-title
 */
public class Code_168_ExcelSheetColumnTitle {

    public static String convertToTitle(int columnNumber){
        StringBuilder builder = new StringBuilder();
        while (columnNumber != 0){
            columnNumber --;
            builder.append((char) (columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26 ;
        }
        return builder.reverse().toString();
    }

    /**
     * 十进制转十六进制
     *
     * @param num
     * @return
     */
    public static String toHex(int num) {
        if(num == 0){
            return "0";
        }
        char[] array = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        StringBuilder result = new StringBuilder();
        while(num != 0){
            // 使用位与，与15位与是因为15二进制位1111，可以得到num的后四位
            result.append(array[num & 15]);
            // 无符号右移，左边填0
            num = num >>> 4;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
//        System.out.println(toHex(1));
        System.out.println(convertToTitle(701));
    }

}
