package databaseSetup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableExample {

	public static void main(String[] args) throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("CREATE TABLE IF NOT EXISTS MOVIE(id INTEGER IDENTITY, MovieName VARCHAR(32) NOT NULL, MoviePrice VARCHAR(32) NOT NULL, MovieTime VARCHAR(32) NOT NULL)");

	}

}
