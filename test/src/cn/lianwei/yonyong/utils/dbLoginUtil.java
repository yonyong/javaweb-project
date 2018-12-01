package cn.lianwei.yonyong.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import cn.lianwei.yonyong.pojo.LoginBean;

public class dbLoginUtil {
	private static String sql;
	private static Connection coon=DBUtils.getConnection();
	private static PreparedStatement sta;
	private static ResultSet rs=null;
	private static ResultSet rs_info=null;
	
	public static LoginBean queryUser(String tel) {
		LoginBean loginBean=new LoginBean();
		sql="select * from login where tel=?";
		try {
			sta=coon.prepareStatement(sql);
			sta.setString(1, tel);
			rs=sta.executeQuery();
			while(rs.next()) {
				loginBean.setTel(rs.getString(1));
				loginBean.setTime(rs.getTimestamp(2));
				loginBean.setCount(rs.getInt(3));
				return loginBean;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static int insertUser(String tel,Timestamp sendValidateTime,int count) {		
		sql="insert into login values (?,?,?)";
		
		try {
			sta=coon.prepareStatement(sql);
			sta.setString(1, tel);
			sta.setTimestamp(2, sendValidateTime);
			sta.setInt(3, count);
			
			return sta.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int updateUser(String tel,Timestamp sendValidateTime,int count) {
		sql="update login set time=?,count=? where tel=?";
		
		try {
			sta=coon.prepareStatement(sql);
			sta.setTimestamp(1, sendValidateTime);
			sta.setInt(2,count);
			sta.setString(3, tel);
			return sta.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
