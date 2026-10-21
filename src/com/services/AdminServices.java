package com.services;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import com.main.MultiCart;
import com.model.Admin;
import com.model.Customer;
import com.model.Seller;
import com.model.Product;
import com.model.Address;
import com.model.Payment;
import com.model.Order;
import com.model.OrderItem;
import com.model.Cart;
import com.model.CartItem;
import com.model.Transaction;
import com.model.Account;
import com.services.AccountServices;
import com.services.SellerServices;
import com.services.CustomerServices;
import com.services.OrderServices;
import com.services.CartServices;
import com.services.PaymentServices;
import com.services.ProductServices;
import com.services.TransactionServices;
import com.storage.Storage;

public class AdminServices{
Scanner sc=new Scanner(System.in);

//add seller

public void addSeller(ArrayList<Seller> sellers) {
int sellerId = AccountServices.generateSellerId();


System.out.print("Enter Seller Name:");
//sc.nextLine();
String sellerName = sc.nextLine();

while (!sellerName.matches("[a-zA-Z]+( [a-zA-Z]+)*")) {
System.out.println("Name must contain only alphabets and spaces"); 
System.out.print("Enter the name:"); 

sellerName = sc.nextLine(); 
}


System.out.print("Enter Seller Email:");
String sellerEmail = sc.next();

while (!sellerEmail.matches("[a-z0-9]+@[a-z0-9]+\\.[a-z]+")) { 
System.out.println("Email must contain alphabets, numbers and only one @ symbol"); 
System.out.print("Enter the Email ID:"); 
sellerEmail = sc.next().toLowerCase(); 
}


System.out.print("Enter Seller Password:");
String sellerPassword = sc.next();

while (!sellerPassword.matches("(?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{5,10}")) { 
System.out.println("Password must be 5 to 10 characters"); 
System.out.println("Password must contain alphabets,numbers and at least one special character"); 
System.out.print("Enter the password:");
sellerPassword = sc.next(); 

}

System.out.print("Enter Company Name:");
sc.nextLine();
String companyName = sc.nextLine();

while(!companyName.matches("[a-zA-Z ]{5,20}")){
System.out.println("company name must be 5 to 20 characters");
System.out.println("Enter the Company Name:");

companyName=sc.nextLine();
}


Seller seller = new Seller(
    sellerId, sellerName, sellerEmail, sellerPassword, companyName
);

sellers.add(seller);

try (FileWriter fw = new FileWriter("sellers.txt", true)) {
    fw.write("ID: " + seller.getId() + "\n");
    fw.write("Name: " + seller.getName() + "\n");
    fw.write("Email: " + seller.getEmail() + "\n");
    fw.write("Company Name: " + seller.getCompanyName() + "\n");
    fw.write("----------------------------------------\n");

    System.out.println("Seller added and saved successfully.");

} catch (IOException e) {
    System.out.println("Error saving seller: " + e.getMessage());
}

}

public void loadSellers(ArrayList<Seller> sellers) {

    try (BufferedReader br = new BufferedReader(new FileReader("sellers.txt"))) {

        String line;
        int id = 0;
        String name = "";
        String email = "";
        String password = "";
        String companyName = "";

        while ((line = br.readLine()) != null) {

            if (line.startsWith("ID: ")) {
            id = Integer.parseInt(line.substring(4));

            } else if (line.startsWith("Name: ")) {
                name = line.substring(6);

            } else if (line.startsWith("Email: ")) {
                email = line.substring(7);

            } else if (line.startsWith("Password: ")) {
                password = line.substring(10);

            } else if (line.startsWith("Company Name: ")) {
                companyName = line.substring(14);

            } else if (line.startsWith("---")) {

                boolean exists = false;

                for (Seller s : sellers) {
                if (s.getId() == id) {
                 exists = true;
                  break;
                     }
                }

               if (!exists && id != 0 && !email.isEmpty())  {
                    Seller seller = new Seller(
                        id, name, email, password, companyName
                    );

                    sellers.add(seller);
                }

                id = 0;
                name = "";
                email = "";
                password = "";
                companyName = "";
            }
        }

        System.out.println("Sellers loaded successfully.");

    } catch (FileNotFoundException e) {
        System.out.println("sellers.txt not found. It will be created when you add a seller.");

    } catch (IOException e) {
        System.out.println("Error loading sellers: " + e.getMessage());
    }
}
//save seller

public void saveSellers(ArrayList<Seller> sellers) {

    try (FileWriter fw = new FileWriter("sellers.txt", false)) {

        for (Seller seller : sellers) {
            fw.write("ID: " + seller.getId() + "\n");
            fw.write("Name: " + seller.getName() + "\n");
            fw.write("Email: " + seller.getEmail() + "\n");
            fw.write("Password: " + seller.getPassword() + "\n");
            fw.write("Company Name: " + seller.getCompanyName() + "\n");
            fw.write("----------------------------------------\n");
        }

        System.out.println("Seller file updated successfully.");

    } catch (IOException e) {
        System.out.println("Error saving sellers: " + e.getMessage());
    }
}

//remove seller

public static void removeSeller(int sellerId, ArrayList<Seller> sellers) {

    boolean found = false;

    for (int i = 0; i < sellers.size(); i++) {

 if (sellers.get(i).getId() == sellerId) {

            sellers.remove(i);
           new AdminServices().saveSellers(sellers);

            System.out.println("Seller removed successfully.");
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Seller ID not found.");
    }
}


//view seller

public static void viewSeller(ArrayList<Seller> sellers) {
if (sellers.isEmpty()) {
System.out.println("No sellers found");
return;
}
System.out.println("----------SELLERS ----------");
for(Seller seller:sellers) {
seller.print();
}
}


//view customer

public static void viewCustomer(ArrayList<Customer> customers) {
if (customers.isEmpty()) {
System.out.println("No customers found");
return;
}
System.out.println("----------CUSTOMERS ----------");
for(Customer customer : customers) {
customer.print();
}
}


// view products

public static void viewProducts(ArrayList<Product> products) {
if (products.isEmpty()) {
System.out.println("No products found");
return;
}

System.out.println("----------PRODUCTS ----------");
for(Product product : products) {
product.print();
}

}

//view all orders

public static void viewAllOrders(ArrayList<Order> orders) {
if (orders.isEmpty()) {
System.out.println("No orders found");
return;
}
System.out.println("----------ORDERS ----------");
for(Order order:orders) {
order.print();
}
}

}