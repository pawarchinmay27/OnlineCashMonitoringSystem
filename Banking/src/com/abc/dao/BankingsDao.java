package com.abc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abc.exceptions.DataAccessException;
import com.abc.utility.Constants;

public class BankingsDao {

	private Connection mbconnection;
	
	
	public BankingsDao() throws DataAccessException {
		
		try {
			mbconnection=DriverManager.getConnection(Constants.DBURL,Constants.DBUNAME,Constants.DBPASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				throw new DataAccessException(e.getMessage());
		}
		
		
		
	}

	public String bankAuthentic(String username,String password) throws DataAccessException{
		
		boolean authenticuser=false;
		PreparedStatement ps;
		ResultSet  rs;
		String bankname=null;
		String query="select * from banks where bankman_id=? and bankman_passw=?";
		try {
			ps=mbconnection.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2,password);
			rs=ps.executeQuery();
			if(rs.next()){
								bankname=rs.getString("bank_name");
			}
			rs.close();
			mbconnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e.getMessage());
		}
		
		return bankname;
		
	}
	

	public void updateCashStatusDao(String uname,String cashavail,String region) throws DataAccessException{
			
		
		
		String query="update banks set cash_stat=? where bankman_id=? and REGION=?";
		try {
			PreparedStatement ps=mbconnection.prepareStatement(query);
			ps.setString(1,cashavail);
			ps.setString(2, uname);
			ps.setString(3, region);
			ps.executeUpdate();
			ps.close();
			mbconnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e.getMessage());
		}
		

	}
	
	
	
	
	
	

		
		
	
	
	
	public void crowdStatusCheckDao(String crowdstat,String manager_id,String region) throws DataAccessException{
		
		String query="update banks set crowd_stat=? where bankman_id=? and REGION=?";
		try {
			PreparedStatement ps=mbconnection.prepareStatement(query);
			ps.setString(1,crowdstat);
			ps.setString(2, manager_id);
			ps.setString(3, region);
			ps.executeUpdate();
			
			mbconnection.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e.getMessage());
		}

		
	}
	
	public void withdrawLimitCheckDao(String withlimit,String uname,String region) throws DataAccessException{
		
		
		String query="update banks set 	max_cash_limit=? where bankman_id=? and REGION=?";
		try {
			PreparedStatement ps=mbconnection.prepareStatement(query);
			ps.setString(1, withlimit);
			ps.setString(2, uname);
			ps.setString(3, region);
			ps.executeUpdate();
			
			mbconnection.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e.getMessage());
		}
	}

}


