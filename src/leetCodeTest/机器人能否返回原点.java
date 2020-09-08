package leetCodeTest;

public class 机器人能否返回原点 {
    public static void main(String[] args) {
        String move = "LL";
        boolean b = judgeCircle(move);
        System.out.println(b);
    }

//    public static boolean judgeCircle(String moves) {
//        if (moves.length() == 0|| moves.equals(""))
//            return true;
//        int LR = 0;
//        int UD = 0;
//        for (int i = 0; i < moves.length(); i++) {
//            switch (moves.charAt(i)){
//                case 'R':
//                    LR++;
//                    break;
//                case 'L':
//                    LR--;
//                    break;
//                case 'U':
//                    UD++;
//                    break;
//                case 'D':
//                    UD--;
//                    break;
//            }
//        }
//        return LR == 0 && UD == 0;
//    }
    public static boolean judgeCircle(String moves) {
        if (moves.length() == 0|| moves.equals(""))
            return true;
        int LR = 0;
        int UD = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)){
                case 'R':
                    LR++;
                    break;
                case 'L':
                    LR--;
                    break;
                case 'U':
                    UD++;
                    break;
                case 'D':
                    UD--;
                    break;
            }
        }
        return LR == 0 && UD == 0;
    }
}
