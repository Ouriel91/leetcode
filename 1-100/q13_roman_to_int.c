// =========== 1 solutions =============

static int CalcRoman(char c)
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

int romanToInt(char * s){
    int i = 1;
    int sum = CalcRoman(s[0]);

    while ('\0' != s[i])
    {
        int prev = CalcRoman(s[i-1]);
        int current = CalcRoman(s[i]);

        if(prev < current)
        {
            sum -= prev; //subtract the left letter
            sum += (current - prev); //add the right letter 
            //and toghter we get the correct result for this speical cases 
        }
        else
        {
            sum += current;
        }

        ++i;
    }

    return sum;  
}