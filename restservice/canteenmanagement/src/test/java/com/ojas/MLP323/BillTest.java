package com.ojas.MLP323;
import com.ojas.MLP323.factory.BillFactory;
import com.ojas.MLP323.model.Bill;
import com.ojas.MLP323.persistence.BillDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
 * Test class for Bill.
 */
@RunWith(JMockit.class)
public class BillTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {
  }
  /**
   * Tests the equals/hashcode methods of the Bill class.
   */
  @Test
  public final void testBill() {
    Bill m = new Bill();
    Bill m100 = new Bill("101010",1,3,100.0,"FIRST10","Pending","Thankyou");

    System.out.println("Testing for Objects BillTests");
    assertNotEquals(m100, null);


    Bill demo=new Bill("1");
    demo.setCartId("1");
    demo.setCustomerId(1);
    demo.setDiscount("TOP");
    demo.setStatus("p");
    demo.setComment("p");
    demo.setItemCount(1);
    demo.setTotalAmount(100);
    assertEquals(m100.getCartId(),
        new Bill("101010",1,3,100.0,"FIRST10","Pending","Thankyou").getCartId());

        assertEquals(m100.getCustomerId(),
        new Bill("101010",1,3,100.0,"FIRST10","Pending","Thankyou").getCustomerId());

        assertEquals(m100.getItemCount(),
        new Bill("101010",1,3,100.0,"FIRST10","Pending","Thankyou").getItemCount());

        assertEquals((int)m100.getTotalAmount(),
        (int)new Bill("101010",1,3,100.0,"FIRST10","Pending","Thankyou").getTotalAmount());

        assertEquals(m100.getDiscount(),
        new Bill("101010",1,3,100.0,"FIRST10","Pending","Thankyou").getDiscount());

        assertEquals(m100.getStatus(),
        new Bill("101010",1,3,100.0,"FIRST10","Pending","Thankyou").getStatus());

        assertEquals(m100.getComment(),
        new Bill("101010",1,3,100.0,"FIRST10","Pending","Thankyou").getComment());



        assertTrue(m100.equals(new Bill("101010",1,3,100.0,"FIRST10","Pending","Thankyou")));

        assertEquals(new Bill("100").hashCode(),new Bill("100").hashCode());

    assertEquals(m100.hashCode(),
    new Bill("101010",1,3,100.0,"FIRST10","Pending","Thankyou").hashCode());
      }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testinsert(@Mocked final BillDAO dao) {

   new Expectations() {
    {
        dao.insertBill("101010",1,3,100.0,"FIRST10","Pending","Thankyou");
        result=1;
        minTimes=0;
    }
   };
    new MockUp<BillFactory>() {
      @Mock
      BillDAO dao() {
        return dao;
      }
    };
    boolean n= BillFactory.insert(new Bill("101010",1,3,100.0,"FIRST10","Pending","Thankyou"));
    assertEquals(true,n);
  }

  @Test
  public final void testcount(@Mocked final BillDAO dao) {
    //resultset Defination

    // final ArrayList<Bill> res=new ArrayList<Bill>();

    // res.add(new Bill("101213",101,3,100,"FIRST10","Pending","Thankyou"));
    // res.add(new Bill("121314",101,3,100,"FIRST50","Pending","Thankyou"));

    //final MenuFactory obj = new MenuFactory();
    new Expectations() {
      {
        dao.getCount(101);
        result = 2;
        minTimes=0;
      }
    };
    new MockUp<BillFactory>() {
        @Mock
        BillDAO dao() {
          return dao;
        }
      };
    int mn1 = BillFactory.count(101);
    System.out.println("Getting Values for Count of Records for Cust Id 101 :");
    assertEquals(2,mn1);
  }

}