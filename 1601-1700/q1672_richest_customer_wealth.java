// =========== 2 solutions =============

//use index solution
class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int max = 0;
        
        for(int i = 0; i<accounts.length; ++i)
        {
            int max_temp = 0;
            for(int j = 0; j<accounts[i].length; ++j)
            {
                max_temp += accounts[i][j];
            }
            
            max = Math.max(max, max_temp);
        }
        
        return max;
    }
}

//foreach version
class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int max = 0;
        
        for(int []customer :accounts)
        {
            int max_temp = 0;
            for(int account : customer)
            {
                max_temp += account;
            }
            
            max = Math.max(max, max_temp);
        }
        
        return max;
    }
}
