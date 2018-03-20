package com.abc.service;

import java.util.ArrayList;

import com.abc.dao.RBIActiondao;
import com.abc.domain.RBIDomain;
import com.abc.exceptions.BusinessException;
import com.abc.exceptions.DataAccessException;

public class RBIActionService {
	
	
	RBIActiondao rbidao;
	
	public RBIActionService() throws BusinessException {
	try {
		rbidao=new RBIActiondao();
	} catch (DataAccessException e) {
		// TODO Auto-generated catch block
		throw new BusinessException(e.getMessage());
	}
		// TODO Auto-generated constructor stub
	}

	public RBIDomain viewBankDetailsdao(String bankname,String bankregion) throws BusinessException{
		
		RBIDomain rbidomainservice;
		try {
				rbidomainservice=rbidao.viewBankDetailsdao(bankname, bankregion);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e.getMessage());
		}
		
		return rbidomainservice;
	}
	
		public boolean	RBIauthentic(String username,String password) throws BusinessException{
			boolean isauthentic=false;
			
			try {
				isauthentic=rbidao.RBIauthentic(username, password);
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				throw new BusinessException(e.getMessage());
			}
			
			return isauthentic;
		}
	
	public boolean RBIdomainsetdetailsservice(String bank_name,String bank_region,int bank_amount,String bank_date,String bank_time) throws BusinessException{
					boolean bankserviceupdated=false;

						try {
							bankserviceupdated=rbidao.RBIdomainsetdetails(bank_name, bank_region, bank_amount, bank_date, bank_time);
						} catch (DataAccessException e) {
							// TODO Auto-generated catch block
							throw new BusinessException(e.getMessage());
						}
					return bankserviceupdated;
				}
	public ArrayList<String> getBanksService(){
		ArrayList<String> banksservice = null;
		
		
			try {
				banksservice=rbidao.getBanks();
				
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return banksservice;
	}
	
	
	public ArrayList<String> getRegionsService() throws BusinessException{
		ArrayList<String> regionservice = null;
		
		try {
			regionservice=rbidao.getRegions();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e.getMessage());
		}
		
		
		return regionservice;
		
	}
	
	}
