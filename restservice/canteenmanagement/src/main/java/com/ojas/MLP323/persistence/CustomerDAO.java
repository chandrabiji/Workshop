package com.ojas.MLP323.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.ojas.MLP323.model.Customer;

import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Bind;

import java.util.List;


/**
 * Functionalities to add
 * 1. Add customers
 * 2. view cust
 * 3. view all cust
 * 4. update cust
 * 5. delete cust
 *
 * 1. view profile
 * 2. edit profile
 * 3. Wallet
*/



/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface CustomerDAO {
  /**
  * @return the all the Customer record.
  */
  @SqlQuery("Select * from customer")
  @Mapper(CustomerMapper.class)
  List<Customer> showAllCustomers();
 /**
  * @param customerId gets the customerId.
  * @return the Customer record with this customerId.
  */
  @SqlQuery("Select * from mlp323.customer where cust_id= :id")
  @Mapper(CustomerMapper.class)
  Customer displayCustomerByCustomerId(@Bind("id") int customerId);

  /**
   *
   * @param customerId gives customerId
   * @param customerName gives customerName
   * @param customerEmail gives customerEmail
   * @param customerAddress gives customerAddress
   * @param customerMobileNo gives customerMobileNo
   * @param customerPassword gives customerPassword
   * @param walletName gives walletName
   * @param walletAmount gives walletAmount
   * @return boolean
   */


  @SqlUpdate("update mlp323.customer set cust_name= :name, cust_email= :email, cust_address= :address,"
      +
      " cust_mobileno= :nobileno, cust_password= :password, cust_wallet_name= :wname, cust_wallet_amount="
      +
      " :wamount where cust_id= :id")
  int updateCustomerRecord(@Bind("id")int customerId, @Bind("name")String customerName, @Bind("email")String customerEmail,
        @Bind("address")String customerAddress, @Bind("nobileno")String customerMobileNo, @Bind("password") String customerPassword,
        @Bind("wname")String walletName, @Bind("wamount")double walletAmount);
 /**
  * Insert new customer.
  * @param customerId to initialize customerId.
  * @param customerName to initialize customerName.
  * @param customerEmail to initialize customerEmail.
  * @param customerAddress to initialize customerAddresss.
  * @param customerMobileNo to initialize customerMobileNo.
  * @param customerPassword to initialize customerPassword.
  * @param walletName to initialize walletName.
  * @param walletAmount to initialize walletAmount.
  * @return addCusres.
  */
  @SqlUpdate("insert into mlp323.customer(cust_id, cust_name, cust_email, cust_address, cust_mobileno, cust_password,"
        +
        " cust_wallet_name, cust_wallet_amount) values(:id, :name, :email, :address, :mobileno, :password, :wname, :wamount)")
  @Mapper(CustomerMapper.class)
  int createNewCustomer(@Bind("id")int customerId, @Bind("name")String customerName, @Bind("email")String customerEmail,
        @Bind("address")String customerAddress, @Bind("mobileno")String customerMobileNo, @Bind("password") String customerPassword,
        @Bind("wname")String walletName, @Bind("wamount")double walletAmount);
 /**
  * Update the customer walletAmount.
  * @param customerId to initialize customerId.
  * @param walletAmount to initialize walletAmount.
  @return boolean
  */
  @SqlUpdate("update  mlp323.customer set cust_wallet_amount= :walletAmount where cust_id= :customerId")
  int updateCustomerWalletAmount(@Bind("customerId")int customerId, @Bind("walletAmount") double walletAmount);
 /**
  * @param customerEmail to initialize customerEmail.
  * @param customerPassword to initialize customerPassword.
  * @return customer list object.
  */
  @SqlQuery("Select cust_id from mlp323.customer where cust_email= :customerEmail  AND cust_password = :customerPassword")
  int checkLoginCustomer(@Bind("customerEmail") String customerEmail, @Bind("customerPassword") String customerPassword);
 /**
  * Delete the customer.
  * @param customerId to initialize the customerId.
  * @return result.
  */
  @SqlUpdate("delete from mlp323.customer  where cust_id = :cid")
  @Mapper(CustomerMapper.class)
  int deleteCustomerRecord(@Bind("cid")int customerId);

  /**
   *
   * @param customerId takes id
   * @return int
   */

  @SqlQuery("select count(*) from mlp323.customer where cust_id=:cid")
  int checkUserIdExist(@Bind("cid")int customerId);

  /**
   * getting last id
   */
  @SqlQuery("select cust_id from mlp323.customer order by cust_id desc limit 1")
  int lastId();

  /**
   * getting email present
   */
  @SqlQuery("select count(*) from mlp323.customer where cust_email=:email")
  int isEmailPresent(@Bind("email") String email);

  /**
   * getting email present
   */
  @SqlQuery("select * from mlp323.customer")
  List<String> getAllmails();




  @SqlUpdate("UPDATE `mlp323`.`customer` SET `CUST_WALLET_NAME` = :pass WHERE (`CUST_EMAIL` = :email)")
  int updatePassword(@Bind("email")String email, @Bind("pass") String pass);
}
