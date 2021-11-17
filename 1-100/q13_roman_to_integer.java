// =========== 1 solutions =============

class Solution {
    
    public int calcRoman(char c)
    {
        switch(c) 
        {
            case 'I':  
                return 1;  
            case 'V':  
                return 5;  
            case 'X':  
                return 10;  
            case 'L':  
                return 50;  
            case 'C':  
                return 100;  
            case 'D':  
                return 500;  
            case 'M':  
                return 1000;  
            default:
                return 0;
        }
    }
    
    public int romanToInt(String s) {
        int res = 0;
        
        for(int i = 0; i<s.length(); ++i)
        {
            int curr = calcRoman(s.charAt(i));
            
            if(i+1 < s.length())
            {
                int next = calcRoman(s.charAt(i+1));
                
                if(curr >= next)
                {
                    // Value of current symbol
                    // is greater or equalto
                    // the next symbol
                    res += curr;
                }
                else
                {
                    // Value of current symbol is
                    // less than the next symbol
                    res += (next - curr);
                    ++i;//the value calculated so pass to next index
                }
            }
            else
            {
                //calculate the last one
                res += curr;
            }
        }
        
        return res;
    }
}