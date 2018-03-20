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
import javax.servlet.http.HttpSession;

import com.abc.exceptions.BusinessException;
import com.abc.service.RBIActionService;
import com.abc.utility.Constants;
import com.abc.utility.DbUtil;

/**
 * Servlet implementation class RBIAuthenticationServlet
 */
@WebServlet("/RBIauth")
public class RBIAuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RBIAuthenticationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		
		String username=request.getParameter("rbiuname");
		String password=request.getParameter("rbipassw");

		
		HttpSession session=request.getSession();
				try {
					RBIActionService rbiservice=new RBIActionService();
					boolean isauthentic=rbiservice.RBIauthentic(username, password);
					if(isauthentic){
						ArrayList<String> banksnameview=rbiservice.getBanksService();
						ArrayList<String> banksregionview=rbiservice.getRegionsService();
						/*ArrayList<String> banksnameupdate=rbiservice.getBanksService();
						ArrayList<String> banksregionupdate=rbiservice.getRegionsService();
						*/
						request.setAttribute("Banknamesliitems",banksnameview);
						request.setAttribute("Bankregionskiitems",banksregionview);
						RequestDispatcher rd=request.getRequestDispatcher("/rbihome.jsp");
						session.setAttribute("bankname", true);
						//response.sendRedirect("rbihome.jsp");
						rd.forward(request, response);
						

					}
					else{
						response.sendRedirect("RBIlogin.jsp?error=1");
					}
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	}

}
