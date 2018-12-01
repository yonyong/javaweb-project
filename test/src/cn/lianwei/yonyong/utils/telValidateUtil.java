package cn.lianwei.yonyong.utils;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lianwei.yonyong.pojo.ValidateBean;

/**
 * Servlet implementation class telValidateUtil
 */
@WebServlet("/telValidateUtil")
public class telValidateUtil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public telValidateUtil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
		response.setContentType("application/json; charset=utf-8");
		
	    int intFlag = (int)(Math.random() * 1000000);
	 
	    String flag = String.valueOf(intFlag);
	    if (flag.length() == 6 && flag.substring(0, 1).equals("9"))
	    {	
	    }
	    else
	        intFlag = intFlag + 100000;
	    String tel=request.getParameter("tel");
	    Date date=new Date();		//获取当前系统的时间
	    Timestamp sendValidateTime=new Timestamp(date.getTime());
		//***************测试telValidateUtil.java   行数：53********************
		String yzm=String.valueOf(intFlag);
		ValidateBean validateBean=dbValicateUtil.queryYZM(tel);
		Date dbdate=new Date();
		long result=0;
		if(validateBean!=null) {
			dbdate=validateBean.getDate();
			result=date.getTime()-dbdate.getTime();
			if(result<=60000)
			{
				System.out.println("一个手机号一分钟只能获取一个验证码！");
				String jsonStr = "{\"errorCode\":\"11\",\"errorMessage\":\"一个手机号一分钟只能获取一个验证码！\"}";
				response.getWriter().write(jsonStr);
			}
			else {
				dbValicateUtil.updateYZM(tel, yzm, sendValidateTime);
				String jsonStr = "{\"errorCode\":\"01\",\"errorMessage\":\"phone or password is error\"}";
				response.getWriter().write(jsonStr);
				System.out.println("**************************************************");
		    	System.out.println(" 敬爱的"+tel+"用户，此次生成的验证码为："+intFlag+"。有效期为1分钟！");
		    	System.out.println("**************************************************");
				}
			}
		else {
			dbValicateUtil.insertYZM(tel, yzm, sendValidateTime);
			String jsonStr = "{\"errorCode\":\"00\",\"errorMessage\":\"phone or password is error\"}";
			response.getWriter().write(jsonStr);
			System.out.println("**************************************************");
	    	System.out.println(" 敬爱的"+tel+"用户，此次生成的验证码为："+intFlag+"。有效期为1分钟！");
	    	System.out.println("**************************************************");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
