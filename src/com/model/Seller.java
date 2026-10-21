package com.model;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import com.main.MultiCart;
import com.model.Admin;
import com.model.Customer;
import com.model.Account;
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

public class Seller extends Account{
private String companyName;
public Seller(int id,String name,String Email,String password,String companyName){
super(id,name,Email,password,"");
this.companyName=companyName;
}
public String getCompanyName(){
return companyName;
}
public void setCompanyName(String companyName){
this.companyName=companyName;
}
public void print(){
System.out.println("ID:"+getId());
System.out.println("NAME:"+getName());
System.out.println("Email ID:"+getEmail());
System.out.println("COMPANY NAME:"+getCompanyName());
}

}