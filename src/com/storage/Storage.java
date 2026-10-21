package com.storage;
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
import com.model.Account;


public class Storage{
public static  ArrayList<Account> accounts=new ArrayList<>();
public static  ArrayList<Customer> customers=new ArrayList<>();
public static  ArrayList<Seller> sellers=new ArrayList<>();
public static  ArrayList<Product> products=new ArrayList<>();
public static  ArrayList<Address> addresses=new ArrayList<>();
public static  ArrayList<Payment> payments=new ArrayList<>();
public static  ArrayList<Order> orders=new ArrayList<>();
public static  ArrayList<Cart>carts=new ArrayList<>();
public static  ArrayList<Admin>admins=new ArrayList<>();
public static  ArrayList<CartItem>cartItems=new ArrayList<>();
public static  ArrayList<OrderItem>orderItems=new ArrayList<>();
public static  ArrayList<Transaction>transactions=new ArrayList<>();
public static  ArrayList<AccountServices>accountServices=new ArrayList<>();
public static  ArrayList<AdminServices>adminServices=new ArrayList<>();
public static  ArrayList<SellerServices>sellerServices=new ArrayList<>();
public static  ArrayList<CustomerServices>customerServices=new ArrayList<>();
public static  ArrayList<OrderServices>orderServices=new ArrayList<>();
public static  ArrayList<CartServices>cartServices=new ArrayList<>();
public static  ArrayList<PaymentServices>paymentServices=new ArrayList<>();
public static  ArrayList<ProductServices>productServices=new ArrayList<>();
public static  ArrayList<TransactionServices>transactionServices=new ArrayList<>();

}