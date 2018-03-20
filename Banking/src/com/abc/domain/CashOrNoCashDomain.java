package com.abc.domain;

public class CashOrNoCashDomain {
	String zone;
	String bank_name;
	String cash_stat;
	String crowd_stat;
	String max_cash_limit;
	String REGION;
	public CashOrNoCashDomain(String zone, String bank_name, String cash_stat, String crowd_stat, String max_cash_limit,
			String rEGION) {
		super();
		this.zone = zone;
		this.bank_name = bank_name;
		this.cash_stat = cash_stat;
		this.crowd_stat = crowd_stat;
		this.max_cash_limit = max_cash_limit;
		REGION = rEGION;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getCash_stat() {
		return cash_stat;
	}
	public void setCash_stat(String cash_stat) {
		this.cash_stat = cash_stat;
	}
	public String getCrowd_stat() {
		return crowd_stat;
	}
	public void setCrowd_stat(String crowd_stat) {
		this.crowd_stat = crowd_stat;
	}
	public String getMax_cash_limit() {
		return max_cash_limit;
	}
	public void setMax_cash_limit(String max_cash_limit) {
		this.max_cash_limit = max_cash_limit;
	}
	public String getREGION() {
		return REGION;
	}
	public void setREGION(String rEGION) {
		REGION = rEGION;
	}
	

	
	
	
}
