import java.util.List;

public interface Votable {
    void vote(User user, int value);
    int getVoteCount();
}
