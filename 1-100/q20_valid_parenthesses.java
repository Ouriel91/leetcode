// =========== 3 solutions =============

//solution using stack
class Solution {
    
    public boolean checkCloseParen(char ch, char top)
    {
        if((')' == ch && '(' == top) ||
            (']' == ch && '[' == top) ||
            ('}' == ch && '{' == top))
            {
                return true;
            }
        return false;
    }
    
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<Character>();
        
        for(char ch: s.toCharArray())
        {
            if('(' == ch || '{' == ch || '[' == ch)
            {
                stack.push(ch);
            }
            else
            {
                if(stack.empty())
                {
                    return false;
                }
                else
                {
                    char top = (Character) stack.peek();
                    boolean isCorrectCloseParen = checkCloseParen(ch, top);
                    if(isCorrectCloseParen)
                    {
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        
        return stack.isEmpty();
    }
}

//short version as above
class Solution {
    
    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<Character>();
        
        for(char ch : s.toCharArray())
        {
            if('(' == ch)
            {
                stack.push(')');
            }
            else if('{' == ch)
            {
                stack.push('}');
            }
            else if('[' == ch)
            {
                stack.push(']');
            }
            else
            {
                if(stack.isEmpty() || ch != stack.pop())
                {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}


//little bit faster than stack
class Solution {
    
    public boolean isValid(String expr)
    {
        Deque<Character> stack
            = new ArrayDeque<Character>();
 
        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);
 
            if (x == '(' || x == '[' || x == '{')
            {
                // Push the element in the stack
                stack.push(x);
                continue;
            }
 
            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
 
        // Check Empty Stack
        return (stack.isEmpty());
    }
}