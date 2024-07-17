package com.mutemi.leetcode.validsudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (validateRows(board)) {
            if (validateColumns(board)) {
                return validateGrid(board);
            }
        }
        return false;
    }

    boolean validateRows(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!validate(board[i])) {
                return false;
            }
        }
        return true;
    }

    boolean validateColumns(char[][] board) {
        for (int columnIndex = 0; columnIndex < board.length; columnIndex++) {
            char[] column = new char[board.length];
            for (int index = 0; index < board.length; index++) {
                column[index] = board[index][columnIndex];
            }
            if (!validate(column)) {
                return false;
            }
        }
        return true;
    }

    boolean validateGrid(char[][] board) {
        int[] grid = {0, 0};
        for (int b = 0;  b < board.length; b++) {
            int rowIndex = 0;
            char[] gridData = new char[board.length];
            for (int rowId = 3*grid[0]; rowId < 3*grid[0] + 3; rowId++ ) {
                for (int colId = (3*grid[1]); colId < (3*grid[1]) + 3; colId++) {
                    System.out.println("ColId "+ colId);
                    gridData[rowIndex] = board[rowId][colId];
                    rowIndex++;
                }
            }
            if (!validate(gridData)) {
                return false;
            }
            if(grid[1] < 2) {
                grid[1]++;
            } else {
                grid[0]++;
                grid[1] = 0;
            }
        }
        return true;
    }

    boolean validate(char[] row) {
        Set<Character> characterSet = new HashSet<>();
        String allowedChars = "123456789.";
        int nonEmptyElements = 0;
        for (char c : row) {
            if (!allowedChars.contains(String.valueOf(c))) {
                return false;
            }
            if (!String.valueOf(c).equalsIgnoreCase(".")) {
                nonEmptyElements++;
                characterSet.add(c);
            }
        }
        if (characterSet.size() != nonEmptyElements) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] validSudokuBoard = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '9', '.', '.', '7', '9'}
        };
        System.out.println(solution.isValidSudoku(validSudokuBoard));
    }
}

