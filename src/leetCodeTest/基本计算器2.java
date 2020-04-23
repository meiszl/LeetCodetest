package leetCodeTest;

import java.util.Stack;

public class 基本计算器2 {
    public static void main(String[] args) {
        String s = "3+33+2*2";
        int calculate = calculate(s);
        System.out.println("calculate = " + calculate);
    }

    /**
     * 使用栈结构制作计算器，遇到乘除运算符就将栈顶的元素取出进行计算，遇到-运算符就push进去-num
     * 最后将栈中元素相加即可。
     * @param s
     * @return
     */
    public static int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();

        char lastOp = '+';
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == ' ') continue;
            if(Character.isDigit(arr[i])){
                int tempNum = arr[i] - '0';
                while(++i < arr.length && Character.isDigit(arr[i])){
                    tempNum = tempNum * 10 + (arr[i] - '0');
                } i--;

                if(lastOp == '+') numStack.push(tempNum);
                else if(lastOp == '-') numStack.push(-tempNum);
                else numStack.push(res(lastOp, numStack.pop(), tempNum));
            } else lastOp = arr[i];
        }

        int ans = 0;
        for(int num : numStack) ans += num;
        return ans;
    }
    private static int res(char op, int a, int b){
        if(op == '*') return a * b;
        else if(op == '/') return a / b;
        else if(op == '+') return a + b; //其实加减运算可以忽略
        else return a - b;
    }

}
