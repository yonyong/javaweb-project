package cn.lianwei.yonyong;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lianwei.yonyong.pojo.ValidateBean;
import cn.lianwei.yonyong.utils.dbOperateUtils;
import cn.lianwei.yonyong.utils.dbValicateUtil;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/register")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=utf-8");
		String password=request.getParameter("password");
		String tel=request.getParameter("tel");
		String volidate=request.getParameter("volidate");
		System.out.println("-------------------tel:"+tel);
		System.out.println("-------------------password:"+password);
		ValidateBean validateBean=dbValicateUtil.queryYZM(tel);
		String yzm=validateBean.getValidate();
		int t=dbOperateUtils.registerQueryUser(tel);
		
		//��ѭ�����ж�ע����û��Ƿ��Ѿ����ڣ�tΪ0�����ڣ�����ע�ᣬ������
		if(!volidate.equals(yzm)||yzm==null) {
			System.out.println("验证码错误*****");
			String jsonStr = "{\"errorCode\":\"2\",\"errorMessage\":\"验证码错误\"}";
			
			response.getWriter().write(jsonStr); 
		}
		else {
			if(t==0) {
				
				System.out.println("进如此循环");
				int result=dbOperateUtils.registerUser(password, tel);
				String jsonStr = "{\"errorCode\":\"1\",\"errorMessage\":\"success\"}";
					
				response.getWriter().write(jsonStr);
			}
			else
			{
				System.out.println("未进如此循环");
				String jsonStr = "{\"errorCode\":\"0\",\"errorMessage\":\"phone or password is error\"}";
				response.getWriter().write(jsonStr);
	//			response.setContentType("text/html;charset=utf-8");
	//			response.setCharacterEncoding("utf-8");
	//			PrintWriter out=response.getWriter();
	//			out.print("<script charset='UTF-8' language='javascript'>alert('该会员已存在，立即登陆！');window.location.href='login.jsp';</script>");
	//			request.getRequestDispatcher("login.jsp").forward(request, response);
						
				
			}
		}
		System.out.println("····················");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
