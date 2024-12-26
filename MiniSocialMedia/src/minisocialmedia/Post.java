package minisocialmedia;

/**
 *
 * @author Hakan
 */
public class Post {

    private String content;
    private long timestamp;
    private String userId;

    public Post(String content, long timestamp, String userId) {
        this.content = content;
        this.timestamp = timestamp;
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getUserId() {
        return userId;
    }

}
