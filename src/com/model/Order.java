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
import com.model.Account;
import com.model.OrderItem;
import com.model.Cart;
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
import java.util.ArrayList;
import com.model.OrderItem;

public class Order{
int orderId;
int customerId;
double totalAmount;
String orderDate;
String status;
private ArrayList<OrderItem> items = new ArrayList<>();
public ArrayList<OrderItem> getItems() {
    return items;
}

public Order(int orderId,int customerId,double totalAmount,String orderDate,String status){
this.orderId=orderId;
this.customerId=customerId;
this.totalAmount=totalAmount;
this.orderDate=orderDate;
this.status=status;
}
public int getOrderId(){
return orderId;
}

public int getCustomerId(){
return customerId;
}
public double getTotalAmount(){
return totalAmount;
}
public String getOrderDate(){
return orderDate;
}
public String getStatus(){
return status;
}
public void addItem(OrderItem item) {
    items.add(item);
}

public void setStatus(String status) {
    this.status = status;
}
public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
}

public void print(){
System.out.println("ORDER ID:"+orderId);
System.out.println("CUSTOMER ID:"+customerId);
System.out.println("TOTAL AMOUNT:"+totalAmount);
System.out.println("ORDER DATE:"+orderDate);
System.out.println("STATUS:"+status);
}

}