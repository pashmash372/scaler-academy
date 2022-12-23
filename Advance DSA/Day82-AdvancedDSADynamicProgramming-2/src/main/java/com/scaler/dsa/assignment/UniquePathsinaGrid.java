package com.scaler.dsa.assignment;


import java.util.ArrayList;
import java.util.Arrays;

public class UniquePathsinaGrid {
    private int[][] mem;
    private ArrayList<ArrayList<Integer>> A;

    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int m, n;
        if (A == null) return 0;
        m = A.size();
        if (m == 0) return 0;
        n = A.get(0).size();
        if (n == 0) return 0;
        mem = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(mem[i], -1);
        this.A = A;
        if (A.get(0).get(0) == 0) mem[0][0] = 1;
        rec(m - 1, n - 1);
        return mem[m - 1][n - 1];
    }

    public int rec(int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (mem[i][j] != -1) return mem[i][j];
        if (A.get(i).get(j) == 1) return mem[i][j] = 0;
        mem[i][j] = rec(i - 1, j) + rec(i, j - 1);
        return mem[i][j];
    }

}
/* Another solution */
class UniquePathsinaGrid1 {
    public int uniquePathsWithObstacles(int[][] A) {
        int[] firstRow = new int[A[0].length];
        int[] secondRow = new int[A[0].length];
        for (int i = 0; i < firstRow.length; i++) {
            if (A[0][i] == 1) {
                firstRow[i] = 0;
            } else if (i == 0) {
                firstRow[i] = 1;
            } else {
                firstRow[i] = firstRow[i - 1];
            }
        }
        if (A.length == 1) {
            return firstRow[firstRow.length - 1];
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    secondRow[j] = 0;
                } else if (j == 0) {
                    secondRow[j] = firstRow[j];
                } else {
                    secondRow[j] = secondRow[j - 1] + firstRow[j];
                }
            }
            firstRow = secondRow;
        }
        return secondRow[secondRow.length - 1];
    }
}

class UniquePathsinaGrid2 {
    public int uniquePathsWithObstacles(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        Boolean[][] visited = new Boolean[rows][cols];
        Integer[][] dp = new Integer[rows][cols];
        return uniquePathsHelper(A, 0, 0, rows, cols, visited, dp);
    }

    int uniquePathsHelper(int[][] A, int i, int j, int endRow, int endCol, Boolean[][] visited, Integer[][] dp) {

        if (i == endRow - 1 && j == endCol - 1 && A[i][j] == 0) {
            return 1;
        } else if (i < 0 || i == endRow || j < 0 || j == endCol || visited[i][j] != null && visited[i][j] || A[i][j] == 1) {
            return 0;
        } else if (dp[i][j] != null) {
            return dp[i][j];
        }
        int right = uniquePathsHelper(A, i, j + 1, endRow, endCol, visited, dp);
        int down = uniquePathsHelper(A, i + 1, j, endRow, endCol, visited, dp);
        return dp[i][j] = right + down;
    }
}

/*Q2. Unique Paths in a Grid
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved.
Get help from TA.
Problem Description
Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty space is marked as 1 and 0 respectively in the grid.



Problem Constraints
1 <= n, m <= 100
A[i][j] = 0 or 1



Input Format
Firts and only argument A is a 2D array of size n * m.



Output Format
Return an integer denoting the number of unique paths from (1, 1) to (n, m).



Example Input
Input 1:

 A = [
        [0, 0, 0]
        [0, 1, 0]
        [0, 0, 0]
     ]
Input 2:

 A = [
        [0, 0, 0]
        [1, 1, 1]
        [0, 0, 0]
     ]


Example Output
Output 1:

 2
Output 2:

 0*/

/*Suppose dp[i][j] represents the number of unique paths to reach (i, j).

If you look at a cell, there are atmost 2 ways to reach it. From the cell left and up.

If the cell does not have an obstacle, then the number of ways to reach this cell would be the summation of the number of ways to reach the immediate neighbors preceding it ( left and up ).

So, dp[i][j] = dp[i-1][j] + dp[i][j-1] if (i-1, j) and (i, j-1) doesn’t have obstacles.
= dp[i-1][j] if only (i-1, j) doesn’t have obstacle
= dp[i][j-1] if only (i, j-1) doesn’t have obstacle
= 0 otherwise

dp[n][m] will be our answer.*/