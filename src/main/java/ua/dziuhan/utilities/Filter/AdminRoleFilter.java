package ua.dziuhan.utilities.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Security filter for admin's part
 */
//@WebFilter("/AdminController")
public class AdminRoleFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		String role=(String) session.getAttribute("user_role");
		if(role==null){
			resp.sendRedirect("client");
		}else if(role.equals("admin")){
			chain.doFilter(request, response);
		}else{
			resp.sendRedirect("client");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
