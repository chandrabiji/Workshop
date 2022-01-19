package com.ojas.MLP323;
import com.ojas.MLP323.factory.CustomerFactory;
import com.ojas.MLP323.factory.MenuFactory;
import com.ojas.MLP323.model.Customer;
import com.ojas.MLP323.model.Menu;
import com.ojas.MLP323.persistence.CustomerDAO;
import com.ojas.MLP323.persistence.MenuDAO;

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
 * Test class for Customer.
 */
@RunWith(JMockit.class)
public class CustomerTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {
  }
  /**
   * Tests the equals/hashcode methods of the customer class.
   */
  @Test
  public final void testCustomer() {
    Customer c = new Customer();
    Customer c100 = new Customer(1000,"A","a@gmail.com","abc","234","aaa","gpay",100);
    Customer c101 = new Customer(101);

    c101.setCustomerName("ABC");
    c101.setCustomerEmail("a");
    c101.setCustomerAddress("ABa");
    c101.setCustomerMobileNo("s45454545");
    c101.setCustomerPassword("aaaa");
    c101.setWalletName("gpay");
    c101.setWalletAmount(12000.0);


    assertNotEquals(c100, null);
    assertNotEquals(c101, null);

    assertEquals(c100.getCustomerId(),
        new Customer(1000,"A","a@gmail.com","abc","234","aaa","gpay",100).getCustomerId());

        assertEquals(c100.getCustomerName(),
        new Customer(1000,"A","a@gmail.com","abc","234","aaa","gpay",100).getCustomerName());

        assertEquals(c100.getCustomerEmail(),
        new Customer(1000,"A","a@gmail.com","abc","234","aaa","gpay",100).getCustomerEmail());

        assertEquals(c100.getCustomerAddress(),
        new Customer(1000,"A","a@gmail.com","abc","234","aaa","gpay",100).getCustomerAddress());

        assertEquals(c100.getCustomerMobileNo(),
        new Customer(1000,"A","a@gmail.com","abc","234","aaa","gpay",100).getCustomerMobileNo());

        assertEquals(c100.getCustomerPassword(),
        new Customer(1000,"A","a@gmail.com","abc","234","aaa","gpay",100).getCustomerPassword());

        assertEquals(c100.getWalletName(),
        new Customer(1000,"A","a@gmail.com","abc","234","aaa","gpay",100).getWalletName());

        assertEquals((int)c100.getWalletAmount(),
        (int)new Customer(1000,"A","a@gmail.com","abc","234","aaa","gpay",100).getWalletAmount());



    c101.setCustomerId(100);
    assertNotEquals(c101, new Customer(101));
    assertEquals(c100.hashCode(),
        new Customer(1000,"A","a@gmail.com","abc","234","aaa","gpay",100).hashCode());
    assertEquals(c100, new Customer(1000,"A","a@gmail.com","abc","234","aaa","gpay",100));
  }
  /**
   * tests that empty Customer list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testshowFullCustomer(@Mocked final CustomerDAO dao) {

    ArrayList<Customer> c=new ArrayList<Customer>();
    c.add(new Customer(1000,"A","a@gmail.com","abc","234","aaa","gpay",100));
    c.add(new Customer(1001,"A","a@gmail.com","abc","234","aaa","gpay",100));
    c.add(new Customer(1002,"A","a@gmail.com","abc","234","aaa","gpay",100));
    c.add(new Customer(1003,"A","a@gmail.com","abc","234","aaa","gpay",100));
    c.add(new Customer(1004,"A","a@gmail.com","abc","234","aaa","gpay",100));


    new Expectations() {
      {
        dao.showAllCustomers();
        result = 5;
        minTimes=0;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };



    try {
      assertEquals(5,CustomerFactory.showFullCustomer().length);
      Customer[] me = CustomerFactory.showFullCustomer();
      System.out.println("\n\nActual Length :"+me.length);
      assertEquals(5, me.length);
    }catch (Exception e) {
     System.out.println("ArrayStore");
    }

  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testcustomerByCustId(@Mocked final CustomerDAO dao) {
    final Customer c100 = new Customer(100);
    final Customer c101 = new Customer(101);
    final ArrayList<Customer> mn = new ArrayList<Customer>();
    //final CustomerFactory obj = new CustomerFactory();
    new Expectations() {
      {
        mn.add(c100);
        mn.add(c101);
        dao.displayCustomerByCustomerId(101);
        result = c101;
        minTimes=0;
      }
    };
    new MockUp<CustomerFactory>() {
        @Mock
        CustomerDAO dao() {
          return dao;
        }
      };

      assertEquals(c101.hashCode(),CustomerFactory.customerByCustId(101).hashCode());
    assertEquals(new Customer(100).getCustomerId(),
        c100.getCustomerId());
    assertEquals(new Customer(101).getCustomerId(),
        c101.getCustomerId());
  }


  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testcreateNewCust(@Mocked final CustomerDAO dao) {
   final Customer c100= new Customer(100,"A","a@gmail.com","abc","234","aaa","gpay",100);
   new Expectations() {
    {
    dao.createNewCustomer(100,"A","a@gmail.com","abc","234","aaa","gpay",100);
    result=1;
    minTimes=0;
   }};
   new MockUp<CustomerFactory>() {
    @Mock
    CustomerDAO dao() {
      return dao;
    }
  };
    boolean n= CustomerFactory.createNewCust(new Customer(100,"A","a@gmail.com","abc","234","aaa","gpay",100));
    assertEquals(true,n);
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testupdateCustRec(@Mocked final CustomerDAO dao) {
    new Expectations() {
          {
            ArrayList<Customer> list = new ArrayList<Customer>();
            dao.updateCustomerRecord(1,"A","a@gmail.com","abc","234","aaa","gpay",100);
            result=1;
            minTimes=0;
        }
      };
    new MockUp<CustomerFactory>() {
        @Mock
        CustomerDAO dao() {
          return dao;
        }
      };

    assertEquals(true, CustomerFactory.updateCustRec(new Customer (1,"A","a@gmail.com","abc","234","aaa","gpay",100)));
  }
  @Test
  public final void testdeleteCustomerRe(@Mocked final CustomerDAO dao) {
    new Expectations() {{
      dao.deleteCustomerRecord(108);
      result=1;
      minTimes=0;
    }};
new MockUp<CustomerFactory>() {
    @Mock
    CustomerDAO dao() {
        return dao;
     }
     };
  assertEquals(true,CustomerFactory.deleteCustomerRe(108));
  }

 @Test
  public final void testupdateAmount(@Mocked final CustomerDAO dao) {
    new Expectations() {
          {
            ArrayList<Customer> list = new ArrayList<Customer>();
            dao.updateCustomerWalletAmount(108,1200);
            result=1;
            minTimes=0;
        }
      };
     new MockUp<CustomerFactory>() {
        @Mock
        CustomerDAO dao() {
            return dao;
         }
         };

    assertEquals(true, CustomerFactory.updateAmount(108, 1200));
  }

  @Test
  public final void testcheckUserId(@Mocked final CustomerDAO dao) {
    final Customer c100 = new Customer(100);
    new Expectations() {
      {
         dao.checkUserIdExist(100);
        result = 1;
        minTimes=0;
      }
    };
    new MockUp<CustomerFactory>() {
        @Mock
        CustomerDAO dao() {
          return dao;
        }
      };

      assertEquals(true, CustomerFactory.checkUserId(100));

  }
}