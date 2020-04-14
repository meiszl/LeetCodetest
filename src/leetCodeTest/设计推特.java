package leetCodeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class 设计推特 {
    public static void main(String[] args) {
        /**
         * ["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed"]
         * [[],[1,5],[1,3],[1,101],[1,13],[1,10],[1,2],[1,94],[1,505],[1,333],[1]]
         */
        Twitter twitter = new Twitter();

        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 333);
        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        System.out.println("twitter.getNewsFeed(1) = " + twitter.getNewsFeed(1));

//        // 用户1关注了用户2.
//        twitter.follow(1, 2);
//
//        // 用户2发送了一个新推文 (推文id = 6).
//        twitter.postTweet(2, 6);
//
//        // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//        // 推文id6应当在推文id5之前，因为它是在5之后发送的.
//        System.out.println("twitter.getNewsFeed(1) = " + twitter.getNewsFeed(1));
//
//        // 用户1取消关注了用户2.
//        twitter.unfollow(1, 2);
//
//        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//        // 因为用户1已经不再关注用户2.
//        System.out.println("twitter.getNewsFeed(1) = " + twitter.getNewsFeed(1));
    }
}
/*
传统方法，首先存放传来的推特使用的格式是int[2]，第一位是userid第二位是推特id，然后按顺序将他们排放在list中。
之后需要另一个结构HashMap<Integer, HashSet<Integer>>去存放每个用户的关注对象。
然后每次提取推特的时候就按顺序检索List<int[]>中的条目，如果存在userID等于
当前查询的用户id或者当前查询的用户所关注的某个ID就将该推特的id加入resultlist中。
 */
class Twitter {
    List<int[]> twtime;
    HashMap<Integer, HashSet<Integer>> post;
    /** Initialize your data structure here. */
    public Twitter() {
        this.twtime = new ArrayList();
        this.post = new HashMap();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        int[] str = new int[2];
        str[0] = userId;
        str[1] = tweetId;
        twtime.add(str);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList();
        int i;
        HashSet<Integer> set = post.get(userId);
        for (i=twtime.size() - 1;i>=0;i--){
            if (list.size() == 10)
                break;
            if ((set != null && set.contains(twtime.get(i)[0])) || (twtime.get(i)[0]) == userId){
                list.add(twtime.get(i)[1]);
            }
        }
        return list;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (post.containsKey(followerId)){
            HashSet<Integer> set = post.get(followerId);
            set.add(followeeId);
        }else {
            HashSet<Integer> set = new HashSet();
            set.add(followeeId);
            post.put(followerId,set);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (post.containsKey(followerId)){
            HashSet<Integer> set = post.get(followerId);
            set.remove(followeeId);
        }else {
            return;
        }
    }
}