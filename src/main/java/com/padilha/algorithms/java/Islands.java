package com.padilha.algorithms.java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
 */
public class Islands {

    private static int n;
    private static int m;

    public static int numIslandsDFS(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> frontier = new LinkedList<>();
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    frontier.offer(new int[]{i, j});
                    visited[i][j] = true;
                    DFSMarkingIsland(grid, frontier, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void DFSMarkingIsland(char[][] grid, Queue<int[]> frontier, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        while(!frontier.isEmpty()) {
            int[] current = frontier.poll();
            // Verifying Direction (Up, Down, Left, Right)
            int[][] dirs = {{-1,0}, {1,0}, {0, -1}, {0, 1}};
            for (int[] dir : dirs) {
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >=n || visited[x][y] || grid[x][y] == '0') continue;
                visited[x][y] = true;
                frontier.offer(new int[]{x, y});
                DFSMarkingIsland(grid, frontier, visited);
            }

        }
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    // Depth First Search Solution (Explore the deeper path first)
    private static void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        // Verify Down
        DFSMarking(grid, i + 1, j);
        // Verify Up
        DFSMarking(grid, i - 1, j);
        // Verify Left
        DFSMarking(grid, i, j + 1);
        // Verify Right
        DFSMarking(grid, i, j - 1);
    }

    // Breadth First Search Solution - The Shortest Path (Explore all Paths one at time)
    private static int numIslandBFS(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> frontier = new LinkedList<>();
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    frontier.offer(new int[]{i, j});
                    visited[i][j] = true;
                    BFSMarking(grid, frontier, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void BFSMarking(char[][] grid, Queue<int[]> queue, boolean[][] visited) {
        int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                if (x < 0 || x >= m || y < 0 || y >=n || visited[x][y] || grid[x][y] == '0')
                    continue;

                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}};
        if (numIslands(grid) == 1) {
            System.out.println("Passed - Test 1 - DFS");
        } else {
            System.out.println("Failed - Test 1 - DFS");
        }
        // Test 2
        char[][] grid2 = {{'1','1','0','0','0'},
                          {'1','1','0','0','0'},
                          {'0','0','1','0','0'},
                          {'0','0','0','1','1'}};
        if (numIslands(grid2) == 3) {
            System.out.println("Passed - Test 2 - DFS");
        } else {
            System.out.println("Failed - Test 2 - DFS");
        }
        char[][] grid1Bfs = {{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        if (numIslandBFS(grid1Bfs) == 1) {
            System.out.println("Passed - Test 1 - BFS");
        } else {
            System.out.println("Failed - Test 1 - BFS");
        }

        char[][] grid2BFS = {{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        if (numIslands(grid2BFS) == 3) {
            System.out.println("Passed - Test 2 - BFS");
        } else {
            System.out.println("Failed - Test 2 - BFS");
        }

        char[][] grid1DfsOwn = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        if (numIslandsDFS(grid1DfsOwn) == 1) {
            System.out.println("Passed - Test 1 - DFS - Own");
        } else {
            System.out.println("Failed - Test 1 - DFS - Own");
        }


        char[][] grid2DFSOwn = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        if (numIslandsDFS(grid2DFSOwn) == 3) {
            System.out.println("Passed - Test 2 - DFS - Own");
        } else {
            System.out.println("Failed - Test 2 - DFS - Own");
        }
    }
}
