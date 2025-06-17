package com.project.back_end.services;

import com.project.back_end.models.Role;
import com.project.back_end.models.enums.RoleType;

public interface RoleService {
    void createRole(RoleType name);

    Boolean existsByType(RoleType roleType);

    Role findByType(RoleType roleType);
}
