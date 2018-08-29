package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Data {
	
	int sales;
	int emp;

	List time_sales =  new ArrayList();
	List time_emp =  new ArrayList();
	List date =  new ArrayList();
	
	//HashMap<Integer,Integer> time_sales = new HashMap<Integer,Integer>();
	//HashMap<Integer,Integer> time_emp = new HashMap<Integer,Integer>();
	//HashMap<Integer,String> date = new HashMap<Integer,String>();
	

	
	String range;
	
	//List<Integer> time_sales = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
	//List<Integer> time_emp = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
	//List<String> date = Arrays.asList("1","2","3","4","5","6","7","8");
	//List<String> range= Arrays.asList("1","2","3","4","5","6","7","8");
	
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getEmp() {
		return emp;
	}
	public void setEmp(int emp) {
		this.emp = emp;
	}
	public List getTime_sales() {
		return time_sales;
	}
	public void setTime_sales(List time_sales) {
		this.time_sales = time_sales;
	}
	public List getTime_emp() {
		return time_emp;
	}
	public void setTime_emp(List time_emp) {
		this.time_emp = time_emp;
	}
	public List getDate() {
		return date;
	}
	public void setDate(List date) {
		this.date = date;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	
}