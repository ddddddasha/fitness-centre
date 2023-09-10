package app.servlets.fitness.services.password;

public interface PasswordHashing {

    String hashPassword(String password);

    boolean verifyPassword(String password, String hashedPassword);
}
