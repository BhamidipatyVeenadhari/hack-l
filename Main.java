import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("1. Register User");
            System.out.println("2. Add Candidate");
            System.out.println("3. Cast Vote");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    User user = new User(username, password);
                    user.save();
                    System.out.println("User registered successfully.");
                    break;

                case 2:
                    System.out.print("Enter candidate name: ");
                    String name = scanner.nextLine();
                    Candidate candidate = new Candidate(name);
                    candidate.save();
                    System.out.println("Candidate added successfully.");
                    break;

                case 3:
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter candidate ID: ");
                    int candidateId = scanner.nextInt();
                    Vote vote = new Vote(userId, candidateId);
                    vote.castVote();
                    System.out.println("Vote casted successfully.");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
