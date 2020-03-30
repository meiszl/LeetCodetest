package leetCodeTest;

import java.util.Arrays;

public class 单词的压缩编码 {
    public static void main(String[] args) {
        String[] words = new String[]{"time", "me", "bell"};
        int i = minimumLengthEncoding(words);
        System.out.println("i = " + i);
    }
    public static int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        Arrays.sort(words,(s1,s2) -> s2.length() - s1.length());
        System.out.println("words = " + Arrays.toString(words));
        for (String word: words){
            len += trie.insert(word);
        }
        return len;
    }
}
class Trie {
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public int insert(String word){
        TrieNode cur = root;
        boolean isNew = false;
        for (int i=word.length()-1;i>=0;i--){
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null){
                isNew = true;
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        return isNew? word.length() + 1: 0;
    }
}
class TrieNode {
    char val;
    TrieNode[] children = new TrieNode[26];
    public TrieNode(){}
}