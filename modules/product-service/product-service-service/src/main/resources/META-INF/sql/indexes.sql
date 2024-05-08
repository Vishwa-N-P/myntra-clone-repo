create index IX_D6443C5 on Product_Brand (brandName[$COLUMN_LENGTH:75$]);
create index IX_83E2F517 on Product_Brand (uuid_[$COLUMN_LENGTH:75$]);

create index IX_F235FDEE on Product_CartList (userId);
create index IX_F2A5FD80 on Product_CartList (uuid_[$COLUMN_LENGTH:75$]);

create index IX_5D82A848 on Product_CartListProduct (cartListId, productId, size_[$COLUMN_LENGTH:75$]);

create index IX_B3CBB368 on Product_Highlights (features[$COLUMN_LENGTH:75$], size_[$COLUMN_LENGTH:75$]);
create index IX_3C62C43F on Product_Highlights (uuid_[$COLUMN_LENGTH:75$]);

create index IX_DE50E461 on Product_Image (imageUrl[$COLUMN_LENGTH:75$], productId);
create index IX_207D2829 on Product_Image (productId);
create index IX_EA6CE5C3 on Product_Image (uuid_[$COLUMN_LENGTH:75$]);

create index IX_39932CDD on Product_Product (productName[$COLUMN_LENGTH:75$], color[$COLUMN_LENGTH:75$], gender[$COLUMN_LENGTH:75$], brandId, highlightsId);
create index IX_956D64AF on Product_Product (uuid_[$COLUMN_LENGTH:75$]);

create index IX_8077BB20 on Product_ProductCategory (categoryName[$COLUMN_LENGTH:75$]);
create index IX_25E39451 on Product_ProductCategory (uuid_[$COLUMN_LENGTH:75$]);

create index IX_2EC1F6DF on Product_ProductOrder (uuid_[$COLUMN_LENGTH:75$]);

create index IX_B9ECAF15 on Product_Wishlist (userId);
create index IX_E0510B79 on Product_Wishlist (uuid_[$COLUMN_LENGTH:75$]);

create index IX_EA6539C6 on Product_WishlistProduct (wishlistId, productId);