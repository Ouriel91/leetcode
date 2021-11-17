// =========== 2 solutions =============

/*time limit*/
int firstBadVersion(int n) 
{
    int i = 1;
    for (; i < n; i++) {
        if (isBadVersion(i)) {
            return i;
        }
    }
    return n;
}

/*accepted*/
int firstBadVersion(int n) {
    
    int start = 1;
    int end = n;
    
    while(start < end)
    {
        int middle = start + (end -start) / 2;
        
        if (isBadVersion(middle))
        {
            end = middle;
        }
        else
        {
            start = middle + 1;
        }
    }
    
    return start;  
}