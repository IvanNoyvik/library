INSERT INTO ROLES (ROLE) VALUES 'Administrator';
INSERT INTO ROLES (ROLE) VALUES 'User';
INSERT INTO ROLES (ROLE) VALUES 'Guest';


INSERT INTO USERS_STATUSES (STATUS, DURATION) VALUES ('OK', CURRENT_DATE());
INSERT INTO USERS_STATUSES (STATUS, DURATION) VALUES ('Locked', CURRENT_DATE());
-- INSERT INTO USERS_STATUSES (STATUS, DURATION) VALUES ('Limited', CURRENT_DATE());



INSERT INTO USERS (LOGIN, PASSWORD, NAME, ROLES_ID, USERS_STATUSES_ID) VALUES ('admin', '1', 'admin', 1, 1);
INSERT INTO USERS (LOGIN, PASSWORD, NAME, ROLES_ID, USERS_STATUSES_ID) VALUES ('ivan', '1', 'Иван', 1, 1);
INSERT INTO USERS (LOGIN, PASSWORD, NAME, ROLES_ID, USERS_STATUSES_ID) VALUES ('user', '1', 'user', 2, 1);
INSERT INTO USERS (LOGIN, PASSWORD, NAME, ROLES_ID, USERS_STATUSES_ID) VALUES ('qwe', '1', 'Ирина', 2, 1);


INSERT INTO AUTHORS (AUTHOR) VALUES 'Брюс Эккель';
INSERT INTO AUTHORS (AUTHOR) VALUES 'Терри Пратчетт';
INSERT INTO AUTHORS (AUTHOR) VALUES 'Стивен Кинг';
INSERT INTO AUTHORS (AUTHOR) VALUES 'Николай Гоголь';
INSERT INTO AUTHORS (AUTHOR) VALUES 'Александр Дюма';



INSERT INTO GENRES (GENRE) VALUES 'Образовательная';
INSERT INTO GENRES (GENRE) VALUES 'Фентази';
INSERT INTO GENRES (GENRE) VALUES 'Фантастика';
INSERT INTO GENRES (GENRE) VALUES 'Комедия';
INSERT INTO GENRES (GENRE) VALUES 'Приключения';



INSERT INTO BOOKS (TITLE, DESCRIPTION, QUANTITY, AUTHORS_ID, GENRES_ID) VALUES ('Философия Java', 'Книго по програмированию на Java', 0, 1, 1);
INSERT INTO BOOKS (TITLE, DESCRIPTION, QUANTITY, AUTHORS_ID, GENRES_ID) VALUES ('Незримые академики', 'Еще одна история аля "Ромео и Джульета"... Наверное...', 5, 2, 2);
INSERT INTO BOOKS (TITLE, DESCRIPTION, QUANTITY, AUTHORS_ID, GENRES_ID) VALUES ('11/22/63', 'Путишествое во времени, любовь и прочие парадоксы', 5, 3, 3);
INSERT INTO BOOKS (TITLE, DESCRIPTION, QUANTITY, AUTHORS_ID, GENRES_ID) VALUES ('Как писать книги', 'Об мастерстве от мастера', 1, 3, 1);
INSERT INTO BOOKS (TITLE, DESCRIPTION, QUANTITY, AUTHORS_ID, GENRES_ID) VALUES ('Темная башня', 'Заключителья книга из одноименной серии', 5, 3, 5);
INSERT INTO BOOKS (TITLE, DESCRIPTION, QUANTITY, AUTHORS_ID, GENRES_ID) VALUES ('Стража! Стража!', 'О тяжелых буднях САМЫХ обычных стражников', 5, 2, 4);
INSERT INTO BOOKS (TITLE, DESCRIPTION, QUANTITY, AUTHORS_ID, GENRES_ID) VALUES ('Граф Монте-Кристо', 'Не имей сто друзей, а имей небольшой оставок с сундуком золота', 5, 5, 5);
INSERT INTO BOOKS (TITLE, DESCRIPTION, QUANTITY, AUTHORS_ID, GENRES_ID) VALUES ('Держи марку!', 'Хотите расскажу вам два занимательных факта про ангелов?', 4, 2, 5);
INSERT INTO BOOKS (TITLE, DESCRIPTION, QUANTITY, AUTHORS_ID, GENRES_ID) VALUES ('Ревизор', 'Комедия в пяти действиях', 3, 4, 4);


INSERT INTO ORDERS (DATE_RECEIVING, DAYS, BOOKS_ID, USERS_ID) VALUES ('2021-01-12', 30, 2, 1);
INSERT INTO ORDERS (DATE_RECEIVING, DAYS, BOOKS_ID, USERS_ID) VALUES (CURRENT_DATE(), 5, 3, 3);
INSERT INTO ORDERS (DATE_RECEIVING, DAYS, BOOKS_ID, USERS_ID) VALUES ('2021-01-16', 120, 4, 3);
INSERT INTO ORDERS (DATE_RECEIVING, DAYS, BOOKS_ID, USERS_ID) VALUES ('2021-01-01', 85, 8, 4);
INSERT INTO ORDERS (DATE_RECEIVING, DAYS, BOOKS_ID, USERS_ID) VALUES ('2021-01-20', 45, 7, 4);
INSERT INTO ORDERS (DATE_RECEIVING, DAYS, BOOKS_ID, USERS_ID) VALUES ('2020-12-15', 100, 7, 4);
