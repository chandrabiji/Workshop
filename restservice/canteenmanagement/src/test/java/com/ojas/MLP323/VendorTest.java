package com.ojas.MLP323;
import com.ojas.MLP323.factory.VendorFactory;
import com.ojas.MLP323.model.Vendor;
import com.ojas.MLP323.persistence.VendorDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;

/**
 * Test class for Vendor.
 */
@RunWith(JMockit.class)
public class VendorTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {
  }
   /**
   * Tests the equals/hashcode methods of the Vendor class.
   */
  @Test
  public final void testVendor() {
    Vendor m = new Vendor();
    m.setVendorName("a");
    m.setVendorEmail("a");
    m.setVendorContactNo("7878787878");
    m.setVendorAddress("assssxdcscs");
    m.setVendorPassword("a");


    Vendor m100 = new Vendor(100);
    Vendor m101 = new Vendor(101);
    assertNotEquals(m100, null);
    assertNotEquals(m101, null);
    assertEquals(m100.getVendorId(),
        new Vendor(100).getVendorId());
    m101.setVendorId(100);
    assertNotEquals(m101, new Vendor(101));
    assertEquals(m100.hashCode(),
        new Vendor(100).hashCode());
    assertEquals(m100, new Vendor(100));
  }
  /**
   * Tests the TestshowAllVendorList
   */

   @Test
  public final void TestshowAllVendorList(@Mocked final VendorDAO dao) {
    final ArrayList<Vendor> v=new ArrayList<Vendor>();
    v.add(new Vendor(201, "Vendor1", "A@gmail.com", "7878787878", "ABCasdasdD","aaaa"));
    v.add(new Vendor(202, "Vendor1", "A@gmail.com", "7878787878", "ABCasdasdD","aaaa"));
    v.add(new Vendor(203, "Vendor1", "A@gmail.com", "7878787878", "ABCasdasdD","aaaa"));
    v.add(new Vendor(204, "Vendor1", "A@gmail.com", "7878787878", "ABCasdasdD","aaaa"));


    new Expectations() {
        {
          dao.showAllVendorList();
          result=v;
        }
    };

    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };


    Vendor[] v1=VendorFactory.allVendors();
    ArrayList<Vendor> vv=new ArrayList<Vendor>();

    for (Vendor q: v1){
      vv.add(q);
      System.out.println("Checked  :"+q.getVendorId());
    }

    System.out.println("Checking Vendor List Count :");

    assertEquals(v.size(),v1.length);
  }


    /**
   * Tests the TestdisplayVendorByVendorId
   */
  @Test
  public final void TestdisplayVendorByVendorId() {

    Vendor v=VendorFactory.displayVendorByVendorId(1);

    System.out.println("Checking Vendor :");

    System.out.println("Found Record is :"+v.getVendorId()+"\t\t"+v.getVendorName());
    assertEquals(1,v.getVendorId());
  }


      /**
   * Tests the TestcheckVendorLogin
   */
  @Test
  public final void TestcheckVendorLogin() {


    int res=VendorFactory.loginVendor("hotel@gmail.com","aaaa");

    System.out.println("Checking Vendor Login :");

    assertEquals(1,res);
  }


      /**
   * Tests the showAllVendorList
   */
  @Test
  public final void TestcreateVendorRecord() {

    boolean res=VendorFactory.createVendorRecord(new Vendor(101, "Vendor1", "A@gmail.com", "7878787878", "ABCasdasdD","aaaa"));
    System.out.println("Checking Vendor Insertion :");
    assertEquals(true,res);
  }



      /**
   * Tests the updateVendorDetails
   */
  @Test
  public final void TestupdateVendorDetails(@Mocked final VendorDAO dao) {


    new Expectations() {
      {
        dao.updateVendorDetails(new Vendor(102, "Vendor1", "A@gmail.com", "7878787878", "ABCasdasdD","aaaa"));
        result=1;
      }
    };

    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    boolean res=VendorFactory.updateVendorDetails(new Vendor(102, "Vendor1", "A@gmail.com", "7878787878", "ABCasdasdD","aaaa"));
    System.out.println("Checking Vendor Updation :");
    assertEquals(true,res);
  }



      /**
   * Tests the deleteVendorRecord
   */
  @Test
  public final void TestdeleteVendorRecord() {

    boolean res=VendorFactory.deleteVendorRecord(101);
    System.out.println("Checking Vendor Deletion :");
    assertEquals(true,res);
  }




      /**
   * Tests the checkUserIdExist
   */
  @Test
  public final void TestcheckUserIdExist() {

    boolean res=VendorFactory.vendorExist(1);
    System.out.println("Checking Vendor Existance :");
    assertEquals(true,res);
  }


}