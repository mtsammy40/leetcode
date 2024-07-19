package com.mutemi.leetcode.rotate_matrix;

/*
    https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/
 */

public class Solution {
    public void rotate(int[][] matrix) {
        printMatrix(matrix);
        int traversal = matrix.length / 2;
        for (int startIndex = 0; startIndex < traversal; startIndex++) {
            System.out.printf("Start index = " + startIndex +"\n");
            int end = matrix.length - 1 - startIndex;
            for (int y = 0; y < end - startIndex; y++) {
                int temp = matrix[startIndex + y][end];
                // top left to top right
                matrix[startIndex + y][end] = matrix[startIndex][startIndex + y];
                // bottom left to top right
                matrix[startIndex][startIndex + y] = matrix[end - y][startIndex];
                // bottom right to bottom left
                matrix[end - y][startIndex] = matrix[end][end - y];
                // top right to bottom right
                matrix[end][end - y] = temp;

                printMatrix(matrix);
            }
        }

        printMatrix(matrix);
    }

    public void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.printf(matrix[row][col] + " | ");
            }
            System.out.println("\n");
        }
        System.out.println("--------------- end");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        int[][] matrix = {
//                {1, 2, 3, 4, 5},
//                {6, 7, 8, 9, 10},
//                {11, 12, 13, 14, 15},
//                {16, 17, 18, 19, 20},
//                {21, 22, 23, 24, 25}
//        };
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        solution.rotate(matrix);
    }
}
