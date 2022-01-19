package com.ojas.MLP323.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.ojas.MLP323.model.Customer;

import org.skife.jdbi.v2.StatementContext;
/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class CustomerMapper implements ResultSetMapper<Customer> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Customer map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Menu
       */
    return new Customer(rs.getInt("cust_id"),
    rs.getString("cust_name"),
    rs.getString("cust_email"),
    rs.getString("cust_address"),
    rs.getString("cust_mobileno"),
    rs.getString("cust_password"),
    rs.getString("cust_wallet_name"),
    rs.getInt("cust_wallet_amount")
    );

  }
}
