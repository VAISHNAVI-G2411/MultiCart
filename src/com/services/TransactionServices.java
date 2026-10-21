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
import com.services.PaymentServices;
import com.services.ProductServices;
import com.services.AccountServices;
import com.storage.Storage;

public class TransactionServices {

//add transaction

public void addTransaction(Transaction transaction,ArrayList<Transaction> transactions) {
transactions.add(transaction);
System.out.println("Transaction added successfully.");
}

//view transactions
public void viewTransactions(ArrayList<Transaction> transactions) {

    if (transactions.isEmpty()) {
        System.out.println("No transactions found.");
        return;
    }

    for (Transaction t : transactions) {
        t.print();
        System.out.println("-----------------------------");
    }
}

//view seller transactions

public void viewSellerTransactions(int sellerId,ArrayList<Transaction> transactions) {
for(Transaction transaction : transactions) {
if(transaction.getSellerId() == sellerId) {
transaction.print();
System.out.println("----------------");
}
}
}
}