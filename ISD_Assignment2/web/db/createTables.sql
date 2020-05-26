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
    userID      integer(10),
    position    varchar(20),
    dateHired   date(6),
    salary      double(8)
);

CREATE TABLE Customer
(
    userID          integer(10),
    billingAddress  varchar(100),
    cardNumber      integer(16),
    cardType        varchar(12),
    cardExpiry      date(4),
    cvv             integer(3)
);

CREATE TABLE AccessLogs
(
    userID integer(10),
    action varchar(30),
    time   timestamp(14)
);


CREATE TABLE Store
(
    storeID         integer(10),
    storeAddress    varchar(100),
    businessHours   varchar(50)
);

CREATE TABLE Order
(
    orderID         integer(10),
    userID          integer(10),
    orderDate       date(6),
    orderStatus     varchar(30),
    deliveryType    varchar(20)
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
    productID       integer(10),
    orderID         integer(10),
    quantity        integer(3),
    price           double(8)
);

CREATE TABLE Invoice
(
    invoiceID   integer(10),
    orderID     integer(10),
    subTotal    double(10),
    issueDate   date(6),
    dueDate     date(6),
    tax         double(10),
    total       double(10)
);

CREATE TABLE Admin
(
    userID      integer(10),
    dateHired   date(6),
    salary      double(8)
);

CREATE TABLE Payment
(
    paymentID       integer(10),
    invoiceID       integer(10),
    paidDate        date(6),
    paymentMethod   varchar(20),
    paidAmount      double(8)
);

CREATE TABLE Shipment
(
    shipmentID      integer(10),
    orderID         integer(10),
    startDate       date(6),
    estArrDate      date(6),
    deliveryAddress varchar(50),
    currentStatus   varchar(100)
);

