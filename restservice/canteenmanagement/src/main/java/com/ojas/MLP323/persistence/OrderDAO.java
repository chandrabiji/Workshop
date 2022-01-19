<<<<<<< HEAD
package com.ojas.MLP323.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.ojas.MLP323.model.Order;

import org.skife.jdbi.v2.sqlobject.Bind;

import java.util.List;

/**
 * Functionalities
 * show all orders
 * create order
 *
 * 1. accept order
 * 2. decline order
 * 3. order status
 * 4. order history
 * 5. current items
 *
 */
/**
 * OrderDAO class used to fetch data from data base.
 * @author hexware
 */
public interface OrderDAO {
  /**
   * @return the all the Order record.
   */
  @SqlQuery("Select * from mlp323.orders")
  @Mapper(OrderMapper.class)
  List<Order> showAllOrders();



  /**
   *
   * @param token as cart id.
   * @return list of objects.
   */
  @SqlQuery("Select * from mlp323.orders where token_number=:token and status='pending'")
  @Mapper(OrderMapper.class)
  List<Order> getPendingRecordsUsingCartId(@Bind("token") String token);



  /**
   * Insert order.
   * @param foodId to initialize food id.
   * @param vendorId to initialize vendor id.
   * @param customerId to initialize customer id.
   * @param noOfItems to initialize no of items.
   * @param orderDateTime to initialize order datetime.
   * @param amountToBePaid to initialize amount to be paid.
   * @param tokenNumber to initialize token number.
   * @param status to initialize status.
   * @param comment to initialize comment.
   * @return new record.
   */
  @SqlUpdate("insert into mlp323.orders(food_id, vendor_id, customer_id, no_of_items, order_date_time, amount_to_be_paid,"
        +
        " token_number, status, comment) values(:ofid, :ovid, :ocid, :onfi, :odt, :oamt, :otoken, :ostatus, :ocomment)")
  @Mapper(OrderMapper.class)
  int createNewOrder(@Bind("ofid")int foodId,
        @Bind("ovid")int vendorId,
        @Bind("ocid")int customerId,
        @Bind("onfi")int noOfItems,
        @Bind("odt") String orderDateTime,
        @Bind("oamt")double amountToBePaid,
        @Bind("otoken")String tokenNumber,
        @Bind("ostatus")String status,
        @Bind("ocomment")String comment);
  /**
   * @param customerId gets the customerId.
   * @return the Order record with this customerId.
   */
  @SqlQuery("Select * from mlp323.orders where customer_id=:id")
  @Mapper(OrderMapper.class)
  List<Order> showOrderByCustomerId(@Bind("id")int customerId);

  /**
     * @param customerId gets the customerId.
     * @param status gets status
     * @return the Order record with this customerId.
     */
  @SqlQuery("Select * from mlp323.orders where customer_id=:id and status = :status")
  @Mapper(OrderMapper.class)
  List<Order> showCurrentOrderbyCustomerIdandComments(@Bind("id")int customerId, @Bind("status")String status);


  /**
   * @param vendorId gets the customerId.
   * @return the Order record with this customerId.
   */
  @SqlQuery("Select * from mlp323.orders where vendor_id=:id")
  @Mapper(OrderMapper.class)
  List<Order> showOrdersByVendorId(@Bind("id")int vendorId);
  /**
   * @param orderId gets the customerId.
   * @return the Order record with this orderId.
   */
  @SqlQuery("Select * from mlp323.orders where order_id=:id")
  @Mapper(OrderMapper.class)
  Order showOrdersByOrderId(@Bind("id")int orderId);


  /**
   *
   * @param orderId takes order id
   * @return int
   */
  @SqlUpdate("delete from mlp323.orders where customer_id = : id")
  int removeOrdersFromTable(@Bind("id")int orderId);




 /**
   * Update the customer walletAmount.
   * @param orderId to initialize customerId.
   * @param status to initialize walletAmount.
   * @return int
   */
  @SqlUpdate("update  mlp323.orders set status= :status where order_id= :orderId ")
  int updateOrderStatus(@Bind("orderId")int orderId, @Bind("status") String status);




 /**
  *
  * @return date
  */
  @SqlQuery("SELECT DATE(NOW())")
  String getDate();

 /**
  *
  * @return date time
  */
  @SqlQuery("SELECT NOW()")
  String getDateTimeString();


  @SqlQuery("select order_id from mlp323.orders where token_number = :cc  and food_id= :ff ")
  int isOrderPresent(@Bind("cc") String id,@Bind("ff") int foodId);




   /**
   * Update the customer walletAmount.
   * @param orderId to initialize customerId.
   * @param status to initialize walletAmount.
   * @return int
   */
  @SqlUpdate("UPDATE `mlp323`.`orders` SET `NO_OF_ITEMS` = :quantity, `AMOUNT_TO_BE_PAID` =: price WHERE (`ORDER_ID` = :orderId)")
  int updateQuantityandPrice(@Bind("orderId")int orderId, @Bind("quantity") int quantity,@Bind("price") double price);



}
=======
package com.ojas.MLP323.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.ojas.MLP323.model.Order;

import org.skife.jdbi.v2.sqlobject.Bind;

import java.util.List;

/**
 * Functionalities
 * show all orders
 * create order
 *
 * 1. accept order
 * 2. decline order
 * 3. order status
 * 4. order history
 * 5. current items
 *
 */
/**
 * OrderDAO class used to fetch data from data base.
 * @author hexware
 */
public interface OrderDAO {
  /**
   * @return the all the Order record.
   */
  @SqlQuery("Select * from mlp323.orders")
  @Mapper(OrderMapper.class)
  List<Order> showAllOrders();



  /**
   *
   * @param token as cart id.
   * @return list of objects.
   */
  @SqlQuery("Select * from mlp323.orders where token_number=:token and status='pending'")
  @Mapper(OrderMapper.class)
  List<Order> getPendingRecordsUsingCartId(@Bind("token") String token);



  /**
   * Insert order.
   * @param foodId to initialize food id.
   * @param vendorId to initialize vendor id.
   * @param customerId to initialize customer id.
   * @param noOfItems to initialize no of items.
   * @param orderDateTime to initialize order datetime.
   * @param amountToBePaid to initialize amount to be paid.
   * @param tokenNumber to initialize token number.
   * @param status to initialize status.
   * @param comment to initialize comment.
   * @return new record.
   */
  @SqlUpdate("insert into mlp323.orders(food_id, vendor_id, customer_id, no_of_items, order_date_time, amount_to_be_paid,"
        +
        " token_number, status, comment) values(:ofid, :ovid, :ocid, :onfi, :odt, :oamt, :otoken, :ostatus, :ocomment)")
  @Mapper(OrderMapper.class)
  int createNewOrder(@Bind("ofid")int foodId,
        @Bind("ovid")int vendorId,
        @Bind("ocid")int customerId,
        @Bind("onfi")int noOfItems,
        @Bind("odt") String orderDateTime,
        @Bind("oamt")double amountToBePaid,
        @Bind("otoken")String tokenNumber,
        @Bind("ostatus")String status,
        @Bind("ocomment")String comment);
  /**
   * @param customerId gets the customerId.
   * @return the Order record with this customerId.
   */
  @SqlQuery("Select * from mlp323.orders where customer_id=:id")
  @Mapper(OrderMapper.class)
  List<Order> showOrderByCustomerId(@Bind("id")int customerId);

  /**
     * @param customerId gets the customerId.
     * @param status gets status
     * @return the Order record with this customerId.
     */
  @SqlQuery("Select * from mlp323.orders where customer_id=:id and status = :status")
  @Mapper(OrderMapper.class)
  List<Order> showCurrentOrderbyCustomerIdandComments(@Bind("id")int customerId, @Bind("status")String status);


  /**
   * @param vendorId gets the customerId.
   * @return the Order record with this customerId.
   */
  @SqlQuery("Select * from mlp323.orders where vendor_id=:id")
  @Mapper(OrderMapper.class)
  List<Order> showOrdersByVendorId(@Bind("id")int vendorId);
  /**
   * @param orderId gets the customerId.
   * @return the Order record with this orderId.
   */
  @SqlQuery("Select * from mlp323.orders where order_id=:id")
  @Mapper(OrderMapper.class)
  Order showOrdersByOrderId(@Bind("id")int orderId);


  /**
   *
   * @param orderId takes order id
   * @return int
   */
  @SqlUpdate("delete from mlp323.orders where customer_id = : id")
  int removeOrdersFromTable(@Bind("id")int orderId);




 /**
   * Update the customer walletAmount.
   * @param orderId to initialize customerId.
   * @param status to initialize walletAmount.
   * @return int
   */
  @SqlUpdate("update  mlp323.orders set status= :status where order_id= :orderId ")
  int updateOrderStatus(@Bind("orderId")int orderId, @Bind("status") String status);




 /**
  *
  * @return date
  */
  @SqlQuery("SELECT DATE(NOW())")
  String getDate();

 /**
  *
  * @return date time
  */
  @SqlQuery("SELECT NOW()")
  String getDateTimeString();


  @SqlQuery("select order_id from mlp323.orders where token_number = :cc  and food_id= :ff ")
  int isOrderPresent(@Bind("cc") String id,@Bind("ff") int foodId);




   /**
   * Update the customer walletAmount.
   * @param orderId to initialize customerId.
   * @param status to initialize walletAmount.
   * @return int
   */
  @SqlUpdate("UPDATE `mlp323`.`orders` SET `NO_OF_ITEMS` = :quantity, `AMOUNT_TO_BE_PAID` =: price WHERE (`ORDER_ID` = :orderId)")
  int updateQuantityandPrice(@Bind("orderId")int orderId, @Bind("quantity") int quantity,@Bind("price") double price);



}
>>>>>>> branch 'master' of https://github.com/chandrabiji/Workshop
