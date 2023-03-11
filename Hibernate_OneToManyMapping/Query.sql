create table Customer (
       customerId integer not null,
        customerEmailId varchar(255),
        customerName varchar(255),
        primary key (customerId)
    );
    
    create table Order_details (
       customerID integer not null,
        orderID integer not null
    );
    
    create table Orders (
       orderID integer not null auto_increment,
        purchaseDate datetime,
        totalAmount double precision not null,
		productName varchar(40),
        primary key (orderID)
    );
    