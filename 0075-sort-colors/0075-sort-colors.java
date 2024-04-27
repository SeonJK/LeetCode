class Solution {
    public void sortColors(int[] nums) {
        // Bubble sort
        // bubbleSort(nums);
        
        // Selection sort
        selectionSort(nums);
    }
    
    private void bubbleSort(int[] nums) {
        int i, j , key;
        for (i = 0; i < nums.length-2; i++) {
            for (j = 0; j < nums.length-1; j++) {
                if (nums[j] > nums[j+1]) {
                    key = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = key;
                }
            }
        }
    }
    
    private void selectionSort(int[] nums) {
        int i, j, key;
        for (i = 0; i < nums.length-1; i++) {
            int minPosition = i;
            for (j = i+1; j < nums.length; j++) {
                if (nums[minPosition] > nums[j])
                    minPosition = j;
            }
            if (i != minPosition) {
                key = nums[minPosition];
                nums[minPosition] = nums[i];
                nums[i] = key;
            }
        }
    }
}