INSERT INTO user (name,password,username)
values ("mai@mai.fr","$2a$10$C5Z9ftaa5QTLJAW390SGT.wZtV.NO8JnhOyRvYwcqki.rwTWT.tMG","mai@mai.fr");

INSERT INTO user_roles (user_id,roles_id) values
((SELECT id FROM user WHERE username="mai@mai.fr"), (SELECT id FROM role where name="ROLE_USER"));
