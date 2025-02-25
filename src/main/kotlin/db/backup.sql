CREATE DATABASE pos_db;

\c pos_db;

CREATE TABLE stocks (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    stock INTEGER NOT NULL DEFAULT 10,
    code VARCHAR(32) NOT NULL UNIQUE
);

CREATE TABLE users {
    id SERIAL PRIMARY KEY,
    uid VARCHAR(12) NOT NULL UNIQUE,
    pin CHAR(60) NOT NULL
);

INSERT INTO users (id, uid, pin) VALUES
    (1, 'root', '$2a$12$xiICjRicEOylOdOxTyZN.uqXXyNZobLPxiC/DXmUO/ljX0mSvjr9C');

INSERT INTO stocks (id, name, price, stock, code) VALUES
    (1, 'Chitato', 12000, 10, 'f56322e8'),
    (2, 'Oreo', 9000, 10, '3f29909e'),
    (3, 'Taro', 8000, 10, '24b40ae6'),
    (4, 'SilverQueen', 25000, 10, 'b84895ec'),
    (5, 'Indomie', 3500, 10, 'e00fed18'),
    (6, 'Mie Sedaap', 3200, 10, '0554540b'),
    (7, 'Pop Mie', 7000, 10, '9e5203e5'),
    (8, 'Le Minerale', 4000, 10, 'e6657a9b'),
    (9, 'Aqua', 5000, 10, '77f04b3b'),
    (10, 'Teh Pucuk', 6000, 10, '57235618'),
    (11, 'Sprite', 8000, 10, '8e42ae5f'),
    (12, 'Coca Cola', 8500, 10, 'e28c951e'),
    (13, 'Fanta', 8200, 10, '44ed1746'),
    (14, 'Pulpy Orange', 11000, 10, '924f0474'),
    (15, 'Buavita', 12000, 10, 'ac48264a'),
    (16, 'Ultra Milk', 7500, 10, 'ee2557c5'),
    (17, 'Frisian Flag', 7000, 10, '20e1aec4'),
    (18, 'Good Day Cappuccino', 5000, 10, 'eb9204c5'),
    (19, 'Nescafe', 6000, 10, '8cdb3076'),
    (20, 'Kapal Api', 4000, 10, '4c8f116d'),
    (21, 'ABC Susu', 4500, 10, '079159ec'),
    (22, 'Roma Malkist', 8500, 10, 'fc8fb286'),
    (23, 'Beng Beng', 3000, 10, 'e8e2387a'),
    (24, 'Tic Tac', 2500, 10, 'be34c227'),
    (25, 'Gery Saluut', 7000, 10, '858178eb'),
    (26, 'Gery Chocolatos', 5500, 10, '4a91e21e'),
    (27, 'Choki Choki', 4000, 10, 'b2e24c32'),
    (28, 'Pocky', 10000, 10, '0e8228a9'),
    (29, 'KitKat', 11000, 10, '29a08ce5'),
    (30, 'Top Coffee', 4500, 10, '7f597945'),
    (31, 'Excelso', 20000, 10, 'c375ab80'),
    (32, 'Luwak White Koffie', 6500, 10, '69df281a'),
    (33, 'Nutrisari', 2500, 10, 'd4f8fb88'),
    (34, 'Milo', 9000, 10, '25e458dd'),
    (35, 'Energen', 3500, 10, '47f201a8'),
    (36, 'Susu Beruang', 12000, 10, '066dd690'),
    (37, 'Yakult', 10000, 10, 'c26cf828'),
    (38, 'Roti Sari Roti', 12000, 10, '993abdf1'),
    (39, 'Roti Tawar', 14000, 10, '78e8a62e'),
    (40, 'Bon Cabe', 8000, 10, '2efd946f'),
    (41, 'Saos ABC', 7000, 10, '50ec6fcc'),
    (42, 'Kecap Bango', 12000, 10, '56f55721'),
    (43, 'Kecap ABC', 11000, 10, '8e73c95d'),
    (44, 'Sambal Indofood', 8500, 10, '95195eb4'),
    (45, 'Mayonaise Maestro', 14000, 10, '2d1bcde0'),
    (46, 'Chili Sauce Heinz', 13500, 10, '64ba9a22'),
    (47, 'Blue Band', 13000, 10, '928a9d7e'),
    (48, 'Keju Kraft', 25000, 10, 'f23d6ab1'),
    (49, 'Sosis Kanzler', 27000, 10, 'd3e60487'),
    (50, 'Bakso So Good', 29000, 10, 'a03d62a5');

SELECT * FROM stocks;
SELECT * FROM users;
