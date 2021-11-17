// =========== 2 solutions =============

//naive approach
int* twoSum(int* arr, int size, int target, int* ret_size){

    int *ret = (int*)malloc(sizeof(int) * 2);
    int i = 0;
    
    for(; i<size; ++i)
    {
        for(int j = i+1; j<size; ++j)
        {
            if(target == arr[i] + arr[j])
            {
                ret[0] = i;
                ret[1] = j;
                *ret_size = 2;
                
                return ret;
            }
        }
    }
    
    return ret;
}

//hash table approach
struct hash{
    int value;
    int index;
    UT_hash_handle hh; //struct from #include <uthash.h> 
};

void destroy_table(struct hash **table)
{
    struct hash *curr = NULL;
    struct hash *temp = NULL;
    
    HASH_ITER(hh, *table ,curr, temp)
    {
        HASH_DEL(*table, curr);
        free(curr);
    }
}

int* twoSum(int* arr, int size, int target, int* ret_size){

    struct hash *table = NULL;
    struct hash *element = NULL;
    int *ret = (int *)malloc(sizeof(int) *2);
    int remain = 0;
    
    for(int i = 0; i<size; ++i)
    {
        remain = target - arr[i];
        
        // Find if there has already been an element such that the sum is target
        HASH_FIND_INT(table, &remain, element);
        if(element)
        {
            ret[0] = element->index;
            ret[1] = i;
            break;
        }
        
        // Add the new number to the hash table if it doesn't exist already
        HASH_FIND_INT(table, &arr[i], element);
        if(!element)
        {
            element = (struct hash *)malloc(sizeof(*element));
            element->value = arr[i];
            element->index = i;
            
            HASH_ADD_INT(table, value, element);
        }
    }
    
    destroy_table(&table);
    *ret_size = 2;
    
    return ret;
}