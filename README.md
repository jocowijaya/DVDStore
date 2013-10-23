E-Commerce DVD Store Application
========
Copyright (C) 2013 Joco Wijaya.

<h2>System Overview</h2>

<b>DVDStore</b> application system is a web based system of DVD store which allows the customer to view and search DVD product information as well as buy and rent DVD products. The advanced system provide an efficient way for the customer in order to view the DVD product in the website instead of they need to go the store just to find the information. The system also allows the customer to place their order through the application. 

Not only handle the customer needs, but also <b>DVDStore</b> system provides several function and features for the DVD store employer and administrator in helping the customer who come to the store to view, search, buy and lease the DVD product. For the customer who is not able to place the order in the website system while they come to the store, the DVD employers will help them by using <b>DVDStore</b> application system. Not only view, and search but also create , edit and delete data function within the system has been provided for the administrator in utilising the system.

<h2>User Manual - Test Intruction</h2>

These are the intructions about how to run the <b>DVDStore</b> application software.

1. Download the application file (DVDStore-master.zip) via https://github.com/jocowijaya/DVDStore

2. Extra the <b>DVDStore-master.zip</b> file into your desktop. 

3. Go to Start Menu, and enter “<b>cmd</b>” in order to open the command prompt window.

4. Change the directory to the application folder, use the "<b>cd</b>" command. 

   > **For example**: “<b>cd Desktop\DVDStore-master</b>”

5. Start GlassFish domain by using following command: 

    ```sh
    asadmin start-domain
    ```

6. Create the pool link between the application and the server by using following command with the database name is <i><b>DVDStoreDB</b></i> and the pool link name is <i><b>DVDStorePool</b></i> : 

  ```sh
  asadmin create-jdbc-connection-pool --datasourceclassname=org.apache.derby.jdbc.ClientDataSource --restype=javax.sql.DataSource --property portNumber=1527:password=APP:user=APP:serverName=localhost:databaseName=DVDStoreDB:ConnectionAttributes=;create\=true DVDStorePool
  ```
  
7. Create the war file by using following command: 

  ```sh
  mvn package
  ```
  
8. Start <b>Derby Network Server<b>. 

    <b>IMPORTANT</b>: Make sure you already download the Derby Database folder.
   
    If not, you can download it via http://db.apache.org/derby/releases/release-10.6.2.1.html
   
   8.1 Find <b>startNetworkServer.bat</b> in the path 

   > **Note** : <b>db-derby-10.6.2.1-bin\bin\startNetworkServer.bat</b>

   8.2 Double click on it to start the server or you can start it by typing “startNetworkServer” in command prompt.
   
9. Move to target folder by using folloiwng command :

  ```sh
  cd target
  ```
10. Create the database in the server side by using command: 
  
  ```sh
  asadmin ping-connection-pool DVDStorePool
  ```
  
11. Create jdbc link between the database and the application by using following command with the jdbc link name is <b>DVDStoreDS</b>: 

  ```sh
  asadmin create-jdbc-resource –-connectionpoolid DVDStorePool jdbc/DVDStoreDS
  ```
  
12. Go back the application folder by using following command: 
  ```sh
  cd..
  ```

13. Compile, package the application and go to target folder again like <b>step 7</b> and <b>step 9</b>.

14. Deploy the application (war file) by using following command:
 
  ```sh
  asadmin deploy DVDStore.war 
  ```

  <b>IMPORTANT</b>: If it is already registered, using following command:
  
  ```sh
  asadmin redeploy DVDStore.war
  ```
  
  And enter "<b>DVDStore</b>" for the name option
  
  Now you are able to run the application browser.
  
15. Open browse, type “<b>localhost:8080/DVDStore</b>” to start the application.
    
    The user will always be navigated to the user default homepage at the beginning.At the time the browser displays the DVDStore homepage, the application will automatically load the default data into the database system. So the robust application contains several default data and ready to be used and tested.

16. For the testing purpose, the default admin username has been provided for tester to login into the system.

  ```sh
  Username (admin) : admin@yahoo.com
  Password (admin) : admin
  ```
  
<h2>Support</h2>

For any question regarding to DVDStore application, please do not hestiate to contact me via jocowijaya@gmail.com

*The application written by [Joco Wijaya](https://plus.google.com/106156651020787222104).* Feel free to add me to your circles on Google Plus and pester me to fix stuff that's broken or answer a question ^_^
