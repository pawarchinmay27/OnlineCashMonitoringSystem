package com.abc.service;

import com.abc.dao.CustomersDao;
import com.abc.exceptions.BusinessException;
import com.abc.exceptions.DataAccessException;

public class CustomersService {

	
	CustomersDao customerdao;
	public CustomersService() throws BusinessException {
			try {
				customerdao=new CustomersDao();
			} catch (DataAccessException e) {
					throw new BusinessException(e.getMessage());
			}
	
	}
	
	public boolean moneyTransferService(String usermobile_no,String  receivermobile,String credit ) throws BusinessException{
	boolean authtransaction=false,tansactionsuccess=false;		
	
		try {
					authtransaction=customerdao.moneyTransferdaocheck(usermobile_no, receivermobile, credit);
					if(authtransaction==true){
						
						tansactionsuccess=customerdao.moneyTransfer(usermobile_no, receivermobile, credit);
						
						if(tansactionsuccess==true){
										return true;
						}
						
						else{
									return false;
						}
					}
					
					else{
								return false;
					}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
				throw new BusinessException(e.getMessage());
		}
		
	}
	
	
	
	public boolean registeredService(String username,String password,String email,String mobile_no) throws BusinessException{
		boolean registeredservice=false;
		try {
			registeredservice= customerdao.registerCustomer(username, password, email, mobile_no);
		} catch (DataAccessException e) {
			throw new BusinessException(e.getMessage());
			
		}
		return registeredservice;
		
	}

	public float getCustomerBalanceService(String usermobile) throws BusinessException{
		float userbalance;
		
		try {
			userbalance=customerdao.getCustomerBalancedao(usermobile);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e.getMessage());
		}
		
		
		return userbalance;
	}
	
	public String isAuthentic(String mobile_no,String password) throws BusinessException{
		String username=null;
				try {
					username=customerdao.isAuthentic(mobile_no, password);
				} catch (DataAccessException e) {
					// TODO Auto-generated catch block
					throw new BusinessException(e.getMessage());
				}
		
		return username;
	}
	
	
}
