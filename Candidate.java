import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Candidate {
    private int id;
    private String name;

    public Candidate(String name) {
        this.name = name;
    }

    public void save() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO Candidates (name) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.executeUpdate();
        connection.close();
    }
}
