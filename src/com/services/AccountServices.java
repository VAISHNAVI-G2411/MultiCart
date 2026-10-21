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
import com.services.TransactionServices;
import com.storage.Storage;



public class AccountServices{

static Scanner sc=new Scanner(System.in);
public static boolean signedIn = false;
public static boolean isSignedIn(){
return signedIn;
}


// sign up

public static void signUp(){

int id = generateId();
/*while ((!String.valueOf(id).matches("[0-9]{1,6}") ||String.valueOf(id).matches("0+") || id < 0)){
    System.out.println(" ID must contain 1 to 6 digits");
    System.out.println("Enter the ID:");
    id = sc.nextInt();
}*/

System.out.print("Enter the name:");
//sc.nextLine();
String name=sc.nextLine();

while (!name.matches("[a-zA-Z]+( [a-zA-Z]+)*")) {

    System.out.println
("Name must contain only alphabets and spaces");

    System.out.print("Enter the name:");
    name = sc.nextLine();
    
   }

System.out.print("Enter the Email ID:");
String emailId=sc.next().toLowerCase();

while (!emailId.matches("[a-z0-9]+@[a-z]+[0-9]*\\.[a-z]+")) {
    System.out.print("Invalid Email ID. \nEnter the Email ID:");
    emailId = sc.next();
}

for (Account a : Storage.accounts) {
if (a.getEmail().equals(emailId)) {
System.out.println("This Email ID already exists");
System.out.println("Please use a different Email ID");
return;
}
}

System.out.print("Enter the password:");
String password=sc.next();

while (!password.matches("(?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{5,10}")) { 
System.out.println("Password must be 5 to 10 characters"); 
System.out.println("Password must contain alphabet,number and at least one special character"); 
System.out.print("Enter the password:");
 password = sc.next(); 
}

System.out.print("Enter the confirm password:");
String confirmPassword=sc.next();


while(!password.equals(confirmPassword)){
System.out.println("password and confirmPassword must be same");
System.out.print("Enter the confirm password:");
confirmPassword=sc.next();
}
Account a=new Account(id,name,emailId,password,confirmPassword);
Storage.accounts.add(a);
System.out.println("SIGNING UP IS SUCCESSFULLY COMPLETED");

try (FileWriter fw = new FileWriter("accounts.txt", true)) {
    fw.write("ID: " + a.getId() + "\n");
    fw.write("Name: " + a.getName() + "\n");
    fw.write("EmailId: " + a.getEmail() + "\n");
    fw.write("Password: " + a.getPassword() + "\n");
    fw.write("Confirm Password: " + a.getConfirmPassword() + "\n");
    fw.write("----------------------------------------\n");

} catch (IOException e) {
    System.out.println("Error writing account data: " + e.getMessage());
}

}




public static void loadAccounts() {
try (BufferedReader br = new BufferedReader(new FileReader("accounts.txt"))) {
String line;
int id =0;
 String name = "", email = "", password = "", confirmPassword = "";

        while ((line = br.readLine()) != null) {
            if (line.startsWith("ID: ")) {
               id = Integer.parseInt(line.substring(4));
            } else if (line.startsWith("Name: ")) {
                name = line.substring(6);
            } else if (line.startsWith("EmailId: ")) {
                email = line.substring(9);
            } else if (line.startsWith("Password: ")) {
                password = line.substring(10);
            } else if (line.startsWith("Confirm Password: ")) {
                confirmPassword = line.substring(18);
            } else if (line.startsWith("---")) {
                boolean exists = false;

                for (Account a : Storage.accounts) {
                    if (a.getEmail().equalsIgnoreCase(email)) {
                        exists = true;
                        break;
                    }
                }

if (!exists && id != 0 && !email.isEmpty()){
                    Account a = new Account(id, name, email, password, confirmPassword);
                    Storage.accounts.add(a);
                }

                id = 0;
                name = "";
                email = "";
                password = "";
                confirmPassword = "";
            }
        }

    } catch (FileNotFoundException e) {
        System.out.println("Account file not found. It will be created during sign up.");
    } catch (IOException e) {
        System.out.println("Error loading accounts: " + e.getMessage());
    }
}



//sign in


public static void signIn() {

    if (signedIn) {
        System.out.println("An account is already signed in. Please sign out first.");
        return;
    }

    System.out.print("Enter the Email ID:");
    String emailId = sc.next().toLowerCase();

    while (!emailId.matches("[a-z0-9]+@[a-z0-9]+\\.[a-z]+")) {
        System.out.println("Invalid Email ID. \nEnter the Email ID:");
        emailId = sc.next().toLowerCase();
    }

    System.out.print("Enter the password:");
    String password = sc.next();

    while (!password.matches("(?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{5,10}")) {
        System.out.println("Password must be 5 to 10 characters");
        System.out.println("Password must contain alphabet, number and at least one special character");
        System.out.print("Enter the password:");
        password = sc.next();
    }

    for (Account a : Storage.accounts) {
        if (a.getEmail().equalsIgnoreCase(emailId)
                && a.getPassword().equals(password)) {

            signedIn = true;

            System.out.println("SIGNED IN SUCCESSFULLY");
            System.out.println("Welcome " + a.getName());
            return;
        }
    }

    System.out.println("Invalid Email ID or Password");
}

//sign out

public static void signOut(){
if (signedIn) {
signedIn = false;
System.out.println("YOU HAVE SUCCESSFULLY SIGNED OUT");
} 
else {
System.out.println("No account is signed in");
}
}

//ID generator

public static int generateCustomerId() {
    int maxId = 0;

    for (Customer c : Storage.customers) {
        if (c.getId() > maxId) {
            maxId = c.getId();
        }
    }

    return maxId + 1;
}

public static int generateSellerId() {
    int maxId = 0;

    for (Seller s : Storage.sellers) {
        if (s.getId() > maxId) {
            maxId = s.getId();
        }
    }

    return maxId + 1;
}

public static int generateAdminId() {
    int maxId = 0;

    for (Admin a : Storage.admins) {
        if (a.getId() > maxId) {
            maxId = a.getId();
        }
    }

    return maxId + 1;
}
public static int generateProductId() {
    int maxId = 0;

    for (Product p : Storage.products) {
        if (p.getId() > maxId) {
            maxId = p.getId();
        }
    }

    return maxId + 1;
}
public static int generateId() {
    int maxId = 0;

    for (Account acc : Storage.accounts) {
        if (acc.getId() > maxId) {
            maxId = acc.getId();
        }
    }

    return maxId + 1;
}

public static int generateOrderId() {
    int maxId = 0;

    for (Order ord : Storage.orders) {
        if (ord.getOrderId() > maxId) {
            maxId = ord.getOrderId();
        }
    }

    return maxId + 1;
}


}