import java.util.Date;

public class Task {
    String id;
    String name;
    String description;
    User createdBy;
    User assignedTo;
    String createdAt;
    String deadline;

    public Task(String id, String name, String description, User assignedTo, String deadline, User createdBy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.assignedTo = assignedTo;
        this.deadline = deadline;
        this.createdBy = createdBy;
        createdAt = new Date().toString();
    }
}
