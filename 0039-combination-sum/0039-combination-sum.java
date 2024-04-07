class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backTrack(List<List<Integer>> list, List<Integer> tmpList, int[] candidates, int remain, int start) {
        if (remain < 0)
            return;
        
        if (remain == 0)
            list.add(new ArrayList<>(tmpList));
        else {
            for (int i = start; i < candidates.length; i++) {
                tmpList.add(candidates[i]);
                backTrack(list, tmpList, candidates, remain - candidates[i], i);
                tmpList.remove(tmpList.size()-1);
            }
        }
    }
}