package com.alaythiaproductions.bookstoreadmin.services;

import com.alaythiaproductions.bookstoreadmin.models.User;
import com.alaythiaproductions.bookstoreadmin.models.security.PasswordResetToken;
import com.alaythiaproductions.bookstoreadmin.models.security.UserRole;

import java.util.Set;

public interface UserService {

    PasswordResetToken getPasswordResetToken(final String token);

    void createPasswordResetTokeForUser(final User user, final String token);

    User findByUsername(String username);

    User findByEmail(String email);

    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User save(User user);
}
