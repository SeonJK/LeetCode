class Solution {    
    public int orangesRotting(int[][] grid) {
        Queue<Pair> rottenQ = new LinkedList<Pair>();
        
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    rottenQ.add(new Pair(i, j , time));
                }
            }
        }
        
        Pair p = new Pair(0,0,0);
        
        while(!rottenQ.isEmpty()) {
            p = rottenQ.poll();
            
            int x = p.getX();
            int y = p.getY();
            int t = p.getTime();
            
            if (x > 0 && grid[x-1][y] == 1) {
                grid[x-1][y] = 2;
                rottenQ.add(new Pair(x-1, y, t+1));
            }
            if (y > 0 && grid[x][y-1] == 1) {
                grid[x][y-1] = 2;
                rottenQ.add(new Pair(x, y-1, t+1));
            }
            if (x < m-1 && grid[x+1][y] == 1) {
                grid[x+1][y] = 2;
                rottenQ.add(new Pair(x+1, y, t+1));
            }
            if (y < n-1 && grid[x][y+1] == 1) {
                grid[x][y+1] = 2;
                rottenQ.add(new Pair(x, y+1, t+1));
            }
        }
        
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }
        return p.getTime();
    }
}

class Pair {
    int x, y;
    int time;
    
    public Pair(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getTime() {
        return this.time;
    }
}