class Solution {
    int modulo = 1000000007;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] arr = new int[m][n][maxMove+1];
        for (int[][] l : arr)
            for (int[] s : l)
                Arrays.fill(s, -1);
        
        return recursive(m, n, maxMove, startRow, startColumn, arr);
    }
    
    public int recursive(int m, int n, int mm, int r, int c, int[][][] arr) {
        if (r==m || c==n || r<0 || c<0) 
            return 1;
        if (mm == 0) 
            return 0;
        if (arr[r][c][mm] >= 0) 
            return arr[r][c][mm];
        
        arr[r][c][mm] = (
            (recursive(m, n, mm-1, r-1, c, arr)+
             recursive(m, n, mm-1, r+1, c, arr)) % modulo
            + (recursive(m, n, mm-1, r, c-1, arr)+
               recursive(m, n, mm-1, r, c+1, arr)) % modulo)
            % modulo;
        
        return arr[r][c][mm];
    }
}