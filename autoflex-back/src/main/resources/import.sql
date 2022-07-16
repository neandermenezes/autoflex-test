-- Product #####

CREATE TABLE IF NOT EXISTS Product (
    id BIGINT,
    name varchar(255) NOT NULL,
    valor int NOT NULL,
    );

DELETE FROM Product;

INSERT INTO Product (name, value) VALUES ('produto1', 100);
INSERT INTO Product (name, value) VALUES ('produto2', 200);
INSERT INTO Product (name, value) VALUES ('produto3', 300);
INSERT INTO Product (name, value) VALUES ('produto4', 400);
INSERT INTO Product (name, value) VALUES ('produto5', 500);
INSERT INTO Product (name, value) VALUES ('produto6', 600);
INSERT INTO Product (name, value) VALUES ('produto7', 700);
INSERT INTO Product (name, value) VALUES ('produto8', 800);
INSERT INTO Product (name, value) VALUES ('produto9', 900);
INSERT INTO Product (name, value) VALUES ('produto10', 1000);

CREATE TABLE IF NOT EXISTS Feedstock (
    id BIGINT,
    name varchar(255) NOT NULL,
    quantity int NOT NULL,
    );

DELETE FROM Feedstock;

INSERT INTO Feedstock (name, quantity) VALUES ('feedstock1', 100);
INSERT INTO Feedstock (name, quantity) VALUES ('feedstock2', 200);
INSERT INTO Feedstock (name, quantity) VALUES ('feedstock3', 300);
INSERT INTO Feedstock (name, quantity) VALUES ('feedstock4', 400);
INSERT INTO Feedstock (name, quantity) VALUES ('feedstock5', 500);
INSERT INTO Feedstock (name, quantity) VALUES ('feedstock6', 600);
INSERT INTO Feedstock (name, quantity) VALUES ('feedstock7', 700);
INSERT INTO Feedstock (name, quantity) VALUES ('feedstock8', 800);
INSERT INTO Feedstock (name, quantity) VALUES ('feedstock9', 900);
INSERT INTO Feedstock (name, quantity) VALUES ('feedstock10', 1000);