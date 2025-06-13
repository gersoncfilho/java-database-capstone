package com.project.back_end.repo;

import com.project.back_end.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(nativeQuery = true,
    value = "SELECT * FROM roles WHERE role = :type")
    Role findByType(String type);
}
