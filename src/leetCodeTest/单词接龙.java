package leetCodeTest;

import javafx.util.Pair;

import java.util.*;

public class 单词接龙 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<String>(){{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
            add("cog");
        }};
        int i = ladderLength(beginWord, endWord, wordList);
        System.out.println("i = " + i);
    }

    /**
     * bfs广度优先搜索。
     * 详解：https://leetcode-cn.com/problems/word-ladder/solution/dan-ci-jie-long-by-leetcode/
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        HashMap<String,List<String>> allComboDict = new HashMap<>();
        wordList.forEach(word ->{
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> transformations = allComboDict.getOrDefault(newWord,new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord,transformations);
            }
        });
        HashMap<String,Boolean> visited = new HashMap<>();
        visited.put(beginWord,true);
        Deque<Pair<String,Integer>> deque = new LinkedList<>();
        deque.addFirst(new Pair(beginWord,1));
        while (!deque.isEmpty()){
            Pair<String, Integer> pollLast = deque.pollLast();
            String word = pollLast.getKey();
            Integer level = pollLast.getValue();
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                for (String adWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adWord.equals(endWord))
                        return level + 1;
                    if (!visited.containsKey(adWord)){
                        visited.put(adWord,true);
                        deque.addFirst(new Pair(adWord,level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
