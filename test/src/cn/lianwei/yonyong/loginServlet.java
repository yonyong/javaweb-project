package cn.lianwei.yonyong;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.lianwei.yonyong.pojo.LoginBean;
import cn.lianwei.yonyong.pojo.UserBean;
import cn.lianwei.yonyong.utils.dbLoginUtil;
import cn.lianwei.yonyong.utils.dbOperateUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=utf-8");
		String tel=request.getParameter("tel");
		String password=request.getParameter("password");
		System.out.println("-------------------tel:"+tel);
		System.out.println("-------------------password:"+password);
		
		UserBean userBean=dbOperateUtils.queryUser(tel, password);
		
		
		//判断用户是否在数据库里
		int t=dbOperateUtils.registerQueryUser(tel);
		
		//判断错误登陆三次锁定的表login中是否已经有这个账户
		LoginBean loginBean=dbLoginUtil.queryUser(tel);
		Date date=new Date();
		Timestamp errorLoginTime=new Timestamp(date.getTime());
		if(loginBean==null) {
			dbLoginUtil.insertUser(tel,errorLoginTime, -1);
			loginBean=dbLoginUtil.queryUser(tel);	//login表和user表没有设置关联，如果user表中存在该用户而login表中不存在，则将其添加进去。
		}
		int count=loginBean.getCount();
		System.out.println("count="+count);
		Date time=loginBean.getTime();
		long result=errorLoginTime.getTime()-time.getTime();
		
		if(result>180000)
			count=0;
		if(t==1) {		//数据库里已经存在手机号为tel的用户
			
			if(count>2)//连续错误登陆次数已经超过三次
			{
				String jsonStr = "{\"errorCode\":\"33\",\"errorMessage\":\"您由于错误登陆次数太多，系统已将您的账户锁定，请在三分钟后重新登录！\"}";
				dbLoginUtil.updateUser(tel, errorLoginTime, count+1);
				response.getWriter().write(jsonStr);
				return;
			}
			else {
				
				if((null==userBean)) {		//用户存在但密码输入错误，那么输出密码输入错误，并且如果当前和上次错误时间相隔不到1分钟则count+1;
					String jsonStr = "{\"errorCode\":\"22\",\"errorMessage\":\"密码输入错误，错误输入三次后您的账户将会被锁定！\"}";
					dbLoginUtil.updateUser(tel, errorLoginTime, count+1);
					response.getWriter().write(jsonStr);
					return;
				}else {
					
					dbLoginUtil.updateUser(tel, errorLoginTime, 0);	
					HttpSession session=request.getSession();
					request.setCharacterEncoding("utf-8");
					response.setContentType("utf-8");
					session.setAttribute("userBean", userBean);
					String jsonStr = "{\"errorCode\":\"00\",\"errorMessage\":\"登陆成功！\"}";
					response.getWriter().write(jsonStr);
				}
			}
		
		}
		else {	//该数据库没有存储过该tel
			dbLoginUtil.insertUser(tel, errorLoginTime, 0);
			dbLoginUtil.updateUser(tel, errorLoginTime, count+1);
			String jsonStr = "{\"errorCode\":\"11\",\"errorMessage\":\"该用户不存在\"}";
			response.getWriter().write(jsonStr);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*HttpSession session=request.getSession();
		UserBean account=new UserBean();
		String tel=request.getParameter("tel");
		String password=request.getParameter("password");
		account.setPassword(password);
		account.setTel(tel);
		
		try {
			UserBean t=dbOperateUtils.queryUser(tel, password);
			if(t!=null){
				System.out.println("success");
				session.setAttribute("account", account);
				response.sendRedirect("info.jsp");
				//return;
			}
			else {
				response.sendRedirect("fail.jsp");
				//return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
