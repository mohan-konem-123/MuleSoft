import java.sql.*;

public class createTable {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/intern", "root", "root");
			Statement stmt = con.createStatement();
			System.out.println("connection success");
			String sql = "Create table Movies(name varchar(30),actor varchar(30),actress varchar(30),director varchar(30),year_of_release int)";
			stmt.executeUpdate(sql);
			System.out.println("Created table Movies in given database");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}