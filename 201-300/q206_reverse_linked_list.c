// =========== 2 solutions =============

//excercise struct
struct ListNode {
    int val;
    struct ListNode *next;
};
 

/*iterative*/
struct ListNode* reverseListIter(struct ListNode* head){

    struct ListNode *curr = head;
    struct ListNode *next = NULL;
    struct ListNode *prev = NULL;
    
    while(NULL != curr)
    {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }
    
    return prev;
}

/*recursive*/
struct ListNode* reverseListRecursive(struct ListNode* head){

    if(NULL == head || NULL == head->next)
    {
        return head;
    }
    
    struct ListNode *temp = reverseListRecursive(head->next);
    head->next->next = head;
    head->next = NULL;
    
    return temp;
}