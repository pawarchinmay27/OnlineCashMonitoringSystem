package com.abc.custom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abc.utility.Constants;
import com.abc.utility.DbUtil;

public class Selectoptions {

	
	public static ResultSet getRows(String Manager_name) throws ClassNotFoundException, SQLException{
		
	Connection con=	DbUtil.getConnection(Constants.DBURL, Constants.DBUNAME,Constants.DBPASSWORD);
	
	PreparedStatement ps;
	String authrbi="select * from banks where bankman_id=? ";
	
	ps=con.prepareStatement(authrbi);
	ps.setString(1, Manager_name);
	ResultSet	rs=ps.executeQuery();
	return rs;
	
	
	}
	public static ResultSet getBanks() throws ClassNotFoundException, SQLException{
		
	Connection con=	DbUtil.getConnection(Constants.DBURL, Constants.DBUNAME,Constants.DBPASSWORD);
	
	PreparedStatement ps;
	String authrbi="select * from banks ";
	
	ps=con.prepareStatement(authrbi);

	ResultSet	rs=ps.executeQuery();
	return rs;
	
	
	}
	public static ResultSet getBanksRegions() throws ClassNotFoundException, SQLException{
		
	Connection con=	DbUtil.getConnection(Constants.DBURL, Constants.DBUNAME,Constants.DBPASSWORD);
	
	PreparedStatement ps;
	String authrbi="select * from banks ";
	
	ps=con.prepareStatement(authrbi);

	ResultSet	rs=ps.executeQuery();
	return rs;
	
	
	}
}
