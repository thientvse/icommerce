# brand
INSERT INTO icommerce.brand (id, name)
VALUES (1, 'Samsung');
INSERT INTO icommerce.brand (id, name)
VALUES (2, 'Apple');

# category
INSERT INTO icommerce.category (id, name)
VALUES (1, 'Điện thoại');
INSERT INTO icommerce.category (id, name)
VALUES (2, 'Điện tử');

# color
INSERT INTO icommerce.color (id, name)
VALUES (1, 'Red');
INSERT INTO icommerce.color (id, name)
VALUES (2, 'Blue');

# user
INSERT INTO icommerce.user (id, email, full_name, shipping_address, billing_address, phone)
VALUES (1, 'thientvse@gmail.com', 'Thiiều Văn Thiện', 'Tây Mỗ, Nam Từ Liêm', 'Tây Mỗ, Nam Từ Liêm', '0389937014');

INSERT INTO icommerce.customer (id, email, full_name, shipping_address, billing_address, phone_number)
VALUES (1, 'thientvse@gmail.com', 'Thiiều Văn Thiện', 'Tây Mỗ, Nam Từ Liêm', 'Tây Mỗ, Nam Từ Liêm', '0389937014');


#
INSERT INTO icommerce.product (id, product_name, description, category_id, brand_id, color_id, quantity, unit_price) VALUES (1, 'Điện thoại Samsung', 'Một sản phẩm của Samsung', 1, 1, 1, 100, 1000);
INSERT INTO icommerce.product (id, product_name, description, category_id, brand_id, color_id, quantity, unit_price) VALUES (2, 'Iphone 13', 'Một sản phẩm của Apple', 1, 2, 2, 50, 1000);
INSERT INTO icommerce.product (id, product_name, description, category_id, brand_id, color_id, quantity, unit_price) VALUES (3, 'Tủ lạnh Samsung', 'Một sản phẩm của Samsung', 2, 1, 2, 50, 500);

