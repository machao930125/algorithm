package org.chao.array;

/**
 * 最大正方形
 */
public class Code_dp_221_maximalSquare {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return maxSide;
        }
        int raws = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[raws][columns];

        for (int i = 0; i < raws; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1'){
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                    }
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }
}
