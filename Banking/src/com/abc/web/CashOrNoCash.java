package com.abc.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

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
 * Servlet implementation class CashOrNoCash
 */
@WebServlet("/cono")
public class CashOrNoCash extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CashOrNoCash() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String region=(String) request.getParameter("zone");
		
		try {
			CashOrNoCashService atmfindings=new CashOrNoCashService();
			ArrayList<CashOrNoCashDomain> atmdetails=atmfindings.getATMDetailsService1(region);
			request.setAttribute("Banksds", atmdetails);
			RequestDispatcher rd=request.getRequestDispatcher("/bankdispd.jsp");
			rd.forward(request, response);
		
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
