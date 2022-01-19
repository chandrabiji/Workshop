package com.ojas.MLP323;
import com.ojas.MLP323.factory.BillFactory;
import com.ojas.MLP323.model.Bill;
import com.ojas.MLP323.persistence.BillDAO;

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


@RunWith(JMockit.class)
public class BillFactoryTest {

@Before
public void initInput(){

 }
/**
 * test for constructor
 */
@Test
public final void testConstructor(){
 final BillFactory exp = new BillFactory();
 assertNotEquals(exp,null);
}
/**
   * Tests the insertnewbill method of the Vendor class.
*/
@Test
public void testinsert() {
  boolean result = BillFactory.insert(new Bill("12012",101,3,111.0,"10","Pending","Thankyou"));
  assertEquals(true,result);
}
/**
   * Tests the count method of the Vendorfactory class.
*/
@Test
public void testcount(@Mocked final BillDAO dao){
  Bill bill = new Bill("121212",101,3,111.0,"10","Pending","Thankyou");
  new Expectations()
  {{
    System.out.println("Mocked full bill Object");
    dao.getCount(3);
    result = 2;
  }};
  new MockUp<BillFactory>(){
    @Mock
    BillDAO dao(){
      System.out.println("Mocked dao for full Bill");
      return dao;
    }
  };
  int bill1 = BillFactory.count(3);
  assertEquals(2,bill1);
}
}