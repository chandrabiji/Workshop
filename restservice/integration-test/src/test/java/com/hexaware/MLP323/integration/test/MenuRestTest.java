package com.hexaware.MLP323.integration.test;

import java.net.URISyntaxException;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;
import org.junit.Test;

import static org.junit.Assert.*;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.*;

/**
 * Main Class
 */
public class MenuRestTest {

	/**
	 * checking menu list api
	 * @throws AssertionError error
	 * @throws URISyntaxException error
	 */
	@Test
	public void testMenuList() throws AssertionError, URISyntaxException {
	Menu[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/menu/list")).getBody().as(Menu[].class);

	assertEquals(5, res.length);
	assertEquals(101, res[0].getFoodId());
	assertEquals("Paneer_Pizza", res[0].getFoodName());
	assertEquals(199, res[0].getFoodPrice(), 0.1);
	assertEquals(1, res[0].getVendorId());
	}

	/**
	 * checking food details api
	 * @throws AssertionError error
	 * @throws URISyntaxException error
	 */
    @Test
	public void testFoodDetails() throws AssertionError, URISyntaxException {
	Menu m = given().
                  accept(ContentType.JSON).
				  when().
                  get(CommonUtil.getURI("/api/menu/showmenubyfoodid/101")).
				  getBody().as(Menu.class);
	assertEquals(101, m.getFoodId());
	assertEquals("Paneer_Pizza", m.getFoodName());
	assertEquals(199.0, m.getFoodPrice(), 0.1);
	assertEquals(1, m.getVendorId());
	}

	/**
	 * checking checking food id is present or not
	 * @throws AssertionError error
	 * @throws URISyntaxException error
	 */

	@Test
	public void testFoodIdPresent() throws AssertionError, URISyntaxException {
	boolean m = given().
                  accept(ContentType.JSON).
				  when().
                  get(CommonUtil.getURI("/api/menu/menuPresent/101")).
				  getBody().as(Boolean.class);
	assertEquals(true, m);
	}

	/**
	 * creating requestBody
	 */
	private static String requestBody = "{\n"+
    " \"foodId\": \"202\",\n"+
	" \"foodName\": \"TestTest\",\n"+
	" \"foodQuantity\": \"100\",\n"+
	" \"foodPrice\": \"199.0\",\n"+
	" \"vendorId\": \"1\"}";

	/**
	 * Test menu insertion
	 * @throws AssertionError error
	 * @throws URISyntaxException error
	 */

	@Test
	public void testMenuPost() throws AssertionError, URISyntaxException {

		Response response = given()
        .header("Content-Type", "application/json")
        .and()
        .body(requestBody)
        .when()
        .post(CommonUtil.getURI("/api/menu/createMenu"))
        .then()
        .extract().response();

        assertEquals(200,response.statusCode());
	}


	/**
	 * creating request
	 */

	private static String updaterequestBody = "{\n"+
    " \"foodId\": \"202\",\n"+
	" \"foodName\": \"TestUpdated\",\n"+
	" \"foodQuantity\": \"100\",\n"+
	" \"foodPrice\": \"199.0\",\n"+
	" \"vendorId\": \"1\"}";


	/**
	 * Test menu updation
	 * @throws AssertionError error
	 * @throws URISyntaxException error
	 */

	@Test
	public void testMenuPut() throws AssertionError, URISyntaxException {

		Response response = given()
        .header("Content-Type", "application/json")
        .and()
        .body(updaterequestBody)
        .when()
        .put(CommonUtil.getURI("/api/menu/updateMenu"))
        .then()
        .extract().response();

        assertEquals(200,response.statusCode());

	}

	/**
	 * Test menu deletion
	 * @throws AssertionError error
	 * @throws URISyntaxException error
	 */

	@Test
    public void deleteRequest() {
        Response response = given()
        .header("Content-Type","application/json")
        .when()
		.delete("http://localhost:18080/MLP323/api/menu/deleteItem/202")
        .then()
        .extract().response();

        assertEquals(200,response.statusCode());
    }



}
