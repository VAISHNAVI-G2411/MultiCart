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
import com.services.AccountServices;
import com.services.TransactionServices;
import com.storage.Storage;

public class ProductServices{
Scanner sc=new Scanner(System.in);

// add product


public static void addProduct(Product product, ArrayList<Product> products) {
    products.add(product);

    try (FileWriter fw = new FileWriter("products.txt", true)) {
        fw.write("ID: " + product.getId() + "\n");
        fw.write("Name: " + product.getName() + "\n");
        fw.write("Category: " + product.getCategory() + "\n");
        fw.write("Price: " + product.getPrice() + "\n");
        fw.write("Stock: " + product.getStock() + "\n");
        fw.write("Seller ID: " + product.getSellerId() + "\n");
        fw.write("----------------------------------------\n");

    } catch (IOException e) {
        System.out.println("Error saving product: " + e.getMessage());
    }
}

public static void loadProducts() {
    try (BufferedReader br = new BufferedReader(new FileReader("products.txt"))) {
        String line;
        String id = "", name = "", category = "", sellerId = "";
        double price = 0;
        int stock = 0;

        while ((line  = br.readLine()) != null) {
            if (line.startsWith("ID: ")) {
                id = line.substring(4);
            } else if (line.startsWith("Name: ")) {
                name = line.substring(6);
            } else if (line.startsWith("Category: ")) {
                category = line.substring(10);
            } else if (line.startsWith("Price: ")) {
                price = Double.parseDouble(line.substring(7));
            } else if (line.startsWith("Stock: ")) {
                stock = Integer.parseInt(line.substring(7));
            } else if (line.startsWith("Seller ID: ")) {
                sellerId = line.substring(11);
            } else if (line.startsWith("---")) {
                boolean exists = false;

                for (Product p : Storage.products) {
                    if (String.valueOf(p.getId()).equals(id)) {
                        exists = true;
                        break;
                    }
                }

                if (!exists && !id.isEmpty()) {
                    Product product = new Product(
                        Integer.parseInt(id), stock, Integer.parseInt(sellerId),
                        name, category, price
                    );
                    Storage.products.add(product);
                }

                id = "";
                name = "";
                category = "";
                sellerId = "";
                price = 0;
                stock = 0;
            }
        }

    } catch (FileNotFoundException e) {
        System.out.println("Product file not found. It will be created when a product is added.");
    } catch (IOException e) {
        System.out.println("Error loading products: " + e.getMessage());
    }
}

public static void saveProducts(ArrayList<Product> products) {
    try (FileWriter fw = new FileWriter("products.txt")) {
        for (Product product : products) {
            fw.write("ID: " + product.getId() + "\n");
            fw.write("Name: " + product.getName() + "\n");
            fw.write("Category: " + product.getCategory() + "\n");
            fw.write("Price: " + product.getPrice() + "\n");
            fw.write("Stock: " + product.getStock() + "\n");
            fw.write("Seller ID: " + product.getSellerId() + "\n");
            fw.write("----------------------------------------\n");
        }
    } catch (IOException e) {
        System.out.println("Error saving products: " + e.getMessage());
    }
}



//view product

public static void viewProducts(ArrayList<Product> products) {
for(Product product : products) {
product.print();
}
}

//search product

public static void searchProduct(String name, ArrayList<Product> products) {
for(Product product : products) {
if(product.getName().equalsIgnoreCase(name)) {
product.print();
}
}
}

// search by category

public static void searchByCategory(String category, ArrayList<Product> products) {
for(Product product : products) {
if(product.getCategory().equalsIgnoreCase(category)) {
product.print();
}
}
}
}