import java.util.ArrayList;
import java.util.List;

public class TaskScheduler {
    private List<Task> tasks = new ArrayList<>();

    public void createTask(Task task) {
        tasks.add(task);
    }

    public void editTask(Task task) {
        Task taskById = findTaskById(task.id);
        if (taskById != null) {
            taskById.description = task.description;
            taskById.name = task.name;
        }
    }

    public void reassignTask (String taskId, User newAsignee) {
        Task task = findTaskById(taskId);
        if (task != null) {
            task.assignedTo = newAsignee;
            EmailNotification emailNotification = new EmailNotification();
            emailNotification.notifyUser(task);
        }
    }

    private Task findTaskById(String taskId) {
        return tasks.stream().filter(task -> task.id.equals(taskId)).findFirst().orElse(null);
    }
}
