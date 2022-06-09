package org.chao.dfs;

/**
 * 岛屿周长
 */
public class Code_463_islandPerimeter {
    public int islandPerimeter(int[][] grid){
        if (grid == null || grid.length == 0){
            return 0;
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    res = dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 0){
            return 1;
        }

        if (grid[r][c] == 2){
            return 0;
        }

        grid[r][c] = 2;

        int res = 0;
        res += dfs(grid, r,  c + 1);
        res += dfs(grid, r,  c - 1);
        res += dfs(grid, r + 1,  c);
        res += dfs(grid, r - 1,  c);

        return res;

    }

}
