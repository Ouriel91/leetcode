// =========== 1 solutions =============

class Solution {
    public int numberOfSteps(int num) {
        int count  = 0;
        
        while(0 != num)
        {
            if(0 == num % 2)
            {
                num >>= 1; //divide by 2
            }
            else
            {
                --num;
            }
            
            ++count;
        }
        
        return count;
    }
}
