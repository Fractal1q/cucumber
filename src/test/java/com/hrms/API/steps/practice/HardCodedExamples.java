package com.hrms.API.steps.practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.*;
import org.junit.runners.MethodSorters;
//import org.apache.hc.core5.http.ContetType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExamples {
	

		
		/**
		 * Rest Assured
		 * 
		 * given - prepare your request
		 * when - you are making the call for to the endpoint
		 * then - validate
		 * 
		 * @param args
		 */
	/**
	 * JWT required for all calls - expires every 12HR
	 */
	static String token ="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUxNjg4NTYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTIxMjA1NiwidXNlcklkIjoiNzA3In0.3o0YbjPdF7q9Halg_fNZqo4UZKLQkIviS4F0WDMLHFY";
	static String BaseURI =RestAssured.baseURI ="http://18.232.148.34/syntaxapi/api";
	static String employeeID;
	
	
	
	public void sampleTestNotes() {
		RestAssured.baseURI ="http://18.232.148.34/syntaxapi/api";
				
		/**
		 * Preparing /getOneEmployee.php request
		 */
		RequestSpecification getOneEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", "16529A").log().all();
		
		// Storing response
		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");
		
		/**
		 * Two ways to print
		 */
		getOneEmployeeResponse.prettyPrint();
		String response = getOneEmployeeResponse.body().asString();
		
		//System.out.println(response);
		
		getOneEmployeeResponse.then().assertThat().statusCode(200);
		
	}
	
	@Test
	public void aPOSTcreateEmployee() {
		RequestSpecification createEmployee = given().header("Content-Type", "application/json")
		.header("Authorization", token).body("{\r\n" + 
				"  \"emp_firstname\": \"Karl\",\r\n" + 
				"  \"emp_lastname\": \"Son\",\r\n" + 
				"  \"emp_middle_name\": \"K\",\r\n" + 
				"  \"emp_gender\": \"M\",\r\n" + 
				"  \"emp_birthday\": \"2010-07-11\",\r\n" + 
				"  \"emp_status\": \"Freelance\",\r\n" + 
				"  \"emp_job_title\": \"QA Tester\"\r\n" + 
				"}");
		
		Response createEmployeeResponse = createEmployee.when().post("/createEmployee.php");
		
		createEmployeeResponse.prettyPrint();
		//createEmployeeResponse.prettyPeek();
		employeeID = createEmployeeResponse.jsonPath().get("Employee[0].employee_id");
		System.out.println(employeeID);
		
		/**
		 * verify status code 201
		 */
		createEmployeeResponse.then().assertThat().statusCode(201);
		/**
		 * verify message using equalsTo()
		 * Needs manual import of import static org.hamcrest.Matchers.*
		 */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Karl"));
		createEmployeeResponse.then().assertThat().header("server", equalTo("Apache/2.4.39 (Win64) PHP/7.2.18"));
		createEmployeeResponse.then().assertThat().header("Content-Length", equalTo("380"));
	}
	
	//@Test
	public void bGETcreatedEmployee() {
		RequestSpecification GETcreatedEmployeeRequest = given().header("Content-Type", "application/json").header("Authorization", token)
		.queryParam("employee_id", employeeID).log().all();
		
		Response GETcreatedEmployee = GETcreatedEmployeeRequest.when().get("/getOneEmployee.php");
		String response = GETcreatedEmployee.prettyPrint();
		String empID = GETcreatedEmployee.jsonPath().getString("employee[0].employee_id");
		boolean viryfingEmployeeIdMatch = empID.equalsIgnoreCase(employeeID);
		//System.out.println(viryfingEmployeeIdMatch);
		Assert.assertTrue(viryfingEmployeeIdMatch);
		System.out.println("*&*&*&*&-----------*&*&*&*&");
		GETcreatedEmployee.then().assertThat().statusCode(200);
		/**
		 * using JsonPath class to retrieve values from response json
		 */
				
		JsonPath js = new JsonPath(response);
		String emplID = js.getString("employee[0].employee_id");
		String firstName = js.getString("employee[0].emp_firstname");
		String midleName = js.getString("employee[0].emp_middle_name");
		String lastName = js.getString("employee[0].emp_lastname");
		String bDay = js.getString("employee[0].emp_birthday");
		String gender = js.getString("employee[0].emp_gender");
		String jobTitle = js.getString("employee[0].emp_job_title");
		String jobStatus = js.getString("employee[0].emp_status");
		
		System.out.println(emplID);
		System.out.println(firstName);
		System.out.println(lastName);
		
		Assert.assertTrue(emplID.contentEquals(employeeID));
		Assert.assertTrue(firstName.contentEquals("Karl"));
		Assert.assertTrue(midleName.contentEquals("K"));
		Assert.assertTrue(lastName.contentEquals("Son"));
		

		Assert.assertEquals(firstName, "Karl");
		Assert.assertEquals(midleName, "K");
		Assert.assertEquals(lastName, "Son");
		Assert.assertEquals(bDay, "2010-07-11");
		Assert.assertEquals(gender, "Male");
		Assert.assertEquals(jobTitle, "QA Tester");
		Assert.assertEquals(jobStatus, "Freelance");
		
		
	}
	
	@Test
	public void cGetAllEmployees() {
		RequestSpecification getAllempRequest = given().header("Content-Type", "application/json").header("Authorization", token);
		
		Response GetAllEmployees = getAllempRequest.when().get("/getAllEmployees.php");
		
		//GetAllEmployees.prettyPrint();
		String allEmployees = GetAllEmployees.body().asString();
		//System.out.println(allEmployees);
		
		JsonPath jss = new JsonPath(allEmployees);
		int sizeOfList = jss.getInt("Employees.size()");
		System.out.println(sizeOfList);
		
		/**
		 * put out all employee IDs
		 */
//		for (int i=0; i<sizeOfList; i++) {
//			String allEmployeeIDs = jss.getString("Employees["+i+"].employee_id");
//			System.out.println(allEmployeeIDs);
//			
////			if(allEmployeeIDs.contentEquals(employeeID)) {
////				
////				System.out.println("Employee Id: " + employeeID + " is present in body");
////				String employeeFirstName = jss.getString("Employees["+i+"].employee_id");
////				System.out.println(employeeFirstName);
////				break;
////			}
		}
	@Test
	public void dPUTUpdateCreatedEmployee() {
		RequestSpecification UpdateCreatedEmployeeRequest = given().header("Content-Type", "application/json")
		.header("Authorization", token).body(HardCodedConstants.updateCreatedEmployee());
		Response updateCreatedEmployeeResponse = UpdateCreatedEmployeeRequest.when().put("/updateEmployee.php");
		updateCreatedEmployeeResponse.prettyPrint();
		
	}

}
