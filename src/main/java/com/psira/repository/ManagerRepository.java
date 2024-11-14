package com.psira.repository;

import com.psira.entity.Manager;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ManagerRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public Manager create(Manager manager) {
        entityManager.persist(manager);
        return manager;
    }

    public Optional<Manager> findById(Integer id) {
        Manager manager = entityManager.find(Manager.class, id);
        return Optional.ofNullable(manager);
    }

    @Transactional
    public Manager update(Manager manager) {
        return entityManager.merge(manager);
    }

    @Transactional
    public void delete(Integer id) {
        Manager manager = findById(id).orElseThrow(() -> new RuntimeException("Manager not found"));
        entityManager.remove(manager);
    }

    public List<Manager> listAll() {
        return entityManager.createQuery("SELECT m FROM Manager m", Manager.class).getResultList();
    }
}