package com.psira.services;

import com.psira.dto.ManagerDTO;
import com.psira.entity.Manager;
import com.psira.repository.ManagerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ManagerService {

    @Inject
    ManagerRepository managerRepository;

    public List<Manager> listAll() {
        return managerRepository.listAll();
    }

    public Optional<Manager> findById(Integer id) {
        return managerRepository.findById(id);
    }

    public Manager create(ManagerDTO managerDTO) {
        Manager manager = new Manager();
        manager.setName(managerDTO.getName());
        manager.setSurname(managerDTO.getSurname());
        manager.setEmail(managerDTO.getEmail());
        manager.setTell(managerDTO.getTell());
        manager.setPosition(managerDTO.getPosition());
        return managerRepository.create(manager);
    }

    public Manager update(Integer id, ManagerDTO managerDTO) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found"));
        manager.setName(managerDTO.getName());
        manager.setSurname(managerDTO.getSurname());
        manager.setEmail(managerDTO.getEmail());
        manager.setTell(managerDTO.getTell());
        manager.setPosition(managerDTO.getPosition());
        return managerRepository.update(manager);
    }

    public void delete(Integer id) {
        managerRepository.delete(id);
    }
}
