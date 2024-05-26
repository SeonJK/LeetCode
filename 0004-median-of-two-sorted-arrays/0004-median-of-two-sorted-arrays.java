class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        List<Integer> merged = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) merged.add(nums1[i]);
        for(int i = 0; i < nums2.length; i++) merged.add(nums2[i]);
        
        int[] arr = merged.stream().mapToInt(i -> i).toArray();
        Arrays.sort(arr);
        
        int l = 0;
        int h = arr.length - 1;
        int mid=0;
        
        mid = (l+h) / 2;
        double ans = 0;
        
        if(arr.length % 2 == 0)
            ans = (double) (arr[mid+1] + arr[mid]) / 2;
        else
            ans = (double) arr[mid];
      
        return ans;
    }
}