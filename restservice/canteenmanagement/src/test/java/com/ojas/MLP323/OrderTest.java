package com.ojas.MLP323;
import com.ojas.MLP323.factory.OrderFactory;
import com.ojas.MLP323.model.Order;
import com.ojas.MLP323.persistence.OrderDAO;

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
 * Test class for Order.
 */
@RunWith(JMockit.class)
public class OrderTest {
    /**
   * setup method.
   */
   @Before
  public void initInput() {
  }
  /**
   * Tests the equals/hashcode methods of the order class.
   */
 @Test
  public final void testOrder() {
    Order o100 = new Order(100);
    Order o101= new Order(101);
  Order o=new Order();
  o.setFoodId(12);
  o.setVendorId(1);
  o.setCustomerId(1);
  o.setNoOfItems(10);
  o.setOrderDateTime("aa");
  o.setAmountToBePaid(100);
  o.setTokenNumber("1212");
  o.setStatus("aa");
  o.setComment("ahii");



  System.out.println("Hash :"+o.createCustomToken(10,"a","b"));


    assertNotEquals(o100, null);
    assertNotEquals(o101, null);

    assertEquals(o100.getOrderId(), new Order(100).getOrderId());

    o100.setOrderId(100);

    assertEquals(o100, new Order(100));
    assertEquals(o100, new Order(100));
    assertEquals(new Order(1,100, 1, 101, 10, "2021-01-12", 1200.0, "12451252", "pending", "Comment").hashCode(),
    new Order(1,100, 1, 101, 10, "2021-01-12", 1200.0, "12451252", "pending", "Comment").hashCode());

  }
  /**
   * tests that empty Order list is handled correctly.
   * @param dao mocking the dao class
   */



   @Test
  public final void testallOrders(@Mocked final OrderDAO dao) {
   final ArrayList<Order> o=new ArrayList<Order>();
    o.add(new Order(1,100, 1, 101, 10, "2021-01-12", 1200.0, "12451252", "pending", "Comment"));
    o.add(new Order(2,101, 1, 101, 10, "2021-01-12", 1200.0, "14789526", "pending", "Comment"));

    new Expectations(){
      {
        dao.showAllOrders();
        result=o;
        minTimes=0;
      }
    };

    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    Order[] ans=OrderFactory.allOrders();
    ArrayList<Order> oo=new ArrayList<Order>();

    for (Order a : ans){
      System.out.println("Testing :"+a.getOrderId());
      oo.add(a);
    }


    System.out.println("Result :\n");
    assertEquals(o,oo);


  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testcreateOrder(@Mocked final OrderDAO dao) {
   final Order o100= new Order(1,101, 1, 101, 10, "2021-01-12", 1200, "14789526", "pending", "Comment");
   new Expectations() {
    {
      dao.createNewOrder(101, 1, 101, 10, "2021-01-12", 1200, "14789526", "pending", "Comment");
      result=1;
      minTimes=0;
   }};
   new MockUp<OrderFactory>() {
    @Mock
    OrderDAO dao() {
      return dao;
    }
  };
    boolean n= OrderFactory.createOrder(new Order(1,101, 1, 101, 10, "2021-01-12", 1200, "14789526", "pending", "Comment"));
    assertEquals(true,n);
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */

  @Test
  public final void testshowOrdersByCustId(@Mocked final OrderDAO dao) {

    final ArrayList<Order> ord = new ArrayList<Order>();
    ord.add(new Order(1,101, 1, 101, 10, "2021-01-12", 1200, "14789526", "pending", "Comment"));
    new Expectations() {
      {
        dao.showOrderByCustomerId(1);
        result = ord;
        minTimes=0;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };
    Order[] ord1 = OrderFactory.showOrdersByCustId(1);

    ArrayList<Order> o=new ArrayList<Order>();
    for (Order a : ord1){
      o.add(a);
    }
    System.out.println("Testing Show Orders BY Cust Id :");
    assertEquals(o,ord);



  }


    /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */

  @Test
  public final void testshowOrdersByVendId(@Mocked final OrderDAO dao) {

    final ArrayList<Order> ord = new ArrayList<Order>();
    ord.add(new Order(1,101, 1, 101, 10, "2021-01-12", 1200, "14789526", "pending", "Comment"));
    ord.add(new Order(2,101, 1, 101, 10, "2021-01-12", 1200, "14789526", "pending", "Comment"));
    ord.add(new Order(3,101, 1, 101, 10, "2021-01-12", 1200, "14789526", "pending", "Comment"));
    ord.add(new Order(4,101, 1, 101, 10, "2021-01-12", 1200, "14789526", "pending", "Comment"));

    new Expectations() {
      {
        dao.showOrdersByVendorId(1);
        result = ord;
        minTimes=0;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };
    Order[] ord1 = OrderFactory.showOrdersByVendId(1);

    ArrayList<Order> result=new ArrayList<Order>();
    for (Order o: ord1){
      result.add(o);
      System.out.println("Order Id :"+o.getOrderId());
    }
    System.out.println("Testing Show Orders BY Vend Id :");
    assertEquals(result,ord);

  }


  @Test
  public final void testshowOrdersByOrderId(@Mocked final OrderDAO dao) {

    final Order ord=new Order(1,101, 1, 101, 10, "2021-01-12", 1200, "14789526", "pending", "Comment");

    new Expectations() {
      {
        dao.showOrdersByOrderId(1);
        result = ord;
        minTimes=0;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };
    Order ord1 = OrderFactory.showOrdersByOrderId(1);


    System.out.println("Testing Show Orders BY Order Id :");
    assertEquals(ord1,ord);

  }
}