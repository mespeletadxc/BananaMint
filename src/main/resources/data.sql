INSERT INTO customers (name, email, birth_date, dni) VALUES
('Alex Perez','alex@bananamint.com','1985-03-06','12345678L'),
('Toni Garcia','toni@bananamint.com','1975-01-01','22222222x'),
('Maria Martínez','maria@bananamint.com','1980-01-01','33333333x');

INSERT INTO accounts (active, balance, max_overdraft, opening_date, type, customer_id) VALUES
('true',100.00,1.00,'2020-03-06','Ahorro',1),
('true',200.00,2.00,'2020-02-02','Ahorro',2);
