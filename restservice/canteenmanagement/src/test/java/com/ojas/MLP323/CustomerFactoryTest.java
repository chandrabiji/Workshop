package com.ojas.MLP323;
import com.ojas.MLP323.factory.CustomerFactory;
import com.ojas.MLP323.model.Customer;
import com.ojas.MLP323.persistence.CustomerDAO;

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
public class CustomerFactoryTest {

    @Before
    public void initInput(){

     }
     /**
 * test for constructor
 */
@Test
public final void testConstructor(){
 final CustomerFactory exp = new CustomerFactory();
 assertNotEquals(exp,null);
}
/**
   * Tests the showallCustomers method of the Customer class.
*/
@Test
public final void testallCustomers(@Mocked final CustomerDAO dao) {
final ArrayList<Customer> exp = new ArrayList<Customer>();
exp.add(new Customer(100,"A","a@gmail.com","abc","234","aaa","gpay",100));
exp.add(new Customer(200,"A","a@gmail.com","abc","234","aaa","gpay",100));
exp.add(new Customer(300,"A","a@gmail.com","abc","234","aaa","gpay",100));



new Expectations()
{{
   System.out.println("Mocked full Customer Object");
   dao.showAllCustomers();
   result = exp;
}};
new MockUp<CustomerFactory>(){
  @Mock
  CustomerDAO dao(){
    System.out.println("Mocked dao for full Customer");
    return dao;
  }
};
Customer[] list = CustomerFactory.showFullCustomer();
ArrayList<Customer> act = new ArrayList<Customer>();
for(Customer v:list)
{
  act.add(v);

System.out.println("Test Customers :"+v.getCustomerId());
}
assertEquals(exp,act);
}
/**
   * Tests the Customerbyid method of the Customerclass.
*/

@Test
public void testdisplayCustomerByCustomerId(@Mocked final CustomerDAO dao){
final Customer customer = new Customer(100,"A","a@gmail.com","abc","234","aaa","gpay",100);
new Expectations()
{{
   System.out.println("Mocked full Customer Object");
   dao.displayCustomerByCustomerId(100);
   result = customer;
}};
new MockUp<CustomerFactory>(){
    @Mock
    CustomerDAO dao(){
      System.out.println("Mocked dao for full Customer");
      return dao;
    }
  };
Customer customer1= CustomerFactory.customerByCustId(100);
assertEquals(customer.getCustomerId(),customer1.getCustomerId());
}
/**
   * Tests the LoginCustomer method of the Customer class.
*/
@Test
public void testloginCustomer(@Mocked final CustomerDAO dao){

    final Customer customer = new Customer(100,"A","a@gmail.com","abc","234","aaa","gpay",100);

new Expectations()
{{
   dao.checkLoginCustomer("a@gmail.com","abc");
   result = 101;
}};
new MockUp<CustomerFactory>(){
    @Mock
    CustomerDAO dao(){
      System.out.println("Mocked dao for full Customer");
      return dao;
    }
  };
int customer1 = CustomerFactory.loginCustomer("a@gmail.com","abc");
assertEquals(customer1,101);

}
/**
   * Tests the createCustomer method of the Customer class.
*/
@Test
public void testcreateCustomerRecord() {
  boolean result = CustomerFactory.createNewCust(new Customer(100,"A","a@gmail.com","abc","234","aaa","gpay",100));
  assertEquals(true,result);
}

/**
   * Tests the Delete method of the Customer class.
*/
@Test
public void testdeleteCustomerRecord(){
  System.out.println("Delete Customer");

    if (CustomerFactory.createNewCust(new Customer(1000,"A","a@gmail.com","abc","234","aaa","gpay",100))){
        System.out.println("Inseretd Successfully...");

    }
    else{
        System.out.println("Not DOne");
    }
    boolean  result = CustomerFactory.deleteCustomerRe(1000);
    assertEquals(true,result);
}
/**
   * Tests the Customerexists method of the Customer class.
*/
@Test
public void testCustomerExist(@Mocked final CustomerDAO dao){
final Customer Customer = new Customer(1100,"A","a@gmail.com","abc","234","aaa","gpay",100);
final boolean res=true;
new Expectations()
{{
   System.out.println("Mocked full Customer Object");
   dao.checkUserIdExist(110);
   result = 1;
}};
new MockUp<CustomerFactory>(){
    @Mock
    CustomerDAO dao(){
      System.out.println("Mocked dao for full Customer");
      return dao;
    }
  };
boolean Customer1 = CustomerFactory.checkUserId(110);
assertEquals(Customer1,res);
}
}