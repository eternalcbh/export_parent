package cn.itcast.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.itcast.dao
 * @ClassName:TestUtil
 * @Description:
 * @date 2020-12-31 14:41
 */
public class TestUtil {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println(getAllDept("4028827c4fb6202a014fb6209c730000"));
	}

	static List<String> deptAll = new ArrayList<>();

	public static void get(String deptId) throws ClassNotFoundException, SQLException {
		deptAll.add(deptId);

		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/saas-export";

		Connection connection = DriverManager.getConnection(url, "root", "root");

		PreparedStatement preparedStatement = connection.prepareStatement("select * from pe_dept where parent_id =  ? ");

		preparedStatement.setString(1,deptId);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()){
			String dept = resultSet.getString(1);
			get(dept);
		}
	}

	public static String getAllDept(String dept) throws SQLException, ClassNotFoundException {
		get(dept);
		StringBuilder stringBuilder = new StringBuilder();
		for (String s : deptAll) {
			stringBuilder.append(s + ",");
		}
		return stringBuilder.toString();
	}
}
