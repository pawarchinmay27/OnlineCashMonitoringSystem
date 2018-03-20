package com.abc.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
 * Servlet implementation class MoneyTransferServelet
 */
@WebServlet("/MoneyTransfer")
public class MoneyTransferServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoneyTransferServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String credit=request.getParameter("amt");
		String receivermobileno=request.getParameter("rno");
		HttpSession session=request.getSession();
		
		String depositormobileno=(String)session.getAttribute("phno");
			
		try {
			CustomersService customerservice=new CustomersService();
			boolean tansactionperformed=customerservice.moneyTransferService(depositormobileno, receivermobileno, credit);
				if(tansactionperformed==true){
					session.setAttribute("getAlert", "yes");
					response.sendRedirect("transfer.jsp");

				}
				else{
					session.setAttribute("getAlert", "no");
					response.sendRedirect("transfer.jsp");

				}
		
		
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

}
