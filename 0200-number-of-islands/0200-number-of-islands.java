class Solution {
    
    int n, m;
    
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        n = grid.length;
        m = grid[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return islandCount;
    }
    
    void dfs(char[][] grid, int x, int y) {
        grid[x][y] = '2';
        
        if (x > 0 && grid[x-1][y] == '1')
            dfs(grid, x-1, y);
        if (y > 0 && grid[x][y-1] == '1')
            dfs(grid, x, y-1);
        if (x < n-1 && grid[x+1][y] == '1')
            dfs(grid, x+1, y);
        if (y < m-1 && grid[x][y+1] == '1')
            dfs(grid, x, y+1);
    }
}