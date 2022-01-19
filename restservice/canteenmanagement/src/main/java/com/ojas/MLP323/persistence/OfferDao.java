package com.ojas.MLP323.persistence;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.ojas.MLP323.model.Offers;

import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Bind;


import java.util.List;



/**
 * OffersDAO class used to fetch data from data base.
 * @author hexware
 */
public interface OfferDao {
  /**
    * @return the all the Offers record.
    */
  @SqlQuery("Select * from mlp323.offers")
  @Mapper(OfferMapper.class)
  List<Offers> displayAllOffers();


  /**
    * @return the all the Offers record.
    * @param i givens i
    */
  @SqlQuery("Select * from Offers where vendorid = :b")
  @Mapper(OfferMapper.class)
  List<Offers> offersByVendorId(@Bind("b") int i);



   /**
     * @param foodId gets the foodId.
     * @return the Offers record with this foodId.
     */
  @SqlQuery("Select * from mlp323.Offers where id=:id")
  @Mapper(OfferMapper.class)
  Offers offersByOfferId(@Bind("id")int id);



   /**
     * @param foodId gets the foodId.
     * @return the Offers record with this foodId.
     */
  @SqlQuery("Select * from mlp323.Offers where name=:name")
  @Mapper(OfferMapper.class)
  Offers offersPresent(@Bind("name")String id);





   /**
     * @param foodId to initialize foodId.
     * @param foodName to initialize foodName.
     * @param foodQty to initialize foodQty.
     * @param foodPrice to initialize foodPrice.
     * @param vendorId to initialize vendor id.
     * @return a new record.
     */
  @SqlUpdate("INSERT INTO `mlp323`.`offers` (`id`, `name`, `share`, `message`, `vendorid`) VALUES (:id,:name,:share,:message,:vendor)")
  int createOffersItem(@Bind("id")int id,
        @Bind("name")String name,
        @Bind("share")Double shares,
        @Bind("message")String message,
        @Bind("vendor")int vendorId);





  /**
    * Delete the food item.
    * @param foodId to initialize the foodId.
    * @return result.
    */
  @SqlUpdate("delete from mlp323.Offers  where id = :fid")
  @Mapper(OfferMapper.class)
  int deleteByOfferId(@Bind("fid")int id);


    /**
   * getting last id
   */
  @SqlQuery("select id from mlp323.Offers order by id desc limit 1")
  int lastId();

}

