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
 class Pair implements Comparable<Pair>{
    int value;
    ListNode node;
    Pair(int value,ListNode node){
        this.value=value;
        this.node=node;
    }

    @Override
    public int compareTo(Pair other){
       return Integer.compare(this.value,other.value);
    }
 }
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                 pq.add(new Pair(lists[i].val,lists[i]));
            }
           
        }
        ListNode head=new ListNode(-1);
        ListNode temp=head;

        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            temp.next=pair.node;
            temp=temp.next;
            if(pair.node.next!=null){
                 pq.add(new Pair(pair.node.next.val,pair.node.next));
            }
           
        }
        return head.next;
    }
}