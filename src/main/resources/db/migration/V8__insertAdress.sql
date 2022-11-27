INSERT INTO `adresses` (`is_delivery_adress`,`is_invoice_adress`, `adress_part_one`, `adress_part_two`, `city`, `last_name_adress`,
                        `name_adress`, `street_number`, `zip`)
VALUES (b'01',b'01', 'Boulevard Charles De Gaulle', 'Immeuble 1', 'Paris', 'Bertrand', 'Daniel', '12', '75004');

INSERT INTO user_adresses (user_id,adresses_id) VALUES( (SELECT id FROM user WHERE username="mai@mai.fr"),1);
