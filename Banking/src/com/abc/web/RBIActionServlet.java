package com.abc.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.domain.RBIDomain;
import com.abc.exceptions.BusinessException;
import com.abc.service.RBIActionService;
import com.abc.utility.Constants;
import com.abc.utility.DbUtil;

/**
 * Servlet implementation class RBIActionServlet
 */
@WebServlet("/RBIaction")
public class RBIActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RBIActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("action").equals("CheckBank")){
			String bankname=request.getParameter("bankc");
			String bankregion=request.getParameter("REGION");
			try {
				RBIActionService rbiservice=new RBIActionService();
				RBIDomain rbidetails=rbiservice.viewBankDetailsdao(bankname, bankregion);
				request.setAttribute("banksforrbi",rbidetails);
				RequestDispatcher rd=request.getRequestDispatcher("/cbdetailsDD.jsp");
				rd.forward(request, response);
				
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(request.getParameter("action").equals("UpdateBank")){
	
			String bank_name=request.getParameter("bankc").toString();
			String bank_region=request.getParameter("bankr").toString();
			String bank_date=request.getParameter("bank_date").toString();
			String bank_time=request.getParameter("bank_time").toString();
			int bank_amount=Integer.parseInt(request.getParameter("bank_depamt").toString());
			HttpSession session=request.getSession();
			
				try {
					RBIActionService rbiservice=new RBIActionService();
			
					
					boolean chekcservlet=rbiservice.RBIdomainsetdetailsservice(bank_name, bank_region, bank_amount, bank_date, bank_time);
				if(chekcservlet==true){
					session.setAttribute("getAlert", "yes");
					session.setAttribute("bankname", true);
					
						response.sendRedirect("rbihome.jsp");
							
				}
				else{
					session.setAttribute("getAlert", "no");
					session.setAttribute("bankname", true);
							
					response.sendRedirect("rbihome.jsp");
				
				}
				
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
