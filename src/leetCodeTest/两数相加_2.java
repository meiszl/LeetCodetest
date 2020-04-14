package leetCodeTest;

import util.ListNode;

public class 两数相加_2 {
    public static void main(String[] args) {
        ListNode li = new ListNode(7);
        li.next = new ListNode(2);
        li.next.next = new ListNode(4);
        li.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(li, l2);
        while (listNode != null){
            System.out.println("listNode.val = " + listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 将数值取出之后生成字符串进行存储，然后从后向前按位拿出数值进行加法运算并记录进位情况，
     * 按照加法运算及进位情况进行新的字符串生成，然后在转换成链表形式即可。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        while (l1 != null){
            str1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            str2.append(l2.val);
            l2 = l2.next;
        }
        boolean flag = false;
        int len1 = str1.length()-1;
        int len2 = str2.length()-1;
        StringBuilder res = new StringBuilder();
        while (len1 >= 0 || len2 >= 0){
            if (len1 >= 0 && len2 >= 0){
                int i = Integer.parseInt(String.valueOf(str1.charAt(len1)));
                int i1 = Integer.parseInt(String.valueOf(str2.charAt(len2)));
                if (flag){
                    i += 1;
                    flag = false;
                }
                int i2 = i + i1;
                if (i2 >= 10){
                    flag = true;
                    i2 = i2 %10;
                }
                res.insert(0,i2);
                len1--;
                len2--;
            }else if (len1 >= 0){
                int i = Integer.parseInt(String.valueOf(str1.charAt(len1)));
                if (flag){
                    i += 1;
                    flag = false;
                }
                if (i >= 10){
                    flag = true;
                    i = i %10;
                }
                res.insert(0,i);
                len1--;
            } else if (len2 >= 0){
                int i = Integer.parseInt(String.valueOf(str2.charAt(len2)));
                if (flag){
                    i += 1;
                    flag = false;
                }
                if (i >= 10){
                    flag = true;
                    i = i %10;
                }
                res.insert(0,i);
                len2--;
            }
        }
        if (flag){
            res.insert(0,1);
        }
        ListNode listNode = new ListNode(Integer.parseInt(String.valueOf(res.charAt(0))));
        ListNode temp = listNode;
        for (int j = 1; j < res.length(); j++) {
            listNode.next = new ListNode(Integer.parseInt(String.valueOf(res.charAt(j))));
            listNode = listNode.next;
        }
        return temp;
    }
}
