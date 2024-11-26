class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
        
        pascal.add(Arrays.asList(1));
        if (numRows == 1) {
            return pascal;
        }
        
        pascal.add(Arrays.asList(1,1));
        if (numRows == 2) {
            return pascal;
        }
        
        for (int i = 2; i < numRows; i++) {
            int[] arr = new int[i+1];
            arr[0] = 1;
            
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    arr[j] = 1;
                    break;
                }
                
                arr[j] = pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j);
            }
            pascal.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        }
        
        return pascal;
    }
}