
package minisocialmedia;

/**
 *
 * @author Hakan
 */
public class MiniSocialMedia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         SocialNetwork network = new SocialNetwork();

        // Add users
        
        network.addUser("user1", "Hakan");
        network.addUser("user2", "Emre");
        network.addUser("user3", "Ardıl");

        // Add friendships
        network.addFriend("user1", "user2");
        network.addFriend("user2", "user3");

        // Post messages
        network.postMessage("user1", "Hi everyone my name is Hakan");
        network.postMessage("user2", "Today is a great day");
        network.postMessage("user3", "Hi my name is Ardıl");

        // View feeds
        network.viewFeed("user1");
        
        System.out.println("----");
        
        network.viewFeed("user2");

        // Find mutual friends
        network.findMutualFriends("user1", "user3");

        // Search users
        network.searchUser("Hakan");
    }
    
}
