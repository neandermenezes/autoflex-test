-- Product #####

CREATE TABLE IF NOT EXISTS Product (
    id BIGINT,
    name varchar(255) NOT NULL,
    valor int NOT NULL,
    FOREIGN KEY(feedstock_id)
    );

DELETE FROM Product;

INSERT INTO Product (name, value) VALUES ('Desk', 200);
INSERT INTO Product (name, value) VALUES ('Chair', 50);
INSERT INTO Product (name, value) VALUES ('Glass Dask', 300);
INSERT INTO Product (name, value) VALUES ('Pen', 5);
INSERT INTO Product (name, value) VALUES ('Pencil', 2);

CREATE TABLE IF NOT EXISTS Feedstock (
    id BIGINT,
    name varchar(255) NOT NULL,
    quantity int NOT NULL,
    );

DELETE FROM Feedstock;

INSERT INTO Feedstock (name, quantity) VALUES ('Wood', 100);
INSERT INTO Feedstock (name, quantity) VALUES ('Plastic', 200);
INSERT INTO Feedstock (name, quantity) VALUES ('Ink', 300);
INSERT INTO Feedstock (name, quantity) VALUES ('Glass', 400);
INSERT INTO Feedstock (name, quantity) VALUES ('Iron', 500);

CREATE TABLE IF NOT EXISTS product_feedstock (
    product_id BIGINT NOT NULL,
    feedstock_id BITINT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES Product(id),
    FOREIGN KEY (feedstock_id) REFERENCES Feedstock(id)
    );

DELETE FROM product_feedstock;

INSERT INTO product_feedstock (product_id, feedstock_id) VALUES (1, 1);
INSERT INTO product_feedstock (product_id, feedstock_id) VALUES (1, 5);
INSERT INTO product_feedstock (product_id, feedstock_id) VALUES (1, 2);

INSERT INTO product_feedstock (product_id, feedstock_id) VALUES (2, 1);
INSERT INTO product_feedstock (product_id, feedstock_id) VALUES (2, 2);
INSERT INTO product_feedstock (product_id, feedstock_id) VALUES (2, 5);

INSERT INTO product_feedstock (product_id, feedstock_id) VALUES (3, 2);
INSERT INTO product_feedstock (product_id, feedstock_id) VALUES (3, 4);
INSERT INTO product_feedstock (product_id, feedstock_id) VALUES (3, 5);

INSERT INTO product_feedstock (product_id, feedstock_id) VALUES (4, 2);
INSERT INTO product_feedstock (product_id, feedstock_id) VALUES (4, 3);

INSERT INTO product_feedstock (product_id, feedstock_id) VALUES (5, 1);