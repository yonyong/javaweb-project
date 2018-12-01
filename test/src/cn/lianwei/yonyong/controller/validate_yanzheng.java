package cn.lianwei.yonyong.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class validate_yanzheng
 */
@WebServlet("/ValidateImage")
public class validate_yanzheng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validate_yanzheng() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=utf-8");
		
		String validateCode=request.getParameter("validateCode");
		HttpSession session=request.getSession();
		String piccode=(String) session.getAttribute("piccode");
		
		
		System.out.println("validateCode="+validateCode+".............piccode="+piccode);
		if(validateCode.equals(piccode)) {
			String jsonStr = "{\"errorCode\":\"1\",\"errorMessage\":\"success\"}";
			response.getWriter().write(jsonStr);
		}
		else {
			String jsonStr = "{\"errorCode\":\"0\",\"errorMessage\":\"phone or password is error\"}";
			response.getWriter().write(jsonStr);
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
