package com.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.abc.domain.RBIDomain;
import com.abc.exceptions.DataAccessException;
import com.abc.utility.Constants;
import com.abc.utility.DbUtil;

public class RBIActiondao {

	
	ArrayList<String> Banknames;
	
	ArrayList<String> Bankregions;
	
	Connection mbconnection;
	PreparedStatement ps;
	ResultSet rs;
	

	public RBIActiondao() throws DataAccessException {
				
		try {
			mbconnection=DbUtil.getConnection(Constants.DBURL, Constants.DBUNAME, Constants.DBPASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
					throw new DataAccessException(e.getMessage());
		}
		
		
	}
	
	public boolean RBIauthentic(String username,String password) throws DataAccessException{
		boolean isauthentic=false;
		PreparedStatement ps;
		ResultSet rs;
		String authrbi="select * from rbia where username=? and password=?";
		try {
			ps=mbconnection.prepareStatement(authrbi);
			ps.setString(1, username);
			ps.setString(2,password);
			rs=ps.executeQuery();
			if(rs.next()){
				isauthentic=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				throw new DataAccessException(e.getMessage());
		}
		
	
		
		
		
		return isauthentic;
	}
	
	
	public RBIDomain viewBankDetailsdao(String bankname,String bankregion) throws DataAccessException{
		RBIDomain bankdetails;
			try {
				mbconnection=DbUtil.getConnection(Constants.DBURL, Constants.DBUNAME, Constants.DBPASSWORD);
				String ckque="select * from banks where bank_name=? and REGION=?";
					ps=mbconnection.prepareStatement(ckque);
					ps.setString(1,bankname);
					ps.setString(2, bankregion);
					rs=ps.executeQuery();
					rs.next();
					bankdetails=new RBIDomain(rs.getString("zone"),  rs.getString("bank_name"), rs.getString("cash_stat"), rs.getString("crowd_stat"), rs.getString("max_cash_limit"),rs.getString("REGION"),rs.getString("cash_dep"),rs.getString("cashdep_time"), rs.getString("cashdep_det"));
					
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				
				
				throw new DataAccessException(e.getMessage());
			}
		
			return bankdetails;
			
		
	}
	
	
	public boolean RBIdomainsetdetails(String bank_name,String bank_region,int bank_amount,String bank_date,String bank_time) throws DataAccessException{
	
			boolean	bankupadted=false;
			int check=0;
		try {
			mbconnection=DbUtil.getConnection(Constants.DBURL, Constants.DBUNAME, Constants.DBPASSWORD);
			String query="update banks set  cash_dep=?, cashdep_det=?,cashdep_time=? where bank_name=? and REGION=?";
			ps=mbconnection.prepareStatement(query);
			ps.setInt(1, bank_amount);
			ps.setString(2, bank_date);
			ps.setString(3, bank_time);
			ps.setString(4, bank_name);
			ps.setString(5,bank_region);
			check=ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
					throw new DataAccessException(e.getMessage());
		}
		
		if(check!=0){
			bankupadted=true;
		}
		
	
		return bankupadted;
	}
	
	
	
	//Get The Regions
	
	public ArrayList<String> getRegions() throws DataAccessException{
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			mbconnection=DbUtil.getConnection(Constants.DBURL, Constants.DBUNAME, Constants.DBPASSWORD);
		Bankregions=new ArrayList<>();
		String getregionsque="select * from banks";
		
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
	
	//Get BankNames
	
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
}
