CREATE DATABASE restexemplo
GO
USE restexemplo
GO
CREATE TABLE produto (
id		INT				NOT NULL,
nome	VARCHAR(50)		NOT NULL,
valor	DECIMAL(7,2)	NOT NULL,
forn	
PRIMARY KEY (id)
)
GO
INSERT INTO produto VALUES
(1, 'HDD 1TB', 250.00),
(2, 'SSD 240 GB', 230.00)

SELECT * FROM produto