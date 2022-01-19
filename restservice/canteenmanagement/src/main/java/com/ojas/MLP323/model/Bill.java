package com.ojas.MLP323.model;

import java.util.Objects;

/**
 * Bill class used to display menu information.
 * @author hexware
 */
public class Bill {

    /**
     * cartId to store cartId.
     */
  private String cartId;
    /**
     * customerId to customerId.
     */
  private int customerId;
    /**
     * itemCount to itemCount.
     */
  private int itemCount;
    /**
     * foodId to store foodId.
     */
  private double totalAmount;
    /**
     * foodId to store foodId.
     */
  private String discount;
    /**
     * foodId to store foodId.
     */
  private String status;
    /**
     * foodId to store foodId.
     */
  private String comment;
/**
   * Default Constructor.
   */
  public Bill() {
  }
 /**
     * @param a to initialize food id.
     *  @param b to initialize food name.
     *  @param c to initialize food qty.
     *  @param d to initialize food price.
     *  @param e to initialize vendor id.
     *  @param f to initialize vendor id.
     *  @param g to initialize vendor id.
     * used to get details through constructor.
     **/



    public Bill(final String a,
    final int b,
    final int c,
    final double d,
    final String e,
    final String f,
    final String g) {
  this.cartId = a;
  this.customerId = b;
  this.itemCount = c;
  this.totalAmount = d;
  this.discount = e;
  this.status = f;
  this.comment = g;
}

public Bill(final String a) {
    this.cartId = a;
}

  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Bill bill = (Bill) o;
      return (boolean)(customerId == bill.customerId &&
              itemCount == bill.itemCount &&
              (int)totalAmount == (int)bill.totalAmount &&
              Objects.equals(cartId, bill.cartId) &&
              Objects.equals(discount, bill.discount) &&
              Objects.equals(status, bill.status) &&
              Objects.equals(comment, bill.comment));
  }

  @Override
  public final int hashCode() {
    return Objects.hash(cartId, customerId, itemCount, totalAmount, discount, status, comment);
  }

    /**
     * @return this food ID.
     */

  public final String getCartId() {
    return cartId;
  }

    /**
     *
     * @param a for id
     */
  public final void setCartId(final String a) {
    this.cartId = a;
  }
    /**
     * @return this food ID.
     */
  public final int getCustomerId() {
    return customerId;
  }

    /**
     *
     * @param a for cust id
     */
  public final void setCustomerId(final int a) {
    this.customerId = a;
  }
    /**
     * @return this food ID.
     */
  public final int getItemCount() {
    return itemCount;
  }
/**
 *
 * @param a for item count
 */
  public final void setItemCount(final int a) {
    this.itemCount = a;
  }
    /**
     * @return this amount.
     */
  public final double getTotalAmount() {
    return totalAmount;
  }
/**
 *
 * @param a for total amount
 */
  public final void setTotalAmount(final double a) {
    this.totalAmount = a;
  }

    /**
     * @return Discount
     */
  public final String getDiscount() {
    return discount;
  }

    /**
     *
     * @param a for discount
     */
  public final void setDiscount(final String a) {
    this.discount = a;
  }

    /**
     * @return this getStatus.
     */
  public final String getStatus() {
    return status;
  }

    /**
     *
     * @param a  for status
     */
  public final void setStatus(final String a) {
    this.status = a;
  }

    /**
     * @return this getComment.
     */
  public final String getComment() {
    return comment;
  }

    /**
     *
     * @param a for comment
     */
  public final void setComment(final String a) {
    this.comment = a;
  }


}
