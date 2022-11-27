INSERT INTO `payment_mode` (`card_number`, `card_type`,`is_credit_card_to_use`, `code_secret`, `name`)
VALUES ('4568589694123789','Visa',b'01', '123', 'Ma carte pour payer');

INSERT INTO user_payment_mode (user_id,payment_mode_id) VALUES( (SELECT id FROM user WHERE username="mai@mai.fr"),1);