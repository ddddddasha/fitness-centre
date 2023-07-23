package app.servlets.fitness.repositories;

import app.servlets.fitness.entities.User;
import app.servlets.fitness.entities.enums.Role;
import app.servlets.fitness.mappers.UserMapper;
import app.servlets.fitness.util.ConnectionManager;
import lombok.Builder;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static app.servlets.fitness.util.Constants.*;

@Builder
public class UserRepositoryImpl implements UserRepository{
    private final UserMapper userMapper;
    @Override
    public User createUser(User user) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement =
                    connection.prepareStatement(INSERT_INTO_PERSON_TABLE);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setDate(3, Date.valueOf(user.getDateBirthday()));
            statement.setString(4, user.getLogin());
            statement.setString(5, user.getPassword());
            statement.setString(6, Role.CLIENT.name());
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public List<User> readUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_PERSON_TABLE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong(ID);
                String firstName = resultSet.getString(FIRST_NAME_DB);
                String lastName = resultSet.getString(LAST_NAME_DB);
                String login = resultSet.getString(LOGIN);
                LocalDate dateBirthday = resultSet.getDate(AGE).toLocalDate();
                String role = resultSet.getString(ROLE);
                User user = userMapper.buildUser(id, firstName, lastName, dateBirthday, login, Role.valueOf(role));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
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
                LocalDate dateBirthday = resultSet.getDate(AGE).toLocalDate();
                String password = resultSet.getString(PASSWORD);
                String role = resultSet.getString(ROLE);
                return userMapper.buildUserForSignIn(firstName, lastName, dateBirthday, login, password, Role.valueOf(role));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_FROM_PERSON_BY_ID);
            statement.setLong(1, id);
            return statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getById(long id) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_DATA_FROM_PERSON_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString(FIRST_NAME_DB);
                String lastName = resultSet.getString(LAST_NAME_DB);
                LocalDate dateBirthday = resultSet.getDate(AGE).toLocalDate();
                String login = resultSet.getString(LOGIN);
                String password = resultSet.getString(PASSWORD);
                return userMapper.buildUserForUserPage(id, firstName, lastName, dateBirthday, login, password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PERSON_BY_ID);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setDate(3, Date.valueOf(user.getDateBirthday()));
            statement.setString(4, user.getLogin());
            statement.setLong(5, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
