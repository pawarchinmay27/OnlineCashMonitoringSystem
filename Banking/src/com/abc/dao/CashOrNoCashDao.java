package com.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.abc.domain.CashOrNoCashDomain;
import com.abc.exceptions.DataAccessException;
import com.abc.utility.Constants;
import com.abc.utility.DbUtil;

public class CashOrNoCashDao {

	
	Connection mbconnection;
	public CashOrNoCashDao() throws DataAccessException {
		
			try {
				mbconnection=DbUtil.getConnection(Constants.DBURL,Constants.DBUNAME,Constants.DBPASSWORD);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
						throw new DataAccessException(e.getMessage());
			}
	
	}
	

	public ArrayList<CashOrNoCashDomain> getATMDetails1(String region) throws DataAccessException{
		String selb="select * from banks where zone=?";
		System.out.println("Region is"+region);
		PreparedStatement ps;
		ResultSet rs;
		ArrayList<CashOrNoCashDomain> atmdataset;
	try{
		ps=mbconnection.prepareStatement(selb);
		atmdataset=new ArrayList<>();
		
		ps.setString(1, region);
		 rs=ps.executeQuery();
		 while(rs.next()){
			 				
			 	atmdataset.add(new CashOrNoCashDomain(rs.getString("zone"),   rs.getString("bank_name"),rs.getString("cash_stat"),rs.getString("crowd_stat"),rs.getString("max_cash_limit") ,rs.getString("REGION")));

		 
		 }
		 
		 
		 mbconnection.close();
		 rs.close();
	}
	
	catch(SQLException e){
		throw new DataAccessException(e.getMessage());
	}
		
	
	
		return atmdataset;
	}
	public ArrayList<CashOrNoCashDomain> getATMFindings(String  bank_name,String bank_region) throws DataAccessException{
		String querycheck="select * from banks where bank_name=? and REGION=?";
		PreparedStatement ps;
		ResultSet rs;
		ArrayList<CashOrNoCashDomain> atmfindingdao;
		try {
			atmfindingdao=new ArrayList<>();
			ps = mbconnection.prepareStatement(querycheck);
			ps.setString(1, bank_name);
			ps.setString(2, bank_region);
			rs=ps.executeQuery();
			while(rs.next()){
				
			
			atmfindingdao.add(new CashOrNoCashDomain(rs.getString("zone"),   rs.getString("bank_name"),rs.getString("cash_stat"),rs.getString("crowd_stat"),rs.getString("max_cash_limit") ,rs.getString("REGION")));
			}
			
			mbconnection.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				throw new DataAccessException(e.getMessage());
		}
		
		return atmfindingdao;
	}


}
