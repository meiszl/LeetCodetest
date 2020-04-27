package leetCodeTest;

import util.ListNode;

import java.util.Arrays;
import java.util.LinkedList;

public class 合并k个排序链表 {
    public static void main(String[] args) {
        ListNode li1 = new ListNode(-1);
        li1.next = new ListNode(5);
        li1.next.next = new ListNode(11);
        ListNode li2 = new ListNode(1);
        li2.next = new ListNode(3);
        li2.next.next = new ListNode(4);
        ListNode li3 = new ListNode(6);
        li3.next = new ListNode(10);
        ListNode[] lists = new ListNode[]{li1,li3};//[[],[-1,5,11],[],[6,10]]
        ListNode listNode = mergeKLists(lists);
        while (listNode != null){
            System.out.println("listNode.val = " + listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 放到数组里面在进行排序
     * @param lists
     * @return
     */
//    public static ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) return null;
//        if (lists.length == 1) return lists[0];
//        int i = 0;
//        LinkedList<Integer> list = new LinkedList();
//        for (i=0;i<lists.length;i++){
//            ListNode list1 = lists[i];
//            while (list1 != null){
//                list.add(list1.val);
//                list1 = list1.next;
//            }
//        }
//        if (list.size() == 0)
//            return null;
//        int[] ints = list.stream().mapToInt(Integer::valueOf).toArray();
//        Arrays.sort(ints);
//        ListNode res = new ListNode(ints[0]);
//        ListNode res1 = res;
//        for (i=1;i<ints.length;i++){
//            res.next = new ListNode(ints[i]);
//            res = res.next;
//        }
//        return res1;
//    }
    /**
     * 归并思想排序，栈溢出
     */
//    public static ListNode mergeKLists(ListNode[] lists) {
//        ListNode listNode = mergeSort(lists, 0, lists.length - 1);
//        return listNode;
//    }
//    public static ListNode mergeSort(ListNode[] lists,int start,int end){
//        if (start == end) return lists[start];
//        if (start > end) return null;
//        int mid = (start + end) >>> 1;
//        return mergeTwolist(mergeSort(lists,start,mid),mergeSort(lists,mid + 1,end));
//    }

    /**
     * 分治思想排序
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        // 每次将链表的两头合并起来放到左端链表
        while(len > 1) {
            for (int i = 0; i < len / 2; i++) {
                lists[i] = mergeTwolist(lists[i], lists[len-1-i]);
            }
            // 最后合并完后链表长度减半
            len = (len + 1) / 2;
        }
        // 最后所有的结点都会存放在最左端位置
        return lists[0];

    }

    /**
     * 合并两个链表的方法
     * @param a
     * @param b
     * @return
     */
    public static ListNode mergeTwolist(ListNode a,ListNode b){
        if (a== null || b == null) return a==null?b:a;
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        while (a!=null && b!=null){
            if (a.val < b.val){
                temp.next = new ListNode(a.val);
                a = a.next;
            }else {
                temp.next = new ListNode(b.val);
                b = b.next;
            }
            temp = temp.next;
        }
        temp.next = a != null? a:b;
        res = res.next;
        return res;
    }
}
