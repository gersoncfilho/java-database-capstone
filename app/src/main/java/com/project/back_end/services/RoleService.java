package com.project.back_end.services;

import com.project.back_end.models.RoleType;

public interface RoleService {
    void createRole(RoleType name);
    Boolean existsByType(RoleType roleType);
}
