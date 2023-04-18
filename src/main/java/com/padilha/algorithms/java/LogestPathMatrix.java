package com.padilha.algorithms.java;

public class LogestPathMatrix
{
    private int[][] DIRECTIONS = {{1,0}, {-1,0},{0,1},{0,-1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int n = matrix.length, m = matrix[0].length, longestPath = 0;
        int[][] cache = new int[][]{};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int longest = longestIncreasingPath(matrix, cache, n, m, i, j);
                longestPath = Math.max(longestPath, longest);
            }
        }
        return longestPath;
    }

    private int longestIncreasingPath(int[][] matrix, int[][] cache, int n, int m, int i, int j) {
        if (cache[i][j] > 0) return cache[i][j];
        int max = 0;
        for (int[] direction : DIRECTIONS) {
            int x = direction[0] + i, y = direction[i] + j;
            if (x > -1 && y > -1 && x < n && y < n && matrix[x][y] > matrix[i][j]){
                int longest = longestIncreasingPath(matrix, cache, n, m, x, y);
                max = Math.max(max, longest);
            }
        }
        cache[i][j] = max + 1;
        return cache[i][j];
    }

    public static void main(String[] args) {

    }
}
