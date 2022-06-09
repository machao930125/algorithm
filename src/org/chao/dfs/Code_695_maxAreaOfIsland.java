package org.chao.dfs;

public class Code_695_maxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 0){
            return 0;
        }

        int area = 0;
        if (grid[r][c] == 1){
            area = 1;
        }

        grid[r][c] = 0;

        area += dfs(grid, r , c + 1);
        area += dfs(grid, r , c - 1);
        area += dfs(grid, r + 1 , c);
        area += dfs(grid, r - 1 , c);

        return area;
    }
}
