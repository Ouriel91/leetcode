// =========== 6 solutions =============

//3 in place solutions

//bubble sort - pass 10/13 (time limit)
class Solution {
    public int[] sortArray(int[] arr) {
        
        for(int i = 0; i < arr.length - 1; ++i)
        {
            for(int j = 0; j<arr.length - i - 1; ++j)
            {
                if(arr[j] > arr[j+1])
                {
                    swap(arr,j, j+1);
                }
            }
        }
        
        return arr;
    }
    
    private void swap(int []arr,int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

//selection sort - pass 10/13 (time limit)
class Solution {
    public int[] sortArray(int[] arr) {
        
        for(int i = 0; i < arr.length - 1; ++i)
        {
            findNextMin(arr,i);
        }
        
        return arr;
    }
    
    private void findNextMin(int []arr, int i)
    {
        int min = i;
        
        for(int j = i+1; j<arr.length;++j)
        {
            if(arr[j] < arr[min])
            {
                min = j;
            }
        }
        
        swap(arr,min,i);
    }
    
    private void swap(int []arr,int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}


//selection sort - pass
class Solution {
    public int[] sortArray(int[] arr) {
        
        for(int i = 1; i < arr.length; ++i)
        {
            int curr = arr[i];
            int j = i-1;
            
            for(; j >= 0 && curr < arr[j]; --j)
            {
                arr[j+1] = arr[j];
            }
            
            arr[j+1] = curr;
        }
        
        return arr;
    }
}


//3 solutions - not in place solutions

//merge sort - pass
class Solution {
    public int[] sortArray(int[] arr) {
        
        sort(arr, 0, arr.length -1);
        
        return arr;
    }
    
    private void sort(int []arr, int start, int end)
    {
        if(start < end)
        {
            int middle = start + (end - start)/2;
            
            sort(arr, start, middle);
            sort(arr, middle + 1, end);
            
            merge(arr, start, end, middle);
        }
    }
    
    private void merge(int []arr, int start, int end, int middle)
    {
        int left_size = middle - start + 1;
        int right_size = end - middle;
        
        //temp arrays
        int []l_arr = new int[left_size];
        int []r_arr = new int[right_size];
        
        //Copy data to temp arrays
        for(int i = 0; i<left_size;++i)
        {
            l_arr[i] = arr[start + i];
        }
        
        for(int i = 0; i<right_size;++i)
        {
            r_arr[i] = arr[middle + 1 +i];
        }
        
        //init indexes for two sub arrays
        int i = 0, j = 0;
        
        //init index of merged sub array
        int k = start;
        
        while(i < left_size && j < right_size)
        {
            if(l_arr[i] <= r_arr[j])
            {
                arr[k] = l_arr[i];
                ++i;
            }
            else{
                arr[k] = r_arr[j];
                ++j;
            }
            ++k;
        }
        
        //copy remaining
        while(i < left_size)
        {
            arr[k] = l_arr[i];
            ++i;
            ++k;
        }
        
        while(j < right_size)
        {
            arr[k] = r_arr[j];
            ++j;
            ++k;
        }
    }
}

//quick sort 
class Solution {
    public int[] sortArray(int[] arr) {
        
        quickSort(arr, 0, arr.length - 1);
        
        return arr;
    }
    
    private void quickSort(int []arr, int start, int end)
    {
        if(start < end)
        {
            int pivot = partition(arr,start, end);
            
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot+1, end);
        }
    }
    
    private int partition(int [] arr, int start, int end)
    {
        int pivot = arr[end];
        
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = start - 1;
        
        for(int j = start; j <= end - 1; ++j)
        {
            
            if(arr[j] < pivot)
            {
                //increment index of smaller element
                ++i;
                swap(arr, i, j);
            }
        }
        
        swap(arr, i+1, end);
        
        return i+1;
    }
    
    private void swap(int []arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

//heap sort
class Solution {
    public int[] sortArray(int[] arr) {
        int n = arr.length;
        
        //build heap
        for(int i = n/2 - 1; i>=0; --i)
        {
            heapify(arr, n, i);
        }
        
        // One by one extract an element from heap
        for(int i = n-1; i>0; --i)
        {
            //move from current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
        
        return arr;
    }
    
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private void heapify(int []arr, int n, int i)
    {
        int largest = i;//largest init is root
        int left = 2*i + 1;//left son
        int right = 2*i + 2;//right son
        
        if(left < n && arr[left] > arr[largest])
        {
            largest = left;
        }
        
        if(right < n && arr[right] > arr[largest])
        {
            largest = right;
        }
        
        //largest isn't root
        if(largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            
            //heapify subtree
            heapify(arr, n, largest);
        }
    }
}