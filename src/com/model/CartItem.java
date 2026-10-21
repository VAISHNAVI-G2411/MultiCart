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
import com.model.Account;
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


public class CartItem{
int productId;
String productName;
double price;
int quantity;

public CartItem(int productId,String productName,double price,int quantity){
this.productId=productId;
this.productName=productName;
this.price=price;
this.quantity=quantity;
}
public int getProductId(){
return productId;
}
public void setProductId(int productId){
this.productId=productId;
}
public String getProductName(){
return productName;
}
public void setProductName(String productName){
this.productName=productName;
}
public double getPrice(){
return price;
}
public void setPrice(double price){
this.price=price;
}
public int getQuantity(){
return quantity;
}
public double getTotal() {
    return price * quantity;
}

public void setQuantity(int quantity) {
    this.quantity = quantity;
}
public void print(){
System.out.println("PRODUCT ID:"+productId);
System.out.println("PRODUCT NAME:"+productName);
System.out.println("PRICE:"+price);
System.out.println("QUANTITY:"+quantity);
}

}