package com.abc.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.exceptions.BusinessException;
import com.abc.service.CustomersService;
import com.abc.utility.Constants;
import com.abc.utility.DbUtil;

/**
 * Servlet implementation class CustomerRegisterServlet
 */
@WebServlet("/CustomerRegister")
public class CustomerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			String mobile_no=request.getParameter("mobile_no");			
			
			
			try {
				CustomersService customerservice=new CustomersService();
				boolean registered=customerservice.registeredService(username, password, email, mobile_no);
				if(registered){
					response.sendRedirect("home.jsp");
					
				}
				else{
					response.sendRedirect("register.jsp");
					
				}
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
