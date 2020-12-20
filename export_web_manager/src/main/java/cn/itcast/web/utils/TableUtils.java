package cn.itcast.web.utils;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author cbh
 * @PackageName:utils
 * @ClassName:TableUtils
 * @Description:
 * @date 2020-12-19 10:10
 */

public class TableUtils {
	static String path = null;
	public static void isMain() throws ClassNotFoundException, SQLException, IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入你要构建的表名");
		String table_name = scanner.nextLine();
		String name = TableUtils.class.getName();
		//db.properties文件存放位置
		InputStream inputStream = Class.forName(name).getResourceAsStream("/properties/db.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		Class.forName(properties.getProperty("jdbc.driver"));
		Connection connection = DriverManager.getConnection(properties.getProperty("jdbc.url"), properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
		Statement statement = connection.createStatement();
		String sql = "select * from " + table_name;
		ResultSet resultSet = statement.executeQuery(sql);
		ResultSetMetaData metaData = resultSet.getMetaData();
		//获取表的类型

		//pojo建表
		System.out.println("=================pojo建表===================");
		for (int i = 0; i < metaData.getColumnCount(); i++) {
			String pojo = "private " + metaData.getColumnTypeName(i+1) +" " + metaData.getColumnName(i+1) +";";
			System.out.println(isTest(pojo));
		}

		//resultMap集合
		System.out.println("================resultMap===========");
		for (int i = 0; i < metaData.getColumnCount(); i++) {
			System.out.println(metaData.getColumnName(i+1));
		}
	}

	public static String isTest(String name){
		StringBuilder toCamel = new StringBuilder(name);
		int len = name.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = name.charAt(i);
			if (c == '_') {
				if (++i < len) {
					sb.append(Character.toUpperCase(name.charAt(i)));
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString().replaceAll("VARCHAR","String").
				replaceAll("DATETIME","Date").replaceAll("DECIMAL","Double")
				.replaceAll("INT","Integer").replaceAll("CHAR","String");
	}
}
