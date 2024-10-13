import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ToDo {
    private static int count = 1;
    private int itemNumber;
    private int hours;
    private int minutes;
    private boolean completed;
    private String title;

    private LocalTime completionTime;

    // Constructor with title and completed parameters
    public ToDo(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
        this.itemNumber = count;
        this.hours = 0;
        this.minutes = 0;
        count++;
    }

    // Default constructor
    public ToDo() {
        this("No Item", false); // Call the parameterized constructor with default values
    }

    public void printItem() {
        System.out.print("Item " + itemNumber + ": " + title + " | ");
        if (completed) {
            System.out.println("Completed at " + formatTime(completionTime));
        } else {
            System.out.println("Not Completed");
        }
    }

    private String formatTime(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(formatter);
    }

    public void convertTime(String timeEnded) {
        if (timeEnded.length() == 5 && timeEnded.charAt(2) == ':') {
            int hours = Integer.parseInt(timeEnded.substring(0, 2));
            int minutes = Integer.parseInt(timeEnded.substring(3));

            if (hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59) {
                this.hours = hours;
                this.minutes = minutes;
                this.completed = true;
                this.completionTime = LocalTime.of(hours, minutes);
            } else {
                this.hours = -1;
                this.minutes = -1;
                this.completed = false;
                this.completionTime = null;
            }
        } else {
            this.hours = -1;
            this.minutes = -1;
            this.completed = false;
            this.completionTime = null;
        }
    }

    // Getters and Setters
    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getTitle() {
        return title;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompletionTime(LocalTime completionTime) {
        if (completed) {
            this.completionTime = completionTime;
        } else {
            // If the item is not completed, the completion time should not be set
            this.completionTime = null;
        }
    }
}


