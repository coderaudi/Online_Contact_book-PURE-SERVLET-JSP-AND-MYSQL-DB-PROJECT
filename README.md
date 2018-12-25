# Online_Contact_book-PURE-SERVLET-JSP-AND-MYSQL-DB-PROJECT

THIS PROJECT IS THE BASIC CONTACT BOOK PROJECT .
FEATURES :  1. USER CAN CREATE THE ACCOUNT ON THE WEB 
            2. USER CAN LOGIN TO ACCOUNT 
            3. USER CAN ADD THE CONTACT TO THE CONTACT BOOK
            4. USER CAN SEE ALL THE ADDED CONTACT.
            5. USER CAN DELETE THE ADDED CONTACT.
            6. USER CAN LOGOUT 
            
FUTURE IMPLEMENTATION:1 . UPDATE DELETE THE CONTACT FROM THE BOOK
                      2 . ADMIN ACCOUNT 
                      3 . USER DASHBORD 
                      
# An PURE MVC Example with Servlets and JSP
Model-View-Controller (MVC) is a pattern used in software engineering to separate the application logic from the user interface. As the name implies, the MVC pattern has three layers.

The Model defines the business layer of the application, the Controller manages the flow of the application, and the View defines the presentation layer of the application.

# Here’re some key features of the pattern:

It separates the presentation layer from the business layer
The Controller performs the action of invoking the Model and sending data to View
The Model is not even aware that it is used by some web application or a desktop application

  1. SERVLETS  // FOR CONTROLLERS
  2. JSP  // VIEWS 
  3. MYSQL // TO STORE THE DATA
  4. JDBC  // CONNECTION INTERFACE 
  
2.1 The Model Layer
This is the data layer which contains business logic of the system, and also represents the state of the application.

It’s independent of the presentation layer, the controller fetches the data from the Model layer and sends it to the View layer.

2.2. The Controller Layer
Controller layer acts as an interface between View and Model. It receives requests from the View layer and processes them, including the necessary validations.

The requests are further sent to Model layer for data processing, and once they are processed, the data is sent back to the Controller and then displayed on the View.

2.3. The View Layer
This layer represents the output of the application, usually some form of UI. The presentation layer is used to display the Model data fetched by the Controller.
  
# PROJECT STRUCTURE 
Requirements:
Eclipse IDE
Apache tomcat server
MYSQL RDBMS APPLICATION
JSTL jar
MYSQL driver jar
