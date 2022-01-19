package com.ojas.MLP323.factory;
import java.util.List;

import com.ojas.MLP323.model.Customer;
import com.ojas.MLP323.persistence.CustomerDAO;
import com.ojas.MLP323.persistence.DbConnection;
/**
 * VendorFactory class used to fetch Customer data from database.
 * @author hexware
 */
public class CustomerFactory {
  /**
   *  Protected constructor.
   */
  public CustomerFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static CustomerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CustomerDAO.class);
  }

  /**
   * Call the Method ShowAllCustomers.
   * @return the Array of objects.
   */

  public static Customer[] showFullCustomer() {
    List<Customer> customers = dao().showAllCustomers();
    return customers.toArray(new Customer[customers.size()]);
  }

  /**
   * Call the Method ShowAllCustomers.
   * @return the Array of objects.
   * @param id tkes customer id
   */

  public static Customer customerByCustId(final int id) {
    Customer cust = dao().displayCustomerByCustomerId(id);
    return cust;
  }

  /**
   * Call the Method UpdateCustomerRecord.
   * @return the Boolean Value.
   * @param c takes customer object
   */

  public static boolean updateCustRec(final Customer c) {
    int result = dao().updateCustomerRecord(c.getCustomerId(),
          c.getCustomerName(),
          c.getCustomerEmail(),
          c.getCustomerAddress(),
          c.getCustomerMobileNo(),
          c.getCustomerPassword(),
          c.getWalletName(),
          c.getWalletAmount());
    if (result == 1) {
      return true;
    }
    return false;

  }


  /**
   * Call the Method createNewCustomer.
   * @return the Boolean Value.
   * @param c is customer object
   */

  public static boolean createNewCust(final Customer c) {
    int result = dao().createNewCustomer(c.getCustomerId(),
                                     c.getCustomerName(),
                                     c.getCustomerEmail(),
                                     c.getCustomerAddress(),
                                     c.getCustomerMobileNo(),
                                     c.getCustomerPassword(),
                                     c.getWalletName(),
                                     c.getWalletAmount());
    if (result == 1) {
      return true;
    }
    return false;

  }

  /**
   *
   * @param id takes id
   * @param amount takes amount
   * @return boolean
   */

  public static boolean updateAmount(final int id, final double amount) {
    int result = dao().updateCustomerWalletAmount(id, amount);
    if (result == 1) {
      return true;
    }
    return false;
  }


  /**
   * Call the Method LoginCust.
   * @return the Boolean Value.
   * @param email takes email id.
   * @param pass takes password.
   */

  public static int loginCustomer(final String email, final String pass) {
    int result = dao().checkLoginCustomer(email, pass);
    return result;
  }

  /**
   * Call the Method CheckUserId.
   * @return the Boolean Value.
   * @param id takes record id.
   */

  public static boolean checkUserId(final int id) {
    int result = dao().checkUserIdExist(id);
    if (result >= 1) {
      return true;
    }
    return false;

  }


    /**
   * Call the Method DeleteCustomerRe.
   * @return the Boolean Value.
   * @param id takes record id
   */

  public static boolean deleteCustomerRe(final int id) {
    int result = dao().deleteCustomerRecord(id);
    if (result == 1) {
      return true;
    }
    return false;
  }


  /***
   * getting last inserted record id
   * @param id
   * @return
   */

  public static int getLastId() {
  return dao().lastId();
  }


  public static boolean isEmailPresent(String email){
    return dao().isEmailPresent(email)>=1?true:false;
  }



  public static String[] getAllMails(){
    List<String> emails= dao().getAllmails();
    return emails.toArray(new String[emails.size()]);
  }


  public static boolean updatePassword(final String email,final String pass){
    return dao().updatePassword(email,pass)==1?true:false;
  }



}
