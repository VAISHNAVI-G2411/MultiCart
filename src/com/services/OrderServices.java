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
import com.services.AdminServices;
import com.services.SellerServices;
import com.services.CustomerServices;
import com.services.AccountServices;
import com.services.CartServices;
import com.services.PaymentServices;
import com.services.ProductServices;
import com.services.TransactionServices;
import com.storage.Storage;

public class OrderServices {
Scanner sc=new Scanner(System.in);

// place order



public void placeOrder(Order order, ArrayList<Order> orders) {
    orders.add(order);

    System.out.println("Saving order to file...");
    saveOrders(orders);

    System.out.println("Order placed successfully.");
}

//save orders

public void saveOrders(ArrayList<Order> orders) {
    try (FileWriter fw = new FileWriter("orders.txt")) {
        for (Order order : orders) {
            fw.write("Order ID: " + order.getOrderId() + "\n");
            fw.write("Customer ID: " + order.getCustomerId() + "\n");
            fw.write("Order Date: " + order.getOrderDate() + "\n");
            fw.write("Status: " + order.getStatus() + "\n");
            fw.write("Total Amount: " + order.getTotalAmount() + "\n");

            for (OrderItem item : order.getItems()) {
                fw.write("ITEM START\n");
                fw.write("Product ID: " + item.getProductId() + "\n");
                fw.write("Seller ID: " + item.getSellerId() + "\n");
                fw.write("Product Name: " + item.getProductName() + "\n");
                fw.write("Price: " + item.getPrice() + "\n");
                fw.write("Quantity: " + item.getQuantity() + "\n");
            }

            fw.write("----------------------------------------\n");
        }
    } catch (IOException e) {
        System.out.println("Error saving orders: " + e.getMessage());
    }
}

//load orders 

public void loadOrders(ArrayList<Order> orders) {
try (BufferedReader br = new BufferedReader(new FileReader("orders.txt"))) {
String line;
Order order = null;
while ((line = br.readLine()) != null) {
if (line.startsWith("Order ID: ")) {
int orderId = Integer.parseInt(line.substring(10));
int customerId = 0;
double totalAmount = 0;
String orderDate = "";
String status = "";
String customerLine = br.readLine();
customerId = Integer.parseInt(customerLine.substring(13));
orderDate = br.readLine().substring(12);
status = br.readLine().substring(8);
totalAmount = Double.parseDouble(br.readLine().substring(14));
boolean exists = false;
for (Order existing : orders) {
if (existing.getOrderId() == orderId) {
 exists = true;
order = existing;
 break; }
 }
if (!exists) {
order = new Order(orderId, customerId,totalAmount, orderDate, status);
 orders.add(order);
}

} else if (line.equals("ITEM START")) {
int productId = Integer.parseInt(br.readLine().substring(12));
int sellerId = Integer.parseInt(br.readLine().substring(11));
String productName = br.readLine().substring(14);
double price = Double.parseDouble(br.readLine().substring(7));
int quantity = Integer.parseInt(br.readLine().substring(10));
if (order != null) {
order.addItem(new OrderItem( productId, sellerId, quantity, productName, price));
}
}
        }

    } catch (FileNotFoundException e) {
        System.out.println("No saved orders found yet.");
    } catch (IOException e) {
        System.out.println("Error loading orders: " + e.getMessage());
    }
}


// view orders

public void viewOrders(ArrayList<Order> orders) {
if (orders.isEmpty()) {
System.out.println("No orders found.");
return;
}
for (Order order : orders) {
order.print();
}
}

// view seller orders

public void viewSellerOrders(int sellerId, ArrayList<Order> orders) {
    boolean found = false;

    for (Order order : orders) {
        for (OrderItem item : order.getItems()) {
            if (item.getSellerId() == sellerId) {
                order.print();
                found = true;
                break;
            }
        }
    }

    if (!found) {
        System.out.println("No orders found for this seller.");
    }
}
//cancel order

public void cancelOrder(ArrayList<Order> orders) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter order ID:");
int orderId = sc.nextInt();
while ((!String.valueOf(orderId).matches("[0-9]{1,6}") ||String.valueOf(orderId).matches("0+") || orderId < 0)){
    System.out.println("order ID must contain 1 to 6 digits and cannot be all zeros.");
    System.out.println("Enter order ID:");
    orderId = sc.nextInt();
}
for(Order order : orders) {
if(order.getOrderId() == orderId) {
order.setStatus("CANCELLED");
saveOrders(orders);
System.out.println("Order cancelled successfully.");
return;
}
}
System.out.println("Order not found.");
}



// update order status


public void updateOrderStatus(ArrayList<Order> orders) {
    System.out.print("Enter order ID:");
    int orderId = sc.nextInt();
while ((!String.valueOf(orderId).matches("[0-9]{1,6}") ||String.valueOf(orderId).matches("0+") || orderId < 0)){
    System.out.println("order ID must contain 1 to 6 digits and cannot be all zeros.");
    System.out.println("Enter order ID:");
    orderId = sc.nextInt();
}
    for (Order order : orders) {
        if (order.getOrderId() == orderId) {

            if (order.getStatus().equalsIgnoreCase("CANCELLED")) {
                System.out.println("Cannot update a cancelled order.");
                return;
            }

            System.out.println("Choose new status:");
            System.out.println("1. SHIPPED");
            System.out.println("2. DELIVERED");
            System.out.println("3. CANCELLED");

            int choice = sc.nextInt();
            String status;

            switch (choice) {
                case 1:
                    status = "SHIPPED";
                    break;
                case 2:
                    status = "DELIVERED";
                    break;
                case 3:
                    status = "CANCELLED";
                    break;
                default:
                    System.out.println("Invalid choice.");
                    return;
            }

            order.setStatus(status);
            saveOrders(orders);

            System.out.println("Order status updated successfully.");
            return;
        }
    }

    System.out.println("Order not found.");
}

}