package app.servlets.fitness.util;

import javax.persistence.EntityManager;

public class EntityManagerHandler implements AutoCloseable{
    private final EntityManager entityManager;

    public EntityManagerHandler() {
        this.entityManager = JPAUtil.getInstance().createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void close() {
        entityManager.close();
    }
}
