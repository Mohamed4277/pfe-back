INSERT INTO user (name,password,username)
values ("admin@admin.fr","$2a$10$C5Z9ftaa5QTLJAW390SGT.wZtV.NO8JnhOyRvYwcqki.rwTWT.tMG","admin@admin.fr");

INSERT INTO user_roles (user_id,roles_id) values((SELECT id FROM user WHERE username="admin@admin.fr"), (SELECT id FROM role where name="ROLE_ADMIN"));
INSERT INTO user_roles (user_id,roles_id) values((SELECT id FROM user WHERE username="admin@admin.fr"), (SELECT id FROM role where name="ROLE_USER"));