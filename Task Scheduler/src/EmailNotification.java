public class EmailNotification implements Notification{
    @Override
    public void notifyUser(Task task) {
        System.out.println("Hi "+task.createdBy.name+", " + task.name+" is assigned to " + task.assignedTo.email);
    }
}
