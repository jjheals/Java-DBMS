import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Query query = new Query(); // To make the query when needed

        // Check how many arguments were given, act accordingly
        switch (args.length) {

            case 2: // 2 Arguments - Username & password
                System.out.println(String.format("Connecting to Database with username %s", args[0]));

                // Try to connect to DB
                try { query.connection = DBConnection.openConnection(args[0], args[1]); }   // Pass the connection to query
                catch (SQLException e) {                                                    // Error
                    System.out.println("DB Connection failed. Quitting.");
                    return;
                }

                System.out.println("Connected successfully.");

            default: // Invalid number of arguments
                System.out.println("Error: Invalid number of arguments. " +
                                   "Usage: java Main [username] [password] " +
                                   "Quitting.");
        }
    }
}