package cn.lianwei.yonyong.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.lianwei.yonyong.utils.dbOperateUtils;

/**
 * Servlet implementation class editInfoServlet
 */
@WebServlet("/editInfo")
public class editInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int id=(int) session.getAttribute("id");
		String title=request.getParameter("title");
		String date=request.getParameter("date");
		request.setCharacterEncoding("utf-8");
		String content=request.getParameter("content");
		
		int status=dbOperateUtils.editInffo(id, title, date, content);
		if(status==1)
			request.getRequestDispatcher("successEdit.jsp").forward(request, response);
		else
			request.getRequestDispatcher("deleteInfoMessage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
