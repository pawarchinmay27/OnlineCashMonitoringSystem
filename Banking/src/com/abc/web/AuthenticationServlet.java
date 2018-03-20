package com.abc.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.exceptions.BusinessException;
import com.abc.service.BankingService;
import com.abc.utility.Constants;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/auth")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection mbconnection;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			
			mbconnection=DriverManager.getConnection(Constants.DBURL,Constants.DBUNAME,Constants.DBPASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public AuthenticationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String manager_name=request.getParameter("bmname");
		String manager_password=request.getParameter("bmpassword");
		
		HttpSession session=request.getSession();
		
		
		
		
		try {
			BankingService bankservice=new BankingService();
			String bankname=bankservice.bankAuthenticService(manager_name, manager_password);
			if(bankname!=null){
				session.setAttribute("bank_name", bankname);
				session.setAttribute("manager_name",manager_name);
				response.sendRedirect("/Banking/bank_home.jsp");

			}
			else{
				response.sendRedirect("/Banking/bank_login.jsp?error=1");
			}
			
			
		} catch ( BusinessException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
