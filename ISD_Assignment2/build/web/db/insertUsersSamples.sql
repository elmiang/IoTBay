Insert into IOTBAYADMIN.users(
email,
password,
name,
dob,
gender,
address,
postcode,
phonenumber
)
values
('john.lee12@hotmail.com','jelly','John Lee','06/06/2000','m','123 Fake St, Fake','0000','0000000000'),
('Anna.bond12@hotmail.com','bubble','Anna bond','10/08/1999','f','124 Fake St, Fake','0001','0000111110'),
('Adam.Jones12@hotmail.com','Tank','Adam Jones','12/10/2006','m','125 Fake St, Fake','0002','000222220'),
('test1','test1','test','01/01/2001','t','test','test','test'),
('test2','test2','test','01/01/2001','t','test','test','test');

Insert into IOTBAYADMIN.CUSTOMER(
userID,
billingaddress,
cardnumber,
cardtype,
cardexpiry,
cvv
)
values
(15,'124 Fake St, Fake',123456789,'Credit','09/09/2022',000);