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

@RunWith(JMockit.class)
public class VendorFactoryTest {

    @Before
    public void initInput(){

     }
     /**
 * test for constructor
 */
@Test
public final void testConstructor(){
 final VendorFactory exp = new VendorFactory();
 assertNotEquals(exp,null);
}
/**
   * Tests the showallvendors method of the Vendor class.
*/
@Test
public final void testallVendors(@Mocked final VendorDAO dao) {
final ArrayList<Vendor> exp = new ArrayList<Vendor>();
exp.add(new Vendor(100,"vendorA","V@gmail.com","9278488","aaa","hyd"));
exp.add(new Vendor(101,"vendorA","V@gmail.com","9278488","aaa","hyd"));
exp.add(new Vendor(102,"vendorA","V@gmail.com","9278488","aaa","hyd"));
exp.add(new Vendor(103,"vendorA","V@gmail.com","9278488","aaa","hyd"));


new Expectations()
{{
   System.out.println("Mocked full Vendor Object");
   dao.showAllVendorList();
   result = exp;
}};
new MockUp<VendorFactory>(){
  @Mock
  VendorDAO dao(){
    System.out.println("Mocked dao for full Vendor");
    return dao;
  }
};
Vendor[] list = VendorFactory.allVendors();
ArrayList<Vendor> act = new ArrayList<Vendor>();
for(Vendor v:list)
{
  act.add(v);

System.out.println("Test Vendors :"+v.getVendorId());
}
assertEquals(exp,act);
}
/**
   * Tests the Vendorbyid method of the Vendorclass.
*/

@Test
public void testdisplayVendorByVendorId(@Mocked final VendorDAO dao){
final Vendor vendor = new Vendor(101,"vendorB","Vb@gmail.com","92784848","bbb","chn");
new Expectations()
{{
   System.out.println("Mocked full Vendor Object");
   dao.displayVendorByVendorId(101);
   result = vendor;
}};
new MockUp<VendorFactory>(){
    @Mock
    VendorDAO dao(){
      System.out.println("Mocked dao for full Vendor");
      return dao;
    }
  };
Vendor vendor1= VendorFactory.displayVendorByVendorId(101);
assertEquals(vendor.getVendorId(),vendor1.getVendorId());
}
/**
   * Tests the LoginVendor method of the Vendor class.
*/
@Test
public void testloginVendor(@Mocked final VendorDAO dao){

 final Vendor vendor = new Vendor(101,"vendorB","Vb@gmail.com","92784848","bbb","chn");

new Expectations()
{{
   dao.checkVendorLogin("Vb@gmail.com","chn");
   result = 101;
}};
new MockUp<VendorFactory>(){
    @Mock
    VendorDAO dao(){
      System.out.println("Mocked dao for full Vendor");
      return dao;
    }
  };
int vendor1 = VendorFactory.loginVendor("Vb@gmail.com","chn");
assertEquals(vendor1,101);

}
/**
   * Tests the createvendor method of the vendor class.
*/
@Test
public void testcreateVendorRecord() {
  boolean result = VendorFactory.createVendorRecord(new Vendor(1012,"TestVendor","Vc@gmail.com","927849848","ccc","up"));
  assertEquals(true,result);
}
/**
   * Tests the update method of the Vendor class.
*/
// @Test
// public void testupdateVendorDetails(){
//   System.out.println("Updating Vendor");

//  VendorFactory.createVendorRecord(new Vendor(111,"TestVendor","Vd@gmail.com","9274849848","ddd","Delhi"));


//  boolean result = VendorFactory.updateVendorDetails(new Vendor(111,"TestVendVVVV","Vd@gmail.com","9274849848","ddd","Delhi"));
// assertEquals(true,result);
// }
/**
   * Tests the Delete method of the Vendor class.
*/
@Test
public void testdeleteVendorRecord(){
  System.out.println("Delete Vendor");
  if (VendorFactory.createVendorRecord(new Vendor(1001,"TestVendor","Vd@gmail.com","9274849848","ddd","Delhi"))){
      System.out.println("Inseretd Successfully...");
    boolean  result = VendorFactory.deleteVendorRecord(1001);
    assertEquals(true,result);
  }
  else{
      System.out.println("Not DOne");
  }
}
/**
   * Tests the Vendorexists method of the vendor class.
*/
@Test
public void testvendorExist(@Mocked final VendorDAO dao){
final Vendor vendor = new Vendor(110,"TestVendor","Vd@gmail.com","9274849848","ddd","Delhi");
final boolean res=true;
new Expectations()
{{
   System.out.println("Mocked full Vendor Object");
   dao.checkUserIdExist(110);
   result = 1;
}};
new MockUp<VendorFactory>(){
    @Mock
    VendorDAO dao(){
      System.out.println("Mocked dao for full Vendor");
      return dao;
    }
  };
boolean vendor1 = VendorFactory.vendorExist(110);
assertEquals(vendor1,res);
}
}