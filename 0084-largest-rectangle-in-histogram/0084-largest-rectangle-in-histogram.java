class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        if (heights.length == 1)
            return heights[0];
        
        int[] lessFromLeft = new int[heights.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[heights.length]; // idx of the first bar the right that is lower than current
        lessFromRight[heights.length - 1] = heights.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;

            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
        
        // MyAnswer - Time Exceeded
//         int n = heights.length;
//         int maxArea = 0;
//         for (int i = 0; i < n; i++) {
//             int minHeight = heights[i];
//             int area = minHeight;
            
//             for (int j = i-1; j >= 0; j--) {
//                 if (minHeight <= heights[j]) {
//                     area += minHeight;
//                 } else {
//                     break;
//                 }
//             }
            
//             for (int k = i+1; k < n; k++) {
//                 if (minHeight <= heights[k]) {
//                     area += minHeight;
//                 } else {
//                     break;
//                 }
//             }
            
//             maxArea = Math.max(maxArea, area);
//         }
//         return maxArea;
    }
}