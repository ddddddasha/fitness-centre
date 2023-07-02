package app.servlets.fitness.mappers;

import app.servlets.fitness.entities.User;

public class UserMapper {
    public User buildUser(String id, String firstName, String lastName, int age, String login, String role){
        return User.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .login(login)
                .role(role)
                .build();
    }

    public User buildUserForSignIn(String firstName, String lastName, int age, String login, String password, String role){
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .login(login)
                .password(password)
                .role(role)
                .build();
    }

    public User buildUserForUserPage(String id, String firstName, String lastName, int age, String login, String password){
        return User.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .login(login)
                .password(password)
                .build();
    }
}
