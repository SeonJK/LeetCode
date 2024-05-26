class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] visited = new boolean[m][n];
        for (boolean[] sub : visited) Arrays.fill(sub, false);
        
        processRight(0, 0, ans, matrix, visited);
        
        return ans;
    }
    
    private void processRight(int i, int j, List<Integer> list, int[][] mat, boolean[][] visited) {
        while (j < mat[0].length && !visited[i][j]) {
            list.add(mat[i][j]);
            visited[i][j] = true;
            j++;
        }
        
        if (i+1 < mat.length && !visited[i+1][j-1])
            processDown(i+1, j-1, list, mat, visited);
    }
    
    private void processDown(int i, int j, List<Integer> list, int[][] mat, boolean[][] visited) {
        while (i < mat.length && !visited[i][j]) {
            list.add(mat[i][j]);
            visited[i][j] = true;
            i++;
        }
        
        if (j-1 >= 0 && !visited[i-1][j-1])
            processLeft(i-1, j-1, list, mat, visited);
    }
    
    private void processLeft(int i, int j, List<Integer> list, int[][] mat, boolean[][] visited) {
        while (j >= 0 && !visited[i][j]) {
            list.add(mat[i][j]);
            visited[i][j] = true;
            j--;
        }
        
        if (i-1 >= 0 && !visited[i-1][j+1])
            processUp(i-1, j+1, list, mat, visited);
    }
    
    private void processUp(int i, int j, List<Integer> list, int[][] mat, boolean[][] visited) {
        while (i >= 0 && !visited[i][j]) {
            list.add(mat[i][j]);
            visited[i][j] = true;
            i--;
        }
        
        if (j+1 < mat[0].length && !visited[i+1][j+1])
            processRight(i+1, j+1, list, mat, visited);
    }
}