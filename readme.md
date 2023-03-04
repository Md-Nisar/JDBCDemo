# JAVA + JDBC + MYSQL


## 1: import Packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


## 2: Register Database Driver to JDBC
Class.forName("Database Driver");


## 3: Open Connection
Connection connection=DriverManager.getConnection("jdbc:Database url", "username", "password");

## 4: Create Statement
Statement smt = conn.createStatement();

## 5: Execute Query
ResultSet rs-smt.executeQuery("SQL statement");

## 6: Extract Database
rs.next()
int i=rs.getInt(index); int i=rs.getInt(columnName);

## 7: Close connection
connection.close()



#### Happy Coding!