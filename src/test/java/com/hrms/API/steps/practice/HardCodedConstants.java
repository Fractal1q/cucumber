package com.hrms.API.steps.practice;

public class HardCodedConstants {
	
	public static String updateCreatedEmployee() {
		 String updateBody = "{\r\n" + 
				"  \"employee_id\": \""+HardCodedExamples.employeeID+"\",\r\n" + 
				"  \"emp_firstname\": \"Karl\",\r\n" + 
				"  \"emp_lastname\": \"Son\",\r\n" + 
				"  \"emp_middle_name\": \"C\",\r\n" + 
				"  \"emp_gender\": \"M\",\r\n" + 
				"  \"emp_birthday\": \"2011-07-11\",\r\n" + 
				"  \"emp_status\": \"Freelance\",\r\n" + 
				"  \"emp_job_title\": \"QA Tester\"\r\n" + 
				"}";
		return updateBody;
	}

}
