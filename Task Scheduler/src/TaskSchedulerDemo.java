import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TaskSchedulerDemo {
    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        User user1 = new User("1", "shanmukh@gmail.com", "Shanmukh", "8754213265");
        User user2 = new User("1", "deepak@gmail.com", "Deepak", "7845121245");

        Task task1 = new Task("1", "Logging system", "Design the the Logging system", user1, "12/11/24", user1);

        taskScheduler.createTask(task1);
        taskScheduler.reassignTask(task1.id, user2);
    }
}