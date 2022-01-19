<<<<<<< HEAD
package com.ojas.MLP323;
import com.ojas.MLP323.factory.MenuFactory;
import com.ojas.MLP323.model.Menu;
import com.ojas.MLP323.persistence.MenuDAO;

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
/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class MenuTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testMenu() {
    System.out.println("Testing Menu Items...");
    Menu m = new Menu();
    Menu m100 = new Menu(100);
    Menu m101 = new Menu(101);

    assertNotEquals(m100, null);
    assertNotEquals(m101, null);

    assertEquals(m100.getFoodId(),
        new Menu(100).getFoodId());

        m101.setFoodId(100);
        m101.setFoodName("aaa");
        m101.setFoodQuantity(100);
        m101.setFoodPrice(100);
        m101.setVendorId(100);

    assertNotEquals(m101, new Menu(101));
    assertEquals(m100.hashCode(),
        new Menu(100).hashCode());
    assertEquals(m100, new Menu(100));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testshowFullMenuu(@Mocked final MenuDAO dao) {

    final ArrayList<Menu> res=new ArrayList<Menu>();
    res.add(new Menu(1011, "ABC", 10, 100,1));
    new Expectations() {
      {
        dao.displayAllMenu();
        result = 1;
        minTimes=0;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    try{
    Menu[] me = MenuFactory.showFullMenuu();

    System.out.println("Checking ShowFullMenuu ...");

    assertEquals(6,me.length);
    }
    catch(Exception e){
      System.out.println("Error");
    }
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testmenuItemByFoodId(@Mocked final MenuDAO dao) {
    final Menu m100 = new Menu(100);
    final Menu m101 = new Menu(101);
    final ArrayList<Menu> mn = new ArrayList<Menu>();
    mn.add(m100);
    mn.add(m101);
    //final MenuFactory obj = new MenuFactory();
    new Expectations() {
      {

        dao.displayAllMenu();
        result = mn;
        minTimes=0;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] mn1 = MenuFactory.showFullMenuu();
    System.out.println("Menu ITem By Food Id  :");
    assertEquals(2, mn1.length);
    assertEquals(new Menu(100).getFoodId(),
        mn1[0].getFoodId());
    assertEquals(new Menu(101).getFoodId(),
        mn1[1].getFoodId());
  }
  @Test
  public final void testmenuPresent(@Mocked final MenuDAO dao) {
    final Menu m100 = new Menu(100);
    final Menu m101 = new Menu(101);
    final ArrayList<Menu> mn = new ArrayList<Menu>();

    new Expectations() {
      {
        mn.add(m100);
        mn.add(m101);
        dao.displayAllMenu();
        result = mn;
        minTimes=0;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] mn1 = MenuFactory.showFullMenuu();
    assertEquals(2, mn1.length);
    assertEquals(new Menu(100).getFoodId(),
        mn1[0].getFoodId());
    assertEquals(new Menu(101).getFoodId(),
        mn1[1].getFoodId());
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testcreateMenuItem(@Mocked final MenuDAO dao) {
   final Menu m100= new Menu(101,"upma",30,10,1);
   new Expectations() {
    {
    dao.createMenuItem(m100.getFoodId(),m100.getFoodName(),m100.getFoodQuantity(),m100.getFoodPrice(),m100.getVendorId());
    result=1;
    minTimes=0;
   }};
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    boolean n= MenuFactory.createMenuItem(new Menu(101,"upma",30,10,1));
    assertEquals(true,n);
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testupdateMenu(@Mocked final MenuDAO dao) {
    assertEquals(true, MenuFactory.updateMenu(new Menu(101, "idli-dosa", 40, 75258.0, 1)));
  }
  @Test
  public final void testdeleteMenu(@Mocked final MenuDAO dao) {
    new Expectations() {{
      dao.deleteFoodItemByFoodId(108);
      result=1;
       minTimes=0;
    }};
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
      return dao;
    }
  };
  assertEquals(true,MenuFactory.deleteMenu(108));
  }

 @Test
  public final void testupdateQuantity(@Mocked final MenuDAO dao) {
    new Expectations() {
          {
            ArrayList<Menu> list = new ArrayList<Menu>();
            dao.updateFoodQuantity(101,12 );
            result=1;
            // minTimes=0;
        }
      };
    new MockUp<MenuFactory>() {
          @Mock
          MenuDAO dao() {
          return dao;
        }
      };

    assertEquals(true, MenuFactory.updateQuantity(101, 12));
  }

}
=======
package com.ojas.MLP323;
import com.ojas.MLP323.factory.MenuFactory;
import com.ojas.MLP323.model.Menu;
import com.ojas.MLP323.persistence.MenuDAO;

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
/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class MenuTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testMenu() {
    System.out.println("Testing Menu Items...");
    Menu m = new Menu();
    Menu m100 = new Menu(100);
    Menu m101 = new Menu(101);

    assertNotEquals(m100, null);
    assertNotEquals(m101, null);

    assertEquals(m100.getFoodId(),
        new Menu(100).getFoodId());

        m101.setFoodId(100);
        m101.setFoodName("aaa");
        m101.setFoodQuantity(100);
        m101.setFoodPrice(100);
        m101.setVendorId(100);

    assertNotEquals(m101, new Menu(101));
    assertEquals(m100.hashCode(),
        new Menu(100).hashCode());
    assertEquals(m100, new Menu(100));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testshowFullMenuu(@Mocked final MenuDAO dao) {

    final ArrayList<Menu> res=new ArrayList<Menu>();
    res.add(new Menu(1011, "ABC", 10, 100,1));
    new Expectations() {
      {
        dao.displayAllMenu();
        result = 1;
        minTimes=0;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    try{
    Menu[] me = MenuFactory.showFullMenuu();

    System.out.println("Checking ShowFullMenuu ...");

    assertEquals(6,me.length);
    }
    catch(Exception e){
      System.out.println("Error");
    }
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testmenuItemByFoodId(@Mocked final MenuDAO dao) {
    final Menu m100 = new Menu(100);
    final Menu m101 = new Menu(101);
    final ArrayList<Menu> mn = new ArrayList<Menu>();
    mn.add(m100);
    mn.add(m101);
    //final MenuFactory obj = new MenuFactory();
    new Expectations() {
      {

        dao.displayAllMenu();
        result = mn;
        minTimes=0;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] mn1 = MenuFactory.showFullMenuu();
    System.out.println("Menu ITem By Food Id  :");
    assertEquals(2, mn1.length);
    assertEquals(new Menu(100).getFoodId(),
        mn1[0].getFoodId());
    assertEquals(new Menu(101).getFoodId(),
        mn1[1].getFoodId());
  }
  @Test
  public final void testmenuPresent(@Mocked final MenuDAO dao) {
    final Menu m100 = new Menu(100);
    final Menu m101 = new Menu(101);
    final ArrayList<Menu> mn = new ArrayList<Menu>();

    new Expectations() {
      {
        mn.add(m100);
        mn.add(m101);
        dao.displayAllMenu();
        result = mn;
        minTimes=0;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] mn1 = MenuFactory.showFullMenuu();
    assertEquals(2, mn1.length);
    assertEquals(new Menu(100).getFoodId(),
        mn1[0].getFoodId());
    assertEquals(new Menu(101).getFoodId(),
        mn1[1].getFoodId());
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testcreateMenuItem(@Mocked final MenuDAO dao) {
   final Menu m100= new Menu(101,"upma",30,10,1);
   new Expectations() {
    {
    dao.createMenuItem(m100.getFoodId(),m100.getFoodName(),m100.getFoodQuantity(),m100.getFoodPrice(),m100.getVendorId());
    result=1;
    minTimes=0;
   }};
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    boolean n= MenuFactory.createMenuItem(new Menu(101,"upma",30,10,1));
    assertEquals(true,n);
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testupdateMenu(@Mocked final MenuDAO dao) {
    assertEquals(true, MenuFactory.updateMenu(new Menu(101, "idli-dosa", 40, 75258.0, 1)));
  }
  @Test
  public final void testdeleteMenu(@Mocked final MenuDAO dao) {
    new Expectations() {{
      dao.deleteFoodItemByFoodId(108);
      result=1;
       minTimes=0;
    }};
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
      return dao;
    }
  };
  assertEquals(true,MenuFactory.deleteMenu(108));
  }

 @Test
  public final void testupdateQuantity(@Mocked final MenuDAO dao) {
    new Expectations() {
          {
            ArrayList<Menu> list = new ArrayList<Menu>();
            dao.updateFoodQuantity(101,12 );
            result=1;
            // minTimes=0;
        }
      };
    new MockUp<MenuFactory>() {
          @Mock
          MenuDAO dao() {
          return dao;
        }
      };

    assertEquals(true, MenuFactory.updateQuantity(101, 12));
  }

}
>>>>>>> branch 'master' of https://github.com/chandrabiji/Workshop
