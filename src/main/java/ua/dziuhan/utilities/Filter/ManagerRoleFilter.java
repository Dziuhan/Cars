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
 * Security filter for manger's part
 */
//@WebFilter("/ManagerController")
public class ManagerRoleFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		String role=(String) session.getAttribute("role");
		if(role==null){
			resp.sendRedirect("ClientController");
		}else if(role.equals("admin")||role.equals("manager")){
			chain.doFilter(request, response);
		}else{
			resp.sendRedirect("ClientController");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
