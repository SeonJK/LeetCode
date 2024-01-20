class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> answer = new ArrayList<>();
        
        int j, k;
        for (int i = 0; i < nums.length; i++) {
            j = i+1;
            k = nums.length-1;
            
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> elem = Arrays.asList(nums[i], nums[j], nums[k]);                       s.add(elem);
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        answer.addAll(s);
        return answer;
        
    }
}