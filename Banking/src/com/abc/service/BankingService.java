package com.abc.service;

import java.sql.SQLException;

import com.abc.dao.BankingsDao;
import com.abc.exceptions.BusinessException;
import com.abc.exceptions.DataAccessException;

public class BankingService {

	
	BankingsDao bdao;	
	
	
	public BankingService() throws  BusinessException {
			try {
				bdao=new BankingsDao();
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				throw new BusinessException(e.getMessage());
			}
		// TODO Auto-generated constructor stub
	}

	public String bankAuthenticService(String username,String password) throws BusinessException{
		boolean authenticuserser=false;
		String bankname;
		try {
					bankname=bdao.bankAuthentic(username, password);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e.getMessage());
		}
		
		return bankname;
		
	}

	public void updateCashStatus(String uname,String cashavail,String region) throws BusinessException {
			try {
				bdao.updateCashStatusDao(uname, cashavail, region);
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				throw new BusinessException(e.getMessage());
			}
	
		
		
		
	}
	
	
	public void crowdStatusCheck(String crowdstat,String manager_id,String region) throws BusinessException{
		
		try {
			bdao.crowdStatusCheckDao(crowdstat, manager_id, region);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e.getMessage());
		}
		
		
	}
	
	public void withdrawLimitCheck(String withlimit,String uname,String region) throws BusinessException{
		
		try {
			bdao.withdrawLimitCheckDao(withlimit, uname, region);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e.getMessage());
		}
	}
}
