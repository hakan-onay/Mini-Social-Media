package minisocialmedia;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author Hakan
 */
public class SocialNetwork {

    private Map<String, User> users; // HashMap for user management
    private Map<String, Set<String>> graph; // Adjacency list for friendships

    public SocialNetwork() {
        this.users = new HashMap<>();
        this.graph = new HashMap<>();
    }

    // Add a new user
    public void addUser(String userId, String name) {
        if (users.containsKey(userId)) {
            System.out.println("User already exists!");
            return;
        }
        User newUser = new User(userId, name);
        users.put(userId, newUser);
        graph.put(userId, new HashSet<>());
        System.out.println("User added: " + name);
    }

    // Add a friend connection
    public void addFriend(String userId1, String userId2) {
        if (!users.containsKey(userId1) || !users.containsKey(userId2)) {
            System.out.println("One or both users not found!");
            return;
        }
        graph.get(userId1).add(userId2);
        graph.get(userId2).add(userId1);
        users.get(userId1).addFriend(userId2);
        users.get(userId2).addFriend(userId1);

        long timestamp = System.currentTimeMillis();
        users.get(userId1).addActivity("Became friends with " + userId2, timestamp);
        users.get(userId2).addActivity("Became friends with " + userId1, timestamp);
        System.out.println("Friendship added between " + userId1 + " and " + userId2);
    }

    // Find mutual friends
    public void findMutualFriends(String userId1, String userId2) {
        if (!users.containsKey(userId1) || !users.containsKey(userId2)) {
            System.out.println("One or both users not found!");
            return;
        }

        Set<String> mutualFriends = new HashSet<>(users.get(userId1).getFriends());
        mutualFriends.retainAll(users.get(userId2).getFriends());

        System.out.println("Mutual friends between " + userId1 + " and " + userId2 + ": " + mutualFriends);
    }

    // Post a message
    public void postMessage(String userId, String content) {
        if (!users.containsKey(userId)) {
            System.out.println("User not found!");
            return;
        }
        users.get(userId).addPost(content);
        System.out.println("Message posted by " + userId + ": " + content);
    }

    // View news feed
    public void viewFeed(String userId) {
        if (!users.containsKey(userId)) {
            System.out.println("User not found!");
            return;
        }

        PriorityQueue<Post> feed = new PriorityQueue<>(Comparator.comparingLong(Post::getTimestamp).reversed());
        for (String friendId : users.get(userId).getFriends()) {
            feed.addAll(users.get(friendId).getPosts());
        }

        System.out.println("News feed for " + userId + ":");
        while (!feed.isEmpty()) {
            Post post = feed.poll();
            System.out.println(post.getContent() + " (by " + post.getUserId() + ")");
        }
    }

    // Search user by ID or name
    public void searchUser(String query) {
        for (User user : users.values()) {
            if (user.getUserId().equalsIgnoreCase(query) || user.getName().equalsIgnoreCase(query)) {
                System.out.println("User found: " + user.getName() + " (ID: " + user.getUserId() + ")");
                return;
            }
        }
        System.out.println("User not found!");
    }

}
