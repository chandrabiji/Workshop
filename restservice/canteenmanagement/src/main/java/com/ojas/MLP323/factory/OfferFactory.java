package com.ojas.MLP323.factory;

import java.util.List;

import com.ojas.MLP323.model.Offers;
import com.ojas.MLP323.persistence.DbConnection;
import com.ojas.MLP323.persistence.OfferDao;
/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class OfferFactory {
  /**
   *  Protected constructor.
   */
  public OfferFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OfferDao dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OfferDao.class);
  }


  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Offers[] showAllOffers() {

    List<Offers> menu = dao().displayAllOffers();
    return menu.toArray(new Offers[menu.size()]);
  }

  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Offers[] showAllOffersByVendorId(final int id) {

    List<Offers> menu = dao().offersByVendorId(id);
    return menu.toArray(new Offers[menu.size()]);
  }



  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Offers offerByOfferId(final int id) {

    Offers menu = dao().offersByOfferId(id);
    return menu;
  }



  /**
   * Call the MenuPresent from menuDAO.
   * @return the Boolean Value.
   * @param id is food id.
   */
  public static Offers offerPresent(final String id) {
    return dao().offersPresent(id);


  }




  /**
   * Call the CreateMenuItem from menuDAO.
   * @return the Boolean Value.
   * @param m takes menu object.
   */
  public static boolean createOffers(final Offers m) {

    // if(m.getFoodImage()!=null)
    // m.setFoodImage(compressBytes(m.getFoodImage()));

    int result = dao().createOffersItem(m.getId(),
        m.getName(),
        m.getShare(),
        m.getMessage(),
        m.getVendorId());
    if (result >= 1) {
      return true;
    }
    return false;
  }







  /**
   * Call the UpdateMenuItem from menuDAO.
   * @return the Boolean Value.
   * @param id takes food id.
   */
  public static boolean deleteOffer(final int id) {
    int result = dao().deleteByOfferId(id);
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

}
