package com.ojas.MLP323.util;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ojas.MLP323.factory.MenuFactory;
import com.ojas.MLP323.model.Menu;




/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/menu")
public class MenuRest {
  /**
   * Returns Menu details.
   * @return the menu details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list")
  public final Menu[] listMenu() {
    final Menu[] menu = MenuFactory.showFullMenuu();
    return menu;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/menubyvendid/{vendid}")
  public final Menu[] showMenuByVenId(@PathParam("vendid") int vendid){
    return MenuFactory.showFullMenuuVend(vendid);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/showmenubyfoodid/{foodid}")
  public final Menu showMenuItemsByFoodId(@PathParam("foodid") int foodid){
    Menu menu = MenuFactory.menuItemByFoodId(foodid);
    return menu;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/menuPresent/{foodid}")
  public static boolean menuPresent(@PathParam("foodid")int id) {
    return MenuFactory.menuPresent(id);
  }



  @POST
  @Path("/createMenu")
  public static boolean createMenuItem(Menu m) {
    return MenuFactory.createMenuItem(m);
  }


  @PUT
  @Path("/updateMenu")
  public static boolean updateMenu(Menu m) {

    return MenuFactory.updateMenu(m);

  }


  @DELETE
  @Path("/deleteItem/{foodId}")
  public static boolean deleteMenu(@PathParam("foodId") int id) {
    return MenuFactory.deleteMenu(id);
  }


  @GET
  @Path("/getnextId")
  public static int last() {
    return (MenuFactory.getLastId()+1);
  }


}
