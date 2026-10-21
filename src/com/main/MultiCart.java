package com.main;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import com.model.Account;
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
import com.model.LanguageManager;


public class MultiCart{
static Scanner sc=new Scanner(System.in);


static AccountServices accountServices = new AccountServices();
static AdminServices adminServices = new AdminServices();
static SellerServices sellerServices = new SellerServices();
static CustomerServices customerServices = new CustomerServices();
static OrderServices orderServices = new OrderServices();
static CartServices cartServices = new CartServices();
static PaymentServices paymentServices = new PaymentServices();
static ProductServices productServices = new ProductServices();
static TransactionServices transactionServices = new TransactionServices();

public static void main(String[] args){
AccountServices.loadAccounts();
ProductServices.loadProducts();
orderServices.loadOrders(Storage.orders);
adminServices.loadSellers(Storage.sellers);
int languageChoice;
int person;
int AdminChoice;
int CustomerChoice;
int SellerChoice;
int choice1;
int choice2;
int choice3;

LanguageManager languageManager = new LanguageManager();
do { 
System.out.println("-------------------------------------------"); 
System.out.println("Select your language"); 
System.out.println("-------------------------------------------"); 
System.out.println("1. English\n2. Tamil\n3. Hindi\n4. Telugu\n5. Malayalam"); 
try { languageChoice = sc.nextInt(); 

if (languageChoice >= 1 && languageChoice <= 5) { 
languageManager.selectLanguage(languageChoice); 
System.out.println(languageManager.getMessage("welcome")); 
break; 
} else 
{ 
System.out.println("Invalid choice. Enter a number from 1 to 5."); 
} } 
catch (java.util.InputMismatchException e) { 
System.out.println("Invalid input. Enter a number from 1 to 5."); 
sc.next();
 } }
 while (true);

do{
System.out.println("-------------------------------------------");
System.out.println("Select who are you?");
System.out.println("\n1."+languageManager.getMessage("admin")+"\n2."+languageManager.getMessage("seller")+"\n3."+languageManager.getMessage("customer")+"\n4."+languageManager.getMessage("exit")+"\n");
System.out.print("Enter the person:");
try{
person=sc.nextInt();

switch(person){

case 1:
do{
System.out.println("-------------------------------------------");
System.out.println("1." + languageManager.getMessage("account"));
System.out.println("2." + languageManager.getMessage("add_seller"));
System.out.println("3." + languageManager.getMessage("remove_seller"));
System.out.println("4." + languageManager.getMessage("view_seller"));
System.out.println("5." + languageManager.getMessage("view_customer"));
System.out.println("6." + languageManager.getMessage("view_products"));
System.out.println("7." + languageManager.getMessage("view_all_orders"));
System.out.println("8." + languageManager.getMessage("view_transactions"));
System.out.println("9." + languageManager.getMessage("update_order_status"));
System.out.println("10." + languageManager.getMessage("exit"));

System.out.print("Enter the Admin choice:");
try{
AdminChoice=sc.nextInt();

 switch(AdminChoice){

 case 1:
 do{
System.out.println("-------------------------------------------");
 System.out.println("1.Sign In\n2.Sign Up\n3.Sign Out\n4.Exit\n");
 System.out.print("Enter the Choice:");
 try{
 choice1=sc.nextInt();

  switch(choice1){
  case 1:
  AccountServices.signIn();
  break;

  case 2:
  AccountServices.signUp();
  break;

  case 3:
  AccountServices.signOut();
  break;

  case 4:
  System.out.println("Exit");
  break;

  default:
  System.out.println("invalid");
 }
 }
 catch(Exception e){
 System.out.println("Enter the given choice");
 sc.next();
 choice1=0;
}

}
while(choice1!=4);
 break;

case 2:
    if (AccountServices.isSignedIn()) {
        adminServices.addSeller(Storage.sellers);
    } else {
        System.out.println("Please sign in first.");
    }
    break;

case 3:
    if (AccountServices.isSignedIn()) {
        System.out.println("Enter Seller ID:");
        int removeSellerId = sc.nextInt();
while ((!String.valueOf(removeSellerId).matches("[0-9]{1,6}")||String.valueOf(removeSellerId).matches("0+") || removeSellerId < 0))

{
    System.out.println("remove Seller ID must contain 1 to 6 digits and cannot be all zeros.");
    System.out.println("Enter removeSeller ID:");
   removeSellerId = sc.nextInt();
}

adminServices.removeSeller(removeSellerId, Storage.sellers);
           } else {
        System.out.println("Please sign in first.");
    }
    break;

  
 case 4:
    if (AccountServices.isSignedIn()) {
        adminServices.viewSeller(Storage.sellers);
    } else {
        System.out.println("Please sign in first.");
    }
    break;

 case 5:
    if (AccountServices.isSignedIn()) {
        adminServices.viewCustomer(Storage.customers);
    } else {
        System.out.println("Please sign in first.");
    }
    break;

 case 6:
    if (AccountServices.isSignedIn()) {
        adminServices.viewProducts(Storage.products);
    } else {
        System.out.println("Please sign in first.");
    }
    break;

 case 7:
    if (AccountServices.isSignedIn()) {
        adminServices.viewAllOrders(Storage.orders);
    } else {
        System.out.println("Please sign in first.");
    }
    break;

case 8:
    if (AccountServices.isSignedIn()) {
        transactionServices.viewTransactions(Storage.transactions);
    } else {
        System.out.println("Please sign in first.");
    }
    break;

 case 9:
    if (AccountServices.isSignedIn()) {
        orderServices.updateOrderStatus(Storage.orders);
    } else {
        System.out.println("Please sign in first.");
    }
    break;

 case 10:
 System.out.println("Exit");
 break;

 default:
 System.out.println("Invalid");

 }
 }
 catch(Exception e){
 System.out.println("Enter the given choice");
 sc.next();
 AdminChoice=0;
}

}
while(AdminChoice!=10);

break;

case 2:
do{
System.out.println("-------------------------------------------");
System.out.println("1." + languageManager.getMessage("account"));
System.out.println("2." + languageManager.getMessage("add_product"));
System.out.println("3." + languageManager.getMessage("view_my_product"));
System.out.println("4." + languageManager.getMessage("update_product"));
System.out.println("5." + languageManager.getMessage("delete_product"));
System.out.println("6." + languageManager.getMessage("update_stock"));
System.out.println("7." + languageManager.getMessage("view_order"));
System.out.println("8." + languageManager.getMessage("exit"));
System.out.print("Enter the Seller choice:");
try{
 SellerChoice=sc.nextInt();

 switch(SellerChoice){
 case 1:
do{
System.out.println("-------------------------------------------");
 System.out.println("1.Sign In\n2.Sign Up\n3.Sign Out\n4.Exit\n");
 System.out.print("Enter the Choice:");
try{
 choice2=sc.nextInt();

  switch(choice2){
  case 1:
  AccountServices.signIn();
  break;

  case 2:
  AccountServices.signUp();
  break;

  case 3:
  AccountServices.signOut();
  break;

  case 4:
  System.out.println("Exit");
  break;

  default:
  System.out.println("Invalid");
  }
 }
 catch(Exception e){
 System.out.println("Enter the given choice");
 sc.next();
 choice2=0;
}

}
while(choice2!=4);
 break;

 
 case 2:

  int productId = AccountServices.generateProductId();
  System.out.println("Your Product ID: " + productId);
  int sellerId = AccountServices.generateSellerId();
  System.out.println("Your Seller ID: " + sellerId);

    System.out.print("\nEnter Stock:");
    int stock = sc.nextInt();
    sc.nextLine();

    System.out.print("\nEnter Product Name:");
    String productName = sc.nextLine();

    System.out.print("\nEnter Category:");
    String category = sc.nextLine();

    System.out.print("\nEnter Price:");
    double price = sc.nextDouble();

    Product product = new Product(
        productId,
        stock,
        sellerId,
        productName,
        category,
        price
    );

    sellerServices.addProduct(product, Storage.products);

    break;

 case 3:
 System.out.print("Enter Seller ID:");
 int viewSellerId = sc.nextInt();
while ((!String.valueOf(viewSellerId).matches("[0-9]{1,6}") ||String.valueOf(viewSellerId).matches("0+") || viewSellerId < 0)) {
    System.out.println("viewSeller ID must contain 1 to 6 digits and cannot be all zeros.");
    System.out.println("Enter viewSeller ID:");
    viewSellerId = sc.nextInt();
}

 SellerServices.viewMyProducts(viewSellerId, Storage.products);
 break;

case 4:
    System.out.print("Enter Seller ID:");
    int updateSellerId = sc.nextInt();
while ((!String.valueOf(updateSellerId).matches("[0-9]{1,6}") ||String.valueOf(updateSellerId).matches("0+") || updateSellerId < 0)) {
    System.out.println("updateSeller ID must contain 1 to 6 digits and cannot be all zeros.");
    System.out.println("Enter updateSeller ID:");
    updateSellerId = sc.nextInt();
}
    SellerServices.updateProduct(updateSellerId, Storage.products);
    break;

 case 5:
 sellerServices.deleteProduct(Storage.products);
 break;
 
 case 6:
 System.out.print("Enter Seller ID:");
 int stockSellerId = sc.nextInt();
while ((!String.valueOf(stockSellerId).matches("[0-9]{1,6}") ||String.valueOf(stockSellerId).matches("0+") || stockSellerId < 0)) {
    System.out.println("seller ID must contain 1 to 6 digits and cannot be all zeros.");
    System.out.println("Enter seller ID:");
    stockSellerId = sc.nextInt();
}
 SellerServices.updateStock(stockSellerId, Storage.products);
 break;
 
case 7:
    System.out.print("Enter Seller ID:");
    int sellerId1 = sc.nextInt();

    orderServices.viewSellerOrders(sellerId1, Storage.orders);
    break;

 case 8:
 System.out.println("Exit");
 break;

 default:
 System.out.println("Invalid");
 }
 }
 catch(Exception e){
 System.out.println("Enter the given choice");
 sc.next();
 SellerChoice=0;
 }

 }
 while(SellerChoice!=8);
break;

case 3:
  int customerId = AccountServices.generateCustomerId();
  System.out.println("Your customer ID: " + customerId);

Cart cart = new Cart(customerId);
do{
System.out.println("-------------------------------------------");
System.out.println("1." + languageManager.getMessage("account"));
System.out.println("2." + languageManager.getMessage("view_product"));
System.out.println("3." + languageManager.getMessage("search_product"));
System.out.println("4." + languageManager.getMessage("add_to_cart"));
System.out.println("5." + languageManager.getMessage("view_cart"));
System.out.println("6." + languageManager.getMessage("remove_from_cart"));
System.out.println("7." + languageManager.getMessage("place_order"));
System.out.println("8." + languageManager.getMessage("make_payment"));
System.out.println("9." + languageManager.getMessage("view_my_order"));
System.out.println("10." + languageManager.getMessage("cancel_order"));
System.out.println("11." + languageManager.getMessage("update_quantity"));
System.out.println("12." + languageManager.getMessage("clear_cart"));
System.out.println("13." + languageManager.getMessage("exit"));
System.out.print("Enter the Customer choice:");
try{
CustomerChoice=sc.nextInt();

 switch(CustomerChoice){
 
 case 1:
 do{
System.out.println("-------------------------------------------");
 System.out.println("1.Sign In\n2.Sign Up\n3.Sign Out\n4.Exit\n");
 System.out.print("Enter the Choice:");
 try{
 choice3=sc.nextInt();

  switch(choice3){
  case 1:
  AccountServices.signIn();
  break;

  case 2:
  AccountServices.signUp();
  break;

  case 3:
  AccountServices.signOut();
  break;

  case 4:
  System.out.println("Exit");
  break;

  default:
  System.out.println("Invalid");
 }
 }
 catch(Exception e){
 System.out.println("Enter the given choice");
 sc.next();
 choice3=0;
}

}
while(choice3!=4);
 break;
 
case 2:
    CustomerServices.viewProducts(Storage.products);
    break;

 case 3:
    System.out.print("Enter Product Name:");
    String searchName = sc.next();

    CustomerServices.searchProduct(searchName, Storage.products);

    break;
 

case 4:

    System.out.print("Enter Product ID:");
    int productId = sc.nextInt();
while ((!String.valueOf(productId).matches("[0-9]{1,6}") ||String.valueOf(productId).matches("0+") || productId < 0)) {
    System.out.println("product ID must contain 1 to 6 digits and cannot be all zeros.");
    System.out.println("Enter product ID:");
    productId = sc.nextInt();
}

    System.out.print("Enter Quantity:");
    int quantity = sc.nextInt();

    boolean found = false;

    for (Product product : Storage.products) {

        if (product.getId() == productId) {

            if (quantity <= 0) {
                System.out.println("Quantity must be greater than 0.");
                break;
            }

            if (quantity > product.getStock()) {
                System.out.println("Not enough stock available.");
                break;
            }

            CartItem item = new CartItem(
                product.getId(),
                product.getName(),
                product.getPrice(),
                quantity
            );

            CustomerServices.addToCart(cart, item);

            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Product not found.");
    }

    break;


 case 5:
 customerServices.viewCart(cart);
 break;

 case 6:
 customerServices.removeFromCart(cart);
 break;

 case 7:
  int orderId = AccountServices.generateOrderId();
  System.out.println("Your order ID: " + orderId);

    CustomerServices.placeOrder(
        orderId,
        customerId,
        cart,
        Storage.orders,
        Storage.products
    );

    break;
 
case 8:

    System.out.print("Enter Payment ID:");
    int paymentId = sc.nextInt();
while ((!String.valueOf(paymentId).matches("[0-9]{1,6}") ||String.valueOf(paymentId).matches("0+") || paymentId < 0)){
    System.out.println("payment ID must contain 1 to 6 digits and cannot be all zeros.");
    System.out.println("Enter payment ID:");
    paymentId = sc.nextInt();
}

    System.out.print("Enter Order ID:");
    orderId = sc.nextInt();
while ((!String.valueOf(orderId).matches("[0-9]{1,6}") ||String.valueOf(orderId).matches("0+") || orderId < 0)) {
    System.out.println("order ID must contain 1 to 6 digits and cannot be all zeros.");
    System.out.println("Enter order ID:");
    orderId = sc.nextInt();
}

    Order selectedOrder = null;

    for (Order order : Storage.orders) {
        if (order.getOrderId() == orderId &&
            order.getCustomerId() == customerId) {
            selectedOrder = order;
            break;
        }
    }

    if (selectedOrder == null) {
        System.out.println("Order not found.");
        break;
    }

   double orderAmount = 0;

for (OrderItem item : selectedOrder.getItems()) {
    orderAmount += item.getPrice() * item.getQuantity();
}

selectedOrder.setTotalAmount(orderAmount);
    System.out.print("Order Amount: Rs." + orderAmount);

    System.out.println("Select Payment Method:");
    System.out.println("1. GPay");
    System.out.println("2. PhonePe");
    System.out.println("3. Card");
    System.out.println("4. Cash on Delivery");
    System.out.println("5. RuPay");

    System.out.print("Enter your choice:");
    int choice = sc.nextInt();

    String paymentMethod = "";

    switch (choice) {
        case 1:
            paymentMethod = "GPay";
            break;
        case 2:
            paymentMethod = "PhonePe";
            break;
        case 3:
            paymentMethod = "Card";
            break;
        case 4:
            paymentMethod = "Cash on Delivery";
            break;
        case 5:
            paymentMethod = "RuPay";
            break;
        default:
            System.out.println("Invalid payment method.");
            break;
    }

    if (paymentMethod.isEmpty()) {
        break;
    }

    System.out.print("Enter Amount:");
    double amount = sc.nextDouble();

    while (amount != orderAmount) {
        System.out.println("Incorrect amount.");
        System.out.print("Please enter Rs." + orderAmount);
        amount = sc.nextDouble();
    }

    String paymentStatus = "SUCCESS";

    if (paymentMethod.equals("Cash on Delivery")) {
        paymentStatus = "PENDING";
    }

    Payment payment = new Payment(
        paymentId,
        orderId,
        amount,
        paymentMethod,
        paymentStatus
    );


Storage.payments.add(payment);
paymentServices.makePayment(payment);

if (paymentStatus.equals("SUCCESS")) {

    for (OrderItem item : selectedOrder.getItems()) {

        double productAmount = item.getPrice() * item.getQuantity();
        double adminCommission = productAmount * 0.10;
        double sellerAmount = productAmount - adminCommission;

        int transactionId = Storage.transactions.size() + 1;

        Transaction transaction = new Transaction(
            transactionId,
            orderId,
            item.getSellerId(),
            productAmount,
            adminCommission,
            sellerAmount,
            "SUCCESS"
        );

        transactionServices.addTransaction(
            transaction,
            Storage.transactions
        );
    }
}

break;


 case 9:
 customerServices.viewMyOrder(customerId,Storage.orders);
 break;

 case 10:
 customerServices.cancelOrder(customerId,Storage.orders);
 break;

 case 11:
 cartServices.updateQuantity(cart);
 break;

 case 12:
 cartServices.clearCart(cart);
 break;

 case 13:
 System.out.println("Exit");
 break;
 
 default:
 System.out.println("Invalid");
 }
 }
 catch(Exception e){
 System.out.println("Enter the given choice");
 sc.next();
 CustomerChoice=0;
}

}
while(CustomerChoice!=13);
break;

case 4:
System.out.println("Exit");
break;

default:
System.out.println("Invalid");
}
}

catch(Exception e){
System.out.println("Enter the given choice");
sc.next();
person=0;
}

}
while(person!=4);
}}