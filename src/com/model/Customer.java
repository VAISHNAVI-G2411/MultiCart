package com.model;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import com.main.MultiCart;
import com.model.Admin;
import com.model.Account;
import com.model.Seller;
import com.model.Product;
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



public class Customer extends Account{
private long phoneNumber;
private String address;

public Customer(int id,String name,String Email,String password,long phoneNumber,String address){
super(id,name,Email,password,"");
this.phoneNumber=phoneNumber;
this.address=address;
}

public long getPhoneNumber(){
return phoneNumber;
}
public void setPhoneNumber(long phoneNumber){
this.phoneNumber=phoneNumber;
}
public String getAddress(){
return address;
}
public void setAddress(String address){
this.address=address;
}
public void print(){
System.out.println("ID:"+getId());
System.out.println("NAME:"+getName());
System.out.println("Email ID:"+getEmail());
System.out.println("PHONE NUMBER:"+getPhoneNumber());
System.out.println("ADDRESS:"+getAddress());

}

}