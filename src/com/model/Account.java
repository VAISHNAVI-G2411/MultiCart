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


public class Account{
private int id;
private String name;
private String Email;
private String password;
private String confirmPassword;


public Account(int id,String name,String Email,String password,String confirmPassword){
this.id=id;
this.name=name;
this.Email=Email;
this.password=password;
this.confirmPassword=confirmPassword;
}

public int getId(){
return id;
}
public void setId(int id){
this.id=id;
}
public String getName(){
return name;
}
public void setName(String name){
this.name=name;
}
public String getEmail(){
return Email;
}
public void setEmail(String Email){
this.Email=Email;
}
public String getPassword(){
return password;
}
public void setPassword(String password){
this.password=password;
}
public String getConfirmPassword(){
return confirmPassword;
}
public void setConfirmPassword(String confirmPassword){
this.confirmPassword=confirmPassword;
}

public void print(){
System.out.println("ID:"+getId());
System.out.println("NAME:"+getName());
System.out.println("Email ID:"+getEmail());
}

}