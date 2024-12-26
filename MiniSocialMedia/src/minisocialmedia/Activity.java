package minisocialmedia;

/**
 *
 * @author Hakan
 */
public class Activity {

    private String description;
    private long timestamp;

    public Activity(String description, long timestamp) {
        this.description = description;
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public long getTimestamp() {
        return timestamp;
    }

}
