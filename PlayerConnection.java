package player;

import java.sql.Connection;
import java.sql.DriverManager;

public class PlayerConnection {

	public static Connection getConnection() throws Exception {

		String url = "jdbc:mysql://localhost:3306/t20wc?createDatabaseIfNotExist=true";
		String username = "root";
		String password = "rootpass";

		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection(url, username, password);
	}
}
