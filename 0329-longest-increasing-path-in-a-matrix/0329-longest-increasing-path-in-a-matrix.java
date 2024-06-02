class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[][] memo = new int[row][col];
        int res = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int currMax = dfs(matrix, i, j, memo);
                res = Math.max(res, currMax);
            }
        }
        return res;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (i<0 || i>=matrix.length || j<0 || j>=matrix[i].length)
            return 0;
        // if (prev >= matrix[i][j])
        //     return 0;
        if (memo[i][j] != 0)
            return memo[i][j];
        
        int top=1, bottom=1, left=1, right=1;
        
        if (i>0 && matrix[i-1][j]>matrix[i][j])
            top = dfs(matrix, i-1, j, memo) + 1;
        if (i<matrix.length-1 && matrix[i+1][j]>matrix[i][j])
            bottom = dfs(matrix, i+1, j, memo) + 1;
        if (j>0 && matrix[i][j-1]>matrix[i][j])
            left = dfs(matrix, i, j-1, memo) + 1;
        if (j<matrix[0].length-1 && matrix[i][j+1]>matrix[i][j])
            right = dfs(matrix, i, j+1, memo) + 1;
        
        int max = top;
        max = Math.max(max, bottom);
        max = Math.max(max, left);
        max = Math.max(max, right);
        
        return memo[i][j] = max;
    }
}