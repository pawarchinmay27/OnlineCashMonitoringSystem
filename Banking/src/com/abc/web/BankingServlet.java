package com.abc.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.exceptions.BusinessException;
import com.abc.service.BankingService;
import com.abc.utility.Constants;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

/**
 * Servlet implementation class BankingServlet
 */
@WebServlet("/banking")
public class BankingServlet extends HttpServlet {
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}
	
	private static final long serialVersionUID = 1L;
	private Connection mbconnection;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
	}
    public BankingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BankingService bankservice = null;
					
	HttpSession session=request.getSession();
	session.setAttribute("operation","no");
		
					try {
						bankservice=new BankingService();
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
		
				HttpSession sesssion=request.getSession();
						String uname=(String) sesssion.getAttribute("manager_name");

							String action=request.getParameter("action");
			
							
							//When Cash Status Is to be updated				
							if(action.equals("statusupdate")){
																						
								
								
								try {
									bankservice.updateCashStatus(uname, request.getParameter("cashavail"), request.getParameter("REGION"));
								} catch (BusinessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								session.setAttribute("operation", "cash_status");
								response.sendRedirect("/Banking/bank_home.jsp");
							}
							
							//when crowd status is to be updated
							else if(action.equals("crowdcheck")){
																				
								
								try {
									bankservice.crowdStatusCheck( request.getParameter("crowdstat"), uname,request.getParameter("REGION"));
								} catch (BusinessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								session.setAttribute("operation", "crowd_status");
								response.sendRedirect("/Banking/bank_home.jsp");
							} 
							//Update The Withdraw limit 
							else if(action.equals("withdrawcheck")){
												
								
								try {
									bankservice.withdrawLimitCheck(request.getParameter("withlimit"), uname,request.getParameter("REGION") );
								} catch (BusinessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								
								
								session.setAttribute("operation", "with_limit");
								response.sendRedirect("/Banking/bank_home.jsp");

							}
							
						
												
		
		
	}

}
