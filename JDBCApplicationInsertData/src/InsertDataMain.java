import java.sql.*;

public class InsertDataMain {
    // JDBC driver name and database URL
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/emp";
    // Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
//STEP 2: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
//STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, "root", "root");
//STEP 4: Execute a query
            System.out.println("Inserting Data in given database...");
            String sql;
            stmt = conn.createStatement();
            sql = "INSERT INTO Students VALUES (107, 'Enrique', 'John', 25)";
            stmt.executeUpdate(sql);
            sql= "INSERT INTO Students VALUES (109, 'Taylor', 'Swift', 30)";
            stmt.executeUpdate(sql);
            sql= "INSERT INTO Students VALUES(100, 'Linkin', 'Park', 28)";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
//STEP 6: Clean-up Resources
            stmt.close();
            conn.close();
        } catch (SQLException se) {
//Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
//Handle errors for Class.forName
            e.printStackTrace();
        } finally {
//finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing can be done
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }
}

