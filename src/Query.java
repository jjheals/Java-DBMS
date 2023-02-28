import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

/** Query
 * Used for making a connection to the DB and returning specified information
 */
public class Query {
    Connection connection;

    /* ----- Pre-written query calls, just need arguments added ----- */
    public String get_item = "SELECT * FROM Items WHERE item-name = %s;";              // format: [item name, string]
    public String get_item_attribute = "SELECT %s FROM Items WHERE item-name = %s;";   // format: [item attribute, string], [item name, string]

    // Constructor
    public Query() {}

    /**
     * Get info for a certain object
     * @param query query statement to execute (use Query.[query] to avoid syntax errors)
     */
    public void getInfo(String query) {
        ResultSet result;       // Result from the query, sql obj
        Statement stmt;         // Statement obj

        // Create statement object
        try {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Error creating statement. Quitting.");
            return;
        }

        // Execute the desired query
        try {
            result = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error with query execution.");
            return;
        }
        // Print result
        System.out.println(result);

        DBConnection.closeConnection(this.connection); // Close DB connection
    }

}