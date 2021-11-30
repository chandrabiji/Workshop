package com.hexaware.MLP323.integration.test;

import java.net.URISyntaxException;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;

/**
 * Main class
 */
public class OrderRestTest {



	/**
	 * Test Order List api
	 * @throws AssertionError error
	 * @throws URISyntaxException error
	 */
	@Test
	public void testOrderList() throws AssertionError, URISyntaxException {
	Order[] res = given().when().accept(ContentType.JSON).get(CommonUtil.getURI("/api/Order/list")).getBody().as(Order[].class);

	assertEquals(1, res.length);

	assertEquals(1, res[0].getOrderId());
	assertEquals(101, res[0].getFoodId());
	assertEquals(1, res[0].getVendorId());
	assertEquals(1, res[0].getCustomerId());
	assertEquals(5, res[0].getNoOfItems());
	assertEquals(1000.0, res[0].getAmountToBePaid(), 0.1);
	assertEquals("12542", res[0].getTokenNumber());
	assertEquals("PENDING", res[0].getStatus());
	assertEquals("hii", res[0].getComment());
	}

	/**
	 * Test Order by customer Id
	 * @throws AssertionError error
	 * @throws URISyntaxException error
	 */

	@Test
	public void testOrderByCustId() throws AssertionError, URISyntaxException {

	Order[] res = given().when().accept(ContentType.JSON).get(CommonUtil.getURI("/api/Order/showOrdersByCustId/1")).getBody().as(Order[].class);


		assertEquals(1, res[0].getCustomerId());
	}


	/**
	 * test order by vendor id
	 * @throws AssertionError
	 * @throws URISyntaxException
	 */

	@Test
	public void testOrderByVendorId() throws AssertionError, URISyntaxException {


	Order[] res = given().when().accept(ContentType.JSON).get(CommonUtil.getURI("/api/Order/showOrdersByVendId/1")).getBody().as(Order[].class);


	assertEquals(1, res[0].getVendorId());

	}

	/**
	 * Test order by order id
	 * @throws AssertionError error
	 * @throws URISyntaxException error
	 */


	@Test
	public void testOrderByOrderId() throws AssertionError, URISyntaxException {
	Order res = given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/Order/showOrdersByOrderId/1")).getBody().as(Order.class);



	assertEquals(1, res.getOrderId());
	assertEquals(101, res.getFoodId());
	assertEquals(1, res.getVendorId());
	assertEquals(1, res.getCustomerId());
	assertEquals(5, res.getNoOfItems());

	}

	/**
	 * Test pending records
	 * @throws AssertionError error
	 * @throws URISyntaxException error
	 */


	@Test
	public void testPendingRecords() throws AssertionError, URISyntaxException {
	Order[] res = given().when().accept(ContentType.JSON).get(CommonUtil.getURI("/api/Order/getPendingRecords/12542")).getBody().as(Order[].class);


	assertEquals(1, res.length);
	}

	/**
	 * Test order insetion
	 * @throws AssertionError error
	 * @throws URISyntaxException error
	 */

	@Test
	public void testOrderPost() throws AssertionError, URISyntaxException {

		Order testOrd=new Order(100,101, 1, 1, 5, "2021/12/22", 1000, "12542", "OrderRestTest" ,"Testing rec");

		Response response = given()
        .header("Content-Type", "application/json")
        .and()
        .body(testOrd)
        .when()
        .post(CommonUtil.getURI("/api/Order/createOrder"))
        .then()
        .extract().response();

        assertEquals(200,response.statusCode());
	}


}