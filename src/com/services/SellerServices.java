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
import com.services.AccountServices;
import com.services.CustomerServices;
import com.services.OrderServices;
import com.services.CartServices;
import com.services.PaymentServices;
import com.services.ProductServices;
import com.services.TransactionServices;
import com.storage.Storage;

public class SellerServices{
static Scanner sc=new Scanner(System.in);

// add product


public static void addProduct(Product product, ArrayList<Product> products) {
    ProductServices.addProduct(product, products);

}

//view my product

public static void viewMyProducts(int sellerId, ArrayList<Product> products) {
boolean found = false;
for (Product product : products) {
if (product.getSellerId() == sellerId) {
product.print();
found = true;
}
}
if (!found) {
System.out.println("No products found for this seller.");
}
} 

// update product


public static void updateProduct(int sellerId, ArrayList<Product> products) {
    System.out.print("Enter product ID:");
    int productId = sc.nextInt();
while ((!String.valueOf(productId).matches("[0-9]{1,6}") ||String.valueOf(productId).matches("0+") || productId < 0)) {
    System.out.println("Product ID must contain 1 to 6 digits and cannot be all zeros.");
    System.out.println("Enter product ID:");
    productId = sc.nextInt();
}
   
    for (Product product : products) {
        if (product.getId() == productId && product.getSellerId() == sellerId) {

            System.out.print("Enter new product name:");
            sc.nextLine();
            String name = sc.nextLine();

            while (!name.matches("[a-zA-Z]+( [a-zA-Z]+)*")) {
                System.out.println("Name must contain only alphabets and spaces.");
                System.out.print("Enter the name:");
                name = sc.nextLine();
            }

            System.out.print("Enter new category:");
            String category = sc.nextLine();

            while (!category.matches("[a-zA-Z]+( [a-zA-Z]+)*")) {
                System.out.println("Category must contain only alphabets and spaces.");
                System.out.print("Enter the category:");
                category = sc.nextLine();
            }

            System.out.print("Enter new price:");
            double price = sc.nextDouble();

            product.setName(name);
            product.setCategory(category);
            product.setPrice(price);

            System.out.println("Product updated successfully.");
            ProductServices.saveProducts(Storage.products);
            return;
        }
    }

    System.out.println("Product not found.");
}
//delete product

public static void deleteProduct(ArrayList<Product> products) {
System.out.print("Enter product ID:");
int productId = sc.nextInt();
while ((!String.valueOf(productId).matches("[0-9]{1,6}") ||String.valueOf(productId).matches("0+") || productId < 0)) {
    System.out.println("Product ID must contain 1 to 6 digits and cannot be all zeros.");
    System.out.println("Enter product ID:");
    productId = sc.nextInt();
}
for (int i = 0; i < products.size(); i++) {
if (products.get(i).getId() == productId) {
products.remove(i);
System.out.println("Product deleted successfully.");
return;
}
}
System.out.println("Product not found.");
}

//update stock

public static void updateStock(int sellerId, ArrayList<Product> products){
System.out.print("Enter product ID:");
int productId = sc.nextInt();
while ((!String.valueOf(productId).matches("[0-9]{1,6}") ||String.valueOf(productId).matches("0+") || productId < 0)) {
    System.out.println("Product ID must contain 1 to 6 digits and cannot be all zeros.");
    System.out.println("Enter product ID:");
    productId = sc.nextInt();
}
for (Product product : products) {
if (product.getId() == productId &&product.getSellerId() == sellerId) { 
System.out.print("Enter new stock:");
int stock = sc.nextInt();
product.setStock(stock);
System.out.println("Stock updated successfully.");
ProductServices.saveProducts(Storage.products);
return;
}
}
System.out.println("Product not found.");
}


}