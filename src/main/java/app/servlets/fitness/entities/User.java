package app.servlets.fitness.entities;

import app.servlets.fitness.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static app.servlets.fitness.util.Constants.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name=USER_TABLE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name=ID, nullable = false, updatable = false)
    private long id;

    @Column(name=FIRST_NAME_DB)
    private String firstName;

    @Column(name=LAST_NAME_DB)
    private String lastName;

    @Column(name=DATE_BIRTHDAY_DB)
    private LocalDate dateBirthday;

    @Column(name=LOGIN, unique = true)
    private String login;

    @Column(name=PASSWORD)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name=ROLE)
    private Role role;
}

