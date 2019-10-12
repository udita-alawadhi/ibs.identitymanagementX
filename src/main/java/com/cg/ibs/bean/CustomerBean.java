package com.cg.ibs.bean;

import java.util.Set;

public class CustomerBean {
	private String uci; // 16 digit Unique Customer ID
	private String userId; // unique credentials created by customer for login
	private String password; // unique credentials created by customer for login
	private Set<AccountBean> accounts;
	private ApplicantBean applicant;
	private int login=0;
	public CustomerBean() {
		super();
	}

	public String getUci() {
		return uci;
	}

	public void setUci(String uci) {
		this.uci = uci;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<AccountBean> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<AccountBean> accounts) {
		this.accounts = accounts;
	}

	public ApplicantBean getApplicant() {
		return applicant;
	}

	public void setApplicant(ApplicantBean applicant) {
		this.applicant = applicant;
	}
	
	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}
}
