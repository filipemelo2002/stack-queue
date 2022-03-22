package com.company.BFS;


import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    private final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private void fillWithWater(char[][] grid, int rows,int  columns,int  i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        // 2D -> 1F = R * #cols + C
        // 1D -> 2D =  index / #cols = R, index  % #cols = C

        queue.add(i * columns + j);
        grid[i][j] = '0';

        while (!queue.isEmpty()) {
            int index = queue.poll();
            int row = index / columns;
            int column = index % columns;

            for (int[] direction: DIRECTIONS) {
                int x = direction[0] + row;
                int y = direction[1] + column;

                if (x > -1 && x < rows && y > -1 && y < columns && grid[x][y] == '1') {
                    grid[x][y] = '0';
                    queue.add(x * columns + y);
                }
            }

        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int numberOfIslands = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        for (int i =0; i < rows; i++) {
            for (int j =0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    ++numberOfIslands;
                    grid[i][j] = '0';
                    fillWithWater(grid, rows, columns, i, j);
                }
            }
        }

        return numberOfIslands;
    }

}
