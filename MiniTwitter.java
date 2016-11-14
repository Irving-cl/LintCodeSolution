
import java.util.*;

public class MiniTwitter {

    public static class Tweet {
        public int id;
        public int user_id;
        public String text;
        public static Tweet create(int user_id, String tweet_text) {
            // This will create a new tweet object,
            // and auto fill id
            return new Tweet();
        }
    }

    public class SortableTweet implements Comparable<SortableTweet> {
        public Tweet tweet;
        public Iterator<Tweet> iter;
        SortableTweet(Tweet tweet, Iterator<Tweet> iter) {
            this.tweet = tweet;
            this.iter = iter;
        }
        @Override
        public int compareTo(SortableTweet o) {
            if (this.tweet.id < o.tweet.id) {
                return 1;
            } else if (this.tweet.id > o.tweet.id) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    private HashMap<Integer, HashSet<Integer>> userFollow;
    private HashMap<Integer, LinkedList<Tweet>> userTweets;

    public MiniTwitter() {
        userFollow = new HashMap<Integer, HashSet<Integer>>();
        userTweets = new HashMap<Integer, LinkedList<Tweet>>();
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        Tweet newTweet = Tweet.create(user_id, tweet_text);
        if (!userTweets.containsKey(user_id)) {
            userTweets.put(user_id, new LinkedList<Tweet>());
        }
        userTweets.get(user_id).addFirst(newTweet);
        return newTweet;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        List<Tweet> feeds = new ArrayList<Tweet>();
        PriorityQueue<SortableTweet> pq = new PriorityQueue<SortableTweet>();
        if (!userFollow.containsKey(user_id)) {
            userFollow.put(user_id, new HashSet<Integer>());
            userFollow.get(user_id).add(user_id);
        }
        for (Integer followedUser : userFollow.get(user_id)) {
            if (userTweets.containsKey(followedUser)) {
                Iterator<Tweet> iter = userTweets.get(followedUser).listIterator(0);
                if (iter.hasNext()) {
                    Tweet tweet = iter.next();
                    pq.add(new SortableTweet(tweet, iter));
                }
            }
        }
        for (int i = 0; i < 10 && !pq.isEmpty(); i++) {
            SortableTweet cur = pq.poll();
            feeds.add(cur.tweet);
            if (cur.iter.hasNext()) {
                pq.add(new SortableTweet(cur.iter.next(), cur.iter));
            }
        }
        return feeds;
    }

    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet> getTimeline(int user_id) {
        List<Tweet> feeds = new ArrayList<Tweet>();
        if (!userTweets.containsKey(user_id)) {
            userTweets.put(user_id, new LinkedList<Tweet>());
        }
        int num = 0;
        for (Tweet tweet : userTweets.get(user_id)) {
            feeds.add(tweet);
            if (++num == 10) {
                break;
            }
        }
        return feeds;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        if (!userFollow.containsKey(from_user_id)) {
            userFollow.put(from_user_id, new HashSet<Integer>());
            userFollow.get(from_user_id).add(from_user_id);
        }
        userFollow.get(from_user_id).add(to_user_id);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        if (userFollow.get(from_user_id).contains(to_user_id)) {
            userFollow.get(from_user_id).remove(to_user_id);
        }
    }

    public static void main(String[] args) {

    }
}