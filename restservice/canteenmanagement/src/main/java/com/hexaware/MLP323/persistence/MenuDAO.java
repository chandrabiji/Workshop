package com.hexaware.MLP323.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Bind;


import java.util.List;

import com.hexaware.MLP323.model.Menu;


/**
 * Functionalities
 * 1. add items
 * 2. view items
 * 3. view all items
 * 4. update items
 * 5. delet items
 *
 */
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface MenuDAO {
  /**
    * @return the all the Menu record.
    */
  @SqlQuery("Select * from mlp323.Menu")
  @Mapper(MenuMapper.class)
  List<Menu> displayAllMenu();


  /**
    * @return the all the Menu record.
    * @param i givens i
    */
  @SqlQuery("Select * from Menu where VENDOR_ID = :b")
  @Mapper(MenuMapper.class)
  List<Menu> disp(@Bind("b") int i);



   /**
     * @param foodId gets the foodId.
     * @return the Menu record with this foodId.
     */
  @SqlQuery("Select * from mlp323.menu where FOOD_ID=:id")
  @Mapper(MenuMapper.class)
  Menu displayMenuByFoodId(@Bind("id")int foodId);



   /**
     * @param foodId gets the foodId.
     * @return the Menu record with this foodId.
     */
  @SqlQuery("Select count(*) from mlp323.menu where FOOD_ID=:id")
  int menuPresent(@Bind("id")int foodId);





   /**
     * @param foodId to initialize foodId.
     * @param foodName to initialize foodName.
     * @param foodQty to initialize foodQty.
     * @param foodPrice to initialize foodPrice.
     * @param vendorId to initialize vendor id.
     * @return a new record.
     */
  @SqlUpdate("insert into mlp323.menu(FOOD_ID, FOOD_NAME, FOOD_QUANTITY, FOOD_PRICE, VENDOR_ID,IMAGE_PATH) values(:id, :name, :qty, :price, :vid, :imgPath)")
  @Mapper(MenuMapper.class)
  int createMenuItem(@Bind("id")int foodId,
        @Bind("name")String foodName,
        @Bind("qty")int foodQty,
        @Bind("price")double foodPrice,
        @Bind("vid")int vendorId,
        @Bind("imgPath")String path
        );


  /**
   *
   * @param foodId gives foodId
   * @param foodName gives foodName
   * @param foodQty gives foodQty
   * @param foodPrice gives foodPrice
   * @param vendorId gives vendorId
   * @return int
   */


  // https://www.informit.com/articles/article.aspx?p=25280#:~:text=To%20insert%20images%20into%20a%20database%2C%20the%20database%20must%20support,SQL3%20for%20storing%20binary%20data.


  @SqlUpdate("update mlp323.menu set FOOD_NAME = :name, FOOD_QUANTITY= :qty, FOOD_PRICE= :price, VENDOR_ID= :vid where FOOD_ID = :id")
  int updateMenuItem(@Bind("id")int foodId,
        @Bind("name")String foodName,
        @Bind("qty")int foodQty,
        @Bind("price")double foodPrice,
        @Bind("vid")int vendorId);

  /**
    * Delete the food item.
    * @param foodId to initialize the foodId.
    * @return result.
    */
  @SqlUpdate("delete from mlp323.menu  where FOOD_ID = :fid")
  @Mapper(MenuMapper.class)
  int deleteFoodItemByFoodId(@Bind("fid")int foodId);

  /**
    * Update the food Quantity.
    * @param foodId to initialize foodId.
    * @param foodQty to initialize foodQty.
    @return int
    */
  @SqlUpdate("update mlp323.menu set FOOD_QUANTITY= :foodQty where FOOD_ID= :foodId")
  @Mapper(MenuMapper.class)
   int updateFoodQuantity(@Bind("foodId")int foodId, @Bind("foodQty")int foodQty);


    /**
   * getting last id
   */
  @SqlQuery("select food_id from mlp323.menu order by food_id desc limit 1")
  int lastId();

}
