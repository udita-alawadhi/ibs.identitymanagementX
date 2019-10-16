package com.cg.ibs.bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

public class AccountBean {
	private BigInteger accountNumber;
	private Set<CustomerBean> accountHolders;
	private BigDecimal currentBalance;
	private AccountType accountType;

	public AccountBean() {
		super();
	}

	
	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public BigInteger getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(BigInteger accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Set<CustomerBean> getAccountHolders() {
		return accountHolders;
	}

	public void setAccountHolders(Set<CustomerBean> accountHolders) {
		this.accountHolders = accountHolders;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountBean [accountNumber=");
		builder.append(accountNumber);
		builder.append(", currentBalance=");
		builder.append(currentBalance);
		builder.append(", Account Type: ");
		builder.append(accountType);
		builder.append("]");
		return builder.toString();
	}

}
