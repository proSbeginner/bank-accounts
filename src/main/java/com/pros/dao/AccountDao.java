package com.pros.dao;




import com.pros.model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {

    private Connection getConnection() {
        String url = "jdbc:sqlserver://localhost:1434;user=SA;password=Passw0rd;databaseName=accountdb";
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Account> findAll() {
        List<Account> list = new ArrayList<Account>();

        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ACCOUNT");

            while (resultSet.next()) {
                Long accountId = resultSet.getLong("id");
                String accountNumber = resultSet.getString("number");
                String accountName = resultSet.getString("name");
                String accountPhone = resultSet.getString("phone");

                Account account = new Account();
                account.setId(accountId);
                account.setNumber(accountNumber);
                account.setName(accountName);
                account.setPhone(accountPhone);

                list.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return list;
    }

    public int create(Account account) {
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO ACCOUNT(number, name, phone) VALUES(?, ?, ?)");
            statement.setString(3, account.getPhone());
            statement.setString(1, account.getNumber());
            statement.setString(2, account.getName());
            int recordCount = statement.executeUpdate();
            return recordCount;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public int delete(Account account) {
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM ACCOUNT WHERE id=?");
            statement.setString(1, account.getId().toString());
            int recordCount = statement.executeUpdate();
            return recordCount;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
