package com.abc.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.abc.utility.Constants;
import com.abc.utility.DbUtil;

public class SelectOptions {
	public ArrayList<String> regions;
	public ArrayList<String> getRegions(String managerid){
		Connection con;
		try {
			con = DbUtil.getConnection(Constants.DBURL, Constants.DBUNAME,Constants.DBPASSWORD);
			PreparedStatement ps;
			String authrbi="select * from banks where bankman_id=? ";
			
			ps=con.prepareStatement(authrbi);
			ps.setString(1, managerid);
			ResultSet	rs=ps.executeQuery();
			regions=new ArrayList<>();
		
			while(rs.next()){
				regions.add(rs.getString("REGION"));
			}
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				return regions;
		
	}
	

}
