#MULTICART CONSOLE BASED PROJECT USING JAVA

##ABOUT THE PROJECT
*MultiCart is the console based e-commerce project using Java, Exception Handling, File Handling, ArrayList and also language manager.
*User can select there confortable language
*The main users of this project is Admin,Seller and Customer.

##FEATURES

##Language Manager
*English
*Tamil
*Hindi
*Telugu
*Malayalam

##Admin
*Add Seller
*Remove Seller
*View Seller
*View Customer
*View Products
*View All Orders
*View Transactions
*Update Order Status

##Seller
*Add Product
*View My Product
*Update Product
*Delete Product
*Update Stock
*View Order

##Customer
*View Product
*Search Product
*Add to Cart
*Place Order
*View Cart
*Remove From Cart
*View My Order
*Make Payment
*Update Quantity
*Cancel Order
*Clear Cart

##TECHNOLOGIES USED
*Java
*OOPs
*File Handling
*Exception Handling
*Collections
*Git and GitHub

##PROJECT STRUCTURE
```text
multi_cart/
|---out/
|---src/
    |---com/
    |   |---main/
    |   |   |---MultiCart.java
    |   |---model/
    |   |   |---Account.java
    |   |   |---Admin.java
    |   |   |---Customer.java
    |   |   |---Seller.java
    |   |   |---Address.java
    |   |   |---Cart.java
    |   |   |---CartItem.java
    |   |   |---Order.java
    |   |   |---OrderItem.java
    |   |   |---Payment.java
    |   |   |---Product.java
    |   |   |---Transaction.java
    |   |   |---LanguageManager.java
    |   |---resources/
    |   |   |---messages.properties
    |   |   |---messages_hi.properties
    |   |   |---messages_ml.properties
    |   |   |---messages_ta.properties
    |   |   |---messages_te.properties
    |   |---services/
    |   |   |---AccountServices.java
    |   |   |---AdminServices.java
    |   |   |---CustomerServices.java
    |   |   |---SellerServices.java
    |   |   |---CartServices.java
    |   |   |---OrderServices.java
    |   |   |---PaymentServices.java
    |   |   |---ProductServices.java
    |   |   |---TransactionServices.java
    |   |---storage/
    |   |   |---Storage.java
    |---accounts.txt
    |---orders.txt
    |---products.txt
    |---sellers.txt
```
##HOW TO RUN
1.Open Command Prompt in the project folder.
2.Set the terminal encoding to UTF-8:`chcp 65001`
3.Copy the resource files into the output directory:`copy /Y com\resources\messages*.properties ..\out\com\resources\`
4.Compile the Java source files:`javac -d ..\out com\model\*.java com\services\*.java com\storage\*.java com\main\MultiCart.java`
5.Run the application:`java -cp ..\out com.main.MultiCart`

##FUTURE ENHANCEMENT
-**Database Integration:** Use MySQL to store user, product, and order details permanently.
-**User Authentication:** Improve login security and password protection.
-**Online Payment:** Integrate a secure payment gateway.
-**Web Interface:** Develop a user-friendly website for shopping.
-**Product Management:** Add product ratings, reviews, and advanced search filters.
-**Order Tracking:** Allow customers to track their order status.
-**Testing:** Add unit tests to improve application reliability.

##AUTHOR
Vaishnavi G
