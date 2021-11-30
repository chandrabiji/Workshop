package com.hexaware.MLP323.factory;
import com.hexaware.MLP323.persistence.BillDAO;
import com.hexaware.MLP323.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP323.model.Bill;
/**
 * VendorFactory class used to fetch Bill data from database.
 * @author hexware
 */
public class BillFactory {
  /**
   *  Protected constructor.
   */
  public BillFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static BillDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(BillDAO.class);
  }

 /**
   * Call the Method insert.
   * @return the objects.
   * @param b takes the Bill object
   */

  public static boolean insert(final Bill b) {
    int cust = dao().insertBill(b.getCartId(),
          b.getCustomerId(),
          b.getItemCount(),
          b.getTotalAmount(),
          b.getDiscount(),
          b.getStatus(),
          b.getComment());


    if (cust >= 1) {
      return true;
    }
    return false;
  }

  /**
   * Call the Method insert.
   * @return the objects.
   * @param id takes the cust id
   */

  public static int count(final int id) {
    return dao().getCount(id);
  }


  /**
   * getAll Bills
   */
  public static Bill[] getAllBills(){

    List<Bill> bills= dao().showAllBills();
    return bills.toArray(new Bill[bills.size()]);
  }

  /**
   * getAll Bills By cust Id
   */
  public static Bill[] getBillsbyCustId(final int custId){

    List<Bill> bills= dao().getBillsbyCustId(custId);
    return bills.toArray(new Bill[bills.size()]);
  }

  /**
   * getAll Bill by cart Id
   */
  public static Bill getBillBycartId(final String id){
    return dao().getBillsbyCartId(id);
  }


  public static int checkOfferCount(int id,String offer){
    return dao().checkOfferCount(id,offer);
  }




}
