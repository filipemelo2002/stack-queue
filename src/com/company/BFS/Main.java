package com.company.BFS;

public class Main {
    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] grid =
                {{'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}};
        System.out.println(numberOfIslands.numIslands(grid));
    }
}
