CREATE DATABASE GameStoreDB;
GO
USE GameStoreDB;
GO

DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Games;
GO

--Users Table
CREATE TABLE Users (
	user_id INT PRIMARY KEY IDENTITY,
	username VARCHAR (50) UNIQUE NOT NULL,
	email_address VARCHAR(100),
	password_hash VARCHAR(255)
);
GO

-- Games Table
CREATE TABLE Games (
	game_id INT PRIMARY KEY IDENTITY,
	name VARCHAR(100) NOT NULL,
	price DECIMAL(10,2) NOT NULL,
	image_path NVARCHAR(255)
);
GO

-- Insert Games
INSERT INTO Games (name, price, image_path)
VALUES ('Call of Duty: Black Ops 6', 69.99, 'Cod_Black_6.png'),
		('Schedule 1', 19.99, 'Schedule_1.png'),
		('Dead by Daylight', 19.99, 'Dead_by_daylight.jpg'),
		('NBA 2k25', 69.99, 'NBA_2k25.jpg'),
		('Ready or Not', 49.99, 'Ready_or_not.jpg'),
		('Elden Ring NightReign', 39.99, 'Elden_Ring_NightReign.png');
GO

-- ===============
-- Test Section 
-- ===============

SELECT * FROM Users;
SELECT * FROM Games;

