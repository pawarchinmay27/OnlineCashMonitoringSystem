package com.abc.domain;

public class RBIDomain {
private	String zone;
private	String bank_name;
private	String cash_stat;
private	String crowd_stat;
private	String max_cash_limit;
private	String REGION;
private	String cashdepositedamount;
private	String cashdepositedtime;
public RBIDomain(String zone, String bank_name, String cash_stat, String crowd_stat, String max_cash_limit,
		String rEGION, String cashdepositedamount, String cashdepositedtime, String cashdepositeddate) {
	super();
	this.zone = zone;
	this.bank_name = bank_name;
	this.cash_stat = cash_stat;
	this.crowd_stat = crowd_stat;
	this.max_cash_limit = max_cash_limit;
	REGION = rEGION;
	this.cashdepositedamount = cashdepositedamount;
	this.cashdepositedtime = cashdepositedtime;
	this.cashdepositeddate = cashdepositeddate;
}
private	String cashdepositeddate;

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
public String getCashdepositedamount() {
	return cashdepositedamount;
}
public void setCashdepositedamount(String cashdepositedamount) {
	this.cashdepositedamount = cashdepositedamount;
}
public String getCashdepositedtime() {
	return cashdepositedtime;
}
public void setCashdepositedtime(String cashdepositedtime) {
	this.cashdepositedtime = cashdepositedtime;
}
public String getCashdepositeddate() {
	return cashdepositeddate;
}
public void setCashdepositeddate(String cashdepositeddate) {
	this.cashdepositeddate = cashdepositeddate;
}
	
	
}
