//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user1 = new User("Shanmukh", "shanmukh@gmail.com");
        User user2 = new User("Sinesh", "dinesh@gmail.com");

        Question question = new Question("System desing LLD plan", "How to prepare for interviews of LLD", user1);
        Answer answer = new Answer("Learn Java and Desing patterns, and then practice examples", user1);
        question.addAnswer(answer);

        Comment comment = new Comment("please eloborate the plan", user2);
        answer.addComment(comment);

        answer.upVote();

        System.out.println("Shanmukh Reputation: " + user1.getReputation());
        System.out.println("Dinesh Reputation: " + user2.getReputation());

    }
}