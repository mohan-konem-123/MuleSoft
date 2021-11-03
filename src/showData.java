import java.sql.*;
import java.util.*;

public class showData {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/intern", "root", "root");
			while (true) {
				System.out.println("1.Display all rows from Movies table \n2.Display row based on actor name \n3.Exit");
				System.out.println("Select one choice:");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					Statement stmt = con.createStatement();
					String QUERY = "SELECT name,actor,actress,director,year_of_release FROM Movies";
					System.out.println("Contents of table Movies:\n");
					ResultSet rs = stmt.executeQuery(QUERY);
					System.out.println("Name \t Actor \t\t Actress \t Director \t Year of Release");
					while (rs.next()) {
						// Display values
						System.out.println(
								rs.getString("name") + '\t' + rs.getString("actor") + '\t' + rs.getString("actress")
										+ '\t' + rs.getString("director") + '\t' + '\t' + rs.getInt("year_of_release"));
					}
					System.out.println();
					stmt.close();
					break;
				case 2:
					String Q = "SELECT * FROM Movies WHERE actor=?";
					PreparedStatement st = con.prepareStatement(Q);
					System.out.println("Enter the name of the actor:");
					String s = sc.next().toLowerCase();
					st.setString(1, s);
					ResultSet RS = st.executeQuery();
					System.out.println("Name \t Actor \t\t Actress \t Director \t Year of Release");
					while (RS.next())
						System.out.println(
								RS.getString("name") + '\t' + RS.getString("actor") + '\t' + RS.getString("actress")
										+ '\t' + RS.getString("director") + '\t' + '\t' + RS.getInt("year_of_release"));
					System.out.println();
					st.close();
					break;
				case 3:
					System.exit(0);
				default:
					System.out.println("Enter the valid choice!!\n");
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}