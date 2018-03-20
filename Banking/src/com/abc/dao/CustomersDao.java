package com.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.abc.exceptions.DataAccessException;
import com.abc.utility.Constants;
import com.abc.utility.DbUtil;

public class CustomersDao {

	
	Connection mbconnection;
	PreparedStatement ps;
	ResultSet rs;
	public CustomersDao() throws DataAccessException {
		
		
		try {
			mbconnection=DbUtil.getConnection(Constants.DBURL,Constants.DBUNAME,Constants.DBPASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			throw new DataAccessException(e.getMessage());
		}
	}
	
	
	
	public boolean moneyTransfer(String usermobile,String receivermobile,String credit) throws DataAccessException{
		int withcheck=0,depcheck=0;
		try {
			mbconnection=DbUtil.getConnection(Constants.DBURL,Constants.DBUNAME, Constants.DBPASSWORD);
			String query="update customers set acbal=acbal-? where mobile_no=?";
			float deduceamount=Float.parseFloat(credit);
			ps=mbconnection.prepareStatement(query);
			ps.setFloat(1,deduceamount);
			ps.setString(2,usermobile);
		
			withcheck=ps.executeUpdate();
			
			String queryreciever="update customers set acbal=acbal+? where mobile_no=?";
			ps=mbconnection.prepareStatement(queryreciever);
			ps.setFloat(1,deduceamount);
			ps.setString(2, receivermobile);
			depcheck=ps.executeUpdate();
			
		
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e.getMessage());
		}
		if(withcheck!=0&&depcheck!=0){
			return true;
		}
		else{
					return false;
		}
		
		
	}
	
	
	public float getCustomerBalancedao(String usermobileno) throws DataAccessException{
		float customerbalance=0;
		try {
			mbconnection=DbUtil.getConnection(Constants.DBURL, Constants.DBUNAME, Constants.DBPASSWORD);
			String authq="select * from customers where mobile_no=?";
			ps=mbconnection.prepareStatement(authq);
			ps.setString(1, usermobileno);

				rs=ps.executeQuery();
				rs.next();
				 customerbalance=rs.getFloat("acbal");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
					throw new DataAccessException(e.getMessage());
		}
		
		
		return customerbalance;
	}
	
	
	public boolean moneyTransferdaocheck(String usermobile,String receivermobile,String credit) throws DataAccessException{
	boolean flagbalcheck=false;	
	boolean identitycheck=true;	
		try {
			mbconnection=DbUtil.getConnection(Constants.DBURL, Constants.DBUNAME, Constants.DBPASSWORD);
			String authq="select * from customers where mobile_no=?"; 
			ps=mbconnection.prepareStatement(authq);
			ps.setString(1, usermobile);
			rs=ps.executeQuery();
			
			if(usermobile.equalsIgnoreCase(receivermobile)){
				identitycheck=false;
			}
			
			if(rs.next()&&identitycheck==true){
				float usersbalance=Float.parseFloat(rs.getString("acbal"));
				float moneycredit=Float.parseFloat(credit);
				if(usersbalance>moneycredit){
					flagbalcheck=true;
				}
				else{
						flagbalcheck=false;
				}
				
				
				
			}//if of result set
			else{
						flagbalcheck=false;
			}
			
			mbconnection.close();
			ps.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block


			throw new DataAccessException(e.getMessage());
			
		}
		
				return flagbalcheck;
	}
	
	
	
	
	
	
	public boolean registerCustomer(String username,String password,String email,String mobile_no) throws DataAccessException{
		int registered = 0;
		String iquery="INSERT INTO customers(name,password,email,mobile_no,profile_pic_image) VALUES(?,?,?,?,?) ";
		System.out.println(username);
			try {
				ps=mbconnection.prepareStatement(iquery);
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, email);
				ps.setString(4,mobile_no);
				ps.setString(5, "Empty");
					registered=ps.executeUpdate();
					mbconnection.close();
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block

				throw new DataAccessException(e.getMessage());
			}

			if(registered!=0){
				return true;
			}
			else{
					return false;
			}
	
	}
	
	public String isAuthentic(String mobile_no,String password) throws DataAccessException{
		String username=null;
		PreparedStatement ps;
		ResultSet rs;
		String authq="select * from customers where mobile_no=? and password=?";
		
		
		try {
				ps=mbconnection.prepareStatement(authq);
				ps.setString(1, mobile_no);
				ps.setString(2,password);
				rs=ps.executeQuery();
				
				if(rs.next()){
					username=rs.getString("name");
					
				}
				
				mbconnection.close();
				ps.close();
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e.getMessage());
		}
		return username;
	}
}
