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
import com.model.Account;
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

public class OrderItem{
private int productId;
private int sellerId;
private String productName;
private double price;
private int quantity;

public OrderItem(int productId,int sellerId,int quantity,String productName,double price){
    this.productId=productId;
    this.sellerId=sellerId;
    this.productName=productName;
    this.price=price;
    this.quantity=quantity;
}
public int getProductId() {
    return productId;
}

public int getSellerId() {
    return sellerId;
}

public String getProductName() {
    return productName;
}

public double getPrice() {
    return price;
}

public int getQuantity() {
    return quantity;
}
public void print(){
System.out.println("PRODUCT ID:"+productId);
System.out.println("SELLER ID:"+sellerId);
System.out.println("PRODUCT NAME:"+productName);
System.out.println("PRICE:"+price);
System.out.println("QUANTITY:"+quantity);
}

}