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
import com.model.Cart;
import com.model.CartItem;
import com.model.Account;
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


public class Transaction{

int transactionId;
int orderId;
int sellerId;
double productAmount;
double adminCommission;
double sellerAmount;
String paymentStatus;

public Transaction(int transactionId,int orderId,int sellerId,double productAmount,double adminCommission,double sellerAmount,String paymentStatus){
this.transactionId=transactionId;
this.orderId=orderId;
this.sellerId=sellerId;
this.productAmount=productAmount;
this.adminCommission=adminCommission;
this.sellerAmount=sellerAmount;
this.paymentStatus=paymentStatus;

}
public int getTransactionId() {
    return transactionId;
}

public int getOrderId() {
    return orderId;
}

public int getSellerId() {
    return sellerId;
}

public double getProductAmount() {
    return productAmount;
}

public double getAdminCommission() {
    return adminCommission;
}

public double getSellerAmount() {
    return sellerAmount;
}

public String getPaymentStatus() {
    return paymentStatus;
}
public void print(){
System.out.println("Transaction ID:"+getTransactionId());
System.out.println("Order ID:"+getOrderId());
System.out.println("Seller ID:"+getSellerId());
System.out.println("Product Amount:"+getProductAmount());
System.out.println("Admin Comission:"+getAdminCommission());
System.out.println("Seller Amount:"+getSellerAmount());
System.out.println("Payment Status:"+getPaymentStatus());
}

}