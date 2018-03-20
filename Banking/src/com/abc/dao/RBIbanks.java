package com.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.abc.exceptions.DataAccessException;
import com.abc.utility.Constants;
import com.abc.utility.DbUtil;

public class RBIbanks {

	ArrayList<String> Banknames;
	
	ArrayList<String> Bankregions;
	private Connection mbconnection;
	
	
	public RBIbanks() throws DataAccessException {
		
		try {
			mbconnection=DbUtil.getConnection(Constants.DBURL, Constants.DBUNAME, Constants.DBPASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
		
			
						throw new DataAccessException(e.getMessage());
				}
		
	}



	public ArrayList<String> getBanks() throws DataAccessException{
		
		Banknames=new ArrayList<>();
		ResultSet rs;

		PreparedStatement ps;
		String authrbi="select * from banks ";
		
		try {
			ps=mbconnection.prepareStatement(authrbi);
	
			 rs=ps.executeQuery();
			 

				while(rs.next()){
					
					Banknames.add(rs.getString("bank_name"));
				}
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				throw new DataAccessException(e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		return Banknames;
	}
	
	
	public ArrayList<String> getRegions() throws DataAccessException{
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			mbconnection=DbUtil.getConnection(Constants.DBURL, Constants.DBUNAME, Constants.DBPASSWORD);
		
		String getregionsque="select * from banks ";
		
		ps=mbconnection.prepareStatement(getregionsque);
		rs=ps.executeQuery();
		while(rs.next()){
			Bankregions.add(rs.getString("REGION"));
		
		
		}
		
		
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e.getMessage());
		}
		
		
		
		
		return Bankregions;
		
	}
	
}
