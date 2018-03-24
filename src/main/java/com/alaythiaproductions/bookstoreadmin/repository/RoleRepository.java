package com.alaythiaproductions.bookstoreadmin.repository;

import com.alaythiaproductions.bookstoreadmin.models.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
