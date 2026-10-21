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
import com.services.AccountServices;
import com.services.CustomerServices;
import com.services.OrderServices;
import com.services.CartServices;
import com.services.PaymentServices;
import com.services.ProductServices;
import com.services.TransactionServices;
import com.storage.Storage;

public class CartServices{
Scanner sc=new Scanner(System.in);

//add to cart

public void addToCart(Cart cart, CartItem item) {
cart.addItem(item);
}

//view cart

public void viewCart(Cart cart) {
cart.displayCart();
}

//update quantity

public void updateQuantity(Cart cart) {
Scanner sc = new Scanner(System.in);
int orderId = AccountServices.generateOrderId();
/*while ((!String.valueOf(orderId).matches("[0-9]{1,6}") ||String.valueOf(orderId).matches("0+") || orderId < 0)) {
    System.out.println("order ID must contain 1 to 6 digits and cannot be all zeros.");
    System.out.println("Enter order ID:");
    orderId = sc.nextInt();
}
*/
int productId =  AccountServices.generateProductId();
/*
while ((!String.valueOf(productId).matches("[0-9]{1,6}") ||String.valueOf(productId).matches("0+") || productId < 0)) {
    System.out.println("Product ID must contain 1 to 6 digits and cannot be all zeros.");
    System.out.println("Enter product ID:");
    productId = sc.nextInt();
}
*/
for(CartItem item : cart.getItems()) {
if(item.getProductId() == productId) {
System.out.print("Enter new quantity:");
int quantity = sc.nextInt();
item.setQuantity(quantity);
System.out.println("Quantity updated.");
return;
}
}
System.out.println("Product not found in cart.");
}

//clear cart

public void clearCart(Cart cart) {
cart.clear();
System.out.println("Cart cleared.");
}
}