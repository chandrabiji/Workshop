package com.ojas.MLP323.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.ojas.MLP323.model.Vendor;

import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;

import org.skife.jdbi.v2.sqlobject.SqlUpdate;
// import com.hexaware.MLP323.model.Menu;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface VendorDAO {
  /**
   * @return the all the Vendor record.
   */
  @SqlQuery("Select * from vendor")
  @Mapper(VendorMapper.class)
  List<Vendor> showAllVendorList();



  /**
   * @param vendorId gets the vendorId.
   * @return the Vendor record with this vendorId.
   */
  @SqlQuery("Select * from mlp323.vendor where VENDOR_ID=:id")
  @Mapper(VendorMapper.class)
  Vendor displayVendorByVendorId(@Bind("id")int vendorId);
  /**
   * @param vendorEmail to initialize vendor email.
   * @param vendorPassword to initialize vendor password.
   * @return vendor object.
   */
  @SqlQuery("Select vendor_id from mlp323.vendor where VENDOR_EMAIL= :vendorEmail  AND VENDOR_PASSWORD = :vendorPassword")
  int checkVendorLogin(@Bind("vendorEmail")String vendorEmail, @Bind("vendorPassword")String vendorPassword);
  /**
   * Insert new vendor.
   * @param vendorId to initialize vendor id.
   * @param vendorName to initialize vendorName.
   * @param vendorEmail to initialize vendorEmail.
   * @param vendorPhoneNo to initialize vendorPhoneNo.
   * @param vendorAddress to initialize vendorAddress.
   * @param vendorPassword to initialize vendorPassword.
   * @return new vendor record.
   */
  @SqlUpdate("insert into mlp323.vendor(VENDOR_ID,VENDOR_NAME, VENDOR_EMAIL,VENDOR_CONTACT, VENDOR_ADDRESS, VENDOR_PASSWORD,VENDOR_RATINGS)"
        +
        " values (:id, :name, :email, :phoneno,  :address,:password,:ratings)")
  @Mapper(VendorMapper.class)
  int createNewVendorRecord(@Bind("id")int vendorId,
        @Bind("name")String vendorName,
        @Bind("email")String vendorEmail,
        @Bind("phoneno")String vendorPhoneNo,
        @Bind("password")String vendorPassword,
        @Bind("address")String vendorAddress,
        @Bind("ratings") double rat);



  /**
   * Update the vendor details.
   * @param vendor to initialize Vendor object.
   * @return the updated vendor.
   */
  @SqlUpdate("update mlp323.vendor set VENDOR_NAME =:vendor.vendorName, VENDOR_EMAIL=:vendor.vendorEmail,"
        +
        " VENDOR_CONTACT=:vendor.vendorContactNo, VENDOR_ADDRESS=:vendor.vendorAddress,"
        +
        " VENDOR_PASSWORD =:vendor.vendorPassword where VENDOR_ID=:vendor.vendorId")
  @Mapper(VendorMapper.class)
  int updateVendorDetails(@BindBean ("vendor")Vendor vendor);
  /**
   * Delete the vendor.
   * @param vendorId to initialize the vendorId.
   * @return result.
   */
  @SqlUpdate("delete from mlp323.vendor  where VENDOR_ID = :vid")
  @Mapper(VendorMapper.class)
  int deleteVendorRecord(@Bind("vid")int vendorId);

  /**
   *
   * @param customerId takes id
   * @return int
   */
  @SqlQuery("select count(*) from mlp323.vendor where vendor_id=:cid")
    int checkUserIdExist(@Bind("cid")int customerId);


  @SqlQuery("select vendor_id from mlp323.vendor order by vendor_id desc limit 1")
  int lastId();

  /**
   * getting email present
   */
  @SqlQuery("select count(*) from mlp323.vendor where VENDOR_EMAIL=:email")
  int isEmailPresent(@Bind("email") String email);



   /**
   *
   * @param vendorId takes id
   * @return int
   */
  @SqlQuery("select VENDOR_RATINGS from mlp323.vendor where vendor_id=:cid")
  double getVendorRatings(@Bind("cid")int vendorId);

  /**
   *
   * @param vendorId takes id
   * @return int
   */
  @SqlQuery("UPDATE `mlp323`.`vendor` SET `VENDOR_RATINGS` = :data WHERE (`VENDOR_ID` = :cid)")
    int updateVendorRatings(@Bind("cid")int vendorId,@Bind("data")double ratings);


  @SqlUpdate("UPDATE `mlp323`.`vendor` SET `VENDOR_PASSWORD` = :pass WHERE (`VENDOR_EMAIL` = :email)")
  int updatePassword(@Bind("email")String email, @Bind("pass") String pass);

}
