package com.forwardery.domain.authentication.repository;


import com.forwardery.domain.authentication.model.Users;
import com.forwardery.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends BaseRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
}
