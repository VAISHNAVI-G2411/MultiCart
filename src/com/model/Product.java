package com.model;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import com.main.MultiCart;
import com.model.Admin;
import com.model.Customer;
import com.model.Seller;
import com.model.Account;
import com.model.Address;
import com.model.Payment;
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

public class Product{
private int id;
private int stock;
private int sellerId;
private String name;
private String category;
private double price;
public Product(int id,int stock,int sellerId,String name,String category,double price){
this.id=id;
this.stock=stock;
this.sellerId=sellerId;
this.name=name;
this.category=category;
this.price=price;
}
public int getId(){
return id;
}
public void setId(int id){
this.id=id;
}
public int getStock(){
return stock;
}
public void setStock(int stock){
this.stock=stock;
}
public int getSellerId(){
return sellerId;
}
public void setSellerId(int sellerId){
this.sellerId=sellerId;
}
public String getName(){
return name;
}
public void setName(String name){
this.name=name;
}
public String getCategory(){
return category;
}
public void setCategory(String category){
this.category=category;
}
public double getPrice(){
return price;
}
public void setPrice(double price){
this.price=price;
}
public void print(){
System.out.println("ID:"+id);
System.out.println("STOCK:"+stock);
System.out.println("SELLER ID:"+sellerId);
System.out.println("NAME:"+name);
System.out.println("CATEGORY:"+category);
System.out.println("PRICE:"+price);
}

}