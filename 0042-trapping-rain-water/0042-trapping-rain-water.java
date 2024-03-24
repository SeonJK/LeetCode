class Solution {
    
    int waterHeight = 0;
    
    public int trap(int[] height) {
        if (height.length <= 2)
           return 0;
        
        int i = 0;
        int j = height.length - 1;
        int Lmax = Integer.MIN_VALUE;
        int Rmax = Integer.MIN_VALUE;
        
        while(i < j) {
            Lmax = Math.max(Lmax, height[i]);
            Rmax = Math.max(Rmax, height[j]);
            
            if (Lmax < Rmax) {
                waterHeight += Lmax - height[i++];
            } else {
                waterHeight += Rmax - height[j--]; 
            }
        }
        
        return waterHeight;
    }
}