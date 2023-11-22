drop schema if exists computer_store;
CREATE schema computer_store;
use computer_store;

create table item(
itemId varchar(20) not null primary key,
prodType varchar(20) not null,
prodName varchar(60) not null,
prodInfo varchar(90) not null,
category varchar(60) not null,
brand varchar(60) not null,
quantity int not null,
price double not null,
rating double,
ecoFriendly bool,
prodVersion double not null,
prodPlatform varchar(60),
weight int not null
);

create table address(
addrId int not null,
street varchar(100) not null,
province varchar(20) not null,
country varchar(50) not null,
postalCode varchar(10) not null,
phone varchar(20) not null,
primary key(addrId)
);

create table customer(
id int not null,
firstName varchar(60) not null,
lastName varchar(60) not null,
addressID int not null,
primary key(id),
foreign key(addressID) references Address(addrId)
);

create table purchaseOrder(
purchId int not null,
customerId int  not null,
quantity int not null,
date varchar(20) not null,
primary key(purchId),
foreign key(customerId) references customer(id)
);

create table orderItem(
orderItemId INT NOT NULL AUTO_INCREMENT,
purchId INT NOT NULL,
itemId VARCHAR(20) NOT NULL,
quantity INT NOT NULL,
orderItemCost double not null.
PRIMARY KEY(orderItemId),
FOREIGN KEY(purchId) REFERENCES purchaseOrder(purchId),
FOREIGN KEY(itemId) REFERENCES item(itemId)
);

create table administrator(
adminId int not null,
admFirstName varchar(20) not null,
admLastName varchar(20) not null,
admAddrID int not null,
primary key(adminId),
foreign key(admAddrId) references Address(addrId)
);

create table review(
reviewId varchar(20) not null primary key,
productId varchar(20) not null, 
review varchar(200),
rating double not null,
customerId int,
foreign key(customerId) references customer(id),
foreign key (productId) references item(itemId)
);







