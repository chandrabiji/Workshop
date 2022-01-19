/*.
*/
package com.ojas.MLP323.factory;

import java.util.List;

import com.ojas.MLP323.model.Vendor;
import com.ojas.MLP323.persistence.DbConnection;
import com.ojas.MLP323.persistence.VendorDAO;
/**
 * VendorFactory class used to fetch vendor data from database.
 * @author hexware
 */
public class VendorFactory {
  /**
   *  Protected constructor.
   */
  public VendorFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }




  /**
   * Call the AllOrders from VendorDAO.
   * @return the connection object.
   */
  public static Vendor[] allVendors() {

    List<Vendor> or = dao().showAllVendorList();
    return or.toArray(new Vendor[or.size()]);
  }


  /**
   * Call the DisplayVendorByVendorId from VendroDAO.
   * @return the connection object.
   * @param id takes id
   */
  public static Vendor displayVendorByVendorId(final int id) {

    Vendor i = dao().displayVendorByVendorId(id);
    return i;
  }





  /**
   * Call the Method LoginVend.
   * @return the Boolean Value.
   * @param email takes email.
   * @param pass takes password.
   */

  public static int loginVendor(final String email, final String pass) {
    int result = dao().checkVendorLogin(email, pass);
    return result;
  }






  /**.
   * Call the Method CreateVendorRecord.
   * @return the Boolean Value.
   * @param c taeks vendor object.
   */

  public static boolean createVendorRecord(final Vendor c) {
    int result = dao().createNewVendorRecord(c.getVendorId(),
                                            c.getVendorName(),
                                            c.getVendorEmail(),
                                            c.getVendorContactNo(),
                                            c.getVendorPassword(),
                                            c.getVendorAddress(),
                                            c.getVendorRatings());
    if (result >= 1) {
      return true;
    }
    return false;

  }
  /**.
   * Call the Method UpdateVendorDetails.
   * @return the Boolean Value.
   * @param c takes vendor object.
   */

  public static boolean updateVendorDetails(final Vendor c) {
    int result = dao().updateVendorDetails(c);
    if (result >= 1) {
      return true;
    }
    return false;

  }
  /**
   * Call the Method DeleteVendorRecord.
   * @return the Boolean Value.
   * @param id takes record id
   */

  public static boolean deleteVendorRecord(final int id) {
    int result = dao().deleteVendorRecord(id);
    if (result >= 1) {
      return true;
    }
    return false;
  }

  /**
   * Call the Method vendorExist.
   * @return the Boolean Value.
   * @param id takes record id
   */


  public static boolean vendorExist(final int id) {
    int result = dao().checkUserIdExist(id);
    if (result >= 1) {
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


    public static boolean isEmailPresent(final String email){
      return dao().isEmailPresent(email)>=1?true:false;
    }



    public static double getRatings(final int id){
      return dao().getVendorRatings(id);
    }

    public static double setRatings(final int custId,final double rate){
      return dao().updateVendorRatings(custId,rate);
    }
    public static boolean updatePassword(final String email,final String pass){
      return dao().updatePassword(email,pass)==1?true:false;
    }
}
