package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Hbase {
	public static void main(String[] args) throws IOException {
		
		HashMap<String,Data> dataList=new HashMap<String,Data>();
		
		// Setting the months in reverse chronological order
		HashMap<Integer,String> monthList=new HashMap<Integer,String>();
		//curent month
		monthList.put(1,"201808");
		monthList.put(2,"201807");
		monthList.put(3,"201806");
		monthList.put(4,"201805");
		monthList.put(5,"201804");
		monthList.put(6,"201803");
		monthList.put(7,"201802");
		monthList.put(8,"201801");
		
		
		
		File file2 = new File("C:\\Users\\MOHMO06\\Desktop\\My\\Nithin\\Hive HBase use cases\\Hbase.txt");
		BufferedReader br2 = new BufferedReader(new FileReader(file2));
		int recordsCount=-1;
		String st2;
		
		
		while ((st2 = br2.readLine()) != null) {
			recordsCount++;
			
			String[] each = st2.split("\t");
					
			if(recordsCount>0) {
				Data data= new Data();
				
				String sales=each[1].trim();
				String emp=each[2].trim();
				
				
				if(sales.equals("\\N")) {
					sales="0";
					data.setSales(0);
				}
				else
					data.setSales(Integer.parseInt(sales));
				
				if(emp.equals("\\N")) {
					emp="0";
					data.setEmp(0);
				}
				else
					data.setEmp(Integer.parseInt(emp));			
				
				//HashMap<Integer,Integer> time_sales=new HashMap<Integer,Integer>();
				//HashMap<Integer,Integer> time_emp=new HashMap<Integer,Integer>();
				//HashMap<Integer,String> date=new HashMap<Integer,String>();
				
				//time_sales.put(1, Integer.parseInt(sales));
				//time_emp.put(1, Integer.parseInt(emp));
				//date.put(1,"201808");
				
				List time_sales = new ArrayList();
				List time_emp = new ArrayList();
				List date = new ArrayList();
				
				time_sales.add(Integer.parseInt(sales));
				time_emp.add(emp);
				date.add("201808");
				
				data.setTime_sales(time_sales);
				data.setTime_emp(time_emp);
				data.setDate(date);
				
				dataList.put(each[0].trim(), data);

			}						
		}    
		br2.close();
		
		System.out.println("\nRecords Count : "+recordsCount);	
	
		int header_flag = -1;
		
		for(int counter=1; counter<8;counter++) {
			
			String filename = "C:\\Users\\MOHMO06\\Desktop\\My\\Nithin\\Hive HBase use cases\\Hive"+counter+".txt";
			File file = new File(filename);
	 
			BufferedReader br = new BufferedReader(new FileReader(file));
		 
			
			String st;
			while ((st = br.readLine()) != null) 
			{
				header_flag++;
				String[] each = st.split("\t");
				
				if(header_flag>0) {
					String sales=each[1].trim();
					String emp=each[2].trim();
					// Get the value from hash map with the key master id
	
					// Cleaning data
					if(sales.equals("\\N"))
						sales="0";				
					if(emp.equals("\\N"))
						emp="0";
					
					//System.out.println("each : "+each[0]);
					
					Data d=dataList.get(each[0].trim());
					int cur_sales = d.getSales();
					int cur_emp = d.getEmp();
					List cur_salesSetter = d.getTime_sales();
					List cur_empSetter = d.getTime_emp();
					List cur_dateSetter = d.getDate();
										
					
					// Setting the object with the current month details which were set from Hbase file.
					Data update = new Data();
					update.setSales(cur_sales);
					update.setEmp(cur_emp);
		
					// set sales
					List salesSetter = new ArrayList();
										
					for(int j=0; j<cur_salesSetter.size(); j++)
						salesSetter.add(cur_salesSetter.get(j));
					salesSetter.add(Integer.parseInt(sales));					
					update.setTime_sales(salesSetter);
					
					// set Employees
					List empSetter = new ArrayList();
					for(int j=0; j<cur_empSetter.size(); j++)
						empSetter.add(cur_empSetter.get(j));					
					empSetter.add(Integer.parseInt(emp));
					
					update.setTime_emp(empSetter);
					
					
					// Set Dates			
					List dateSetter = new ArrayList();
					for(int j=0; j<cur_dateSetter.size(); j++)
						dateSetter.add(cur_dateSetter.get(j));
					dateSetter.add(Integer.parseInt(monthList.get(counter+1)));
									
					update.setDate(dateSetter);
					
					// setting the list with the previous month details
					dataList.put(each[0].trim(),update);
				}
			}	    
			br.close();	
		}
	
		// Get all the keys
	 	Set s = dataList.keySet();
	    
	 	// Iterate over each key
	    Iterator iterator = s.iterator();
	    while(iterator.hasNext()){
	      String element = (String) iterator.next();
	      //System.out.println(element);
	      Data eachRecord=dataList.get(element);
	      
	      /*int cur_sales = (Integer) eachRecord.getTime_sales().get(0);
	      
	      Data latest = eachRecord;
	      
	      for(int j=1; j<eachRecord.getTime_sales().size(); j++)
	      {
	    	  int pre_sales = (Integer) eachRecord.getTime_sales().get(j);
	    	  
	    	  if(latest.getRange().equals(null)) {
		    	  if(cur_sales>pre_sales)
		    	  {
		    		  latest.setRange("high");
		    		  break;
		    	  }		    	  
		    	  else if(cur_sales>pre_sales)
		    	  {
		    		  latest.setRange("low");
		    		  break;
		    	  }
		    	  else
		    		  latest.setRange(null);
	    	  }
	    	  
	    	  System.out.println(eachRecord.getTime_sales().get(j));
	      }
	      dataList.put(element,latest);
	      
	      */
      
	      
	      
	      System.out.println(element+" , "+eachRecord.getSales()+" , "+eachRecord.getEmp()+" , "+eachRecord.getTime_sales()+" , "+eachRecord.getTime_emp()+" , "+eachRecord.getDate());
	      
	      
	      
	    }
	    
	}
}

