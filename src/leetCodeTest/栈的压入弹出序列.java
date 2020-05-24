package leetCodeTest;

import java.util.Deque;
import java.util.LinkedList;

public class 栈的压入弹出序列 {
    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4};
        int[] popped = new int[]{3,4,1,2};
        boolean b = validateStackSequences(pushed, popped);
        System.out.println("b = " + b);

    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int pufl = 0,popfl = 0;
        Deque<Integer> deque = new LinkedList<>();
        while (pufl <= pushed.length && popfl <= popped.length){
            if (popfl == popped.length&&pufl == pushed.length)
                break;
            if (pufl == pushed.length&&popfl < popped.length){
                if (deque.peekFirst() == popped[popfl]){
                    deque.pollFirst();
                    popfl++;
                    continue;
                }else {
                    return false;
                }
            }
            if (!deque.isEmpty()){
                if (deque.peekFirst() == popped[popfl]){
                    deque.pollFirst();
                    popfl++;
                }else {
                    deque.addFirst(pushed[pufl]);
                    pufl++;
                }
            }else{
                deque.addFirst(pushed[pufl]);
                pufl++;
            }
        }
        return pufl == pushed.length&&popfl == popped.length;
    }
}

