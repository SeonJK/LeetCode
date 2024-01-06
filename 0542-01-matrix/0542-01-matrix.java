class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int MAX = mat.length + mat[0].length;
        for (int i = 0 ; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) { 
                    continue;
                }
                
                int top = MAX, left = MAX;
                if (i-1 >= 0) {
                    top = mat[i-1][j];
                }
                if (j-1 >= 0) {
                    left = mat[i][j-1];
                }
                
                mat[i][j] = Math.min(top, left) + 1;
            }
        }
        
        for (int k = mat.length - 1; k >= 0; k--) {
            for (int v = mat[k].length - 1; v >= 0; v--) {
                if (mat[k][v] == 0) {
                    continue;
                }
                
                int bottom = MAX, right = MAX;
                if (k+1 < mat.length) {
                    bottom = mat[k+1][v];
                }
                if (v+1 < mat[k].length) {
                    right = mat[k][v+1];
                }
                
                mat[k][v] = Math.min(mat[k][v], Math.min(bottom, right)+1);
            }
        }
        
        return mat;
    }
}