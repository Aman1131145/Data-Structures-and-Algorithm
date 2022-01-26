package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PalindromeLinkedList {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static LinkedListNode<Integer> takeInput() throws IOException{
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }
        
        return head;
    }
    
    public static void print(LinkedListNode<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {

            LinkedListNode<Integer> head = takeInput(); 

            boolean ans = PalindromeLinkedList.isPalindrome(head);
            System.out.println(ans);

            t -= 1;

        }
        
    }

    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        /**
         * here we just checked if the list is empty
         * or if it have only one element
         * than we will return true because 
         * it have only one element or none at all
         * and hence it is palindrome
         */
        if(head == null || head.next == null){
            return true;
        }
        /**
         * here we created three nodes temp mid and h2
         * temp is equal to head
         * and mid and h2 are equal to null
         */
        LinkedListNode<Integer> temp = head,mid,h2;//temp = head, mid = null, h2 = null;
        //here we get the mid point of the temp
        mid=midPoint(temp);
        //then we will point h2 to mid.next
        h2 = mid.next ;
        //and the specify the value of mid.next to null
        mid.next = null;
        //the we reverse the linked list from h2
        h2=reverseIt(h2);
        //we put a flag to ensure the right value
        boolean flag=false;
        /**
         * we run this loop to check that all the values of both the linked list are the same or not 
         */
        while(temp!=null && h2!=null){
            //we do flag = false to ensure that everytime when we go to next element the value remain false
            flag=false;
            // if data at temp is equal to data at h2 then we will change the value of flag to true and go to the temp.next and h2.next
         	if(temp.data.equals(h2.data)){
              	flag=true;
             	temp=temp.next;
             	h2=h2.next;
            }
            // else we return the value of flag
            else{
                return flag;
            }
        }
        return flag;
    }
    /**
     * here we are reversing the linked list that is given to the function
     * Base Case : first we check if the linked list is empty or have only one element if one of these statements is true we return the head
     * then we make a node tail and point it towards head.next
     * Recursion : then we initialize a new node ans that will store all the recursion 
     * Small Calculation : then we store the head in tail.next
     *                      and then we point head.next towards null
     * and finally we will return the ans 
     * @param head
     * @return
     */
    private static LinkedListNode<Integer> reverseIt(LinkedListNode<Integer> head){   
        if(head==null || head.next==null){
        	return head;
        }
     	LinkedListNode<Integer> tail=head.next;
     	LinkedListNode<Integer> ans=reverseIt(head.next);
     	tail.next=head;
     	head.next=null;
     	return ans;
    }

    /**
     * Here we are returning the midpoint of the whole linked list that is given to us
     * first we initialize two nodes slow and fast and point both towards head
     * then we use a while loop which checks if fast.next is not equal to null and fast .next.next is not equal to null
     * inside the while loop we just point the fast towards fast.next.next
     * and slow to slow.next
     * Thinking : this way when fast is travelling at the speed of 2 and slow is travelling at the speeed of 1
     *              then it is sure that slow is half the length as fast hence slow will be the mid of the list 
     * therefore we will return the slow
     * @param head
     * @return
     */
    private static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head){
        LinkedListNode<Integer> slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}