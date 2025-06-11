CREATE USER IF NOT EXISTS 'user'@'%' IDENTIFIED BY 'user_password';
CREATE USER IF NOT EXISTS 'user'@'192.168.65.1' IDENTIFIED BY 'user_password';

ALTER USER 'user'@'%' IDENTIFIED WITH mysql_native_password BY 'user_password';
GRANT ALL PRIVILEGES ON java_db_capstone.* TO 'user'@'%';

ALTER USER 'user'@'192.168.65.1' IDENTIFIED WITH mysql_native_password BY 'user_password';
GRANT ALL PRIVILEGES ON java_db_capstone.* TO 'user'@'192.168.65.1';
FLUSH PRIVILEGES;