package com.services;
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
import com.model.Account;
import com.services.AdminServices;
import com.services.SellerServices;
import com.services.CustomerServices;
import com.services.OrderServices;
import com.services.CartServices;
import com.services.AccountServices;
import com.services.ProductServices;
import com.services.TransactionServices;
import com.storage.Storage;

public class PaymentServices{
public void makePayment(Payment payment){
System.out.println("Payment processing...");
payment.print();
System.out.println("Payment successful.");
}
}