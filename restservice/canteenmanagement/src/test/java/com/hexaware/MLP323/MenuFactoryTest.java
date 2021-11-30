package com.hexaware.MLP323;
import com.hexaware.MLP323.factory.MenuFactory;
import com.hexaware.MLP323.model.Menu;
import com.hexaware.MLP323.persistence.MenuDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;

@RunWith(JMockit.class)
public class MenuFactoryTest {


@Before
public void initInput(){

 }
/**
 * test for constructor
 */
@Test
public final void testConstructor(){
 final MenuFactory exp = new MenuFactory();
 assertNotEquals(exp,null);
}
/**
   * Tests the showfullMenu method of the Menu class.
*/

@Test
public final void testshowFullMenuu(@Mocked final MenuDAO dao) {
final ArrayList<Menu> exp = new ArrayList<Menu>();
exp.add(new Menu(100,"dosa",10,150,202));
exp.add(new Menu(101,"dosa",10,150,202));
exp.add(new Menu(102,"dosa",10,150,202));
exp.add(new Menu(103,"dosa",10,150,202));


new Expectations()
{{
   System.out.println("Mocked full Menu Object");
   dao.displayAllMenu();
   result = exp;
}};
new MockUp<MenuFactory>(){
  @Mock
  MenuDAO dao(){
    System.out.println("Mocked dao for full Menu");
    return dao;
  }
};
Menu[] list = MenuFactory.showFullMenuu();
ArrayList<Menu> act = new ArrayList<Menu>();
for(Menu m:list)
{
  act.add(m);
  System.out.println("Testing Menu  :"+m.getFoodId());
}
assertEquals(exp,act);
}
/**
   * Tests the showcustomer method of the Menu class.
*/

@Test
public void testmenuItemByFoodId(@Mocked final MenuDAO dao){
final Menu menu = new Menu(101,"chapathi",11,160,203);
new Expectations()
{{
   System.out.println("Mocked full Menu Object");
   dao.displayMenuByFoodId(101);
   result = menu;
}};
new MockUp<MenuFactory>(){
    @Mock
    MenuDAO dao(){
      System.out.println("Mocked dao for Menu by Id");
      return dao;
    }
  };
Menu menu1 = MenuFactory.menuItemByFoodId(101);

assertEquals(menu.hashCode(),menu1.hashCode());
}
/**
   * Tests the showcustomer method of the Menu class.
*/
@Test
public void testmenuPresent(@Mocked final MenuDAO dao){
final Menu menu = new Menu(112,"chapathi",11,160.0,1);
new Expectations(){
    {
    System.out.println("Mocked full Menu Object");
    dao.menuPresent(101);
    result = 1;
    }
};
new MockUp<MenuFactory>(){
    @Mock
    MenuDAO dao(){
      System.out.println("Mocked dao for Menu by Id");
      return dao;
    }
  };
boolean menu1 = MenuFactory.menuPresent(101);
System.out.println("Checking Menu Present :");
assertEquals(true,menu1);
}
/**
   * Tests the createmenuitem method of the Menu class.
*/
@Test
public void testcreateMenuItem() {
  boolean result = MenuFactory.createMenuItem(new Menu(110,"sambar110",12,170.0,1));
    assertEquals(true,result);
}
/**
   * Tests the update method of the Menu class.
*/
@Test
public void testupdateMenu(){
  System.out.println("Updating Menu");
  Menu menu = new Menu(103,"idly",13,180,1);
  boolean result = MenuFactory.updateMenu(menu);
 assertEquals(true,result);
}
/**
   * Tests the Delete method of the Menu class.
*/
@Test
public void testdeleteMenu(){
  System.out.println("Delete Menu");
  if(MenuFactory.createMenuItem(new Menu(1001,"ABC",120,1452.0,1))){
      System.out.println("Inserted for Deletion...");
      boolean result = MenuFactory.deleteMenu(1001);
    assertEquals(true,result);
  }
  else{
      System.out.println("Not inserted...");
  }

}
/**
   * Tests the updatequantity method of the Menu class.
*/
@Test
public void testupdateQuantity(){
  System.out.println("Updating Quantity");
  boolean result = MenuFactory.updateQuantity(101,3000);
 assertEquals(true,result);
}
}