-- Sample data for testing

-- PRODUCTS

set @tart_product_id = next value for hibernate_sequence;
set @lpizza_product_id = next value for hibernate_sequence;
set @mpizza_product_id = next value for hibernate_sequence;
set @icecream_product_id = next value for hibernate_sequence;
set @cake_product_id = next value for hibernate_sequence;

insert into product (id, name, unit_price)
values
    (@tart_product_id, 'Bakewell Tarts', 12),
    (@lpizza_product_id, 'Large Margarita Pizza', 17.50),
    (@mpizza_product_id, 'Medium Margarita Pizza', 12.50),
    (@icecream_product_id, 'Large Mint Chocolate Ice Cream', 10),
    (@cake_product_id, 'Triple Chocolate Cake', 18)
;

-- TAGS

set @pizza_tag_id = next value for hibernate_sequence;
set @icecream_tag_id = next value for hibernate_sequence;
set @large_tag_id = next value for hibernate_sequence;
set @medium_tag_id = next value for hibernate_sequence;
set @chocolate_tag_id = next value for hibernate_sequence;
set @cake_tag_id = next value for hibernate_sequence;

insert into tag (id, name) values
  (@pizza_tag_id, 'pizza'),
  (@icecream_tag_id, 'ice cream'),
  (@large_tag_id, 'large'),
  (@medium_tag_id, 'medium'),
  (@chocolate_tag_id, 'chocolate'),
  (@cake_tag_id, 'cake')
;

-- PRODUCT-TAG ASSOCIATIONS

insert into product_tag (products_id, tags_id) values
  (@tart_product_id, @cake_tag_id),
  (@lpizza_product_id, @large_tag_id),
  (@lpizza_product_id, @pizza_tag_id),
  (@mpizza_product_id, @medium_tag_id),
  (@mpizza_product_id, @pizza_tag_id),
  (@icecream_product_id, @large_tag_id),
  (@icecream_product_id, @icecream_tag_id),
  (@cake_product_id, @chocolate_tag_id),
  (@cake_product_id, @cake_tag_id)
;
