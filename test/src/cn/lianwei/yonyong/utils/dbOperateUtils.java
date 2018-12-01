package cn.lianwei.yonyong.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cn.lianwei.yonyong.pojo.InfoBean;
import cn.lianwei.yonyong.pojo.UserBean;

public class dbOperateUtils {
	private static String sql;
	private static Connection coon=DBUtils.getConnection();
	private static PreparedStatement sta;
	private static ResultSet rs=null;// ��¼��֤��ѯ����ж�    �û�
	private static ResultSet rs_info=null;// ��¼��֤��ѯ����ж�         ��Ϣ
	
	//��ѯ�û�
	public static UserBean queryUser(String tel,String password) {
		UserBean userBean=new UserBean();
		try {
			password=MD5Utils.getMD5(password);
			sql="select * from user where tel=? and password=?";
			sta=coon.prepareStatement(sql);//Ԥ����Ҫ����setString֮ǰ
			sta.setString(1, tel);//���sql�еĵ�һ�� ?
			sta.setString(2, password);//���sql�еĵڶ���  ?
			rs=sta.executeQuery();
			while(rs.next()) {
				userBean.setTel(rs.getString(2));
				userBean.setPassword(rs.getString(1));
				return userBean;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		finally{		//�ر����ݿ�����
//			try {
//				coon.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return null;
	}
	
	public static int registerQueryUser(String tel) {
		try {
			sql="select * from user where tel=? ";
			sta=coon.prepareStatement(sql);//Ԥ����Ҫ����setString֮ǰ
			sta.setString(1, tel);//���sql�еĵ�һ�� ?
			rs=sta.executeQuery();
			if(rs.next())
				return 1;
			else
				return 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		finally{		//�ر����ݿ�����
//			try {
//				coon.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return 0;
	}
	
	public static int registerUser(String password,String tel) {
		password=MD5Utils.getMD5(password);
		sql="insert into user values (?,?)";
		try {
			sta=coon.prepareStatement(sql);
			sta.setString(1, password);
			sta.setString(2, tel);
			return sta.executeUpdate();			//�����ӳɹ�������1�����ʧ�ܷ���0
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		finally {			//�ر����ݿ�����
//			try {
//				coon.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return 0;
	}
	
	//��ѯ��Ϣ�б�
	public static ArrayList<InfoBean> queryInfo() {
		ArrayList<InfoBean> list=new ArrayList<InfoBean>(); //�½�һ�����ڴ�Ų�ѯ�����InfoBean���͵ļ���
		try {
			sql="select * from info;";
			sta=coon.prepareStatement(sql);
			rs_info=sta.executeQuery();
			while(rs_info.next()) {					//������ѯ�Ľ��������ÿһ�α�������Ϣ������InfoBean�����Ӧ
				int id=Integer.parseInt(rs_info.getString(1));
				String title=rs_info.getString(2);
				String content=rs_info.getString(3);
				String date=rs_info.getString(4);
				
				InfoBean infoBean=new InfoBean();//�½�InfoBean��Ķ���Ŀ���ǽ�ÿһ�ζ�Ӧ����Ϣ���ϣ���Ϊһ�����󣬴�ŵ�������
				
				infoBean.setId(id);
				infoBean.setTitle(title);
				infoBean.setContent(content);
				infoBean.setDate(date);
				
				list.add(infoBean);//�����α���������Ϣ�õ��Ķ�����ӵ�������
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
	
//	��ϸ��Ϣ
	public static InfoBean queryInfoById(int temp_id) {
		InfoBean infoBean=new InfoBean();//�½�InfoBean��Ķ���Ŀ���ǽ�ÿһ�ζ�Ӧ����Ϣ���ϣ���Ϊһ�����󣬴�ŵ�������
		try {
				sql="select * from info where id=?;";
				sta=coon.prepareStatement(sql);
				sta.setInt(1, temp_id);
				rs_info=sta.executeQuery();		
				
				rs_info.next();		//һ��Ҫnextһ�£������������ﱻ�ӵ�Ҫ��
				
				int id=rs_info.getInt(1);
				String title=rs_info.getString(2);
				String content=rs_info.getString(3);
				String date=rs_info.getString(4);
				
				
				infoBean.setId(id);
				infoBean.setTitle(title);
				infoBean.setContent(content);
				infoBean.setDate(date);
				return infoBean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infoBean;	
	}
	
	
	//�༭��Ϣ
	public static int editInffo(int id,String title,String date,String content) {
		sql="update info t set t.title=?,t.date=?,t.content=? where t.id=?";
		try {
			sta=coon.prepareStatement(sql);
			sta.setString(1, title);
			sta.setString(2, date);
			sta.setString(3, content);
			sta.setInt(4, id);
			return sta.executeUpdate();			//�����ӳɹ�������1�����ʧ�ܷ���0
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	//ɾ����Ϣ
	public static int deleteInfo(int temp_id) {
		int result=0;
		try {
				sql="delete from info where id=?;";
				sta=coon.prepareStatement(sql);
				sta.setInt(1, temp_id);
				result=sta.executeUpdate();		
				
				return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;	
	}
	
	public static int addInffo(int id,String title,String content,String date) {
		sql="insert into info values (?,?,?,?)";
		try {
			sta=coon.prepareStatement(sql);
			sta.setInt(1, id);
			sta.setString(2, title);
			sta.setString(3, content);
			sta.setString(4, date);
			return sta.executeUpdate();			//�����ӳɹ�������1�����ʧ�ܷ���0
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
