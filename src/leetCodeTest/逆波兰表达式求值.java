package leetCodeTest;

import java.util.Arrays;
import java.util.Stack;

public class 逆波兰表达式求值 {
    public static void main(String[] args) {
        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int i = evalRPN(tokens);
        System.out.println("i = " + i);
    }

    /**
     * 栈实现
     * @param tokens
     * @return
     */
//    public static int evalRPN(String[] tokens) {
//        if (tokens == null || tokens.length == 0)return 0;
//        Stack<Integer> stack = new Stack();
//        for (int i = 0; i < tokens.length; i++) {
//            switch (tokens[i]){
//                case "*":
//                    stack.push(stack.pop() * stack.pop());
//                    break;
//                case "+":
//                    stack.push(stack.pop() + stack.pop());
//                    break;
//                case "/":
//                    Integer pop1 = stack.pop();
//                    Integer pop2 = stack.pop();
//                    stack.push(pop2 / pop1);
//                    break;
//                case "-":
//                    Integer pop = stack.pop();
//                    Integer pop3 = stack.pop();
//                    stack.push(pop3 - pop);
//                    break;
//                default:
//                    stack.push(Integer.parseInt(tokens[i]));
//            }
//        }
//        return stack.pop();
//    }

    /**
     * 数组模拟栈实现
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)return 0;
        int[] stack = new int[tokens.length/2+1];
        int flag = 0;
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]){
                case "*":
                    stack[flag - 2] = stack[flag-2]*stack[--flag];
                    break;
                case "+":
                    stack[flag-2] = stack[flag-2]+stack[--flag];
                    break;
                case "/":
                    stack[flag-2] = stack[flag-2]/stack[--flag];
                    break;
                case "-":
                    stack[flag-2]=stack[flag-2]-stack[--flag];
                    break;
                default:
                    stack[flag++] = Integer.parseInt(tokens[i]);
                    break;
            }
        }
        System.out.println("Arrays.toString(stack) = " + Arrays.toString(stack));
        return stack[0];
    }
}
