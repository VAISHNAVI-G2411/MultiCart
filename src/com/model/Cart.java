package com.model;
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
import com.model.Account;
import com.model.CartItem;
import com.model.Transaction;
import com.services.AccountServices;
import com.services.AdminServices;
import com.services.SellerServices;
import com.services.CustomerServices;
import com.services.OrderServices;
import com.services.CartServices;
import com.services.PaymentServices;
import com.services.ProductServices;
import com.services.TransactionServices;
import com.storage.Storage;


public class Cart{
private int customerId;
private ArrayList<CartItem> items = new ArrayList<>();
public Cart(int customerId) {
this.customerId = customerId;
}
public void addItem(CartItem item) {
items.add(item);
}
public void clear() {
items.clear();
}
public int getCustomerId() {
return customerId;
}
public ArrayList<CartItem> getItems() {
return items;
}
public void displayCart() {
if (items.isEmpty()) {
System.out.println("Cart is empty.");
return;
}
double total = 0;
for (CartItem item : items) {
System.out.println(item.productName +"  Quantity: " + item.quantity +"  Price: " + item.price);
total = total + item.getTotal();
}
System.out.println("Total: " + total);
System.out.println("THANK YOU FOR SHOPPING");
}
}



