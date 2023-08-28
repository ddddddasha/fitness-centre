package app.servlets.fitness.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("ADMIN"),
    CLIENT("CLIENT");

    private final String name;
}
