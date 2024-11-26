class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val pascal = mutableListOf<List<Int>>()
        
        pascal.add(listOf(1))
        if (numRows == 1) {
            return pascal.toList()
        }
        
        pascal.add(listOf(1, 1))
        if (numRows == 2) {
            return pascal.toList()
        }
        
        for (i in 2 until numRows) {
            val arr = Array<Int> (i+1) {1}
            
            for (j in 1 .. i) {
                if (j == i) {
                    arr[j] = 1
                    break
                }
                
                arr[j] = pascal[i-1][j-1] + pascal[i-1][j]
            }
            pascal.add(arr.toList())
        }
        
        return pascal.toList()
    }
}