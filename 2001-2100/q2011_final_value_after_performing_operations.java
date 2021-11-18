// =========== 2 solutions =============

class Solution {
    public int finalValueAfterOperations(String[] op) {
        int res = 0;
        
        for(String str : op)
        {
            if(str.equals("++X") || str.equals("X++"))
            {
                ++res;
            }
            else
            {
                --res;
            }
        }
        
        return res;
    }
}

//more stylish solution and with no autoboxing
class Solution {
    public int finalValueAfterOperations(String[] op) {
        int res = 0;
        
        for(String str : op)
        {
            res += (str.charAt(1) == '+' ? 1: -1);
        }
        
        return res;
    }
}