package com.abc.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.exceptions.BusinessException;
import com.abc.service.CustomersService;
import com.abc.utility.Constants;
import com.abc.utility.DbUtil;

/**
 * Servlet implementation class CustomerLoginServlet
 */
@WebServlet("/CustomerLogin")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String mobile_no=request.getParameter("mob_no");
		String password=request.getParameter("password");
			HttpSession session=request.getSession();
			
		try {
			CustomersService customerservice=new CustomersService();
			String username=customerservice.isAuthentic(mobile_no, password);
			System.out.println(username);
			/*ServletConfig config=getServletConfig();
			String timeout=config.getInitParameter("timeout");
			int duration=Integer.parseInt(timeout);
			*/if(username!=null){
				//session.setMaxInactiveInterval(duration);
				session.setAttribute("phno",mobile_no);
				session.setAttribute("uname", username);
				session.setAttribute("passw", password);
				response.sendRedirect("home.jsp");
				
			}
			else{
							response.sendRedirect("login.jsp?error=1");
				
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
