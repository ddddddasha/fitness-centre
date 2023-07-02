package app.servlets.fitness.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("Администратор"),
    CLIENT("Клиент");

    private final String name;
}
