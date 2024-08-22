import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Vote {
    private int userId;
    private int candidateId;

    public Vote(int userId, int candidateId) {
        this.userId = userId;
        this.candidateId = candidateId;
    }

    public void castVote() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO Votes (user_id, candidate_id) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, userId);
        statement.setInt(2, candidateId);
        statement.executeUpdate();
        connection.close();
    }
}
