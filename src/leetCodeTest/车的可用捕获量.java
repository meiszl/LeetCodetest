package leetCodeTest;

public class 车的可用捕获量 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','R','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}};
        int i = numRookCaptures(board);
        System.out.println("i = " + i);
    }

    /**
     * 按照题目要求设计代码即可，此类问题没有特别的思路只是考察将文字翻译成代码的能力。
     * @param board
     * @return
     */
    public static int numRookCaptures(char[][] board) {
        int i,j,flag = 0;
        for (i=0;i<board.length;i++)
            for (j=0;j<board[i].length;j++)
                if (board[i][j] == 'R'){
                    flag = findAllp(i,j,board);
                }
        return flag;

    }

    public static int findAllp(int i,int j,char[][] board){
        int temp = i;
        int flag = j;
        int count = 0;
        while (i>=0){
            if (board[i][j] == 'B')
                break;
            if (board[i][j] == 'p'){
                count++;
                break;
            }
            i--;
        }
        i = temp;
        while (i<8)
        {
            if (board[i][j] == 'B')
                break;
            if (board[i][j] == 'p'){
                count++;
                break;
            }
            i++;
        }
        i = temp;
        while (j>=0){
            if (board[i][j] == 'B')
                break;
            if (board[i][j] == 'p'){
                count++;
                break;
            }
            j--;
        }
        j = flag;
        while (j<8)
        {
            if (board[i][j] == 'B')
                break;
            if (board[i][j] == 'p'){
                count++;
                break;
            }
            j++;
        }
        return count;
    }
}
