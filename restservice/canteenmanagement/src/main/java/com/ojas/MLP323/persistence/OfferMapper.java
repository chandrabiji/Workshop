package com.ojas.MLP323.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.ojas.MLP323.model.Offers;

import org.skife.jdbi.v2.StatementContext;
/**
 * OffersMapper class used to fetch Offers data from database.
 * @author hexware
 */
public class OfferMapper implements ResultSetMapper<Offers> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Offers map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Offers
       */
    return new Offers(rs.getInt("id"), rs.getString("name"), rs.getDouble("share"),rs.getString("message"),rs.getInt("vendorId"));
    // return new Offers(rs.getInt("food_id"),rs.getString("food_name"));
  }
}
