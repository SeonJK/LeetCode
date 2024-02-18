class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        int i = 1;
        for (; i < nums.length; i++) {
            result[i] = nums[i-1] * result[i-1];
        }
        int suffixNum = nums[i-1];
        for (int j = nums.length-2; j >= 0; j--) {
            result[j] *= suffixNum;
            suffixNum *= nums[j];
        }
        
        return result;
    }
}