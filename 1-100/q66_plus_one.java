// =========== 2 solutions =============

//shorter version of code
class Solution {
    public int[] plusOne(int[] arr) {
          
        for(int i = arr.length-1;i>=0;--i)
        {
            if(arr[i] < 9)
            {
                ++arr[i];
                
                return arr;
            }
            
            arr[i] = 0;
        }
        
        int [] res = new int[arr.length+1]; //initialize array with 0
        res[0] = 1; //override the first index
        
        return res;
    }
}

//my solution - 0 ms (great!!!)
class Solution {
    public int[] plusOne(int[] arr) {
        
        int []res;
        
        //sprate of 2 cases, the ones digit is 9 or not
        if(9 == arr[arr.length - 1])
        {
            //count how much carry is needed (means the digits is 9 from ones and on)
            //when there is no carry, break the loop
            int count = 0;
            res = new int[arr.length];//if needed re allocate again
            for(int i = arr.length -1; i>=0; --i)
            {
                if(9 == arr[i])
                {
                    ++count;
                }
                else
                {
                    break;
                }
            }
            
            //special case like 999, need re allocation, fill all the digits in 0
            //exceptn the first digit (it's 1)
            if(count == arr.length)
            {
                res = new int[arr.length + 1];
                res[0] = 1;
                for(int i = 1; i<res.length; ++i)
                {
                    res[i] = 0;
                }
                    
            }
            else
            {
                //no needed re allocation, fill all the digits that need carry with 0
                int i = res.length - 1;
                while(count > 0)
                {
                    res[i] = 0;
                    --i;
                    --count;
                }
                
                //put the carry
                res[i] = arr[i] + 1;
                
                //if have more from original array that no need carry just copy it
                //to result array
                --i;
                for(; i>=0; --i)
                {
                    res[i] = arr[i];
                }
            }
        }
        else
        {
            //most of cases, add one to ones digits, the other is same as the original array
            //return the original array
            ++arr[arr.length -1];
            return arr;
        }
        
        return res;
    }
}
