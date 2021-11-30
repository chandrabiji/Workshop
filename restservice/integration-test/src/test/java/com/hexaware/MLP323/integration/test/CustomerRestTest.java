package com.hexaware.MLP323.integration.test;

import java.net.URISyntaxException;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;

/**
 * Testing main class
 */
public class CustomerRestTest
{

    /**
     *  Testing customer list getting api
     * @throws AssertionError error
     * @throws URISyntaxException errror
     */
    @Test
	public void testcustomerlist() throws AssertionError, URISyntaxException {

        System.out.println("\n\n\n\n\nCalled TeswtCustomerList..\n\n\n\n\n");
    Customer[] res = given().
                when().
                accept(ContentType.JSON)
                .get(CommonUtil.getURI("/api/customer/list"))
                .getBody()
                .as(Customer[].class);


        assertEquals(5,res.length);
    }


    /**
     * tests Fetching single customer
     * @throws AssertionError error
     * @throws URISyntaxException error
     */

    @Test
	public void testSingleCustomer() throws AssertionError, URISyntaxException {
        System.out.println("\n\n\n\n\nCalled testSingleCustomer..\n\n\n\n\n");
	Customer res = given().
                  accept(ContentType.JSON).
				  when().
                  get(CommonUtil.getURI("/api/customer/Customerbycustid/1")).
                  getBody().as(Customer.class);

                assertEquals(1, res.getCustomerId());
                assertEquals("Sakshi", res.getCustomerName());
                assertEquals("Sakshi@gmail.com", res.getCustomerEmail());
                assertEquals("7585256325", res.getCustomerMobileNo());
    }


    /**
     * fetch customer post api
     * @throws AssertionError error
     * @throws URISyntaxException error
     */
    @Test
    public void testCustomerPost() throws AssertionError, URISyntaxException {
        System.out.println("\n\n\n\n\nCalled testCustomerPost..\n\n\n\n\n");
        Customer requestBody=new Customer(99, "TestName", "Test@gmail.com",
         "ABCD", "78585858", "aaaa", "asa", 12545);


        Response response=given().
        contentType(ContentType.JSON).
        when().
        body(requestBody).
        post(CommonUtil.getURI("/api/customer/createCustomer")).
        then().
        extract().response();

        assertEquals(200,response.statusCode());
    }

    /**
     *  testCustomerPut testing
     * @throws AssertionError error
     * @throws URISyntaxException error
     */
    @Test
    public void testCustomerPut() throws AssertionError, URISyntaxException {
        System.out.println("\n\n\n\n\nCalled testCustomerPut..\n\n\n\n\n");
        Customer requestBody=new Customer(99, "UpdatedName", "Test@gmail.com",
         "ABCD", "78585858", "aaaa", "asa", 12545);


        Response response=given().
        contentType(ContentType.JSON).
        when().
        body(requestBody).
        put(CommonUtil.getURI("/api/customer/updateCustomer")).
        then().
        extract().response();

            assertEquals(200,response.statusCode());
    }

    /***
     * tests login functionality
     * @throws AssertionError error
     * @throws URISyntaxException error
     */
    @Test
    public void testLogin() throws AssertionError, URISyntaxException {
        System.out.println("\n\n\n\n\nCalled testLogin..\n\n\n\n\n");


        Boolean m = given().
                      accept(ContentType.JSON).
                      when().
                      get(CommonUtil.getURI("/api/customer/Login/Sakshi@gmail.com/aaaa")).
                      getBody().as(Boolean.class);

        System.out.println("\n\n\n\n\n"+m+"\n\n\n\n\n");

        assertEquals(true, m);
    }


    /**
     * check user id exists or not
     * @throws AssertionError
     * @throws URISyntaxException
     */

    @Test
    public void checkUserIdExist() throws AssertionError, URISyntaxException {
        System.out.println("\n\n\n\n\nCalled checkUserIdExist..\n\n\n\n\n");
        boolean m = given().
                      accept(ContentType.JSON).
                      when().
                      get(CommonUtil.getURI("/api/customer/checkUserIdExist/1")).
                      getBody().as(Boolean.class);

                      System.out.println("\n\nCheck User id :"+m);

        assertEquals(true, m);



    }
    /***
     * checking record is deleting or not
     * @throws AssertionError
     * @throws URISyntaxException
     */
    @Test
    public void testDelete() throws AssertionError, URISyntaxException {
        System.out.println("\n\n\n\n\nCalled testDelete..\n\n\n\n\n");

        Boolean m = given().
                      accept(ContentType.JSON).
                      when().
                      delete(CommonUtil.getURI("/api/customer/delete/99")).
                      getBody().as(Boolean.class);

        System.out.println("\n\ndelete :"+m);
        assertEquals(true, m);
    }
}