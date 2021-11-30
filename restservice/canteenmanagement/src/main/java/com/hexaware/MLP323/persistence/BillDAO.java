package com.hexaware.MLP323.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Bind;
import com.hexaware.MLP323.model.Bill;
import java.util.List;


/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface BillDAO {
  /**
  * @return the all the Bill record.
  */
  @SqlQuery("Select * from bills")
  @Mapper(BillMapper.class)
  List<Bill> showAllBills();
 /**
  * @param bill gets the BillId.
  * @return the Bill record with this BillId.
  */
  @SqlQuery("Select * from mlp323.Bills where cartid= :id")
  @Mapper(BillMapper.class)
  Bill getBillsbyCartId(@Bind("id") String bill);
/**
  * @param bill gets the BillId.
  * @return the Bill record with this BillId.
  */
  @SqlQuery("Select * from mlp323.Bills where customerid= :id")
  @Mapper(BillMapper.class)
  List<Bill> getBillsbyCustId(@Bind("id") int bill);



  /**
  * @param id gets the BillId.
  * @return the Bill record with this BillId.
  */
  @SqlQuery("Select distinct count(*) from mlp323.Bills where customerid= :id")
  int getCount(@Bind("id") int id);



  /***
   *
   * @param id takes id
   * @param custid takes custid
   * @param itemcount takes itemcount
   * @param amount takes amount
   * @param dis takes dis
   * @param status takes status
   * @param comment takes comment
   * @return boolean value
   */

  @SqlUpdate("INSERT INTO `mlp323`.`bills` "
        +
        "(`cartid`, `customerid`, `itemcount`, `totalamount`, `discount`, `status`, `comment`)"
        +
        " VALUES (:cartId, :customerid, :itemcount, :totalamount, :discount, :status ,:comment)")
  @Mapper(BillMapper.class)
  int insertBill(@Bind("cartId") String id,
      @Bind("customerid") int custid,
      @Bind("itemcount") int itemcount,
      @Bind("totalamount") double amount,
      @Bind("discount") String dis,
      @Bind("status") String status,
      @Bind("comment") String comment);



      @SqlQuery("select count(*) from `mlp323`.`bills` where discount =:offer and customerid=:id")
      int checkOfferCount(@Bind("id") int id,@Bind("offer")String offer);

}
