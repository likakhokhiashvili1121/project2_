package db;

import io.qameta.allure.Step;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {

    UserSQL userData = new UserSQL();

    @Step
    public DataBase connect() {
        try (Connection conn = DBconnection.getConnection()) {
            System.out.printf("Connected to the database %s successfully.%n", conn.getCatalog());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return this;
    }

    @Step("lets alehop the data into the database")
    public DataBase insertData() {
        String insertQuery = "INSERT INTO [users].[dbo].[users](firstname,lastname, phone, email, dateOfBirth, password) VALUES(?,?,?,?,?,?)";

        try {
            Connection conn = DBconnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, getFirstName());
            preparedStatement.setString(2, getLastName());
            preparedStatement.setString(3, getPhone());
            preparedStatement.setString(4, getEmail());
            preparedStatement.setDate(5, getDateOfBirth());
            preparedStatement.setString(6, getPassword());
            preparedStatement.executeUpdate();
            return this;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Commit changes")
    public DataBase commitChanges() throws SQLException {
        DBconnection.getConnection().commit();
        return this;
    }

    @Step("Get first name")
    public String getFirstName() {
        return userData.firstName;
    }

    @Step("Get last name")
    public String getLastName() {
        return userData.lastName;
    }

    @Step("Get phone number")
    public String getPhone() {
        return userData.phone;
    }

    @Step("Get email address")
    public String getEmail() {
        return userData.email;
    }

    @Step("Get date of birth")
    public Date getDateOfBirth() {
        return userData.dateOfBirth;
    }

    @Step("Get password")
    public String getPassword() {
        return userData.password;
    }
}
