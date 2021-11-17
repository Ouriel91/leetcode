// =========== 2 solutions =============

//solve with spaces in start and end restriction
char * reverseWords(char * s){

    int len = strlen(s);
    char *ret = calloc(len + 1,  sizeof(char)); //ret string
    
    int ret_i = 0;
    int i = len - 1;
    
    //move backward in string stop when discovering space (spaces in the end just skipped)
    //or discovering space in start
    //move on original string backword and copy it to ret string normally
    for(; i>=0; --i)
    {
        if((i > 0 && ' ' != s[i] && s[i-1] == ' ') || 
          (0 == i && ' ' != s[i]))
        {
            //if the ret index is not 0, put a space as space between words
            if(0 != ret_i)
            {
                ret[ret_i++] = ' ';
            }

            int j = i;//where to start to copy, copy from j

            for(; ' ' != s[j] && j<len; ++j, ++ret_i)
            {
                ret[ret_i] = s[j];
            }
        }
    }
    
    return ret;
}

// ===================================
//solution without spaces in start and end restriction. - from quiz

void reverse(char *begin, char *end)
{
    while(begin < end)
    {
        char temp = *begin;
        *begin = *end;
        *end = temp;
        ++begin;
        --end;
    }
}

char *reverseWords(char *s){

    char *begin = s;
    char *runner = s;
    
    while('\0' != *runner)
    {
        if(' ' == *runner)
        {
            reverse(begin, runner - 1);
            begin = runner + 1;
        }
        ++runner;
    }
    
    reverse(begin, runner - 1);
    reverse(s, runner -1);
    
    return s;
}