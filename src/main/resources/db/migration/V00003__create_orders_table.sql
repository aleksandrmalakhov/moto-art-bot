DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
    id INT PRIMARY KEY,
    id_bike INT NOT NULL,
    id_client INT NOT NULL,
    date DATE NOT NULL,
    time_start TIME NOT NULL,
    time_stop TIME NOT NULL,
    cost INT NOT NULL ,
    FOREIGN KEY (id_bike) REFERENCES bikes(id),
    FOREIGN KEY (id_client) REFERENCES clients(id)
);