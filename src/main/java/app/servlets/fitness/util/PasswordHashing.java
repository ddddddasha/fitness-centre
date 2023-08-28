package app.servlets.fitness.util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;


import static app.servlets.fitness.util.Constants.*;

public class PasswordHashing {

    public String hashPassword(String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        try{
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM_PBKDF2);
            byte[] hash = factory.generateSecret(spec).getEncoded();
            String saltStr = Base64.getEncoder().encodeToString(salt);
            String hashStr = Base64.getEncoder().encodeToString(hash);

            return saltStr + SPLIT_FOR_PBKDF2 + hashStr;
        }
        catch (Exception e){
            return null;
        }
    }

    public boolean verifyPassword(String password, String hashedPassword){

        String[] parts = hashedPassword.split(SPLIT_FOR_PBKDF2);
        byte[] salt = Base64.getDecoder().decode(parts[ZERO]);
        byte[] hash = Base64.getDecoder().decode(parts[ONE]);

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        try{
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM_PBKDF2);
            byte[] testHash = factory.generateSecret(spec).getEncoded();
            return Arrays.equals(hash, testHash);
        }
        catch (Exception e){
            return false;
        }
    }
}
