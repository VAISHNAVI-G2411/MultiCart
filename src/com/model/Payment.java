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
import com.model.Account;
import com.model.Order;
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


public class Payment{

private int paymentId;
private int orderId;
private double amount;
private String paymentMethod;
private String paymentStatus;


public Payment(int paymentId,int OrderId,double amount,String paymentMethod,String paymentStatus){
this.paymentId=paymentId;
this.orderId = OrderId;
this.amount=amount;
this.paymentMethod=paymentMethod;
this.paymentStatus=paymentStatus;
}
public int getPaymentId(){
return paymentId;
}
public void setPaymentId(int paymentId){
this.paymentId=paymentId;
}
public int getOrderId(){
return orderId;
}
public void setOrderId(int orderId){
this.orderId=orderId;
}
public double getAmount(){
return amount;
}
public void setAmount(double amount){
this.amount=amount;
}
public String getPaymentMethod(){
return paymentMethod;
}
public void setPaymentMethod(String paymentMethod){
this.paymentMethod=paymentMethod;
}
public String getPaymentStatus(){
return paymentStatus;
}
public void setPaymentStatus(String paymentStatus){
this.paymentStatus=paymentStatus;
}

public void print(){
System.out.println("PAYMENT ID:"+getPaymentId());
System.out.println("ORDER ID:"+getOrderId());
System.out.println("AMOUNT:"+getAmount());
System.out.println("PAYMENT METHOD:"+getPaymentMethod());
System.out.println("PAYMENT STATUS:"+getPaymentStatus());

}
}