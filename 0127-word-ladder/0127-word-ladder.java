class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        
        int cnt=0;
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        while(!q.isEmpty()){
            cnt++;
            int size = q.size();
            
            for(int k = 0; k < size; k++){
                String word = q.poll();
                if(word.equals(endWord))
                    return cnt;
                
                for(int i = 0; i < word.length(); i++){
                    for(char ch= 'a'; ch <= 'z'; ch++){
                        char[] arr = word.toCharArray();
                        arr[i] = ch;
                        String midWord = new String(arr);
                        if(dict.contains(midWord)){
                            q.add(midWord);
                            dict.remove(midWord);
                        }
                    }
                }
            }
        }
        
        return 0; 
    }
}