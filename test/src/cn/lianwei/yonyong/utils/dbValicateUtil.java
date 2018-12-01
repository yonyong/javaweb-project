package cn.lianwei.yonyong.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import cn.lianwei.yonyong.pojo.ValidateBean;

	public class dbValicateUtil {
		private static String sql;
		private static Connection coon=DBUtils.getConnection();
		private static PreparedStatement sta;
		private static ResultSet rs=null;
		private static ResultSet rs_info=null;
		
		public static ValidateBean queryYZM(String tel) {		//判断改手机号是否已经在数据库中
			ValidateBean validateBean=new ValidateBean();
			sql="select * from validate where tel=?";
			try {
				sta=coon.prepareStatement(sql);
				sta.setString(1, tel);
				rs=sta.executeQuery();
				while(rs.next()) {
					
					validateBean.setTel(rs.getString(1));
					validateBean.setValidate(rs.getString(2));
					validateBean.setDate(rs.getTimestamp(3));
					return validateBean;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return null;
		}
		
		public static int insertYZM(String tel,String yzm,Timestamp sendValidateTime) {		//如果用户手机号不存在，将手机号、验证码，及获取验证码生成的时间存入数据库
			sql="insert into validate values (?,?,?)";
			
			try {
				sta=coon.prepareStatement(sql);
				sta.setString(1, tel);
				sta.setString(2, yzm);
				sta.setTimestamp(3, sendValidateTime);
				
				return sta.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		
		public static int updateYZM(String tel,String yzm,Timestamp sendValidateTime) {
			sql="update validate set yzm=?,time=? where tel=?";
			
			try {
				sta=coon.prepareStatement(sql);
				sta.setString(1, yzm);
				sta.setTimestamp(2, sendValidateTime);
				sta.setString(3, tel);
				return sta.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		
}
