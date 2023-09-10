package app.servlets.fitness.services.password;

import app.servlets.fitness.config.PasswordHashingConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class PasswordHashingImpl implements PasswordHashing{

    private final PasswordHashingConfiguration passwordHashingConfig;

    @Override
    public String hashPassword(String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[passwordHashingConfig.SALT_LENGTH];
        random.nextBytes(salt);

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt,
                passwordHashingConfig.ITERATIONS, passwordHashingConfig.KEY_LENGTH);
        try{
            SecretKeyFactory factory = SecretKeyFactory.getInstance(passwordHashingConfig.ALGORITHM_PBKDF2);
            byte[] hash = factory.generateSecret(spec).getEncoded();
            String saltStr = Base64.getEncoder().encodeToString(salt);
            String hashStr = Base64.getEncoder().encodeToString(hash);

            return saltStr + passwordHashingConfig.SPLIT_FOR_PBKDF2 + hashStr;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean verifyPassword(String password, String hashedPassword) {
        String[] parts = hashedPassword.split(passwordHashingConfig.SPLIT_FOR_PBKDF2);
        byte[] salt = Base64.getDecoder().decode(parts[passwordHashingConfig.ZERO]);
        byte[] hash = Base64.getDecoder().decode(parts[passwordHashingConfig.ONE]);

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, passwordHashingConfig.ITERATIONS, passwordHashingConfig.KEY_LENGTH);
        try{
            SecretKeyFactory factory = SecretKeyFactory.getInstance(passwordHashingConfig.ALGORITHM_PBKDF2);
            byte[] testHash = factory.generateSecret(spec).getEncoded();
            return Arrays.equals(hash, testHash);
        }
        catch (Exception e){
            return false;
        }
    }
}
