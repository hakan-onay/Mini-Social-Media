package minisocialmedia;

import java.util.*;

/**
 *
 * @author Hakan
 */
public class User {

    private String userId;
    private String name;
    private Set<String> friends;
    private LinkedList<Post> posts;
    private PriorityQueue<Activity> activities;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.friends = new HashSet<>();
        this.posts = new LinkedList<>();
        this.activities = new PriorityQueue<>(Comparator.comparingLong(Activity::getTimestamp).reversed());
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Set<String> getFriends() {
        return friends;
    }

    public LinkedList<Post> getPosts() {
        return posts;
    }

    public PriorityQueue<Activity> getActivities() {
        return activities;
    }

    public void addFriend(String friendId) {
        friends.add(friendId);
    }

    public void removeFriend(String friendId) {
        friends.remove(friendId);
    }

    public void addPost(String content) {
        long timestamp = System.currentTimeMillis();
        posts.addFirst(new Post(content, timestamp, userId));
        addActivity("Posted a message: " + content, timestamp);
    }

    public void addActivity(String description, long timestamp) {
        activities.add(new Activity(description, timestamp));
    }

    

}
