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


@RunWith(JMockit.class)
public class OrderFactoryTest {
@Before
public void initInput() {
//final int argOrderId,
// final int argFoodId, final int argVendorId, final int argCustomerId, final int argNoOfItems,
}
@Test
public final void testallOrders(@Mocked final OrderDAO dao){
final ArrayList<Order> exp = new ArrayList<Order>();
exp.add(new Order(1,101,1,2,3,"2021-03-03",450.0,"111111","pending","cmnt"));
exp.add(new Order(2,101,1,2,3,"2021-03-03",450.0,"222222","pending","cmnt"));
exp.add(new Order(3,101,1,2,3,"2021-03-03",450.0,"333333","pending","cmnt"));

new Expectations()
{{
   System.out.println("Mocked full order");
    dao.showAllOrders();
    result = exp;
}};

new MockUp<OrderFactory>(){
  @Mock
  OrderDAO dao(){
     return dao;
  }
};

Order[] list = OrderFactory.allOrders();
ArrayList<Order> act = new ArrayList<Order>();
for(Order o:list)
{
   act.add(o);

   System.out.println("Test Orders :"+o.getOrderId());
}
assertEquals(exp,act);

}
@Test
public void testcreateOrder(){
  boolean result = OrderFactory.createOrder(new Order(3,101,1,2,3,"2021-03-03",450.0,"333333","pending","cmnt"));
    assertEquals(true,result);
}
@Test
public void testshowOrdersByCustId(@Mocked final OrderDAO dao){
    final ArrayList<Order> order=new ArrayList<Order>();
    order.add(new Order(3,101,1,1,3,"2021-03-03",450.0,"333333","pending","cmnt"));
new Expectations()
{{
   System.out.println("Mocked full Order Object");
   dao.showOrderByCustomerId(1);
   result = order;
}};
new MockUp<OrderFactory>(){
  @Mock
  OrderDAO dao(){
    System.out.println("Mocked dao for full Order");
    return dao;
  }
};
Order[] order1 = OrderFactory.showOrdersByCustId(1);
ArrayList<Order> result=new ArrayList<Order>();

for (Order o: order1){
    result.add(o);
    System.out.println("Testing :"+o.getOrderId());
}
assertEquals(order,result);
}


@Test
public void testshowCurrentOrdersByIdandComment(@Mocked final OrderDAO dao){
final ArrayList<Order> order = new ArrayList<Order>();
order.add(new Order(3,101,1,1,3,"2021-03-03",450.0,"121212","pending","cmnt"));
new Expectations()
{{
   System.out.println("Mocked full Order Object");
   dao.showCurrentOrderbyCustomerIdandComments(3,"pending");
   result = order;
}};
new MockUp<OrderFactory>(){
  @Mock
  OrderDAO dao(){
    System.out.println("Mocked dao for full Order");
    return dao;
  }
};
Order[] order1 = OrderFactory.showCurrentOrdersByIdandComment(3,"pending");

assertEquals(order1.length,order.size());
}



@Test
public void testshowOrdersByVendId(@Mocked final OrderDAO dao){

   final  ArrayList<Order> order=new ArrayList<Order>();
    order.add(new Order(3,101,1,1,3,"2021-03-03",450.0,"4444","pending","cmnt"));
new Expectations()
{{
   System.out.println("Mocked full Order Object");
   dao.showOrdersByVendorId(1);
   result = order;
}};
new MockUp<OrderFactory>(){
  @Mock
  OrderDAO dao(){
    System.out.println("Mocked dao for full Order");
    return dao;
  }
};
Order[] order1 = OrderFactory.showOrdersByVendId(1);
assertEquals(order1.length,order.size());
}


@Test
public void testshowOrdersByOrderId(@Mocked final OrderDAO dao){
final Order order = new Order(3,101,1,1,3,"2021-03-03",450.0,"6666","pending","cmnt");
new Expectations()
{{
   System.out.println("Mocked full Order Object");
   dao.showOrdersByOrderId(3);
   result = order;
}};
new MockUp<OrderFactory>(){
  @Mock
  OrderDAO dao(){
    System.out.println("Mocked dao for full Order");
    return dao;
  }
};
Order order1 = OrderFactory.showOrdersByOrderId(3);
assertEquals(order.getOrderId(),order1.getOrderId());
}



// @Test
// public void testupdateOrderStatus(){
//   System.out.println("Updating Order");
//   Order order = new Order(1,101,1,2,3,"2021-03-03",450.0,"333333","fferferf","cmnt");
//  boolean result = OrderFactory.updateOrderStatus(3,"yes");
//  assertEquals(true,result);
// }

}