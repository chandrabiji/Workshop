package com.ojas.MLP323.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.ojas.MLP323.model.Bill;

import org.skife.jdbi.v2.StatementContext;
/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class BillMapper implements ResultSetMapper<Bill> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped Bill object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Bill map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Menu
       */
    return new Bill(rs.getString("cartid"),
    rs.getInt("customerid"),
    rs.getInt("itemcount"),
    rs.getDouble("totalamount"),
    rs.getString("discount"),
    rs.getString("status"),
    rs.getString("comment")
    );

  }
}
