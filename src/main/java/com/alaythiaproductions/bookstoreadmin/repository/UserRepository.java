package com.alaythiaproductions.bookstoreadmin.repository;

import com.alaythiaproductions.bookstoreadmin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String string);

    User findByEmail(String email);

}
