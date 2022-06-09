package org.chao.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class Code_054_spiralOrder {

    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> ans = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return ans;
        }

        int rows = matrix.length; int columns = matrix[0].length;
        int row = 0; int column = 0;
        boolean[][] visited = new boolean[rows][columns];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int total = rows * columns;
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            ans.add(matrix[row][column]);
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            visited[row][column] = true;
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]){
                directionIndex = (directionIndex + 1) % 4;
            }

            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }

        return ans;
    }
}
