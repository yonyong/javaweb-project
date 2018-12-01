package cn.lianwei.yonyong.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lianwei.yonyong.utils.IdUtil;
import cn.lianwei.yonyong.utils.dbOperateUtils;

/**
 * Servlet implementation class addInfo
 */
@WebServlet("/addInfo")
public class addInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int id=IdUtil.getID();
		String title=request.getParameter("title");
		String date=request.getParameter("date");
		String content=request.getParameter("content");
		int status=dbOperateUtils.addInffo( id,title, content,date);
		if(status==1) {
			request.getRequestDispatcher("info.jsp").forward(request, response);
		}
		else
			request.getRequestDispatcher("info.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
