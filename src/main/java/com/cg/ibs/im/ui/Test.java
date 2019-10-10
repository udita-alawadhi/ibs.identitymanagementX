package com.cg.ibs.im.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.ibs.im.service.CustomerService;
import com.cg.ibs.im.service.CustomerServiceImpl;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your Date of Birth in DD-MM-YYYY format");
		 String date = scanner.next();

		 // if format of date is invalid, ask for DOB again.
		 DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		 LocalDate dt = null;
		 CustomerService customer = new CustomerServiceImpl();

		 while (dt==null || !customer.verifyDob(dt)) {
		  System.out.println("Please enter a valid date of birth in correct format(dd-MM-yyyy).\nYour age should be greater than 18!");
		  date = scanner.next();
		  Pattern pattern = Pattern.compile("^(1[0-2]|0[1-9])(-3[01]|[-12][0-9]|-0[1-9])[0-9]{4}$");
		  Matcher matcher = pattern.matcher(date);
		  if (matcher.matches()) {
		   dt = LocalDate.parse(date, dtFormat);
		  }else{
		   dt=null;
		  }
		 }
		 System.out.println(dt);

	}
}
