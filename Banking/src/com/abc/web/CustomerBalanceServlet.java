package com.abc.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.exceptions.BusinessException;
import com.abc.service.CustomersService;

/**
 * Servlet implementation class CustomerBalanceServlet
 */
@WebServlet("/CustomerBalance")
public class CustomerBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerBalanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			CustomersService customerservice=new CustomersService();
			
			HttpSession session=request.getSession();
			
			String usermobileno=session.getAttribute("phno").toString();
			
			float userbalance=customerservice.getCustomerBalanceService(usermobileno);
			
			request.setAttribute("customerbalance", userbalance);
			
			RequestDispatcher rd=request.getRequestDispatcher("/balance.jsp");
			
			rd.forward(request, response);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
