package cn.lianwei.yonyong.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.lianwei.yonyong.pojo.UserBean;

/**
 * Servlet Filter implementation class filter
 */

public class filter implements Filter {

    /**
     * Default constructor. 
     */
    public filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
 
        HttpSession session = httpServletRequest.getSession();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        if (httpServletRequest.getServletPath().indexOf("login.jsp") > 0 || 
        		httpServletRequest.getServletPath().indexOf("login") > 0 ||
        		httpServletRequest.getServletPath().indexOf("register.jsp") > 0 ||
        		httpServletRequest.getServletPath().indexOf("register") > 0 ||
        		httpServletRequest.getServletPath().indexOf("youkeInfo.jsp") > 0
        		) {
            System.out.println("放过该请求...");
            chain.doFilter(request, response);
        } else {
 
            UserBean userBean = (UserBean)session.getAttribute("userBean");
            if (userBean != null) {
                System.out.println("已登录，取消过滤...");
                chain.doFilter(request, response);
 
            } else {
                System.out.println("未登录，跳转到登录页面...");
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsp");
            }
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
