// =========== 2 solutions =============

//no helpers at all
class Solution {
    public String reverseWords(String s) {
        
        if(null == s)
        {
            return null;
        }
        
        char []temp = s.toCharArray(); //string is immutable in java, need an extra space
        
        int n = s.length();
        
        //reverse whole string
        reverse(temp, 0, n-1);
        
        //reverse each word
        reverseWords(temp, n);
        
        //clean spaces
        return cleanSpaces(temp, n);
    }
    
    private void reverseWords(char []temp, int n)
    {
        int space_index = 0,  non_space_index = 0;
        
        while(space_index<n)
        {
            while(space_index<non_space_index || space_index < n && ' ' == temp[space_index] )
            {
                ++space_index; //skip spaces
            }
            
            while(non_space_index<space_index || non_space_index < n && ' ' != temp[non_space_index] )
            {
                ++non_space_index; //skip non spaces
            }
            
            reverse(temp, space_index, non_space_index - 1);
        }
    }
    
    private void reverse(char []temp, int start, int end)
    {
        while(start < end)
        {
            char temp_c = temp[start];
            temp[start] = temp[end];
            temp[end] = temp_c;
            
            ++start;
            --end;
        }
    }
    
    private String cleanSpaces(char []temp, int n)
    {
        int space_index = 0,  non_space_index = 0;
        
        while(space_index<n)
        {
            while(space_index < n && ' ' == temp[space_index] )
            {
                ++space_index; //skip spaces
            }
            
            while(space_index < n && ' ' != temp[space_index] )
            {
                temp[non_space_index] = temp[space_index]; //keep non spaces
                ++non_space_index;
                ++space_index;
            }
            
            while(space_index < n && ' ' == temp[space_index] )
            {
                ++space_index; //skip spaces (after word)
            }

            // keep only one space (if we have more than one space between words)
            if(space_index < n)
            {
                temp[non_space_index] = ' ';
                ++non_space_index;
            }
        }
        
        return new String(temp).substring(0, non_space_index);
    }
}

//with hepers - StringBuilder (needed) and split methods (for spaces)
public class Solution {
    public String reverseWords(String s) {
        
        String[] words = s.split(" "); //split words in spaces
        StringBuilder sb = new StringBuilder(); //string is immutable in java
        
        for(int i = 0; i<=words.length-1; ++i)
        {
            if(!words[i].isEmpty())
            {
                sb.insert(0, words[i]);
                if(i < words.length - 1)
                {
                    sb.insert(0, " ");//space after word
                }
            }
        }
        
        return sb.toString();
    }
}