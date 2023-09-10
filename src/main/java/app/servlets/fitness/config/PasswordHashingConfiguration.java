package app.servlets.fitness.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class PasswordHashingConfiguration {

    @Value("${hashing.algorithm_pbkdf2}")
    public String ALGORITHM_PBKDF2;
    @Value("${hashing.split_for_pbkdf2}")
    public String SPLIT_FOR_PBKDF2;
    @Value("${hashing.zero}")
    public int ZERO;
    @Value("${hashing.one}")
    public int ONE;
    @Value("${hashing.salt_length}")
    public int SALT_LENGTH;
    @Value("${hashing.iterations}")
    public int ITERATIONS;
    @Value("${hashing.key_length}")
    public int KEY_LENGTH;
}
