package com.hexaware.MLP323.integration.test;

import java.net.URISyntaxException;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;

public class BillRestTest {

    /**
     * checking Bill Count Api
     * @throws AssertionError
     * @throws URISyntaxException
     */
@Test
public void testCountBill() throws AssertionError, URISyntaxException {
    int res = given().
    accept(ContentType.JSON).
    contentType(ContentType.JSON).
    when().
    get(CommonUtil.getURI("/api/Bill/count/1")).
    getBody().as(Integer.class);

    System.out.println("\n\n\n\nCount :"+res);
    assertEquals(1, res);

}

/**
 * inserting bill api test
 * @throws AssertionError
 * @throws URISyntaxException
 */
    @Test
    public void testBillPost() throws AssertionError, URISyntaxException {


        Bill b=new Bill("101010",1,3,100.0,"FIRST10","Pending","Test");

        Response response=given().
        contentType(ContentType.JSON).
        when().
        body(b).
        post(CommonUtil.getURI("/api/Bill/createBill")).
        then().
        extract().response();

        assertEquals(200,response.statusCode());
    }



}