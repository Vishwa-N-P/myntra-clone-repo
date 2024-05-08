create table Product_Brand (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	brandName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Product_CartList (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table Product_CartListProduct (
	id_ LONG not null primary key,
	cartListId LONG,
	productId LONG,
	size_ VARCHAR(75) null,
	quantity INTEGER,
	createDate DATE null,
	modifiedDate DATE null
);

create table Product_Highlights (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	features VARCHAR(75) null,
	size_ VARCHAR(110) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Product_Image (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	view VARCHAR(75) null,
	imageUrl VARCHAR(250) null,
	productId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table Product_Product (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	productName VARCHAR(150) null,
	productInfo VARCHAR(75) null,
	color VARCHAR(75) null,
	ratingCount LONG,
	rating DOUBLE,
	price LONG,
	discount LONG,
	discountPercentage INTEGER,
	finalPrice LONG,
	gender VARCHAR(75) null,
	brandId LONG,
	highlightsId LONG,
	productCount INTEGER,
	status INTEGER,
	createDate DATE null,
	modifiedDate DATE null
);

create table Product_ProductCategory (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	categoryName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Product_ProductOrder (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	productId LONG,
	size_ VARCHAR(75) null,
	quantity INTEGER,
	cost LONG,
	userId LONG,
	addressId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table Product_Wishlist (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table Product_WishlistProduct (
	id_ LONG not null primary key,
	wishlistId LONG,
	productId LONG,
	createDate DATE null,
	modifiedDate DATE null
);