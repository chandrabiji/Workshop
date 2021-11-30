package com.hexaware.MLP323.factory;

import com.hexaware.MLP323.persistence.OrderDAO;
import com.hexaware.MLP323.persistence.DbConnection;
import java.util.List;
import java.util.Objects;

import com.hexaware.MLP323.model.Order;
/**
 * OrderFactory class used to fetch order data from database.
 * @author hexware
 */
public class OrderFactory {
  /**
   *  Protected constructor.
   */
  protected OrderFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OrderDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrderDAO.class);
  }


  /**
   * Call the AllOrders from OrderDAO.
   * @return the connection object.
   */
  public static Order[] allOrders() {

    List<Order> or = dao().showAllOrders();
    return or.toArray(new Order[or.size()]);
  }


  /**
   * Call the CreateNewOrder from OrderDAO.
   * @return the connection object.
   * @param o takes order object
   */
  public static boolean createOrder(final Order o) {

    int result = dao().createNewOrder(o.getFoodId(),
                                    o.getVendorId(),
                                    o.getCustomerId(),
                                    o.getNoOfItems(),
                                    o.getOrderDateTime(),
                                    o.getAmountToBePaid(),
                                    o.getTokenNumber(),
                                    o.getStatus(),
                                     o.getComment());

    if (result >= 1) {
      return true;
    }
    return false;

  }


  /**
   * Call the ShowOrderByCustomerId from OrderDAO.
   * @return the connection object.
   * @param customerId take cust id.
   */
  public static Order[] showOrdersByCustId(final int customerId) {

    List<Order> result = dao().showOrderByCustomerId(customerId);

    return result.toArray(new Order[result.size()]);
  }


  /**
   * Call the ShowCurrentOrderByCustomerId from OrderDAO.
   * @return the connection object.
   * @param customerId takes cust_id.
   * @param comment takes comment.
   */
  public static Order[] showCurrentOrdersByIdandComment(final int customerId, final String comment) {

    List<Order> result = dao().showCurrentOrderbyCustomerIdandComments(customerId, comment);

    return result.toArray(new Order[result.size()]);
  }



  /**
   * Call the ShowOrdersByVendorId from OrderDAO.
   * @return the connection object.
   * @param vId takes vendor id
   */
  public static Order[] showOrdersByVendId(final int vId) {

    List<Order> result = dao().showOrdersByVendorId(vId);

    return result.toArray(new Order[result.size()]);
  }


  /**
   * Call the ShowOrdersByOrderId from OrderDAO.
   * @return the connection object.
   * @param oId takes orderid
   */
  public static Order showOrdersByOrderId(final int oId) {

    Order result = dao().showOrdersByOrderId(oId);

    return result;
  }



  /**
   * Call the UpdateOrderStatus from OrderDAO.
   * @return the connection object.
   * @param id takes id.
   * @param status takes status.
   */
  public static boolean updateOrderStatus(final int id, final String status) {

    int result = dao().updateOrderStatus(id, status);

    if (result >= 1) {
      return true;
    }
    return false;

  }

  /**
   * Call the UpdateOrderStatus from OrderDAO.
   * @return the connection object.
   * @param id takes id.
   */
  public static Order[] getPendingRecords(final String id) {

    List<Order> result = dao().getPendingRecordsUsingCartId(id);
    return result.toArray(new Order[result.size()]);
  }





  /**
   * Call the getCurrentDate.
   * @return the connection object.
   */
  public static String getCurrentDate() {
    return dao().getDate();
  }


  /**
   * Call the getCurrentDate.
   * @return the connection object.
   */
  public static String getCurrentDateTime() {
    return dao().getDateTimeString();
  }


  /**
   * generates hashcode
   * @param name
   * @param dattime
   * @param id
   * @return
   */
  public static int gethashCode(String name,String id){
    return Objects.hash(name,OrderFactory.getCurrentDateTime(),id);
  }



  /**
   * generates hashcode
   * @param name
   * @param dattime
   * @param id
   * @return
   */
  public static int isOrderPresent(String id,int foodid){
    return dao().isOrderPresent(id,foodid);
  }

    /**
   * generates hashcode
   * @param name
   * @param dattime
   * @param id
   * @return
   */
  public static boolean updateQuantityandPrice(int id,int quantity,double price){
    if(dao().updateQuantityandPrice(id,quantity,price)==1){
      return true;
    }
    return false;
  }





}
