package com.project.back_end.seed;

import com.project.back_end.models.enums.RoleType;
import com.project.back_end.services.RoleService;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder {

    private final RoleService roleService;

    public RoleSeeder(RoleService roleService) {
        this.roleService = roleService;
    }

    public void seed() {
        createIfNotExists(RoleType.ROLE_ADMIN);
        createIfNotExists(RoleType.ROLE_DOCTOR);
        createIfNotExists(RoleType.ROLE_PATIENT);
    }

    private void createIfNotExists(RoleType roleType) {
        if (!roleService.existsByType(roleType)) {
            roleService.createRole(roleType);
        }
    }
}
