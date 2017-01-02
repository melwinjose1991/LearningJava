package melwin.leetcode;

// ||SORTING|| ||MERGE_SORT|| ||LINKED_LIST||
// ||SLOW_FAST_POINTER|| ||O(n.logn)||

public class Analyzed_SortList {
	/*
	
	// Que : Sort a linked list in O(n log n) time & O(1) space.
	
	// QuickSort will create a callstack with O(log(n)) calls 
	// 		which therefore takes O(log(n)) space.
	// HeapSort requires random access, so cant be used.
	// Used modified version of Merge-Sort.
	  
	source : https://gist.github.com/sundeepblue/9463371
	
	public:
	    ListNode *sortList(ListNode *head) {
		    if(!head || !head->next) return head;
		    
		    // not right if write: *fast = head. Otherwise, {2,1} will not be sorted.
		    ListNode *slow = head, *fast = head->next; 
		    
		    // get middle node
		    while(fast && fast->next) {
		        slow = slow->next;
		        fast = fast->next->next;
		    }
		    ListNode *left = head, *right = slow->next;
		    slow->next = NULL;
		    
		    left = sortList(left);
		    right = sortList(right);
		    return merge(left, right);
		}
	
		ListNode *merge(ListNode *L, ListNode *R) {
		    if(!L) return R;
		    if(!R) return L;
		    ListNode *h = NULL;
		    if(L->val < R->val) {
		        h = L;
		        h->next = merge(L->next, R);
		    } else {
		        h = R;
		        h->next = merge(L, R->next);
		    }
		    return h;
		}
	
	 */
	
	public static void main(String[] args) {
	}

}
