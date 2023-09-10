package app.servlets.fitness.entities;

import app.servlets.fitness.entities.enums.Role;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static app.servlets.fitness.util.Constants.*;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;

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
    @Column(name=FIRST_NAME_COLUMN, nullable = false)
    private String firstName;
    @Column(name=LAST_NAME_COLUMN, nullable = false)
    private String lastName;
    @Column(name=DATE_BIRTHDAY_COLUMN,nullable = false)
    private LocalDate dateBirthday;
    @Column(name=LOGIN, nullable = false, unique = true)
    private String login;
    @Column(name=PASSWORD, nullable = false)
    private String password;
    @Enumerated(STRING)
    @Column(name=ROLE)
    private Role role;
    @OneToMany(mappedBy = USER, cascade = ALL)
    private List<Purchase> purchases;
}

