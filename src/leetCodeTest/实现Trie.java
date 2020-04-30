package leetCodeTest;

import java.util.ArrayList;
import java.util.List;

public class 实现Trie {
    public static void main(String[] args) {
        Trie1 trie = new Trie1();

        trie.insert("apple");
        System.out.println("trie.search(\"apple\") = " + trie.search("apple")); //true
        System.out.println("trie.search(\"app\") = " + trie.search("app")); // false
        System.out.println("trie.startsWith(\"app\") = " + trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println("trie.search(\"app\") = " + trie.search("app"));//true

    }
}

/**
 * 注意存储的不是字符串本身而是他的Ascii索引。
 */
 class Trie1 {
     TrieNode1 root;
    /** Initialize your data structure here. */
    public Trie1() {
        root = new TrieNode1();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode1 tr = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int num = chars[i] - 'a';
            if (tr.children[num] == null){
                tr.children[num] = new TrieNode1();
            }
            tr = tr.children[num];
        }
        tr.flag = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode1 tr = root;
        char[] chars = word.toCharArray();
        int num;
        for (char aChar : chars) {
            num = aChar - 'a';
            if (tr.children[num] == null){
                return false;
            }
            tr = tr.children[num];
        }
        return tr.flag;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode1 tr = root;
        char[] chars = prefix.toCharArray();
        int num;
        for (char aChar : chars) {
            num = aChar - 'a';
            if (tr.children[num] == null)
                return false;
            tr = tr.children[num];
        }
        return true;
    }
}
class TrieNode1 {
    char val;
    boolean flag;
    TrieNode1[] children = new TrieNode1[26];
    public TrieNode1(){}
}
