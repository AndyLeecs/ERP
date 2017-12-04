import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class JdbcTest {
	public static void main(String[] args) throws SQLException{
		Driver driver = new com.mysql.jdbc.Driver();
		String url = "jdbc:mysql://127.0.0.1:3306/ssh";
		Properties info = new Properties();
		info.put("user", "root");
		info.put("password", "root");
		java.sql.Connection conn = driver.connect(url, info);
		System.out.println(conn);
	}

}
