package com.ojas.MLP323.model;
import java.util.Objects;



/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Menu {
/**
 * foodId to store foodId.
 */
  private int foodId;
  /**
 * foodName to store foodName.
 */
  private String foodName;
/**
 * foodQtyto store foodQty.
 */
  private int foodQuantity;



/**
 * foodPrice store foodPrice.
 */
private double foodPrice;



/**
 * vendor id store vendorId.
 */
private int vendorId;/**

* vendor id store vendorId.
*/
 private String imageUrl;








  /**
   * Default Constructor.
   */
  public Menu() {  }
   /**
 * @param argFoodId to initialize food id.
 * used to get details through constructor.
 */
  public Menu(final int argFoodId) {
    this.foodId = argFoodId;
  }
/**
 * @param argFoodId to initialize food id.
 *  @param argfoodName to initialize food name.
 *  @param argfoodQuantity to initialize food qty.
 *  @param argfoodPrice to initialize food price.
 *  @param argvendorId to initialize vendor id.
 * used to get details through constructor.
 */

public Menu(final int argFoodId, final String argfoodName, final int argfoodQuantity, final double argfoodPrice, final int argvendorId) {
  this.foodId = argFoodId;
  this.foodName = argfoodName;
  this.foodQuantity = argfoodQuantity;
  this.foodPrice = argfoodPrice;
  this.vendorId = argvendorId;
}

public Menu(final int argFoodId, final String argfoodName, final int argfoodQuantity, final double argfoodPrice, final int argvendorId,final String imag) {
  this.foodId = argFoodId;
  this.foodName = argfoodName;
  this.foodQuantity = argfoodQuantity;
  this.foodPrice = argfoodPrice;
  this.vendorId = argvendorId;
  this.imageUrl=imag;
}




  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.foodId)
        && Objects.equals(foodName, menu.foodName)
        && Objects.equals(foodQuantity, menu.foodQuantity)
        && Objects.equals(foodPrice, menu.foodPrice)
        && Objects.equals(vendorId, menu.vendorId)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(foodId, foodName, foodQuantity, foodPrice, vendorId);
  }
    /**
     * @return this food ID.
     */
  public final int getFoodId() {
    return foodId;
  }



     /**
     * @return this food Name.
     */
  public final String getFoodName() {
    return foodName;
  }
    /**
     * @param argFoodId gets the food id.
     */
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }
      /**
     * @param argFoodName gets the food Name.
     */
  public final void setFoodName(final String argFoodName) {
    this.foodName = argFoodName;
  }
       /**
     * @return this food Qty.
     */
  public final int getFoodQuantity() {
    return foodQuantity;
  }


    /**
     * @param argFoodQuantity gets the food Quantity.
     */
  public final void setFoodQuantity(final int  argFoodQuantity) {
    this.foodQuantity = argFoodQuantity;
  }




        /**
     * @return this food Price.
     */
  public final double getFoodPrice() {
    return foodPrice;
  }
     /**
     * @param argFoodPrice gets the food price.
     */
  public final void setFoodPrice(final double argFoodPrice) {
    this.foodPrice = argFoodPrice;
  }



       /**
     * @return this vendor ID.
     */
    public final int getVendorId() {
      return vendorId;
    }



      /**
       * @param argVendorId gets the food id.
       */
    public final void setVendorId(final int argVendorId) {
      this.vendorId = argVendorId;
    }



       /**
     * @return this vendor ID.
     */
    public final String getImage() {
      return imageUrl;
    }



      /**
       * @param argVendorId gets the food id.
       */
    public final void setImage(final String img) {
      this.imageUrl = img;
    }


}


// https://www.journaldev.com/44618/java-sql-Blob