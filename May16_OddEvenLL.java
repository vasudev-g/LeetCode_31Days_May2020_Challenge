/* Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ... */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd=head;
        ListNode even=null;
        if(head !=null && head.next!=null)
         even = head.next;
         ListNode evenf=even;
        if(odd==null)
            return null;
        if(even==null)
        {
            return odd;
        }
        if(even.next==null)
        {
            odd.next=evenf;
            return odd;
        }
        ListNode oddlast=head;
       
        
        while(true)
        {
            
           if (odd == null || even == null || 
                        (even.next) == null)  
        {  
            odd.next = evenf;  
            break;  
        }  
  
       
        odd.next = even.next;  
        odd = even.next;  
  
        
        if (odd.next == null)  
        {  
            even.next = null;  
            odd.next = evenf;  
            break;  
        }  
  
       
        even.next = odd.next;  
        even = odd.next;  
        }
    
        return head;
    }
}