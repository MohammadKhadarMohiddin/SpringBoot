package com.elamp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javainuse.process.Processor;
import com.javainuse.process.temp;

@Controller
public class RequestHandler {
	
	@RequestMapping(method = RequestMethod.GET, value="/req")
	@ResponseBody
	String response(@RequestParam Map<String, String> customQuery) throws Exception {	
			
		System.out.println("customQuery = name " + customQuery.get("name"));
		System.out.println("customQuery = street_line1 " + customQuery.get("street_line1"));
		System.out.println("customQuery = address_city " + customQuery.get("address_city"));
		System.out.println("customQuery = address_state_code " + customQuery.get("address_state_code"));
		System.out.println("customQuery = address_postal_code " + customQuery.get("address_postal_code"));
		System.out.println("customQuery = phone " + customQuery.get("phone"));
		
		Processor p = new Processor();
		return p.process(customQuery.get("name")+","+customQuery.get("street_line1")+","+customQuery.get("address_city")+","+customQuery.get("address_state_code")+","+customQuery.get("address_postal_code")+","+customQuery.get("phone"));
		
/*		temp t = new temp();
		return t.test(customQuery.get("name")+","+customQuery.get("street_line1")+","+customQuery.get("address_city")+","+customQuery.get("address_state_code")+","+customQuery.get("address_postal_code")+","+customQuery.get("phone"));
*/		
	}
}
