package com.ojas.MLP323.factory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
// import java.io.InputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import com.ojas.MLP323.model.Menu;
import com.ojas.MLP323.persistence.DbConnection;
import com.ojas.MLP323.persistence.MenuDAO;
/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class MenuFactory {
  /**
   *  Protected constructor.
   */
  public MenuFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static MenuDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(MenuDAO.class);
  }


  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Menu[] showFullMenuu() {

    List<Menu> menu = dao().displayAllMenu();
    return menu.toArray(new Menu[menu.size()]);
  }

  /**
   * Call the data base connection.
   * @return the array of menu object.
   * @param i givens i
   */
  public static Menu[] showFullMenuuVend(final int i) {

    List<Menu> menu = dao().disp(i);
    return menu.toArray(new Menu[menu.size()]);
  }

  /**
   * Call the DisplayMenuByFoodId from menuDAO.
   * @return the menu object.
   * @param id is food id
   */
  public static Menu menuItemByFoodId(final int id) {
    Menu menu = dao().displayMenuByFoodId(id);
    return menu;
  }

  /**
   * Call the MenuPresent from menuDAO.
   * @return the Boolean Value.
   * @param id is food id.
   */
  public static boolean menuPresent(final int id) {
    int result = dao().menuPresent(id);
    if (result >= 1) {
      return true;
    }
    return false;

  }




  /**
   * Call the CreateMenuItem from menuDAO.
   * @return the Boolean Value.
   * @param m takes menu object.
   */
  public static boolean createMenuItem(final Menu m) {

    // if(m.getFoodImage()!=null)
    // m.setFoodImage(compressBytes(m.getFoodImage()));

    int result = dao().createMenuItem(m.getFoodId(),
        m.getFoodName(),
        m.getFoodQuantity(),
        m.getFoodPrice(),
        m.getVendorId(),
        m.getImage());
    if (result >= 1) {
      return true;
    }
    return false;
  }





  public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
          System.out.println("error");
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
      System.out.println("error");

		} catch (DataFormatException e) {
          System.out.println("error");

		}
		return outputStream.toByteArray();
	}

  /**
   * Call the UpdateMenuItem from menuDAO.
   * @return the Boolean Value.
   * @param m is menu object.
   */
  public static boolean updateMenu(final Menu m) {
    int result = dao().updateMenuItem(m.getFoodId(),
          m.getFoodName(),
          m.getFoodQuantity(),
          m.getFoodPrice(),
          m.getVendorId());
    if (result >= 1) {
      return true;
    }
    return false;
  }

  /**
   * Call the UpdateMenuItem from menuDAO.
   * @return the Boolean Value.
   * @param id takes food id.
   */
  public static boolean deleteMenu(final int id) {
    int result = dao().deleteFoodItemByFoodId(id);
    if (result >= 1) {
      return true;
    }
    return false;
  }


  /**
   * Call the UpdateMenuItemQuantity from menuDAO.
   * @return the Boolean Value.
   * @param id takes food id.
   * @param foodQty takes food quanti.
   */
  public static boolean updateQuantity(final int id, final int foodQty) {
    int result = dao().updateFoodQuantity(id, foodQty);
    if (result >= 1) {
      return true;
    }
    return false;
  }



  /***
   * getting last inserted record id
   * @param id
   * @return
   */

  public static int getLastId() {
    return dao().lastId();
    }

}
