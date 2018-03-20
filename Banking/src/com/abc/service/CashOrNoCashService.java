package com.abc.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.abc.dao.CashOrNoCashDao;
import com.abc.domain.CashOrNoCashDomain;
import com.abc.exceptions.BusinessException;
import com.abc.exceptions.DataAccessException;

public class CashOrNoCashService {
ResultSet banksresult;
	
CashOrNoCashDao serviceobj;
	public CashOrNoCashService() throws BusinessException {
	try {
		serviceobj=new CashOrNoCashDao();
	} catch (DataAccessException e) {
		// TODO Auto-generated catch block
			throw new BusinessException(e.getMessage());
	}
		
	}


	public ArrayList<CashOrNoCashDomain>	getATMDetailsService1(String region) throws BusinessException{
		ArrayList<CashOrNoCashDomain>atmdeatials;
		try {
				 atmdeatials=serviceobj.getATMDetails1(region);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e.getMessage());
		}
		
			return atmdeatials;
		
		}

	
	public ArrayList<CashOrNoCashDomain> getATMFindings(String  bank_name,String bank_region) throws BusinessException{
		ResultSet rs = null;
		ArrayList<CashOrNoCashDomain> atmfinding;
		try {
				atmfinding=serviceobj.getATMFindings(bank_name, bank_region);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
				throw new BusinessException(e.getMessage());
		}
		
		return atmfinding;
	}
}
