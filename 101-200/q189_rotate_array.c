// =========== 3 solutions =============

//time limit, pass all tests except one
void rotate(int* arr, int size, int k){

    int i = 0;
    int j = 0;
    
    for(; i<k; ++i)
    {
        int last = arr[size-1];
        for(j = size-1; j>=1; --j)
        {
            arr[j] = arr[j-1];
        }
        arr[0] = last;
    }
}

// with space o(n)
void rotate(int* arr, int n, int k){
    
    int i = 0;
    int temp[n];
    
    for(; i<n; ++i)
    {
        temp[(i+k)%n] = arr[i];
    }
    
    for(i=0; i<n; ++i)
    {
        arr[i] = temp[i];
    }    
}


/*no memory space */
void RotSub(int *arr, int size)
{
    int i = 0;
    
    for(; i<size/2;++i)
    {
        int temp = arr[i];
        arr[i] = arr[size - i - 1];
        arr[size - i - 1] = temp;
    }
}

void rotate(int* arr, int n, int k){
    
    k %= n;  
    
    RotSub(arr, n);
    RotSub(arr, k);
    RotSub(arr+k, n-k);
}

