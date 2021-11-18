// =========== 2 solutions =============

class Solution {
    public String defangIPaddr(String address) {
        
        StringBuilder sb = new StringBuilder(); //sb can be immutable
        
        for(int i=0; i<address.length(); ++i)
        {
            if('.' == address.charAt(i))
            {
                sb.append("[.]");
            }
            else
            {
                sb.append(address.charAt(i));
            }
        }
        
        return sb.toString();
    }
}

//using builtin java method
class Solution {
    public String defangIPaddr(String address) {

        return address.replace(".","[.]"); //in java string is immutable, 
        //so inside it create another object string
    }
}
