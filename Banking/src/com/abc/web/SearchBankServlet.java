package com.abc.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.domain.CashOrNoCashDomain;
import com.abc.exceptions.BusinessException;
import com.abc.service.CashOrNoCashService;

import com.abc.utility.Constants;
import com.abc.utility.DbUtil;

/**
 * Servlet implementation class SearchBankServlet
 */
@WebServlet("/SearchBank")
public class SearchBankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String bank_name=request.getParameter("bank_name_main");
	
	String bank_region=request.getParameter("REGION");

			try {
				CashOrNoCashService serviceobj=new CashOrNoCashService();
				ArrayList<CashOrNoCashDomain> rs=serviceobj.getATMFindings(bank_name, bank_region);
				request.setAttribute("Bank_Status", rs);
				RequestDispatcher rd=request.getRequestDispatcher("/SearchBanksResult.jsp");
				rd.forward(request, response);
				
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
