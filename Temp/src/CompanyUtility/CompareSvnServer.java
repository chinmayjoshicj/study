package CompanyUtility;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class CompareSvnServer {
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@ofss222745.in.oracle.com:1521/ODT12CDB";

	// Database credentials
	static final String USER = "ODT121";
	static final String PASS = "ODT121";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// "com.mysql.jdbc.Driver"
			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			stmt = conn.createStatement();
			String query = "select * from user_source";
			PreparedStatement p = conn.prepareStatement(query);
			ResultSet rs = p.executeQuery();

			LinkedList<String> filesDone = new LinkedList<>();
			PrintWriter writer = null;
			while (rs.next()) {
				String name = rs.getString(1);
				if (!filesDone.contains(name)) {
					System.out.println("Writing to " + name + "...");
					filesDone.add(name);
					if(writer!=null) {
						writer.close();
					}
					writer = new PrintWriter("C:\\Users\\cmjoshi\\Desktop\\ServerSVN\\" + name + ".sql", "UTF-8");
				}
				writer.print(rs.getString(4));
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}

}
