package com.project.back_end.services.impl;

import com.project.back_end.models.Role;
import com.project.back_end.models.enums.RoleType;
import com.project.back_end.repo.RoleRepository;
import com.project.back_end.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    @Override
    public void createRole(RoleType roleType) {
        roleRepository.save(new Role(roleType));
    }

    @Transactional(readOnly = true)
    @Override
    public Boolean existsByType(RoleType roleType) {
        return roleRepository.findAll().stream()
                .anyMatch(role -> role.getRole().equals(roleType));
    }

    //TODO: Implement custom exception handling or logging
    @Transactional(readOnly = true)
    @Override
    public Role findByType(RoleType roleType) {
        return roleRepository.findByType(roleType.toString());
    }
}
