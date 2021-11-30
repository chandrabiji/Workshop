package com.hexaware.MLP323.integration.test;

import java.net.URISyntaxException;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;

/**
 * Main Class
 */
public class VendorRestTest {

    /**
     * Test vendor List
     * @throws AssertionError error
     * @throws URISyntaxException error
     */
	@Test
	public void testVendorList() throws AssertionError, URISyntaxException {
	Vendor[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/vendor/list"))
        .getBody().as(Vendor[].class);

	assertEquals(1, res.length);
	assertEquals(1, res[0].getVendorId());
	assertEquals("Hotel Vaishali", res[0].getVendorName());
    }
    /**
     * test Vendor Details
     * @throws AssertionError
     * @throws URISyntaxException
     */

    @Test
	public void testVendorDetails() throws AssertionError, URISyntaxException {
	Vendor m = given().
                  accept(ContentType.JSON).
				  when().
                  get(CommonUtil.getURI("/api/vendor/vendorbyvendid/1")).
				  getBody().as(Vendor.class);
	assertEquals(1, m.getVendorId());
	assertEquals("Hotel Vaishali", m.getVendorName());
    }



    /**
     * Test Vendor Insertion
     * @throws AssertionError
     * @throws URISyntaxException
     */
	@Test
    public void testvendorpost() throws AssertionError, URISyntaxException {
		Vendor m = new Vendor();
			m.setVendorId(101);
			m.setVendorName("a");
			m.setVendorEmail("a");
			m.setVendorContactNo("7878787878");
			m.setVendorAddress("assssxdcscs");
			m.setVendorPassword("a");

        Response response=given().
        contentType(ContentType.JSON).
        when().
        body(m).
        post(CommonUtil.getURI("/api/vendor/createVendor")).
        then().
        extract().response();

        assertEquals(200,response.statusCode());
    }

    /**
	 * Test Vendor updation
	 * @throws AssertionError error
	 * @throws URISyntaxException error
	 */

    @Test
    public void testvendorput() throws AssertionError, URISyntaxException {
		Vendor m = new Vendor();
		m.setVendorId(101);
		m.setVendorName("updated");
		m.setVendorEmail("a");
		m.setVendorContactNo("7878787878");
		m.setVendorAddress("assssxdcscs");
		m.setVendorPassword("a");

			Response response=given().
			contentType(ContentType.JSON).
			when().
			body(m).
			put(CommonUtil.getURI("/api/vendor/updateVendor")).
			then().
			extract().response();

			assertEquals(200,response.statusCode());
	}

    /**
	 * Test Vendor login
	 * @throws AssertionError error
	 * @throws URISyntaxException error
	 */
	@Test
    public void testLogin() throws AssertionError, URISyntaxException {


        Boolean m = given().
                      accept(ContentType.JSON).
                      when().
                      get(CommonUtil.getURI("/api/vendor/loginVen/menu@vaishali.com/aaaa")).
                      getBody().as(Boolean.class);

        System.out.println("\n\n\n\n\n"+m+"\n\n\n\n\n");

        assertEquals(true, m);
    }

    /**
	 * Test Vendor exist
	 * @throws AssertionError error
	 * @throws URISyntaxException error
	 */

	@Test
    public void checkVendorIdExist() throws AssertionError, URISyntaxException {
        boolean m = given().
                      accept(ContentType.JSON).
                      when().
                      get(CommonUtil.getURI("/api/vendor/checkVendor/101")).
                      getBody().as(Boolean.class);

                      System.out.println("\n\nCheck User id :"+m);

        assertEquals(true, m);



    }

     /**
	 * Test Vendor Deletion
	 * @throws AssertionError error
	 * @throws URISyntaxException error
	 */
    @Test
    public void testDelete() throws AssertionError, URISyntaxException {

        Boolean m = given().
                      accept(ContentType.JSON).
                      when().
                      delete(CommonUtil.getURI("/api/vendor/deleteVendor/101")).
                      getBody().as(Boolean.class);

        System.out.println("\n\ndelete :"+m);
        assertEquals(true, m);
}
}