CREATE TABLE Users
(
    userID      integer NOT NULL PRIMARY KEY
                GENERATED ALWAYS AS IDENTITY
                (START WITH 1, INCREMENT BY 1),
    email       varchar(30),
    password    varchar(16),
    name        varchar(30),
    dob         date,
    gender      varchar(1),
    address     varchar(100),
    postCode    varchar(4),
    phoneNumber varchar(15)
    
);

CREATE TABLE Staff
(
    userID      integer NOT NULL,
    position    varchar(20),
    dateHired   date,
    salary      double,
    FOREIGN KEY (userID) REFERENCES Users(userID)
);

CREATE TABLE Customer
(
    userID          integer NOT NULL,
    billingAddress  varchar(100),
    cardNumber      integer,
    cardType        varchar(12),
    cardExpiry      date,
    cvv             integer,
    FOREIGN KEY (userID) REFERENCES Users(userID)
);

CREATE TABLE AccessLogs
(
    userID Integer NOT NULL,
    action varchar(30),
    time   timestamp,
    FOREIGN KEY (userID) REFERENCES Users(userID)
);


CREATE TABLE Store
(
    storeID         integer,
    storeAddress    varchar(100),
    businessHours   varchar(50)
);

CREATE TABLE OrderTable
(
    orderID         integer,
    userID          integer NOT NULL,
    orderDate       date,
    orderStatus     varchar(30),
    deliveryType    varchar(20),
    FOREIGN KEY (userID) REFERENCES Users(userID)
);

CREATE TABLE Product
(
    productID       integer NOT NULL PRIMARY KEY
                    GENERATED ALWAYS AS IDENTITY
                    (START WITH 1, INCREMENT BY 1),
    productName     varchar(50),
    type            varchar(30),
    description     varchar(300),
    quantity        varchar(4),
    availability    boolean,
    price           double
);

CREATE TABLE OrderLine
(
    productID       integer,
    orderID         integer,
    quantity        integer,
    price           double
);

CREATE TABLE Invoice
(
    invoiceID   integer,
    orderID     integer,
    subTotal    double,
    issueDate   date,
    dueDate     date,
    tax         double,
    total       double
);

CREATE TABLE Admin
(
    userID      integer NOT NULL,
    dateHired   date,
    salary      double,
    FOREIGN KEY (userID) REFERENCES Users(userID)
);

CREATE TABLE Payment
(
    paymentID       integer,
    invoiceID       integer,
    paidDate        date,
    paymentMethod   varchar(20),
    paidAmount      double
);

CREATE TABLE Shipment
(
    shipmentID      integer,
    orderID         integer,
    startDate       date,
    estArrDate      date,
    deliveryAddress varchar(20),
    currentStatus   varchar(20)
);

CREATE TABLE UserRecord
(
    userID      integer NOT NULL PRIMARY KEY
                GENERATED ALWAYS AS IDENTITY
                (START WITH 1, INCREMENT BY 1),
    email       varchar(30),
    password    varchar(16),
    name        varchar(30),
    dob         date,
    gender      varchar(1),
    address     varchar(100),
    postCode    varchar(4),
    phoneNumber varchar(15),
    role varchar(100)
    
);