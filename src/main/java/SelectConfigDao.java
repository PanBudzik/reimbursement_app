import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectConfigDao {
	String sql = "SELECT * FROM config";
	String url = "jdbc:mysql://localhost:3306/reimbursement_calculator_db";
	String username = "root";
	String password = "";

	public ResultSet select() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
}}
