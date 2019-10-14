package com.cg.ibs.im.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.cg.ibs.bean.AccountBean;
import com.cg.ibs.bean.CustomerBean;

public class AccountDaoImpl {
	private static Map<String, AccountBean> accountsDao = new HashMap<String, AccountBean>();
	private CustomerBean newCustomer = new CustomerBean();
	
	public Set<String> getAccountsByUci() {
		Set<String> customerAccounts = new HashSet<String>();
//		newCustomer = getC
		return customerAccounts;
	}
}
