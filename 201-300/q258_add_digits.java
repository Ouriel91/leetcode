// =========== 2 solutions =============

//num is non negative number

//iterative solution, divide the original number, and summarize the remainder
//do it again to the sum,
//if the return smaller than 10 return it, if not summarize it as we did to the sum
//and return it
class Solution {
    public int addDigits(int num) {
        
        int sum = 0;
        int ret = 0;
        
        while(0 != num)
        {
            sum += num % 10;
            num /= 10;
        }
        
        while(0 != sum)
        {
            ret += sum % 10;
            sum /= 10;
        }
        
        if(ret >= 10)
        {
            int end = 0;
            
            while(ret != 0)
            {
                end += ret % 10;
                ret /= 10;
            }
            
            return end;
        }
        
        return ret;
    }
}

//o(1) solution
//if the number smaller than 9 (and not negative - question requirment) - return it
//else - chcek if the number divid in 9 with no remainder - return it, else return the 
//remainder of divid in 9
//more details here: https://en.wikipedia.org/wiki/Congruence_relation
class Solution {
    public int addDigits(int num) {
        
        return num > 9 ? (num%9 == 0 ? 9  : num%9) :num;
    }    
}
