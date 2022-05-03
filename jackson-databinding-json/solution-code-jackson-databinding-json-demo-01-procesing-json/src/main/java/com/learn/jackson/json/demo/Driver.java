package com.learn.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON  file and map/convert to Java POJO: 
			// data/sample-lite.json
			
			Student theStudent = mapper.readValue(
						new File("data/sample-full.json"), Student.class);
			
			// print first name and last name
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());

			System.out.println("address is -");
			System.out.println("city :"+theStudent.getAddress().getCity());
			System.out.println("country :"+theStudent.getAddress().getCountry());
			System.out.println("state :"+theStudent.getAddress().getState());
			System.out.println("street : "+theStudent.getAddress().getStreet());
			System.out.println("zip : "+theStudent.getAddress().getZip());
			System.out.println("languages are - ");
			for(String lang: theStudent.getLanguages()){
				System.out.println(lang);
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}




