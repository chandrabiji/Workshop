package com.hexaware.MLP323.util;
import java.util.Scanner;

import com.hexaware.MLP323.factory.BillFactory;
import com.hexaware.MLP323.factory.CustomerFactory;
import com.hexaware.MLP323.factory.MenuFactory;
import com.hexaware.MLP323.factory.OrderFactory;
import com.hexaware.MLP323.factory.VendorFactory;
import com.hexaware.MLP323.model.Customer;
import com.hexaware.MLP323.model.Menu;
import com.hexaware.MLP323.model.Order;
import com.hexaware.MLP323.model.Vendor;
// import java.lang.Integer;
import com.hexaware.MLP323.model.Bill;

/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
public class CliMain {
  private Scanner sc = new Scanner(System.in, "UTF-8");
  /**
   * login variables.
   */
  private Customer currentUser = null;
  /**
   * login variable for vendor.
   */
  private Vendor currentVendor = null;


  /**
   * main method  is the basic entry point for the application.
   * @param args used to get the user input.
   */
  public static void main(final String[] args) {
    CliMain mainObj = new CliMain();
    mainObj.mainMenuUsers();
  }

  /**
  * MainMenuUsers method  used to display the option we had in the application.
  */
  private void mainMenuUsers() {
    System.out.println();
    System.out.println("|-------------------- Canteen Management System -------------------|");
    System.out.println("|------------------------------------------------------------------|");
    System.out.println("|  1. Vendor                                                       |");
    System.out.println("|  2. Customer                                                     |");
    System.out.println("|  3. Admin                                                        |");
    System.out.println("|  4. Exit                                                         |");
    System.out.println("-------------------------------------------------------------------|");
    mainMenuUsersDetails();
  }
  /**
   * MainMenuUsersDetails method  process the option selected from main menu.
   */
  private void mainMenuUsersDetails() {
    try {
      System.out.print("Enter your choice:");
      int menuOption = sc.nextInt();
      switch (menuOption) {
        case 1:
          if (currentVendor == null) {
            vendorLogin();
          } else {
            vendorMainMenuUsers();
          }
          break;
        case 2:
          if (currentUser == null) {
            customerLoginCred();
          } else {
            customerMainMenuUsers();
          }
          break;
        case 3:
          adminLogin();
          break;

        case 4:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose either 1 or 2 or 3 or 4");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    sc.nextLine();
    mainMenuUsers();
  }

  /**
   *  vendor login method.
   */

  public final void vendorLogin() {
    System.out.print("Vendor Username :");
    String vendorName = sc.next();
    System.out.print("Vendor Password :");
    String vendorPassword = sc.next();

    int currentVendorId = VendorFactory.loginVendor(vendorName, vendorPassword);
    Vendor vg = null;
    vg = VendorFactory.displayVendorByVendorId(currentVendorId);

    if (vg != null) {
      System.out.println("Login successfull");
      currentVendor = vg;
      vendorMainMenuUsers();
    } else {
      System.out.println("Vendor Login Credentials are Not authorised...");
      mainMenuUsers();
    }
  }
  /**
   * adminlogin.
   */
  public final void adminLogin() {

    System.out.print("Admin Username :");
    String vendorName = sc.next();
    System.out.print("Admin Password :");
    String vendorPassword = sc.next();

    if (vendorName.equals("admin") && vendorPassword.equals("admin")) {
      adminmainMenu();
    } else {
      System.out.println("Vendor Login Credentials are Not authorised...");
      mainMenuUsers();
    }

  }

  /**
   * adminmainMenu.
   */

  public final void adminmainMenu() {
    System.out.println();
    System.out.println("|--------------- Admin Main Menu -------------|");
    System.out.println("|---------------------------------------------|");
    System.out.println("| 1. Add Vendors                              |");
    System.out.println("| 2. Remove Vendor                            |");
    System.out.println("| 3. Show All Vendors                         |");
    System.out.println("| 4. Back                                     |");
    System.out.println("|---------------------------------------------|");

    System.out.print("\n Enter your choice :");

    switch (sc.nextInt()) {
      case 1:
        Vendor v = new Vendor();
        System.out.print("Enter Vendor Id :");
        int vId = sc.nextInt();
        if (VendorFactory.vendorExist(vId)) {
          System.out.println("This Id is Already Taken....");
        } else {
          v.setVendorId(vId);
          System.out.print("Enter Vendor Name :");
          v.setVendorName(sc.next());
          System.out.print("Enter Vendor Email :");
          v.setVendorEmail(sc.next());
          System.out.print("Enter Vendor Address :");
          v.setVendorAddress(sc.next());
          System.out.print("Enter Contact Number :");
          v.setVendorContactNo(sc.next());
          System.out.print("Enter Password ");
          v.setVendorPassword(sc.next());

          if (VendorFactory.createVendorRecord(v)) {
            System.out.println("Vendor Created Successfully with Id :" + vId);
          } else {
            System.out.println("Vendor Not Created...");
          }
        }
        adminmainMenu();
        break;

      case 2:
        System.out.print("Enter Vendor Id :");
        int i = sc.nextInt();
        if (VendorFactory.vendorExist(i)) {
          if (VendorFactory.deleteVendorRecord(i)) {
            System.out.println("Vendor Deleted Successfully...");
          } else {
            System.out.println("Vendor Not Deleted ...");
          }
        } else {
          System.out.println("Vendor Not Exist...");
        }
        adminmainMenu();
        break;
      case 3:
        Vendor[] ven = VendorFactory.allVendors();
        System.out.println("Vendor Id" + "\t" + "Vendor Name" + "\t" + "Contact No" + "\t" + "Address");
        for (Vendor f:ven) {
          System.out.println(f.getVendorId() + "\t\t" + f.getVendorName() + "\t\t" + f.getVendorContactNo() + "\t\t" + f.getVendorAddress());
        }
        adminmainMenu();
        break;
      case 4:

        mainMenuUsers();
        break;
      default:
        System.out.println("Enter Valid Choice Between 1 to 4");
        adminmainMenu();
        break;

    }
  }

  /**
   * vendorMainMenuUsers method  used to display the option we had in the application.
   */
  private void vendorMainMenuUsers() {

    System.out.println();
    System.out.println("|--------------- Vendor Main Menu -------------|");
    System.out.println("|----------------------------------------------|");
    System.out.println("| 1. Menu Items                                |");
    System.out.println("| 2. Orders                                    |");
    System.out.println("| 3. Customers                                 |");
    System.out.println("| 4. Logout                                      |");
    System.out.println("|----------------------------------------------|");
    vendorMainMenuUsersDetails();
  }
  /**
   * vendorMainMenuUsersDetails method  process the option selected from vendor main menu.
   */
  private void vendorMainMenuUsersDetails() {
    try {
      System.out.println("Enter your choice:");
      int menuOption = sc.nextInt();
      switch (menuOption) {
        case 1:
          foodItemsMenu();
          break;
        case 2:
          ordersMainMenuUsers();
          break;
        case 3:
          vendorCustomerMenu();
          break;
        case 4:
          currentVendor = null;
          mainMenuUsers();
        default:
          System.out.println("Choose either 1 to 4");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    sc.nextLine();
    vendorMainMenuUsers();
  }
  /**
   * FoodItemMenu method  used to display the option we had in the application.
   */
  private void foodItemsMenu() {
    System.out.println();

    System.out.println("|--------------- Menu Items Main Menu ---------------|");
    System.out.println("|----------------------------------------------------|");
    System.out.println("| 1. Add Items                                       |");
    System.out.println("| 2. View Item                                       |");
    System.out.println("| 3. View All Items                                  |");
    System.out.println("| 4. Update Items                                    |");
    System.out.println("| 5. Delete Items                                    |");
    System.out.println("| 6. Back                                            |");
    System.out.println("|----------------------------------------------------|");
    foodItemsMenuDetails();
  }
  /**
   * foodItemsMenuDetails method  process the option selected from vendor main menu.
   */
  private void foodItemsMenuDetails() {

      System.out.println("Enter your choice:");
      int menuOption = sc.nextInt();
      switch (menuOption) {
        case 1:
          System.out.print("Enter food id       :");
          int id = sc.nextInt();
          if (!MenuFactory.menuPresent(id)) {
            System.out.print("Enter food name     :");
            String name = sc.next();
            System.out.print("Enter food quantity :");
            int qty = sc.nextInt();
            System.out.print("Enter food price    :");
            double price = sc.nextDouble();
            if (VendorFactory.vendorExist(currentVendor.getVendorId())) {
              if (MenuFactory.createMenuItem(new Menu(id, name, qty, price, currentVendor.getVendorId()))) {
                System.out.println("Your Data Inserted Successfully....");
              } else {
                System.out.println("Your Data Not Inserted ....");
              }
            } else {
              System.out.println("Vendor Not Exist");
            }
          } else {
            System.out.println("Item id Already exist...");
          }
          System.out.println();

          break;
        case 2:
          System.out.print("Enter Food Id :");
          int itemId = sc.nextInt();

          if (MenuFactory.menuPresent(itemId)) {
            Menu me = MenuFactory.menuItemByFoodId(itemId);
            System.out.println("----------Menu Information----------------\n");
            System.out.println("Food Id       :" + me.getFoodId()
                        +
                        "\nFood Name     :" + me.getFoodName()
                        +
                        "\nFood Price    :" + me.getFoodPrice()
                        +
                        "\nFood Quantity :" + me.getFoodQuantity()
                        +
                        "\nVendor Id     :" + me.getVendorId() + "\n");

            System.out.println("------------------------------------------");
          } else {
            System.out.println("Sorry Data is Not Present ....");
          }
          break;
        case 3:
          showFullMenuVendor(currentVendor.getVendorId());
          break;
        case 4:
          System.out.print("Enter Food Id :");
          int y = sc.nextInt();

          if (MenuFactory.menuPresent(y)) {
            Menu m = MenuFactory.menuItemByFoodId(y);
            System.out.println("\n----------Original Information----------------\n");
            System.out.println("Food Name     :" + m.getFoodName()
                        +
                        "\nFood Price    :" + m.getFoodPrice()
                        +
                        "\nFood Quantity :" + m.getFoodQuantity()
                        +
                        "\nVendor Id     :" + m.getVendorId() + "\n");

            System.out.println("------------------------------------------\n\n");


            System.out.print("Enter Updated food name     :");
            String nam = sc.next();
            System.out.print("Enter Updated food quantity :");
            int qt = sc.nextInt();
            System.out.print("Enter Updated food price    :");
            double pric = sc.nextDouble();
            System.out.print("Enter the Updated vendor id :");
            int vI = sc.nextInt();


            Menu menu = new Menu(y, nam, qt, pric, vI);
            if (MenuFactory.updateMenu(menu)) {
              System.out.println("\n Updated Successfully...\n");
            } else {
              System.out.println("\nUpdation Failed\n");
            }
          } else {
            System.out.println("Data is Not Present...");
          }
          break;

        case 5:
          System.out.print("Enter Food Id :");


          int yy = sc.nextInt();
          if (MenuFactory.menuPresent(yy)) {
            if (MenuFactory.deleteMenu(yy)) {
              System.out.println("\nDeleted Successfully...\n");
            } else {
              System.out.println("\nNot Deleted...\n");
            }
          } else {
            System.out.println("Menu Not Present...");
          }
          break;
        case 6:
          vendorMainMenuUsers();
        default:
          System.out.println("Choose either 1 or 6");
      }

    sc.nextLine();
    foodItemsMenu();
  }
  /**
   * ordersMainMenuUsers method  used to display the option we had in the application.
   */
  private void ordersMainMenuUsers() {
    System.out.println();

    System.out.println("|--------------- Order Main Menu ---------------|");
    System.out.println("|-----------------------------------------------|");
    System.out.println("| 1. Accept Order                               |");
    System.out.println("| 2. Decline Order                              |");
    System.out.println("| 3. Order Status                               |");
    System.out.println("| 4. Back                                       |");
    System.out.println("|-----------------------------------------------|");
    ordersMainMenuUsersDetails();
  }
  /**
   * ordersMainMenuUsersDetails method  process the option selected from vendor main menu.
   */
  private void ordersMainMenuUsersDetails() {

      System.out.println("Enter your choice:");
      int menuOption = sc.nextInt();
      switch (menuOption) {
        case 1:
          System.out.println("Showing All Records Choose Yours :");
          if (OrderFactory.allOrders().length != 0) {
            showOrdersHere(OrderFactory.allOrders());
            System.out.println("\n\n");


            System.out.print("Enter Cart Id :");
            String acid = sc.next();

            double cost = 0;

            Order[] orde = OrderFactory.getPendingRecords(acid);


            if (orde.length == 0) {
              System.out.println("Sorry All Orders for this id are Accepted / Over ....");
            } else {
              System.out.println("Order Id" + "\t\t" + "Token No");
              Order ref = orde[0];
              for (Order o :orde) {
                System.out.println(o.getOrderId() + "\t\t" + o.getTokenNumber());
                OrderFactory.updateOrderStatus(o.getOrderId(), "accepted");
                // System.out.println("\n\nOrder Accepted .....\n\n");
                cost = cost + (o.getAmountToBePaid());
              }
              System.out.println("Accepted Orders :\n");
              // showOrdersHere(orde);


              System.out.println("|\n\n Doing Billing for Card Id " + acid + " Pls Wait....|");


              Bill b = new Bill();

              System.out.println("-------------------------------------------------------------");
              System.out.println("                                          Total : " + cost);

              int count = BillFactory.count(ref.getCustomerId());



              if (count >= 0 && count <= 3) {
                b.setDiscount("FIRST50");
                b.setTotalAmount(cost * 0.50);
                System.out.println("                                 Discount Total : " + (cost * 0.50));
                System.out.println("\n\nCongratulations !!!  You have got 50 % Discount....\n\n");
              } else if (count > 3 && count <= 10) {
                b.setDiscount("FIRST30");
                b.setTotalAmount(cost * 0.70);
                System.out.println("                                 Discount Total : " + (cost * 0.70));
                System.out.println("\n\nCongratulations !!!  You have got 30 % Discount....\n\n");
              } else {
                b.setDiscount("FIRST10");
                System.out.println("                                 Discount Total : " + (cost * 0.90));
                System.out.println("\n\nCongratulations !!!  You have got 10 % Discount....\n\n");
                b.setTotalAmount(cost * 0.90);
              }


              b.setItemCount(orde.length);
              b.setCustomerId(ref.getCustomerId());
              b.setCartId(acid);
              b.setStatus("PENDING");
              b.setComment("Pay Pls");
              if (BillFactory.insert(b)) {
                System.out.println("Bill Inserted Successfully...");
              } else {
                System.out.println("Bill Not Inserted Successfully...");
              }
              System.out.println("\n\n\n");
            }
          } else {
            System.out.println("No Orders Now ...");
          }
          break;
        case 2:
          if (OrderFactory.allOrders().length != 0) {
            System.out.println("Showing All Records Choose Yours :");
            showOrdersHere(OrderFactory.allOrders());
            System.out.println("\n\n");

            System.out.println("\n");
            System.out.print("Enter Your Cart Id :");
            String a = sc.next();

            Order[] ore = OrderFactory.getPendingRecords(a);


            if (ore.length == 0) {
              System.out.println("Sorry All Orders for this id are Accepted / Over ....");
            } else {
              System.out.println("Order Id" + "\t\t" + "Token No");
              for (Order o :ore) {
                OrderFactory.updateOrderStatus(o.getOrderId(), "declined");
                CustomerFactory.updateAmount(o.getCustomerId(), CustomerFactory.customerByCustId(o.getCustomerId()).getWalletAmount()+o.getAmountToBePaid());
                System.out.println("Money Paid Back to Customer...");
                System.out.println("\n\nOrder Declined .....\n\n");
              }
              System.out.println("Declined Orders...");
              showOrdersHere(ore);
            }
          } else {
            System.out.println("Orders Not Present...");
          }
          break;
        case 3:
          Order[] all = OrderFactory.allOrders();
          if (all.length != 0) {
            showOrdersHere(all);
          } else {
            System.out.println("No Orders Right Now ...");
          }

          break;
        case 4:
          vendorMainMenuUsers();
        default:
          System.out.println("Choose either 1 or 3");
      }

    sc.nextLine();
    ordersMainMenuUsers();
  }
  /**
   * vendorCustomerMenu method  used to display the option we had in the application.
   */
  private void vendorCustomerMenu() {

    System.out.println();
    System.out.println("|--------------- Vendor Customer Main Menu ---------------|");
    System.out.println("|---------------------------------------------------------|");
    System.out.println("| 1. Add Customer                                         |");
    System.out.println("| 2. View Customer                                        |");
    System.out.println("| 3. View All Customers                                   |");
    System.out.println("| 4. Update Customers                                     |");
    System.out.println("| 5. Delete Customers                                     |");
    System.out.println("| 6. Back                                            |");
    System.out.println("|----------------------------------------------------|");
    vendorCustomerMenuDetails();
  }
  /**
   * vendorCustomerMenuDetails method  process the option selected from vendorCustomerMainMenuUsers.
   */
  private void vendorCustomerMenuDetails() {

      System.out.println("Enter your choice:");
      int menuOption = sc.nextInt();
      switch (menuOption) {
        case 1:
          System.out.print("Enter customer id       :");
          int ncid = sc.nextInt();
          if (!CustomerFactory.checkUserId(ncid)) {
            System.out.print("Enter customer name     :");
            String ncname = sc.next();
            System.out.print("Enter customer email    :");
            String ncemail = sc.next();
            System.out.print("Enter customer address  :");
            String ncaddress = sc.next();
            System.out.print("Enter customer mobileno :");
            String ncmobileno = sc.next();
            System.out.print("Enter customer password :");
            String ncpassword = sc.next();
            System.out.print("Enter walletname        :");
            String ncwalletname = sc.next();
            System.out.print("Enter walletamount      :");
            double ncwalletamount = sc.nextDouble();

            if (CustomerFactory.createNewCust(new Customer(ncid, ncname, ncemail, ncaddress, ncmobileno, ncpassword, ncwalletname, ncwalletamount))) {
              System.out.println("New Customer added In database...");
            } else {
              System.out.println("Customer Addition Failed...");
            }
          } else {
            System.out.println("User Id Already Exist...");
          }
          vendorCustomerMenu();
          break;
        case 2 :
          System.out.print("ENter Customer Id :");
          custBYId(sc.nextInt());
          vendorCustomerMenu();
          break;
        case 4:
          System.out.print("Enter Customer Id :");
          editProfileByCustomerID(sc.nextInt());
          vendorCustomerMenu();
          break;
        case 3:
          displayAllCustomers();
          vendorCustomerMenu();

          break;
        case 5:
          System.out.print("Enter The Customer Id To Delete :");
          int del = sc.nextInt();
          if (CustomerFactory.checkUserId(del) && CustomerFactory.deleteCustomerRe(del)) {
            System.out.println("Deleted Successfully");
          } else {
            System.out.println("Record Not Deleted...");
          }
          vendorCustomerMenu();
          break;
        case 6:
          vendorMainMenuUsers();
        default:
          System.out.println("Choose either 1 or 6");
      }

    sc.nextLine();
    vendorMainMenuUsers();
  }
  /**
   * CustomerLoginCred method to check the credentials.
   */
  private void customerLoginCred() {
    System.out.println();
    System.out.print("Username  :");
    String customerEmail = sc.next();
    System.out.print("Password  :");
    String customerPassword = sc.next();

      int custId = CustomerFactory.loginCustomer(customerEmail, customerPassword);
      Customer cust = CustomerFactory.customerByCustId(custId);

      if (cust != null) {
        System.out.println("User Login Successfully\n\n");
        currentUser = cust;
        customerMainMenuUsers();
      } else {
        System.out.println("Invalid Credentials...");
      }
  }

  /**
   * customerMainMenuUsers method  used to display the option we had in the application.
   */
  private void customerMainMenuUsers() {
    System.out.println();
    System.out.println("|--------------------  WELCOME TO CUSTOMER MAIN MENU --------------------|");
    System.out.println("|------------------------------------------------------------------------|");
    System.out.println("| 1. Profie                                                              |");
    System.out.println("| 2. Menu Items                                                          |");
    System.out.println("| 3. Orders                                                              |");
    System.out.println("| 4. Logout                                                              |");
    System.out.println("|------------------------------------------------------------------------|");
    customerMainMenuUsersDetails();
  }
  /**
   * customerMainMenuUsersDetails method  process the option selected from customerMainMenuUsers.
   */
  private void customerMainMenuUsersDetails() {
    try {
      System.out.print("Enter your choice:");
      int menuOption = sc.nextInt();
      switch (menuOption) {
        case 1:
          profileMenu();
          break;
        case 2:
          foodMenuItems();
          break;
        case 3:
          customerOrderMenu();
          break;
        case 4:
          currentUser = null;
          mainMenuUsers();
        default:
          System.out.println("Choose either 1 to 5");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    sc.nextLine();
    customerMainMenuUsers();
  }
   /**
   * profileMenu method  used to display the option we had in the application.
   */
  private void profileMenu() {
    System.out.println();
    System.out.println("|--------------------- Customer Profile Menu ------------------|");
    System.out.println("|--------------------------------------------------------------|");
    System.out.println("| 1. View Profile                                              |");
    System.out.println("| 2. Edit Profile                                              |");
    System.out.println("| 3. Back                                                      |");
    System.out.println("|--------------------------------------------------------------|");
    profileMenuDetails();
  }
  /**
   * profileMenuDetails method  process the option selected from customerProfileMenu.
   */
  private void profileMenuDetails() {
    try {
      System.out.print("Enter your choice:");
      int menuOption = sc.nextInt();
      switch (menuOption) {
        case 1:
          // System.out.println("Enter Customer Id : ");
          custBYId(currentUser.getCustomerId());
          profileMenu();
          break;
        case 2:
        // System.out.print("Enter customer id : ");
          editProfileByCustomerID(currentUser.getCustomerId());
          profileMenu();
          break;
        case 3:
          customerMainMenuUsers();
        default:
          System.out.println("Choose either 1 or 3");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    sc.nextLine();
    profileMenu();
  }

  /**
   * FoodMenuItems method  used to display the option we had in the application.
   */
  private void foodMenuItems() {

    System.out.println();

    System.out.println("|--------------------- Customer Food Menu -------------------|");
    System.out.println("|------------------------------------------------------------|");
    System.out.println("| 1. View Food Items                                         |");
    System.out.println("| 2. View All Food Items                                     |");
    System.out.println("| 3. Order Food Items                                        |");
    System.out.println("| 4. Back                                                    |");
    System.out.println("|------------------------------------------------------------|");

    foodMenuItemsDetails();
  }
  /**
   * FoodMenuItemsDetails method  process the option selected from FoodMenuItems.
   */
  private void foodMenuItemsDetails() {

      System.out.println("Enter your choice:");
      int menuOption = sc.nextInt();
      switch (menuOption) {
        case 1:
          System.out.println("Enter Food Id :");
          int me = sc.nextInt();
          if (MenuFactory.menuPresent(me)) {
            Menu m = MenuFactory.menuItemByFoodId(me);

            System.out.println("-------------Displaying Menu Item-------------------\n");
            System.out.println("Food Id       :" + m.getFoodId());
            System.out.println("Food Name     :" + m.getFoodName());
            System.out.println("Food Price    :" + m.getFoodPrice());
            System.out.println("Food Quantity :" + m.getFoodQuantity());
            System.out.println("Food Vendor   :" + m.getVendorId());
            System.out.println("\n----------------------------------------------------\n\n");

          } else {
            System.out.println("No Item Id Found...");
          }
          foodMenuItems();
          break;
        case 2:
          showFullMenu();

          foodMenuItems();
          break;
        case 3:

          System.out.println("\nShowing All Items Menu\n");

          showFullMenu();
          orderFood();

          foodMenuItems();
          break;
        case 4:
          customerMainMenuUsers();

          foodMenuItems();
        default:
          System.out.println("Choose either 1 to 3");
      }

    sc.nextLine();
    foodMenuItems();
  }
  /**
   * CustomerOrderMenu method  used to display the option we had in the application.
   */
  private void customerOrderMenu() {
    System.out.println();
    System.out.println("|-------------------- Customer Orders Menu ------------------|");
    System.out.println("|------------------------------------------------------------|");
    System.out.println("| 1. Order History                                           |");
    System.out.println("| 2. PendingOrders                                           |");
    System.out.println("| 3. AcceptedOrders                                          |");
    System.out.println("| 4. DeclinedOrders                                          |");
    System.out.println("| 5. Back                                                    |");
    System.out.println("|------------------------------------------------------------|");

    ordersDetails();
  }
  /**
   * ordersDetails method  process the option selected from FoodMenuItems.
   */
  private void ordersDetails() {
    try {
      System.out.print("Enter your choice:");
      int menuOption = sc.nextInt();
      switch (menuOption) {
        case 1:
          showFullOrders(currentUser.getCustomerId());
          break;
        case 2:
          showCurrentOrders(currentUser.getCustomerId(), "pending");
          break;

        case 3:

          showCurrentOrders(currentUser.getCustomerId(), "accepted");
          break;

        case 4:
          showCurrentOrders(currentUser.getCustomerId(), "declined");
          break;

        case 5:
          customerMainMenuUsers();
        default:
          System.out.println("Choose either 1 or 3");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    sc.nextLine();
    customerOrderMenu();
  }

  private void showFullOrders(final int customerId) {
    Order[] order = OrderFactory.showOrdersByCustId(customerId);
    displayStrad(order);
  }
  private void showCurrentOrders(final int customerId, final String  status) {
    Order[] order = OrderFactory.showCurrentOrdersByIdandComment(customerId, status);
    displayStrad(order);
  }

  /**
   *
   * @param order takes order list
   */
  public final void displayStrad(final Order[] order) {
    System.out.println("order_Id" + "\t" + "Food_Id" + "\t" + "v_id" + "\t" + "customer_id" + "\t" + "no_of_items"
            +
            "\t" + "order_date_time" + "\t" + "amount_to_be_paid" + "\t" + "token_number" + "\t" + "status" + "\t" + "comment");
    for (Order m : order) {
      System.out.println(m.getOrderId() + "\t" + m.getFoodId() + "\t" + m.getVendorId() + "\t" + m.getCustomerId()
            +
            "\t" + m.getNoOfItems() + "\t" + m.getOrderDateTime() + "\t" + m.getAmountToBePaid() + "\t" + m.getTokenNumber()
            +
            "\t" + m.getStatus() + "\t" + m.getComment());
    }
  }



  private void editProfileByCustomerID(final int id) {
    if (!CustomerFactory.checkUserId(id)) {
      System.out.println("User Not Exist..");
      return;
    }
    Customer cc = CustomerFactory.customerByCustId(id);

    System.out.println("Displaying Previous Customer Information");
    System.out.println("-------------------------------------------------\n");
    System.out.println(
                    "Customer Name      :" + cc.getCustomerName()
                    +
                    "\n"
                    +
                    "Customer Mobile No :" + cc.getCustomerMobileNo() + "\n"
                    +
                    "Customer Email     :" + cc.getCustomerEmail() + "\n"
                    +
                    "Customer Address   :" + cc.getCustomerAddress());
    System.out.println("-------------------------------------------------\n\n");

    Customer c = currentUser;

    if (currentUser == null) {
      c = CustomerFactory.customerByCustId(id);
    }
    System.out.println();

    System.out.println("|--------------- Customer Profile Updation -------------|");
    System.out.println("|-------------------------------------------------------|");
    System.out.println("| 1. Update All Information                             |");
    System.out.println("| 2. Update Name                                        |");
    System.out.println("| 3. Update Mobile No                                   |");
    System.out.println("| 4. Update Email                                       |");
    System.out.println("| 5. Update Address                                     |");
    System.out.println("| 6. Update Wallet Name                                 |");
    System.out.println("| 7. Update Wallet Amount                               |");
    System.out.println("| 8. Update Password                                    |");
    System.out.println("|-------------------------------------------------------|");


    System.out.print("\nEnter Your choice :");
    switch (sc.nextInt()) {
      case 1:
        System.out.println("Enter Updated Name          :");
        c.setCustomerName(sc.next());
        System.out.println("Enter Updated Email         :");
        c.setCustomerEmail(sc.next());
        System.out.println("Enter Updated Address       :");
        c.setCustomerAddress(sc.next());
        System.out.println("Enter Updated Mobile No     :");
        c.setCustomerMobileNo(sc.next());
        System.out.println("Enter Updated Password      :");
        c.setCustomerPassword(sc.next());
        System.out.println("Enter Updated Wallet Name   :");
        c.setWalletName(sc.next());
        System.out.println("Enter Updated Wallet Amount :");
        c.setWalletAmount(sc.nextDouble());

        break;
      case 2:
        System.out.println("Enter Updated Name          :");
        c.setCustomerName(sc.next());
        break;
      case 3:
        System.out.println("Enter Updated Mobile No     :");
        c.setCustomerMobileNo(sc.next());
        break;
      case 4:
        System.out.println("Enter Updated Email         :");
        c.setCustomerEmail(sc.next());
        break;
      case 5:
        System.out.println("Enter Updated Address       :");
        c.setCustomerAddress(sc.next());
        break;
      case 6:
        System.out.println("Enter Updated Wallet Name   :");
        c.setWalletName(sc.next());
        break;
      case 7:
        System.out.println("Enter Updated Wallet Amount :");
        c.setWalletAmount(sc.nextDouble());
        break;
      case 8:
        System.out.println("Enter Updated Password :");
        c.setCustomerPassword(sc.next());
        break;
      default:
        System.out.println("Enter Choice between 1 to 8");
        break;
    }


    if (CustomerFactory.updateCustRec(c)) {
      System.out.println("Customer Profile Updated Successfully...");
      if (currentUser != null) {
        currentUser = c;
      }
    } else {
      System.out.println("Customer is Not Updated...");
    }
  }

  private void showFullMenu() {
    Menu[] menu = MenuFactory.showFullMenuu();
    System.out.println("FOOD_ID" + "\t" + "FOOD_NAME" + "\t" + "QUANTITY" + "\t" + "PRICE" + "\t" + "VENDOR_ID");
    for (Menu m : menu) {
      System.out.println(m.getFoodId() + "\t" + m.getFoodName() + "\t" + m.getFoodQuantity()
          +
          "\t" + m.getFoodPrice() + "\t" + m.getVendorId());
    }
  }
  private void showFullMenuVendor(final int id) {
    Menu[] menu = MenuFactory.showFullMenuuVend(id);
    System.out.println("FOOD_ID" + "\t" + "FOOD_NAME" + "\t" + "QUANTITY" + "\t" + "PRICE" + "\t" + "VENDOR_ID");
    for (Menu m : menu) {
      System.out.println(m.getFoodId() + "\t" + m.getFoodName() + "\t" + m.getFoodQuantity()
          +
          "\t" + m.getFoodPrice() + "\t" + m.getVendorId());
    }
  }

  /**
   * customer edit info.
   * @param id gets id
   */
  public final void custBYId(final int id) {
    if (!CustomerFactory.checkUserId(id)) {
      System.out.println("User Not Exist...");
      return;
    }
    Customer c = CustomerFactory.customerByCustId(id);

    System.out.println("            Displaying Customer Information");
    System.out.println("-------------------------------------------------\n");
    System.out.println(
                    "Id        :" + c.getCustomerId() + "\n"
                    +
                    "Name      :" + c.getCustomerName() + "\n"
                    +
                    "Mobile No :" + c.getCustomerMobileNo() + "\n"
                    +
                    "Email     :" + c.getCustomerEmail() + "\n"
                    +
                    "Address   :" + c.getCustomerAddress());
    System.out.println("-------------------------------------------------");
  }


  /**
   * displays customers.
   */
  public final void displayAllCustomers() {
    Customer[] cus = CustomerFactory.showFullCustomer();

    System.out.println("Customer Id" + "\t" + "Customer Name" + "\t" + "Customer Email" + "\t" + "Customer_Mobile No" + "\t" + "Customer_Address");

    for (Customer c:cus) {
      System.out.println(c.getCustomerId() + "\t\t" + c.getCustomerName() + "\t\t" + c.getCustomerEmail() + "\t\t" + c.getCustomerMobileNo()
                                + "\t\t" + c.getCustomerAddress());
    }
  }

  /**
   * orders food.
   */


  public final void orderFood() {
    System.out.println("\n\n Getting Waiter For You ...");
    System.out.println("\n\n Gathering Some base information");

    Order o = new Order();

    o.setCustomerId(currentUser.getCustomerId());
    o.setOrderDateTime(OrderFactory.getCurrentDate());



    int tok = o.createCustomToken(currentUser.getCustomerId(), currentUser.getCustomerMobileNo(), OrderFactory.getCurrentDateTime());

    System.out.println(" Cart Created with Id :" + Integer.toString(tok));
    o.setTokenNumber(Integer.toString(tok));
    foodOrderingMenu(o);

    OrderFactory.createOrder(o);

  }

  /**
   * orders menu.
   * @param o takes orders object.
   */
  public final void foodOrderingMenu(final Order o) {

    int itemId;
    System.out.println("|-------------- Customer Food Menu --------------|");
    System.out.println("|------------------------------------------------|");
    System.out.println("| 1. Order Items                                 |");
    System.out.println("| 2. Back                                        |");
    System.out.println("|------------------------------------------------|");
    System.out.println("\nEnter Your Choice :");

    switch (sc.nextInt()) {
      case 1:
        System.out.print("Enter Food Id :");
        itemId = sc.nextInt();
        Menu m =null;
        if (MenuFactory.menuPresent(itemId)) {
          m = MenuFactory.menuItemByFoodId(itemId);
          o.setFoodId(itemId);
          o.setVendorId(m.getVendorId());
          System.out.println("Enter No Of Items :");
          int countItems=sc.nextInt();
          if (m.getFoodQuantity() < countItems) {
            o.setNoOfItems(countItems);
            double amountGenerated=o.getNoOfItems() * m.getFoodPrice();
            if (amountGenerated <= CustomerFactory.customerByCustId(currentUser.getCustomerId()).getWalletAmount()){
              o.setAmountToBePaid(amountGenerated);
              CustomerFactory.updateAmount(currentUser.getCustomerId(), CustomerFactory.customerByCustId(currentUser.getCustomerId()).getWalletAmount()-amountGenerated);
              o.setStatus("pending");
              o.setComment("Order Table");
            }
            else{
              System.out.println("You Have Insufficient Balance...");
            }

            if (OrderFactory.createOrder(o)) {
              System.out.println("Order Inserted Successfully...");
            } else {
              System.out.println("Order Not Inserted");
            }
            foodOrderingMenu(o);
          }
          else{
            System.out.println("Insufficient Quantity of items...");
          }
        } else {
          System.out.println("Sorry But Item Id not present...");
          foodOrderingMenu(o);
        }

        break;
      case 2:
        foodMenuItems();
        break;
      default:
        System.out.println("Enter values in 1 and 2");
    }
  }

  /**
   *  Shwing orders.
   * @param all takes orders objects.
   */


  public final void showOrdersHere(final Order[] all) {
    System.out.println("Order Id" + "\t\t" + "Customer Id " + "\t\t" + "Token No (Cart Id)" + "\t\t Status");
    for (Order u:all) {
      System.out.println(u.getOrderId() + "\t\t" + u.getCustomerId() + "\t\t" + u.getTokenNumber() + "\t\t" + u.getStatus());
    }
  }
}
