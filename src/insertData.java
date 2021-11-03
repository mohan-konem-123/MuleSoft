import java.sql.*;
import java.util.*;

public class insertData {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/intern", "root", "root");
			PreparedStatement stmt = con.prepareStatement(
					"insert into Movies(name,actor,actress,director,year_of_release) values(?,?,?,?,?)");
			System.out.println("Enter movie name:");
			String name = sc.next().toLowerCase();
			stmt.setString(1, name);
			System.out.println("Enter movie actor name:");
			String actor = sc.next().toLowerCase();
			stmt.setString(2, actor);
			System.out.println("Enter movie actress name:");
			String actress = sc.next().toLowerCase();
			stmt.setString(3, actress);
			System.out.println("Enter movie director name:");
			String director = sc.next().toLowerCase();
			stmt.setString(4, director);
			System.out.println("Enter movie year of movie release:");
			int year_of_release = sc.nextInt();
			stmt.setInt(5, year_of_release);
			int i = stmt.executeUpdate();
			System.out.println("Inserted Data into table in given database successfully");
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}