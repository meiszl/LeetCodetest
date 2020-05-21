package leetCodeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TrieNode2{
    HashMap<Character,TrieNode2> children = new HashMap<>();
    String word = null;
    public TrieNode2(){}
}
public class 单词搜索2 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] word = new String[]{"oath","pea","eat","rain"};
        单词搜索2 d = new 单词搜索2();
        List<String> words = d.findWords(board, word);
        System.out.println("words = " + words);
    }

    /**
     * 前缀树过滤+回溯+dfs
     * 前置：回溯+dfs解决单词搜索问题
     * 详解：https://leetcode-cn.com/problems/word-search-ii/solution/dan-ci-sou-suo-ii-by-leetcode/
     */
    private char[][] _board = null;
    private ArrayList<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode2 root = new TrieNode2();
        for (String word : words) {
            TrieNode2 node = root;
            for (char c : word.toCharArray()) {
                if (node.children.containsKey(c)){
                    node = node.children.get(c);
                }else {
                    TrieNode2 newNode = new TrieNode2();
                    node.children.put(c,newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        this._board = board;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (root.children.containsKey(board[row][col]))
                    backtracking(row,col,root);
            }
        }
        return res;
    }
    private void backtracking(int row,int col, TrieNode2 parent){
        char c = this._board[row][col];
        TrieNode2 trieNode2 = parent.children.get(c);

        if (trieNode2.word != null){
            this.res.add(trieNode2.word);
            trieNode2.word = null;
        }

        this._board[row][col] = '#';

        int[] rowOffset = {-1,0,1,0};
        int[] colOffset = {0,1,0,-1};
        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0|| newRow >= this._board.length||newCol < 0|| newCol >= this._board[0].length){
                continue;
            }
            if (trieNode2.children.containsKey(this._board[newRow][newCol])){
                backtracking(newRow,newCol,trieNode2);
            }
        }
        this._board[row][col] = c;
        if (trieNode2.children.isEmpty()){
            parent.children.remove(c);
        }
    }
}
