package app.servlets.fitness.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static app.servlets.fitness.util.Constants.PERSISTENCE_UNIT_NAME;

public class JPAUtil{
    private static final JPAUtil INSTANCE = new JPAUtil();
    private final EntityManagerFactory entityManagerFactory;

    private JPAUtil() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static JPAUtil getInstance() {
        return INSTANCE;
    }

    public EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
