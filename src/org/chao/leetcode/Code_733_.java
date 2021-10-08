package org.chao.leetcode;

public class Code_733_ {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image.length; j ++){
                if(image[i][j] == target){
                    image[i][j] = newColor;
                }
            }
        }

        return image;
    }
}
