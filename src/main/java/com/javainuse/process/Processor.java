package com.javainuse.process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.elamp.model.PhoneResponce;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
//import com.javainuse.SpringBatchApplication;

public class Processor {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(Processor.class);
		
	// Store phone response.
	String name = null;
	String street_line_1 = null;
	String address_city = null;
	String address_state_code = null;
	String address_postal_code = null;
	String address_phone = null;

	// Store input data
	String in_name = null;
	String in_street_line_1 = null;
	String in_address_city = null;
	String in_address_state_code = null;
	String in_address_postal_code = null;
	String 	in_Phone = null;
	
	
	BufferedWriter bw = null;
	FileWriter fw = null;

	public String process(String data) throws Exception {
		
		
		System.out.println("enter process data::" + data);

		String[] data1 = data.split(",");
		// return data.toString();

		ResponseEntity<PhoneResponce> response1 = getPhoneResponse(data1);
		setPhoneResponse(response1);

		System.out.println("before if...." + response1.getBody().getBelongs_to().get(0).getType());

		// If type = Person
		if (response1.getBody().getBelongs_to().get(0).getType().equalsIgnoreCase("Person")) {
			System.out.println("enter type=person");

			// Take the Address from phone Response and pass to Matching algorithm

			// boolean matches= Matching algorthim(address)
			// if algorthim = true, take address from api/csv and call to 2nd api
			// if algorthim = false,return null
			
			
			Boolean matchingResult = getMatchingResults(data1, response1);
			
			/* Code for Matching Algorithm *****
			 * String input="5T'S COMPLETE CONDOMINIUM SVC128 COVE AVEGULF SHORESAL365428045286535";
			List<String> dst_in_lst= new ArrayList<>();
			dst_in_lst.add("5T's Appliance Inc.128 Cove AveGulf ShoresAL365428045286535");
			dst_in_lst.add("5T'S Complete Condominium Services128 Cove AveGulf ShoresAL365428045286535");

			com.amex.lwe.Matching object= new com.amex.lwe.Matching();
			String score=object.match(input, dst_in_lst);
			*/

			if (matchingResult) {
				return getBusinessResponse();
			} 
			else {
				String response=in_name+","+ in_street_line_1  + ","+ in_address_state_code + ","+ in_address_city+ ","+ in_address_postal_code+ ","+ in_Phone+","+ null;				
				return response;				
			}
		}

		if (response1.getBody().getBelongs_to().get(0).getType().equalsIgnoreCase("Business")) {
			// If type = business
			System.out.println("enter type=busines");
			
			Boolean matchingResult = getMatchingResults(data1, response1);
			
			
			// Take the Address from phone Response and pass to Matching algorithm
			// boolean matches= Matching algorthim(address)
			// if algorthim = true, take address from api/csv and call to 2nd api
			// if algorthim = false,take address from csv and call 2nd api
			
			if (matchingResult) {
				return getBusinessResponse();				
			} 
			else {
				return getBusinessResponseonInputData();
			}
		}


		return null;
	}

	
	private Boolean getMatchingResults(String[] data1, ResponseEntity<PhoneResponce> response1) throws Exception {
		
		in_name = data1[0];
		in_street_line_1 = data1[1];
		in_address_city = data1[2];
		in_address_state_code =data1[3];
		in_address_postal_code = data1[4];
		in_Phone = data1[5];
		
		String input = in_name + "\u0001" + in_street_line_1 + "\u0001" + in_address_city + "\u0001" + in_address_state_code + "\u0001" + in_address_postal_code + "\u0001" + in_Phone;;
		
		name = response1.getBody().getBelongs_to().get(0).getName();
		street_line_1 = response1.getBody().getCurrent_addresses().get(0).getStreet_line_1();
		address_city = response1.getBody().getCurrent_addresses().get(0).getCity();
		address_state_code = response1.getBody().getCurrent_addresses().get(0).getState_code();
		address_postal_code = response1.getBody().getCurrent_addresses().get(0).getPostal_code();
		address_phone = response1.getBody().getPhone_number();
	
	    String destination_string= name + "\u0001" + street_line_1 + "\u0001" + address_city + "\u0001" + address_state_code + "\u0001" + address_postal_code + "\u0001" + address_phone;
		List<String> dst_in_lst= new ArrayList<>();
		dst_in_lst.add(destination_string);
		
		//com.amex.lwe.Matching object= new com.amex.lwe.Matching();
		//String score=object.match(input, dst_in_lst);
		
		String score = "";
		
		if(score==null) {
			return null;
		}else {
			return true;
		}
		
	}
	
	private void setPhoneResponse(ResponseEntity<PhoneResponce> response1) {

		address_city = response1.getBody().getCurrent_addresses().get(0).getCity();
		address_state_code = response1.getBody().getCurrent_addresses().get(0).getState_code();
		street_line_1 = response1.getBody().getCurrent_addresses().get(0).getStreet_line_1();
		//
	}

	private ResponseEntity<PhoneResponce> getPhoneResponse(String[] data1) {

		// Phone response
		RestTemplate restTemplate = new RestTemplate();
		String host = "proapi.whitepages.com/3.0/phone.json";
		
		in_name = data1[0];
		in_street_line_1 = data1[1];
		in_address_city = data1[2];
		in_address_state_code =data1[3];
		in_address_postal_code = data1[4];
		in_Phone = data1[5];
		
		System.out.println("name:::" + in_name);
		String api_key = "96712c80cbdc49bcbca4974c27cbce89";
		String url = "https://" + host + "?api_key=" + api_key + "&phone=" + in_Phone;
		//System.out.println("url::" + url);
		logger.info("1st URL_"+in_Phone+":::"+url);

		// get the response and mapped to java object
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<PhoneResponce> response = restTemplate.exchange(url, HttpMethod.GET, entity,
				PhoneResponce.class);

		//System.out.println("1st Response::" + response.toString());
		logger.info("1st response_"+in_Phone+":::"+response.toString());

		return response;

	}

	private String getBusinessResponse() {

		// 2nd Call based on phone response.

		String host2 = "proapi.whitepages.com/3.0/business";
		String api_key2 = "84527d893e0840bc94861fb8c9fb237b";
		String url2 = "https://" + host2 + "?name=" + in_name.replaceAll(" ", "%20") + "&address.city="
				+ address_city.replaceAll(" ", "%20") + "&address.state_code="
				+ address_state_code.replaceAll(" ", "%20") + "&street_line_1=" + street_line_1.replaceAll(" ", "%20")
				+ "&api_key=" + api_key2;
		
		//System.out.println("url2:::" + url2);
		logger.info("2nd URL_"+in_Phone+":::"+url2);
		

		RestTemplate restTemplate2 = new RestTemplate();
		ResponseEntity<String> response2 = restTemplate2.getForEntity(url2, String.class);

		//System.out.println("2nd response:::" + response2.toString());
		logger.info("2nd response_"+in_Phone+":::"+response2.toString());
		
		//String response=in_Phone+"   --->   "+response2.toString().replaceFirst("<200 OK,", "JSON : ")+"\n";
		//String response=in_name+","+ in_street_line_1  + ","+ in_address_state_code + ","+ in_address_city+ ","+ in_address_postal_code+ ","+ in_Phone+","+response2.toString().replaceFirst("<200 OK,", "JSON : ");

		return response2.toString().replaceFirst("<200,", "");

	}
	
	private String getBusinessResponseonInputData() {

		System.out.println("enter getBusinessResponse on input data");
		
		
		// 2nd Call based on phone response.
		String host2 = "proapi.whitepages.com/3.0/business";
		String api_key2 = "84527d893e0840bc94861fb8c9fb237b";
		String url2 = "https://" + host2 + "?name=" + in_name.replaceAll(" ", "%20") + "&address.city="
				+ in_address_city.replaceAll(" ", "%20") + "&address.state_code="
				+ in_address_state_code.replaceAll(" ", "%20") + "&street_line_1=" + in_street_line_1.replaceAll(" ", "%20")
				 + "&address.postal_code=" + in_address_postal_code.replaceAll(" ", "%20")
					+ "&api_key=" + api_key2;
		//System.out.println("url2:::" + url2);
		logger.info("2nd URL_"+in_Phone+":::"+url2);

		RestTemplate restTemplate2 = new RestTemplate();
		ResponseEntity<String> response2 = restTemplate2.getForEntity(url2, String.class);

	
		//System.out.println("2nd business response based on csv:::" + response2.toString());
		logger.info("2nd response_"+in_Phone+":::"+response2.toString());
		//String response=in_name+","+ in_street_line_1  + ","+ in_address_state_code + ","+ in_address_city+ ","+ in_address_postal_code+ ","+ in_Phone+","+response2.toString().replaceFirst("<200 OK,", "JSON : ");
		return response2.toString().replaceFirst("<200,", "");

	}
}