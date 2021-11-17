// =========== 2 solutions =============

//uses helper array
class Solution {
    public boolean isPalindrome(int x) {
        
        if(x<0)
        {
            return false;
        }
        
        if(x >= 0 && x <= 9)
        {
            return true;
        }
        
        int count = 0;
        int copy_x = x;
        while(copy_x != 0)
        {
            ++count;
            copy_x /= 10;
        }
        
        int []help = new int[count];
        int i = 0;
        while(x != 0)
        {
            help[i] = x % 10;
            ++i;
            x /= 10;
        }
        
        int start = 0, end = help.length - 1;
        
        while(start < end)
        {
            if(help[start] != help[end])
            {
                return false;
            }
            
            ++start;
            --end;
        }
        
        return true;
    }
}

//improve for array solution
//by reverseing number 
class Solution{
    public boolean isPalindrome(int x) {
        if(x<0 || ( 0 !=x && 0 == x % 10)) // 
        {
            return false;
        }
        
        int rev = 0;
        while(x>rev)
        {
            rev = rev*10 + x%10;
            x/=10;
        }
        
        return (x == rev || x == rev/10);
    }  
}