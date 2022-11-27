INSERT INTO user (name,password,username)
values ("mai@mai.fr","$2a$10$lvD4ipG1fR.JCpeFViV3aOXpjupRcGspP1Y2jtjYUjW/8mGKOAhRy","mai@mai.fr");

INSERT INTO user_roles (user_id,roles_id) values
((SELECT id FROM user WHERE username="mai@mai.fr"), (SELECT id FROM role where name="ROLE_USER"));
