package cn.lianwei.yonyong.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lianwei.yonyong.utils.dbOperateUtils;

/**
 * Servlet implementation class deleteInfoServlet
 */
@WebServlet("/deleteInfo")
public class deleteInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id=Integer.parseInt(request.getParameter("id"));
		
		int rs=dbOperateUtils.deleteInfo(id);
		if(rs==1) {
			System.out.println("------------------"+rs);
//			response.setContentType("text/html;charset=utf-8");
//			request.setAttribute("status", "success");
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
//			out.print("你好");
//			String titleStr = new String(aa.getBytes("iso-8859-1"),"UTF-8"); 
			out.print("<script charset='UTF-8' language='javascript'>alert('消息删除成功！');"
					+ "window.location.href='info.jsp';</script>");
//			request.getRequestDispatcher("queryInfoServlet").forward(request, response);
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
