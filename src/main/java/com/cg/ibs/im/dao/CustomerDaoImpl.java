package com.cg.ibs.im.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import com.cg.ibs.bean.AccountBean;
import com.cg.ibs.bean.CustomerBean;
import com.cg.ibs.im.exception.IBSCustomException;
import com.cg.ibs.im.exception.IBSException;

public class CustomerDaoImpl implements CustomerDao {

	private static Map<String, CustomerBean> customerDao = new HashMap<String, CustomerBean>();
	public static final String UPLOADS_LOC="./uploads";
	CustomerBean newCustomer = new CustomerBean();
	
	static {
		CustomerBean customer1 = new CustomerBean();
		customer1.setUci("5555111151511001");
		customer1.setUserId("udita");
		customer1.setPassword("abc123");
		AccountBean account1 = new AccountBean();
		account1.setAccountNumber("05100001111");
		account1.setCurrentBalance(new BigDecimal("20048.32"));
		customer1.setAccounts(account1);
		customerDao.put(customer1.getUci(), customer1);
		
		CustomerBean customer2 = new CustomerBean();
		customer2.setUci("5555111151512201");
		customer2.setUserId("chetan551");
		customer2.setPassword("xyz123");
		AccountBean account2 = new AccountBean();
		account2.setAccountNumber("05100222111");
		account2.setCurrentBalance(new BigDecimal("208.92"));
		customer2.setAccounts(account2);
		customerDao.put(customer2.getUci(), customer2);
	}
	
	@Override
	public boolean saveCustomer(CustomerBean customer) throws IBSCustomException {
		boolean result = false;
		if (customer != null) {
			customerDao.put(customer.getUci(), customer);
			result = true;
		} else {
			throw new IBSCustomException(IBSException.customerNotPresent);
		}
		return result;
	}

	@Override
	public CustomerBean getCustomerDetails(String uci) throws IBSCustomException {
		newCustomer = null;
		for (Entry<String, CustomerBean> entry : customerDao.entrySet()) {
			if (entry.getKey().equals(uci)) {
				newCustomer = entry.getValue();
				break;
			}
		}
		if (newCustomer==null) {
			throw new IBSCustomException(IBSException.customerNotPresent);
		}
		return newCustomer;
	}

	@Override
	public Set<String> getAllCustomers() {
		return new TreeSet<String>(customerDao.keySet());
	}

	public CustomerBean getCustomerByApplicantId(long applicantId) {
		CustomerBean newCustomer = new CustomerBean();
		for (Entry<String, CustomerBean> entry : customerDao.entrySet()) {
			long appId = entry.getValue().getApplicant().getApplicantId();
			if (appId == applicantId) {
				newCustomer = entry.getValue();
				break;
			}
		}
		return newCustomer;
	}
	
	@Override
	public boolean copy(String srcPath, String destPath) {
        boolean isDone=false;
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);

        if (srcFile.exists()) {
                try (FileInputStream fin = new FileInputStream(srcFile);
                                FileOutputStream fout = new FileOutputStream(destFile)) {
                        byte[] data = new byte[1024];
                        while(fin.read(data)>-1) {
                                fout.write(data);
                        }
                        isDone=true;
                } catch (IOException exception) {
                        //raise a user defiend exception
                }
        } else {
                // throw your exception
        }
        return isDone;
	}
}