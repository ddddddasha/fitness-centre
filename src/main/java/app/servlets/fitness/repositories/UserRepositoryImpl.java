package app.servlets.fitness.repositories;

import app.servlets.fitness.entities.User;
import app.servlets.fitness.mappers.UserMapper;
import app.servlets.fitness.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static app.servlets.fitness.util.Constants.*;

public class UserRepositoryImpl implements UserRepository{
    private final UserMapper mapper = new UserMapper();
    @Override
    public User createUser(User user) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement =
                    connection.prepareStatement(INSERT_INTO_PERSON_TABLE);
            statement.setString(1, user.getId());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setLong(4, user.getAge());
            statement.setString(5, user.getLogin());
            statement.setString(6, user.getPassword());
            statement.setString(7, "ADMIN");
            statement.execute();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> readUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_PERSON_TABLE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(ID);
                String firstName = resultSet.getString(FIRST_NAME_DB);
                String lastName = resultSet.getString(LAST_NAME_DB);
                String login = resultSet.getString(LOGIN);
                int age = resultSet.getInt(AGE);
                String role = resultSet.getString(ROLE);
                User user = mapper.buildUser(id, firstName, lastName, age, login, role);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public User getByLogin(String login) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_DATA_FROM_PERSON_BY_LOGIN);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString(FIRST_NAME_DB);
                String lastName = resultSet.getString(LAST_NAME_DB);
                int age = resultSet.getInt(AGE);
                String password = resultSet.getString(PASSWORD);
                String role = resultSet.getString(ROLE);
                return mapper.buildUserForSignIn(firstName, lastName, age, login, password, role);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_FROM_PERSON_BY_ID);
            statement.setString(1, id);
            return statement.execute();
        } catch (SQLException e) {

            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public User getById(String id) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_DATA_FROM_PERSON_BY_ID);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString(FIRST_NAME_DB);
                String lastName = resultSet.getString(LAST_NAME_DB);
                int age = resultSet.getInt(AGE);
                String login = resultSet.getString(LOGIN);
                String password = resultSet.getString(PASSWORD);
                return mapper.buildUserForUserPage(id, firstName, lastName, age, login, password);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PERSON_BY_ID);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getLogin());
            statement.setString(5, user.getId());
            statement.executeUpdate();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean isIdExistsInDatabase(String id) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_COUNT_FROM_PERSON_BY_ID);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
