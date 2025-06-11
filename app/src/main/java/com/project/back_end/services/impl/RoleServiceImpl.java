package com.project.back_end.services.impl;

import com.project.back_end.models.Role;
import com.project.back_end.models.RoleType;
import com.project.back_end.repo.RoleRepository;
import com.project.back_end.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    @Autowired
    public RoleServiceImpl (RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createRole(RoleType roleType) {
        repository.save(new Role(roleType));
    }

    @Override
    public Boolean existsByType(RoleType roleType) {
        return repository.findAll().stream()
                .anyMatch(role -> role.getRole().equals(roleType));
    }
}
