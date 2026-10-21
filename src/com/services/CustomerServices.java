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
import com.services.AccountServices;
import com.services.OrderServices;
import com.services.CartServices;
import com.services.PaymentServices;
import com.services.ProductServices;
import com.services.TransactionServices;
import com.storage.Storage;

public class CustomerServices{
static Scanner sc=new Scanner(System.in);

// view product

public static void viewProducts(ArrayList<Product> products) {
if (products.isEmpty()) {
System.out.println("No products available.");
return;
}
for (Product product : products) {
product.print();
}
}

// search product

public static void searchProduct(String name, ArrayList<Product> products) { 
boolean found = false; 
for(Product product : products) { 
if (product.getName().toLowerCase().contains(name.toLowerCase())) { 
product.print(); 
found = true; 
} } 
if (!found) { 
System.out.println("Product not found."); 
} }

// add to cart

public static void addToCart(Cart cart, CartItem item) {
if (item.getQuantity() <= 0) {
System.out.println("Quantity must be greater than zero.");
return;
}
for (Product product : Storage.products) {
if (product.getId() == item.getProductId()) {
if (product.getStock() <= 0) {
System.out.println("Product is out of stock.");
return;
}
int totalQuantity = item.getQuantity();
for (CartItem cartItem : cart.getItems()) {
if (cartItem.getProductId() == item.getProductId()) {
totalQuantity += cartItem.getQuantity();
}
}
if (totalQuantity > product.getStock()) {
System.out.println("Insufficient stock.");
System.out.println("Available stock: " + product.getStock());
 return;
}
for (CartItem cartItem : cart.getItems()) {
if (cartItem.getProductId() == item.getProductId()) {
cartItem.setQuantity(totalQuantity);
System.out.println("Cart quantity updated.");
return;
}
}
cart.addItem(item);
System.out.println("Product added to cart.");
return;
}
}
System.out.println("Product not found.");
}


// view cart



public static void viewCart(Cart cart) {
    if (cart.getItems().isEmpty()) {
        System.out.println("Your cart is empty.");
        return;
    }

    double totalAmount = 0;

    for (int i = 0; i < cart.getItems().size(); i++) {
        CartItem item = cart.getItems().get(i);
        Product foundProduct = null;

        for (Product product : Storage.products) {
            if (product.getId() == item.getProductId()) {
                foundProduct = product;
                break;
            }
        }

        if (foundProduct == null) {
            System.out.println("Removing unavailable product ID: "
                    + item.getProductId());
            cart.getItems().remove(i);
            i--;
        } else {
            totalAmount += foundProduct.getPrice() * item.getQuantity();
        }
    }

    if (cart.getItems().isEmpty()) {
        System.out.println("Your cart is empty.");
        return;
    }

    cart.displayCart();
    System.out.println("Total Cart Amount: " + totalAmount);
}

// remove from cart

public static void removeFromCart(Cart cart) {
System.out.print("Enter product ID:");
int productId = sc.nextInt();
while ((!String.valueOf(productId).matches("[0-9]{1,6}") ||String.valueOf(productId).matches("0+") || productId < 0)) {
    System.out.println("Product ID must contain 1 to 6 digits and cannot be all zeros.");
    System.out.println("Enter product ID:");
    productId = sc.nextInt();
}
for (int i = 0; i < cart.getItems().size(); i++) {
if (cart.getItems().get(i).getProductId() == productId) {
cart.getItems().remove(i);
System.out.println("Product removed from cart.");
return;
}
}
System.out.println("Product not found in cart.");
}




// Place Order
public static void placeOrder(int orderId, int customerId, Cart cart,
        ArrayList<Order> orders, ArrayList<Product> products) {


    for (Order order : orders) {
        if (order.getOrderId() == orderId) {
            System.out.println("Order ID already exists.");
            return;
        }
    }

       if (cart.getItems().isEmpty()) {
        System.out.println("Cart is empty.");
        return;
    }

   
    for (CartItem item : cart.getItems()) {

        if (item.getQuantity() <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }

        Product foundProduct = null;

        for (Product product : products) {
            if (product.getId() == item.getProductId()) {
                foundProduct = product;
                break;
            }
        }

        if (foundProduct == null) {
            System.out.println("Product not found: " + item.getProductId());
            return;
        }

     
        int totalQuantity = 0;

        for (CartItem cartItem : cart.getItems()) {
            if (cartItem.getProductId() == item.getProductId()) {
                totalQuantity += cartItem.getQuantity();
            }
        }

        if (totalQuantity > foundProduct.getStock()) {
            System.out.println("Insufficient stock for: "
                    + foundProduct.getName());
            System.out.println("Available stock: "
                    + foundProduct.getStock());
            System.out.println("Requested quantity: " + totalQuantity);
            return;
        }
    }
    double totalAmount = 0;

    for (CartItem item : cart.getItems()) {
        for (Product product : products) {
            if (product.getId() == item.getProductId()) {
                totalAmount += product.getPrice() * item.getQuantity();
                break;
            }
        }
    }

   
    System.out.println("Total Amount: Rs. " + totalAmount);
    System.out.print("Confirm order? (yes/no):");
    String confirmation = sc.next();

    if (!confirmation.equalsIgnoreCase("yes")) {
        System.out.println("Order cancelled by customer.");
        return;
    }
System.out.print("Enter Phone Number:");
String phone = sc.next();

while (!phone.matches("[0-9]{10}") || phone.matches("0{10}")) {
    System.out.println("Phone number must contain exactly 10 digits and cannot be all zeros.");
    System.out.println("Enter Phone Number:");
    phone = sc.next();
}

long phoneNumber = Long.parseLong(phone);
System.out.print("Enter House No:");
String houseNo = sc.next();

System.out.print("Enter Street:");
sc.nextLine();
String street = sc.nextLine();

System.out.print("Enter City:");
String city = sc.nextLine();

System.out.print("Enter State:");
String state = sc.nextLine();

System.out.print("Enter PIN Code:");
int pinCode = sc.nextInt();

 
    String orderDate = java.time.LocalDate.now().toString();
    String status = "PLACED";

    Order order = new Order(
            orderId, customerId, totalAmount, orderDate, status
    );


    for (CartItem item : cart.getItems()) {
        for (Product product : products) {

            if (product.getId() == item.getProductId()) {

                product.setStock(
                        product.getStock() - item.getQuantity()
                );

                OrderItem orderItem = new OrderItem(
                        product.getId(),
                        product.getSellerId(),
                        item.getQuantity(),
                        product.getName(),
                        product.getPrice()
                );

                order.addItem(orderItem);
                break;
            }
        }
    }

Address address = new Address(
    Storage.addresses.size() + 1,
    customerId,
    orderId,
    houseNo,
    street,
    city,
    state,
    pinCode
);

Storage.addresses.add(address);

orders.add(order);

new OrderServices().saveOrders(orders);
ProductServices.saveProducts(products);
 
    //cart.clear();

    System.out.println("Order placed successfully.");
    System.out.println("Order ID: " + orderId);
    System.out.println("Total Amount: Rs. " + totalAmount);
}



// view orders

public static void viewMyOrder(int customerId, ArrayList<Order> orders) {

System.out.println("Enter Order ID:");
int orderId = sc.nextInt();

boolean found = false;

for (Order o : Storage.orders) {
    if (o.getOrderId() == orderId &&
        o.getCustomerId() == customerId) {

System.out.println("ORDER ID:" + o.getOrderId());
System.out.println("CUSTOMER ID:" + o.getCustomerId());
System.out.println("TOTAL AMOUNT:" + o.getTotalAmount());
System.out.println("ORDER DATE:" + o.getOrderDate());
System.out.println("STATUS:" + o.getStatus());
        found = true;
        break;
    }
}

if (!found) {
    System.out.println("Order ID not found.");
}
}

// cancel order


public static void cancelOrder(int customerId, ArrayList<Order> orders) {
    System.out.println("Enter order ID:");
    int orderId = sc.nextInt();
while ((!String.valueOf(orderId).matches("[0-9]{1,6}") ||String.valueOf(orderId).matches("0+") || orderId < 0)) {
    System.out.println("order ID must contain 1 to 6 digits and cannot be all zeros.");
    System.out.println("Enter order ID:");
    orderId = sc.nextInt();
}

    for (Order order : orders) {
        if (order.getOrderId() == orderId
                && order.getCustomerId() == customerId) {

            if (order.getStatus().equalsIgnoreCase("CANCELLED")) {
                System.out.println("Order is already cancelled.");
                return;
            }

            if (order.getStatus().equalsIgnoreCase("SHIPPED")
                    || order.getStatus().equalsIgnoreCase("DELIVERED")) {
                System.out.println("Cannot cancel a shipped or delivered order.");
                return;
            }

            for (OrderItem item : order.getItems()) {
                for (Product product : Storage.products) {
                    if (product.getId() == item.getProductId()) {
                        product.setStock(
                                product.getStock() + item.getQuantity()
                        );
                        break;
                    }
                }
            }

            order.setStatus("CANCELLED");

            new OrderServices().saveOrders(orders);
            ProductServices.saveProducts(Storage.products);

            System.out.println("Order cancelled successfully.");
            return;
        }
    }

    System.out.println("Order not found.");
}

}