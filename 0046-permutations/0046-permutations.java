class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backTrack(list, nums, 0);
        return list;
    }

    void backTrack(List<List<Integer>> list, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> tempList = new ArrayList<>();
            for (int num : nums) {
                tempList.add(num);
            }
            list.add(tempList);
        } else {
            for (int i = start; i < nums.length; ++i) {
                swap(nums, start, i);
                backTrack(list, nums, start+1);
                swap(nums, start, i);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}