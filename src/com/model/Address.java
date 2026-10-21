package com.model;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import com.main.MultiCart;
import com.model.Admin;
import com.model.Customer;
import com.model.Seller;
import com.model.Product;
import com.model.Account;
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


public class Address{
private int addressId;
private int customerId;
private int orderId;
private String houseNo;
private String street;
private String city;
private String state;
private int pinCode;

public Address(int addressId,int customerId,int orderId,String houseNo,String street,String city,String state,int pinCode){
this.addressId=addressId;
this.customerId=customerId;
this.orderId=orderId;
this.houseNo=houseNo;
this.street=street;
this.city=city;
this.state=state;
this.pinCode=pinCode;
}

public int getAddressId(){
return addressId;
}
public void setAddressId(int addressId){
this.addressId=addressId;
}
public int getCustomerId(){
return customerId;
}
public void setCustomerId(int customerId){
this.customerId=customerId;
}
public int getOrderId(){
return orderId;
}
public void setOrderId(int orderId){
this.orderId=orderId;
}
public String getHouseNo(){
return houseNo;
}
public void setHouseNo(String houseNo){
this.houseNo=houseNo;
}
public String getStreet(){
return street;
}
public void setStreet(String street){
this.street=street;
}
public String getCity(){
return city;
}
public void setCity(String city){
this.city=city;
}
public String getState(){
return state;
}
public void setState(String state){
this.state=state;
}
public int getPinCode(){
return pinCode;
}
public void setPinCode(int pinCode){
this.pinCode=pinCode;
}

public void print(){
System.out.println("ADDRESS ID:"+addressId);
System.out.println("CUSTOMER ID:"+customerId);
System.out.println("ORDER ID:"+orderId);
System.out.println("HOUSE NO:"+houseNo);
System.out.println("STREET:"+street);
System.out.println("CITY:"+city);
System.out.println("STATE:"+state);
System.out.println("PIN CODE:"+pinCode);
}
}