package com.psira.repository;

import com.psira.entity.Post;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PostRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public Post create(Post post) {
        entityManager.persist(post);
        return post;
    }

    public Optional<Post> findById(Long id) {
        Post post = entityManager.find(Post.class, id);
        return Optional.ofNullable(post);
    }

    @Transactional
    public Post update(Post post) {
        return entityManager.merge(post);
    }

    @Transactional
    public void delete(Long id) {
        Post post = findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        entityManager.remove(post);
    }

    public List<Post> listAll() {
        List<Post> posts = entityManager.createQuery("SELECT p FROM Post p", Post.class).getResultList();

        // Access qualification using the getter method
        for (Post post : posts) {
            post.setQualification(Post.Qualification.fromDatabaseString(post.getQualification().name()));
        }

        return posts;
    }
}
