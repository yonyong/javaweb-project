package cn.lianwei.yonyong.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtils {
	private static Connection coon=null;
	private static String driver="com.mysql.jdbc.Driver";
	private static String user="";
	private static String password="";
	private static String url="jdbc:mysql://localhost:3306/testcopy";
	
	public static Connection getConnection(){
		try {
			Class.forName(driver);
			coon=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coon;
//		try {
//
//            Class.forName(driver);
//
//            coon = DriverManager.getConnection(url, user, password);
//
//        } catch (Exception e) {
//
//            System.out.println("���ݿ������쳣");
//
//            e.printStackTrace();
//
//        }
//
//        return coon;
	}
	
	public static void closeConnection() {
		if(coon!=null) {
			try {
				coon.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
