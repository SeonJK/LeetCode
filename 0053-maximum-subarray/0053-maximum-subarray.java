class Solution {
    public int maxSubArray(int[] nums) {
        int total = 0;
        int result = Integer.MIN_VALUE;
        
        for (int n : nums) {
            total += n;
            result = Math.max(total, result);
            
            if (total < 0) {
                total = 0;
            }
        }
        
        return result;
    }
}