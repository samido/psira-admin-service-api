package com.psira.services;

import com.psira.dto.PostDTO;
import com.psira.dto.ManagerDTO;
import com.psira.entity.Post;
import com.psira.entity.Manager;
import com.psira.repository.PostRepository;
import com.psira.repository.ManagerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PostService {

    @Inject
    PostRepository postRepository;

    @Inject
    ManagerRepository managerRepository;

    public List<Post> listAll() {
        return postRepository.listAll();
    }

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public Post create(PostDTO postDTO) {
        Post post = new Post();
        post.setPostName(postDTO.getPostName());
        post.setJobDescription(postDTO.getJobDescription());
        post.setBusinessUnit(postDTO.getBusinessUnit());
        post.setExperienceYears(postDTO.getExperienceYears());
        post.setQualification(postDTO.getQualification());
        post.setDriversLicenseRequired(postDTO.getDriversLicenseRequired());
        post.setOpeningDate(postDTO.getOpeningDate());
        post.setClosingDate(postDTO.getClosingDate());

        // Set Manager
        Manager manager = managerRepository.findById(postDTO.getManager().getId())
                .orElseThrow(() -> new RuntimeException("Manager not found"));
        post.setManager(manager);

        return postRepository.create(post);
    }

    public Post update(Long id, PostDTO postDTO) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        post.setPostName(postDTO.getPostName());
        post.setJobDescription(postDTO.getJobDescription());
        post.setBusinessUnit(postDTO.getBusinessUnit());
        post.setExperienceYears(postDTO.getExperienceYears());
        post.setQualification(postDTO.getQualification());
        post.setDriversLicenseRequired(postDTO.getDriversLicenseRequired());
        post.setOpeningDate(postDTO.getOpeningDate());
        post.setClosingDate(postDTO.getClosingDate());

        // Update Manager
        Manager manager = managerRepository.findById(postDTO.getManager().getId())
                .orElseThrow(() -> new RuntimeException("Manager not found"));
        post.setManager(manager);

        return postRepository.update(post);
    }

    public void delete(Long id) {
        postRepository.delete(id);
    }
}
